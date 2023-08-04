package nl.ind.onderzoek.domain.command.onderzoek.aggregate;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.Test;

import static nl.ind.onderzoek.utils.aandachtspunt.AandachtspuntCommandUtils.*;
import static nl.ind.onderzoek.utils.aandachtspunt.AandachtspuntEventUtils.*;
import static nl.ind.onderzoek.utils.onderzoek.OnderzoekEventUtils.onderzoekGeinitieerd;
import static nl.ind.onderzoek.utils.onderzoek.OnderzoekEventUtils.onderzoekGeopend;
import static nl.ind.onderzoek.utils.organisatie.OrganisatieEventUtils.*;

//@Disabled("Test ignored omdat test incorrect CommandHandler not found exceptie geeft, IT testen werkt CommandHandler wel")
class AandachtspuntTest {

    FixtureConfiguration<Onderzoek> fixture = new AggregateTestFixture<>(Onderzoek.class);

    @Test
    void gegevenOnderzoekGeopend_wanneerWerkAandachtspuntAlgemeenBeeldBijCommand_verwachtAandachtspuntAlgemeenBeeldBijgewerktEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend()
                )
                .when(werkAandachtspuntAlgemeenBeeldBij())
                .expectSuccessfulHandlerExecution()
                .expectEvents(aandachtspuntAlgemeenBeeldBijgewerkt());
    }

    @Test
    void gegevenOnderzoekGeopend_wanneerWerkAandachtspuntKennismigrantenBijCommand_verwachtAandachtspuntKennismigrantenBijgewerktEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend()
                )
                .when(werkAandachtspuntKennismigrantenBij())
                .expectSuccessfulHandlerExecution()
                .expectEvents(aandachtspuntKennismigrantenBijgewerkt());
    }

    @Test
    void gegevenOnderzoekGeopend_wanneerWerkAandachtspuntInkomenKennismigrantBijCommand_verwachtAandachtspuntInkomenKennismigrantBijgewerktEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend()
                )
                .when(werkAandachtspuntInkomenKennismigrantBij())
                .expectSuccessfulHandlerExecution()
                .expectEvents(aandachtspuntInkomenKennismigrantBijgewerkt());
    }

    @Test
    void gegevenOnderzoekGeopend_wanneerWerkAandachtspuntMaatregelBijCommand_verwachtAandachtspuntMaatregelBijgewerktEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend()
                )
                .when(werkAandachtspuntMaatregelBij())
                .expectSuccessfulHandlerExecution()
                .expectEvents(aandachtspuntMaatregelBijgewerkt());
    }

}