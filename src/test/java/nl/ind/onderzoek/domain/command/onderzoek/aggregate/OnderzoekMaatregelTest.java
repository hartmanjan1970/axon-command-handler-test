package nl.ind.onderzoek.domain.command.onderzoek.aggregate;

import nl.ind.onderzoek.domain.command.onderzoek.event.maatregel.MaatregelCommandToEventMapperImpl;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static nl.ind.onderzoek.utils.TestConstanten.*;
import static nl.ind.onderzoek.utils.onderzoek.OnderzoekEventUtils.onderzoekGeinitieerd;
import static nl.ind.onderzoek.utils.onderzoek.OnderzoekEventUtils.onderzoekGeopend;
import static nl.ind.onderzoek.utils.waarschuwing.WaarschuwingCommandUtils.*;
import static nl.ind.onderzoek.utils.waarschuwing.WaarschuwingEventUtils.*;
import static org.axonframework.test.matchers.Matchers.*;

class OnderzoekMaatregelTest {

    private final FixtureConfiguration<Onderzoek> fixture = new AggregateTestFixture<>(Onderzoek.class);

    @BeforeEach
    void setUp() {
        fixture.registerInjectableResource(new MaatregelCommandToEventMapperImpl());
    }

    @Test
    void gegevenOnderzoekIsOpen_wanneerBewaarBestaandeMaatregelen_verwachtBestaandeMaatregelenBewaard() {
        fixture.given(onderzoekGeinitieerd(), onderzoekGeopend())
                .when(bewaarBestaandeMaatregelen())
                .expectSuccessfulHandlerExecution()
                .expectEventsMatching(exactSequenceOf(messageWithPayload(deepEquals(bestaandeMaatregelenBewaard()))));
    }

    @Test
    void gegevenOnderzoekGestart_wanneerVerwerkBestuurlijkeBoeteOpgelegd_verwachtBestuurlijkeBoeteOpgelegdVerwerkt() {
        fixture.given(onderzoekGeinitieerd())
                .when(verwerkBestuurlijkeBoeteOpgelegd(ONDERZOEK_ID))
                .expectSuccessfulHandlerExecution()
                .expectEvents(bestuurlijkeBoeteOpgelegdVerwerkt(ONDERZOEK_ID));
    }

    @Test
    void gegevenOnderzoekGestart_wanneerVerwerkWaarschuwingOpgelegd_verwachtWaarschuwingOpgelegdVerwerkt() {
        fixture.given(onderzoekGeinitieerd())
                .when(verwerkWaarschuwingOpgelegd(ONDERZOEK_ID, ERKENNING_ID))
                .expectSuccessfulHandlerExecution()
                .expectEvents(waarschuwingOpgelegdVerwerkt(ONDERZOEK_ID, DOCUMENT_ID));
    }

}