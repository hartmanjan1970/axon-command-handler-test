package nl.ind.onderzoek.domain.command.onderzoek.aggregate;

import org.assertj.core.matcher.AssertionMatcher;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nl.ind.onderzoek.utils.TestConstanten.*;
import static nl.ind.onderzoek.utils.abonnement.AbonnementCommandUtils.neemOnderzoekInBehandeling;
import static nl.ind.onderzoek.utils.erkenning.ErkenningAggregateMemberUtils.erkenning;
import static nl.ind.onderzoek.utils.erkenning.ErkenningCommandUtils.herleefOnderzoekErkenning;
import static nl.ind.onderzoek.utils.erkenning.ErkenningCommandUtils.trekOnderzoekErkenningIn;
import static nl.ind.onderzoek.utils.erkenning.ErkenningEventUtils.onderzoekErkenningHerleefd;
import static nl.ind.onderzoek.utils.erkenning.ErkenningEventUtils.onderzoekErkenningIngetrokken;
import static nl.ind.onderzoek.utils.onderzoek.OnderzoekCommandUtils.*;
import static nl.ind.onderzoek.utils.onderzoek.OnderzoekControlCommandUtils.*;
import static nl.ind.onderzoek.utils.onderzoek.OnderzoekEventUtils.*;
import static nl.ind.onderzoek.utils.organisatie.OrganisatieCommandUtils.*;
import static nl.ind.onderzoek.utils.organisatie.OrganisatieEventUtils.*;
import static org.axonframework.test.matchers.Matchers.exactSequenceOf;
import static org.axonframework.test.matchers.Matchers.messageWithPayload;

class OnderzoekTest {

    private final FixtureConfiguration<Onderzoek> fixture = new AggregateTestFixture<>(Onderzoek.class);

    @Test
    void gegevenStartOnderzoek_wanneerGeenVoorgaandeActies_verwachtOnderzoekGestart() {
        fixture.givenNoPriorActivity()
                .when(initieerOnderzoek())
                .expectSuccessfulHandlerExecution()
                .expectEvents(onderzoekGeinitieerd());
    }

    @Test
    void gegevenOnderzoekGeinitieerd_wanneerControleerOfOrganisatieVoorKvkNummerBestaat_enOrganisatieIdBestaat_verwachtGecontroleerdDatOrganisatieVoorKvkNummerBestaat() {
        fixture.given(onderzoekGeinitieerd())
                .when(controleerOfOrganisatieVoorKvkNummerBestaat_organisatieIdBestaat())
                .expectSuccessfulHandlerExecution()
                .expectEvents(organisatieVoorKvkNummerBestaat());
    }

