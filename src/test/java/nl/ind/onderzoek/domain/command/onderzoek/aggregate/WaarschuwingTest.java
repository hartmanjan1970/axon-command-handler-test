package nl.ind.onderzoek.domain.command.onderzoek.aggregate;

import nl.ind.onderzoek.domain.command.onderzoek.event.maatregel.MaatregelCommandToEventMapperImpl;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static nl.ind.onderzoek.utils.TestConstanten.DOCUMENT_ID;
import static nl.ind.onderzoek.utils.TestConstanten.ONDERZOEK_ID;
import static nl.ind.onderzoek.utils.onderzoek.OnderzoekEventUtils.onderzoekGeinitieerd;
import static nl.ind.onderzoek.utils.waarschuwing.WaarschuwingCommandUtils.verwerkWaarschuwingVerlopen;
import static nl.ind.onderzoek.utils.waarschuwing.WaarschuwingCommandUtils.verwerkWaarschuwingVerwijderd;
import static nl.ind.onderzoek.utils.waarschuwing.WaarschuwingEventUtils.*;

//@Disabled("Test ignored omdat test incorrect CommandHandler not found exceptie geeft, IT testen werkt CommandHandler wel")
class WaarschuwingTest {

    private final FixtureConfiguration<Onderzoek> fixture = new AggregateTestFixture<>(Onderzoek.class);

    @BeforeEach
    void setUp() {
        fixture.registerInjectableResource(new MaatregelCommandToEventMapperImpl());
    }

    @Test
    void gegevenOnderzoekGestartWaarschuwingOpgelegdVerwerkt_wanneerVerwerkWaarschuwingVerlopen_verwachtWaarschuwingVerlopenVerwerkt() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        waarschuwingOpgelegdVerwerkt(ONDERZOEK_ID, DOCUMENT_ID)
                )
                .when(verwerkWaarschuwingVerlopen(ONDERZOEK_ID))
                .expectSuccessfulHandlerExecution()
                .expectEvents(waarschuwingVerlopenVerwerkt(ONDERZOEK_ID));
    }

    @Test
    void gegevenOnderzoekGestartWaarschuwingOpgelegdVerwerkt_wanneerVerwerkWaarschuwingVerwijderd_verwachtWaarschuwingVerwijderdVerwerkt() {
        fixture.given(
                        onderzoekGeinitieerd(),
                        waarschuwingOpgelegdVerwerkt(ONDERZOEK_ID, DOCUMENT_ID)
                )
                .when(verwerkWaarschuwingVerwijderd(ONDERZOEK_ID))
                .expectSuccessfulHandlerExecution()
                .expectEvents(waarschuwingVerwijderdVerwerkt(ONDERZOEK_ID));
    }

}