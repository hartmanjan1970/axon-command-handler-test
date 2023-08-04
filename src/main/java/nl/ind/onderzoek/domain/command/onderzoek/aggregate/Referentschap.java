package nl.ind.onderzoek.domain.command.onderzoek.aggregate;

import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.command.onderzoek.Inkomen;
import nl.ind.onderzoek.domain.command.onderzoek.command.inkomen.VerwerkReferentschapInkomenOntvangen;
import nl.ind.onderzoek.domain.command.onderzoek.command.referentschap.VerwerkBeeindigdReferentschapBijgewerkt;
import nl.ind.onderzoek.domain.command.onderzoek.command.referentschap.VerwerkReferentschapBeeindigd;
import nl.ind.onderzoek.domain.command.onderzoek.command.referentschap.VerwerkReferentschapOngedaanGemaakt;
import nl.ind.onderzoek.domain.command.onderzoek.event.inkomen.GegevensEnBescheidenOpvragenBijgewerkt;
import nl.ind.onderzoek.domain.command.onderzoek.event.inkomen.ReferentschapInkomenOntvangenMapper;
import nl.ind.onderzoek.domain.command.onderzoek.event.inkomen.ReferentschapInkomenOntvangenVerwerkt;
import nl.ind.onderzoek.domain.command.onderzoek.event.referentschap.BeeindigdReferentschapBijgewerktVerwerkt;
import nl.ind.onderzoek.domain.command.onderzoek.event.referentschap.ReferentschapBeeindigdVerwerkt;
import nl.ind.onderzoek.domain.command.onderzoek.event.referentschap.ReferentschapOngedaanGemaaktVerwerkt;
import nl.ind.onderzoek.domain.referentschap.Beperking;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.EntityId;

import java.math.BigDecimal;
import java.util.UUID;

import static java.math.BigDecimal.ZERO;
import static java.math.RoundingMode.HALF_UP;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@EqualsAndHashCode
@SuperBuilder
public class Referentschap {

    @EntityId
    private UUID referentschapId;

    private UUID persoonId;
    private Beperking beperking;
    private boolean gegevensEnBescheidenOpvragen;

    @CommandHandler
    public void verwerkReferentschapBeeindigd(VerwerkReferentschapBeeindigd command) {
        apply(ReferentschapBeeindigdVerwerkt.builder()
                .onderzoekId(command.getOnderzoekId())
                .referentschapId(command.getReferentschapId())
                .beperking(this.beperking)
                .einddatum(command.getEinddatum())
                .build());
    }

    @CommandHandler
    public void verwerkReferentschapOngedaanGemaaktVerwerkt(VerwerkReferentschapOngedaanGemaakt command) {
        apply(ReferentschapOngedaanGemaaktVerwerkt.builder()
                .onderzoekId(command.getOnderzoekId())
                .referentschapId(command.getReferentschapId())
                .beperking(this.beperking)
                .build());
    }

    @CommandHandler
    public void verwerkBeeindigdReferentschapBijgewerktVerwerkt(VerwerkBeeindigdReferentschapBijgewerkt command) {
        apply(BeeindigdReferentschapBijgewerktVerwerkt.builder()
                .onderzoekId(command.getOnderzoekId())
                .referentschapId(command.getReferentschapId())
                .beperking(this.beperking)
                .einddatum(command.getEinddatum())
                .build());
    }

    @CommandHandler
    public void verwerkReferentschapInkomenOntvangen(VerwerkReferentschapInkomenOntvangen command, ReferentschapInkomenOntvangenMapper mapper) {
        BigDecimal aantalPeriodieken = BigDecimal.valueOf(command.getInkomens().size());

        ReferentschapInkomenOntvangenVerwerkt event = mapper.map(command);
        event.setGemiddeldSocialeVerzekeringsloonBedrag(
                command.getInkomens()
                        .stream()
                        .map(Inkomen::getSocialeVerzekeringsloonBedrag)
                        .reduce(BigDecimal::add)
                        .map(loonSom -> loonSom.divide(aantalPeriodieken, HALF_UP))
                        .orElse(ZERO)
        );
        apply(event);
    }

// Fixme, Deze CommandHandler wordt onbekende reden niet bereikt. Als het command `WerkGegevensEnBescheidenOpvragenBij` in OnderzoekReferentschap staat wordt de CommandHandler WEL gevonden ????
//    @CommandHandler
//    public void werkGegevensEnBescheidenOpvragenBij(WerkGegevensEnBescheidenOpvragenBij command) {
//        if (command.getOnderzoekStatus().isInOnderzoek())
//            apply(GegevensEnBescheidenOpvragenBijgewerkt.builder()
//                    .onderzoekId(command.getOnderzoekId())
//                    .referentschapId(command.getReferentschapId())
//                    .gegevensEnBescheidenOpvragen(command.isGegevensEnBescheidenOpvragen())
//                    .build());
//    }

    @EventSourcingHandler
    public void gegevensEnBescheidenOpvragenBijgewerkt(GegevensEnBescheidenOpvragenBijgewerkt event) {
        this.gegevensEnBescheidenOpvragen = event.isGegevensEnBescheidenOpvragen();
    }
}
