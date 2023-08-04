package nl.ind.onderzoek.domain.command.onderzoek.aggregate;

import nl.ind.onderzoek.domain.command.onderzoek.event.inkomen.ReferentschapInkomenOntvangenMapperImpl;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.Test;

import static nl.ind.onderzoek.utils.TestConstanten.ONDERZOEK_STATUS_AFGEROND;
import static nl.ind.onderzoek.utils.TestConstanten.ONDERZOEK_STATUS_OPEN;
import static nl.ind.onderzoek.utils.onderzoek.OnderzoekEventUtils.*;
import static nl.ind.onderzoek.utils.organisatie.OrganisatieEventUtils.*;
import static nl.ind.onderzoek.utils.referentschap.ReferentschapCommandUtils.*;
import static nl.ind.onderzoek.utils.referentschap.ReferentschapEventUtils.*;

class OnderzoekReferentschapTest {

    private final FixtureConfiguration<Onderzoek> fixture = new AggregateTestFixture<>(Onderzoek.class);

    @Test
    void gegevenOnderzoekGeopendNaarOrganisatieMetReferentschappen_wanneerBewaarReferentschappenVoorOrganisatieCommand_verwachtReferentschappenVoorOrganisatieBewaardEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend()
                )
                .when(bewaarReferentschappenVoorOrganisatie())
                .expectSuccessfulHandlerExecution()
                .expectEvents(referentschappenVoorOrganisatieBewaard());
    }

    @Test
    void gegevenOnderzoekGeopendNaarOrganisatieZonderReferentschappen_wanneerBewaarReferentschappenVoorOrganisatieCommand_verwachtGeenEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend()
                )
                .when(bewaarReferentschappenVoorOrganisatie_zonderReferentschappen())
                .expectSuccessfulHandlerExecution()
                .expectNoEvents();
    }

    @Test
    void gegevenOnderzoekIsNietOpenNaarOrganisatieMetReferentschappen_wanneerBewaarReferentschappenVoorOrganisatieCommand_verwachtGeenEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel()
                )
                .when(bewaarReferentschappenVoorOrganisatie())
                .expectSuccessfulHandlerExecution()
                .expectNoEvents();
    }

    @Test
    void gegevenOnderzoekGeopendNaarOrganisatie_wanneerVerwerkReferentschapOntstaanCommand_verwachtEventReferentschapOntstaanVerwerkt() {
        fixture.given(onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend()
                )
                .when(verwerkReferentschapOntstaan())
                .expectSuccessfulHandlerExecution()
                .expectEvents(referentschapOntstaanVerwerkt());
    }

    @Test
    void gegevenOnderzoekNaarOrganisatieIsNietInOnderzoek_wanneerVerwerkReferentschapOntstaanCommand_verwachtGeenActie() {
        fixture.given(onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel()
                )
                .when(verwerkReferentschapOntstaan())
                .expectSuccessfulHandlerExecution()
                .expectNoEvents();
    }

    @Test
    void gegevenOnderzoekIsOpen_wanneerWerkGegevensEnBescheidenOpvragenBij_verwachtGegevensEnBescheidenOpvragenBijgewerktEvent() {
        fixture.registerInjectableResource(new ReferentschapInkomenOntvangenMapperImpl())
                .given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend(),
                        referentschapOntstaanVerwerkt()
                )
                .when(werkGegevensEnBescheidenOpvragenBij(ONDERZOEK_STATUS_OPEN))
                .expectSuccessfulHandlerExecution()
                .expectEvents(gegevensEnBescheidenOpvragenBijgewerkt());
    }

    @Test
    void gegevenOnderzoekIsNietOpen_wanneerWerkGegevensEnBescheidenOpvragenBij_verwachtGeenEvent() {
        fixture.registerInjectableResource(new ReferentschapInkomenOntvangenMapperImpl())
                .given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend(),
                        referentschapOntstaanVerwerkt(),
                        onderzoekIsAfgerond()
                )
                .when(werkGegevensEnBescheidenOpvragenBij(ONDERZOEK_STATUS_AFGEROND))
                .expectSuccessfulHandlerExecution()
                .expectNoEvents();
    }

}
