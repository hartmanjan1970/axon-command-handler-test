package nl.ind.onderzoek.domain.command.onderzoek.aggregate;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.Test;

import static nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.OnderzoekOnderdeel.*;
import static nl.ind.onderzoek.utils.TestConstanten.VERPLICHTING_CATEGORIE_INFORMATIEPLICHT_NAME;
import static nl.ind.onderzoek.utils.TestConstanten.VOORWAARDE_CATEGORIE_CONTINUITEIT_EN_SOLVABILITEIT_NAME;
import static nl.ind.onderzoek.utils.aandachtspunt.AandachtspuntCommandUtils.maakNieuwAandachtspuntAan;
import static nl.ind.onderzoek.utils.aandachtspunt.AandachtspuntEventUtils.*;
import static nl.ind.onderzoek.utils.onderzoek.OnderzoekEventUtils.onderzoekGeinitieerd;
import static nl.ind.onderzoek.utils.onderzoek.OnderzoekEventUtils.onderzoekGeopend;
import static nl.ind.onderzoek.utils.organisatie.OrganisatieEventUtils.*;

class OnderzoekAandachtspuntTest {

    private final FixtureConfiguration<Onderzoek> fixture = new AggregateTestFixture<>(Onderzoek.class);

    @Test
    void gegevenOnderzoekGeopend_wanneerMaakNieuwAandachtspuntAanCommand_voorAlgemeenBeeld_verwachtAandachtspuntAlgemeenBeeldEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend()
                )
                .when(maakNieuwAandachtspuntAan(ALGEMEEN_BEELD, VOORWAARDE_CATEGORIE_CONTINUITEIT_EN_SOLVABILITEIT_NAME))
                .expectSuccessfulHandlerExecution()
                .expectEvents(aandachtspuntAlgemeenBeeldAangemaakt());
    }

    @Test
    void gegevenOnderzoekGeopend_wanneerMaakNieuwAandachtspuntAanCommand_voorKennismigranten_verwachtAandachtspuntKennismigrantenEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend()
                )
                .when(maakNieuwAandachtspuntAan(KENNISMIGRANTEN, VERPLICHTING_CATEGORIE_INFORMATIEPLICHT_NAME))
                .expectSuccessfulHandlerExecution()
                .expectEvents(aandachtspuntKennismigrantenAangemaakt());
    }

    @Test
    void gegevenOnderzoekGeopend_wanneerMaakNieuwAandachtspuntAanCommand_voorInkomenKennismigrant_verwachtAandachtspuntInkomenKennismigrantEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend()
                )
                .when(maakNieuwAandachtspuntAan(INKOMEN_KENNISMIGRANT, VERPLICHTING_CATEGORIE_INFORMATIEPLICHT_NAME))
                .expectSuccessfulHandlerExecution()
                .expectEvents(aandachtspuntInkomenKennismigrantAangemaakt());
    }

    @Test
    void gegevenOnderzoekGeopend_wanneerMaakNieuwAandachtspuntAanCommand_voorMaatregelen_verwachtAandachtspuntMaatregelenEvent() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        organisatieVoorKvkNummerBestaat(),
                        organisatieHeeftErkenningMetErkenningsdoel(),
                        organisatieHeeftActieveErkenningMetErkenningsdoel(),
                        organisatieIsNietInOnderzoekVoorErkenningsdoel(),
                        onderzoekGeopend()
                )
                .when(maakNieuwAandachtspuntAan(MAATREGELEN, VERPLICHTING_CATEGORIE_INFORMATIEPLICHT_NAME))
                .expectSuccessfulHandlerExecution()
                .expectEvents(aandachtspuntMaatregelAangemaakt());
    }

}
