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

//@Disabled("Test ignored omdat test incorrect CommandHandler not found exceptie geeft, IT testen werkt CommandHandler wel")
class ReferentschapTest {

    FixtureConfiguration<Onderzoek> fixture = new AggregateTestFixture<>(Onderzoek.class);

    @Test
    void gegevenOnderzoekIsOpen_wanneerVerwerkReferentschapBeeindigdCommand_verwachtReferentschapBeeindigdVerwerktEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend(),
                        referentschapOntstaanVerwerkt()
                )
                .when(verwerkReferentschapBeeindigd())
                .expectSuccessfulHandlerExecution()
                .expectEvents(referentschapBeeindigdVerwerkt());
    }

    @Test
    void gegevenOnderzoekIsOpen_wanneerVerwerkReferentschapOngedaanGemaaktCommand_verwachtReferentschapOngedaanGemaaktVerwerktEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend(),
                        referentschapOntstaanVerwerkt()
                )
                .when(verwerkReferentschapOngedaanGemaakt())
                .expectSuccessfulHandlerExecution()
                .expectEvents(referentschapOngedaanGemaaktVerwerkt());
    }

    @Test
    void gegevenOnderzoekIsOpen_wanneerVerwerkBeeindigdReferentschapBijgewerktCommand_verwachtBeeindigdReferentschapBijgewerktVerwerktEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend(),
                        referentschapOntstaanVerwerkt()
                )
                .when(verwerkBeeindigdReferentschapBijgewerkt())
                .expectSuccessfulHandlerExecution()
                .expectEvents(beeindigdReferentschapBijgewerktVerwerkt());
    }

    @Test
    void gegevenOnderzoekIsOpen_wanneerVerwerkReferentschapInkomenOntvangenCommand_verwachtReferentschapInkomenOntvangenVerwerktEvent() {
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
                .when(verwerkReferentschapInkomenOntvangen())
                .expectSuccessfulHandlerExecution()
                .expectEvents(referentschapInkomenOntvangenVerwerkt());
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