    @Test
    void gegevenOnderzoekIsNietGeinitieerd_wanneerControleerOfOrganisatieVoorKvkNummerBestaat_verwachtGeenEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        onderzoekGeopend()
                )
                .when(controleerOfOrganisatieVoorKvkNummerBestaat_organisatieIdBestaat())
                .expectSuccessfulHandlerExecution()
                .expectNoEvents();
    }

    @Test
    void gegevenControleerOfOrganisatieVoorKvkNummerBestaat_wanneerOrganisatieIdBestaatNiet_verwachtOnderzoekWordtNietInBehandelingGenomen() {
        fixture.given(onderzoekGeinitieerd())
                .when(controleerOfOrganisatieVoorKvkNummerBestaat_organisatieIdBestaatNiet())
                .expectSuccessfulHandlerExecution()
                .expectEvents(onderzoekIsNietInBehandelingGenomen(FOUTREDEN_KVK_NUMMER_NIET_BEKEND_BIJ_BEDRIJF_INSTELLING));
    }

    @Test
    void gegevenOnderzoekInitieelEnControleerOfOrganisatieEenErkenningVoorErkenningsdoelHeeft_wanneerErkenningsdoelAanwezig_verwachtOrganisatieEenErkenningVoorErkenningsdoelHeeft() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat()
                )
                .when(controleerOfOrganisatieErkenningVoorErkenningsdoelHeeft(
                                List.of(erkenning(ERKENNINGSDOEL_ARBEID, ERKENNING_STATUS_ACTIEF))
                        )
                )
                .expectSuccessfulHandlerExecution()
                .expectEventsMatching(
                        exactSequenceOf(
                                messageWithPayload(
                                        new AssertionMatcher<>() {
                                            @Override
                                            public void assertion(Object actual) throws AssertionError {
                                                assertThat(actual).usingRecursiveComparison().isEqualTo(organisatieHeeftErkenningMetErkenningsdoel());
                                            }
                                        }
                                )
                        )
                );
    }

    @Test
    void gegevenOnderzoekGeopend_wanneerControleerOfOrganisatieEenErkenningVoorErkenningsdoelHeeft_verwachtGeenEvents() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend()
                )
                .when(controleerOfOrganisatieErkenningVoorErkenningsdoelHeeft(
                                List.of(erkenning(ERKENNINGSDOEL_ARBEID, ERKENNING_STATUS_ACTIEF))
                        )
                )
                .expectSuccessfulHandlerExecution()
                .expectNoEvents();
    }

    @Test
    void gegevenControleerOfOrganisatieEenErkenningVoorErkenningsdoelHeeft_wanneerErkenningsdoelAfwezig_verwachtOnderzoekWordtNietInBehandelingGenomen() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat()
                )
                .when(controleerOfOrganisatieErkenningVoorErkenningsdoelHeeft(List.of()))
                .expectSuccessfulHandlerExecution()
                .expectEvents(onderzoekIsNietInBehandelingGenomen(FOUTREDEN_ORGANISATIE_HEEFT_GEEN_ERKENNING_VOOR_ERKENNINGSDOEL));
    }

    @Test
    void gegevenOnderzoekGeinitieerdGecontroleerdDatOrganisatieEenActieveErkenningVoorErkenningsdoelHeeft_wanneerErkenningActief_verwachtGecontroleerdDatOrganisatieEenActieveErkenningVoorErkenningsdoelHeeft() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel()
                )
                .when(controleerOfOrganisatieActieveErkenningVoorErkenningsdoelHeeft(
                        List.of(erkenning(ERKENNINGSDOEL_ARBEID, ERKENNING_STATUS_ACTIEF))))
                .expectSuccessfulHandlerExecution()
                .expectEventsMatching(
                        exactSequenceOf(
                                messageWithPayload(
                                        new AssertionMatcher<>() {
                                            @Override
                                            public void assertion(Object actual) throws AssertionError {
                                                assertThat(actual).usingRecursiveComparison()
                                                        .isEqualTo(organisatieHeeftActieveErkenningMetErkenningsdoel());
                                            }
                                        }
                                )
                        )
                );
    }

    @Test
    void gegevenOnderzoekGeopendGecontroleerdDatOrganisatieEenActieveErkenningVoorErkenningsdoelHeeft_verwachtGeenEvents() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend()
                )
                .when(controleerOfOrganisatieActieveErkenningVoorErkenningsdoelHeeft(
                        List.of(erkenning(ERKENNINGSDOEL_ARBEID, ERKENNING_STATUS_ACTIEF))))
                .expectSuccessfulHandlerExecution()
                .expectNoEvents();
    }

    @Test
    void gegevenGecontroleerdDatOrganisatieEenActieveErkenningVoorErkenningsdoelHeeft_wanneerErkenningNietActief_verwachtOnderzoekWordtNietInBehandelingGenomen() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel()
                )
                .when(controleerOfOrganisatieActieveErkenningVoorErkenningsdoelHeeft(
                        List.of(erkenning(ERKENNINGSDOEL_ARBEID, ERKENNING_STATUS_BEEINDIGD))))
                .expectSuccessfulHandlerExecution()
                .expectEvents(onderzoekIsNietInBehandelingGenomen(FOUTREDEN_ORGANISATIE_HEEFT_GEEN_ACTIEVE_ERKENNING_VOOR_ERKENNINGSDOEL));
    }

    @Test
    void gegevenOnderzoekGeinitieerdEnControleerOfOrganisatieEenErkenningVoorErkenningsdoelNietAlInOnderzoek_wanneerOrganisatieMetErkenningNietAlInOnderzoek_verwachtGecontroleerdDatOrganisatieMetEenErkenningVoorErkenningsdoelNietAlInOnderzoekIs() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel()
                )
                .when(controleerOfOrganisatieVoorErkenningsdoelInOnderzoekIs(false))
                .expectSuccessfulHandlerExecution()
                .expectEvents(organisatieIsNietInOnderzoekVoorErkenningsdoel());
    }

    @Test
    void gegevenOnderzoekGeopend_wanneerControleerOfOrganisatieEenErkenningVoorErkenningsdoelNietAlInOnderzoek_verwachtGeenEvents() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend()
                )
                .when(controleerOfOrganisatieVoorErkenningsdoelInOnderzoekIs(false))
                .expectSuccessfulHandlerExecution()
                .expectNoEvents();
    }

    @Test
    void gegevenControleerOfOrganisatieEenErkenningVoorErkenningsdoelNietAlInOnderzoek_wanneerOrganisatieMetErkenningWelAlInOnderzoek_verwachtOnderzoekWordtNietInBehandelingGenomen() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel()
                )
                .when(controleerOfOrganisatieVoorErkenningsdoelInOnderzoekIs(true))
                .expectSuccessfulHandlerExecution()
                .expectEvents(
                        onderzoekIsNietInBehandelingGenomen(FOUTREDEN_ORGANISATIE_MET_ERKENNING_VOOR_ERKENNINGSDOEL_IS_AL_IN_ONDERZOEK));
    }

    @Test
    void gegevenOnderzoekGestartEnAlleVierDeControlesUitgevoerd_wanneerOnderzoekKanInBehandelingWordenGenomen_verwachtOnderzoekIsGeopend() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel()
                )
                .when(openOnderzoek())
                .expectSuccessfulHandlerExecution()
                .expectEvents(onderzoekGeopend());
    }

    @Test
    void gegevenOnderzoekGeopend_wanneerRondOnderzoekAfCommand_verwachtOnderzoekIsAfgerondEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend()
                )
                .when(rondOnderzoekAf())
                .expectSuccessfulHandlerExecution()
                .expectEvents(onderzoekIsAfgerond());
    }

    @Test
    void gegevenOnderzoekGeInitieerd_wanneerRondOnderzoekAfCommand_verwachtGeenEvents() {
        fixture.given(
                        onderzoekGeinitieerd()
                )
                .when(rondOnderzoekAf())
                .expectSuccessfulHandlerExecution()
                .expectNoEvents();
    }

    @Test
    void gegevenOnderzoekGeopend_wanneerNeemOnderzoekInBehandelingCommand_verwachtOnderzoekIsInBehandeling() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend()
                )
                .when(neemOnderzoekInBehandeling())
                .expectSuccessfulHandlerExecution()
                .expectEvents(onderzoekInBehandelingGenomen());
    }

    @Test
    void gegevenOnderzoekNogNietOpen_wanneerNeemOnderzoekInBehandelingCommand_verwachtGeenEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel()
                )
                .when(neemOnderzoekInBehandeling())
                .expectSuccessfulHandlerExecution()
                .expectNoEvents();
    }

    @Test
    void gegevenOnderzoekIsGeopend_wanneerVoegMedewerkerToeAanOnderzoekCommand_verwachtEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend()
                )
                .when(voegMedewerkerToeAanOnderzoek())
                .expectSuccessfulHandlerExecution()
                .expectEvents(medewerkerAanOnderzoekToegevoegd());
    }

    @Test
    void gegevenOnderzoekIsInBehandeling_wanneerVoegMedewerkerToeAanOnderzoekCommand_verwachtMedewerkerAanOnderzoekToegevoegdEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend(),
                        onderzoekInBehandelingGenomen()
                )
                .when(voegMedewerkerToeAanOnderzoek())
                .expectSuccessfulHandlerExecution()
                .expectEvents(medewerkerAanOnderzoekToegevoegd());
    }

    @Test
    void gegevenOnderzoekIsGinitieerd_wanneerVoegMedewerkerToeAanOnderzoekCommand_verwachtGeenEvents() {
        fixture.given(
                        onderzoekGeinitieerd()
                )
                .when(voegMedewerkerToeAanOnderzoek())
                .expectSuccessfulHandlerExecution()
                .expectNoEvents();
    }

    @Test
    void gegevenOnderzoekIsInOnderzoek_wanneerRegistreerOrganisatieGegevensCommand_verwachtEvent() {
        fixture.given(onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend()
                )
                .when(registreerOrganisatieGegevens())
                .expectSuccessfulHandlerExecution()
                .expectEvents(organisatieGegevensGeregistreerd());
    }

    @Test
    void gegevenOnderzoekIsNietInOnderzoek_wanneerRegistreerOrganisatieGegevensCommand_verwachtGeenEvent() {
        fixture.given(onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel()
                )
                .when(registreerOrganisatieGegevens())
                .expectSuccessfulHandlerExecution()
                .expectNoEvents();
    }

    @Test
    void gegevenOnderzoekIsInOnderzoek_wanneerRegistreerPersoonGegevensCommand_verwachtEvent() {
        fixture.given(onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend()
                )
                .when(registreerPersoonGegevens())
                .expectSuccessfulHandlerExecution()
                .expectEvents(persoonGegevensGeregistreerd());
    }

    @Test
    void gegevenOnderzoekIsInOnderzoek_wanneerWerkPersoonGegevensBijCommand_verwachtPersoonGegevensGeregistreerdEvent() {
        fixture.given(onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend()
                )
                .when(werkPersoonGegevensBij())
                .expectSuccessfulHandlerExecution()
                .expectEvents(persoonGegevensGeregistreerd());
    }

    @Test
    void gegevenOnderzoekGeinitieerd_wanneerWerkPersoonGegevensBijCommand_verwachtGeenEvents() {
        fixture.given(
                        onderzoekGeinitieerd()
                )
                .when(werkPersoonGegevensBij())
                .expectSuccessfulHandlerExecution()
                .expectNoEvents();
    }

    @Test
    void gegevenOnderzoekIsNietInOnderzoek_wanneerRegistreerPersoonGegevensCommand_verwachtGeenEvent() {
        fixture.given(onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel()
                )
                .when(registreerPersoonGegevens())
                .expectSuccessfulHandlerExecution()
                .expectNoEvents();
    }

    @Test
    void gegevenOnderzoekIsInBehandeling_wanneerWerkOrganisatieGegevensBijCommand_verwachtOrganisatieGegevensBijgewerktEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend(),
                        onderzoekInBehandelingGenomen()
                )
                .when(werkOrganisatieGegevensBij())
                .expectSuccessfulHandlerExecution()
                .expectEvents(organisatieGegevensBijgewerkt());
    }

    @Test
    void gegevenOnderzoekIsAfgerond_wanneerWerkOrganisatieGegevensBijCommand_verwachtGeenEvents() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend(),
                        onderzoekIsAfgerond()
                )
                .when(werkOrganisatieGegevensBij())
                .expectSuccessfulHandlerExecution()
                .expectNoEvents();
    }

    @Test
    void gegevenOnderzoekIsInBehandeling_wanneerVerleenOrganisatieErkenningCommand_verwachtOrganisatieErkenningVerleendEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend(),
                        onderzoekInBehandelingGenomen()
                )
                .when(verleenOrganisatieErkenning(ONDERZOEK_ID))
                .expectSuccessfulHandlerExecution()
                .expectEvents(organisatieErkenningVerleend(ONDERZOEK_ID));
    }

    @Test
    void gegevenOnderzoekGeinitieerd_wanneerVerleenOrganisatieErkenningCommand_verwachtGeenEvents() {
        fixture.given(
                        onderzoekGeinitieerd()
                )
                .when(verleenOrganisatieErkenning(ONDERZOEK_ID))
                .expectSuccessfulHandlerExecution()
                .expectNoEvents();
    }

    @Test
    void gegevenOnderzoekIsInBehandeling_wanneerTrekOnderzoekErkenningInCommand_verwachtOnderzoekErkenningIngetrokkenEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend(),
                        onderzoekInBehandelingGenomen()
                )
                .when(trekOnderzoekErkenningIn(ONDERZOEK_ID))
                .expectSuccessfulHandlerExecution()
                .expectEvents(onderzoekErkenningIngetrokken(ONDERZOEK_ID));
    }

    @Test
    void gegevenOnderzoekGeinitieerd_wanneerTrekOnderzoekErkenningInCommand_verwachtGeenEvents() {
        fixture.given(
                        onderzoekGeinitieerd()
                )
                .when(trekOnderzoekErkenningIn(ONDERZOEK_ID))
                .expectSuccessfulHandlerExecution()
                .expectNoEvents();
    }

    @Test
    void gegevenOnderzoekIsInBehandeling_wanneerHerleefOnderzoekErkenningCommand_verwachtOnderzoekErkenningHerleefdEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend(),
                        onderzoekInBehandelingGenomen()
                )
                .when(herleefOnderzoekErkenning(ONDERZOEK_ID))
                .expectSuccessfulHandlerExecution()
                .expectEvents(onderzoekErkenningHerleefd(ONDERZOEK_ID));
    }

    @Test
    void gegevenOnderzoekGeinitieerd_wanneerHerleefOnderzoekErkenningCommand_verwachtGeenEvents() {
        fixture.given(
                        onderzoekGeinitieerd()
                )
                .when(herleefOnderzoekErkenning(ONDERZOEK_ID))
                .expectSuccessfulHandlerExecution()
                .expectNoEvents();
    }

    @Test
    void gegevenOnderzoekIsInBehandeling_wanneerWijzigOrganisatieErkenningsdoelCommand_verwachtOrganisatieErkenningsdoelGewijzigdEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend(),
                        onderzoekInBehandelingGenomen()
                )
                .when(wijzigOrganisatieErkenningsdoel(ONDERZOEK_ID))
                .expectSuccessfulHandlerExecution()
                .expectEvents(organisatieErkenningsdoelGewijzigd(ONDERZOEK_ID));
    }

    @Test
    void gegevenOnderzoekGeinitieerd_wanneerWijzigOrganisatieErkenningsdoelCommand_verwachtGeenEvents() {
        fixture.given(
                        onderzoekGeinitieerd()
                )
                .when(wijzigOrganisatieErkenningsdoel(ONDERZOEK_ID))
                .expectSuccessfulHandlerExecution()
                .expectNoEvents();
    }

}