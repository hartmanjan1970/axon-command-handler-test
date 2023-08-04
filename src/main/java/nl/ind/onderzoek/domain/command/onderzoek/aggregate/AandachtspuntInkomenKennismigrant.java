package nl.ind.onderzoek.domain.command.onderzoek.aggregate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.VerplichtingCategorie;
import nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.werkbij.WerkAandachtspuntInkomenKennismigrantBij;
import nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.bijgewerkt.AandachtspuntInkomenKennismigrantBijgewerkt;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;

import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
@SuperBuilder
@ToString
public class AandachtspuntInkomenKennismigrant extends Aandachtspunt {

    private UUID referentschapId;
    private VerplichtingCategorie categorie;

    @CommandHandler
    public void werkAandachtspuntBij(WerkAandachtspuntInkomenKennismigrantBij command) {
        apply(AandachtspuntInkomenKennismigrantBijgewerkt.builder()
                .onderzoekId(command.getOnderzoekId())
                .aandachtspuntId(command.getAandachtspuntId())
                .aandachtspunt(AandachtspuntInkomenKennismigrant.builder()
                        .onderzoekId(command.getOnderzoekId())
                        .aandachtspuntId(command.getAandachtspuntId())
                        .beschrijving(command.getBeschrijving())
                        .referentschapId(command.getReferentschapId())
                        .categorie(command.getCategorie())
                        .build())
                .build()
        );
    }

    @EventSourcingHandler
    public void aandachtspuntBijgewerkt(AandachtspuntInkomenKennismigrantBijgewerkt event) {
        super.aandachtspuntBijgewerkt(event);

        AandachtspuntInkomenKennismigrant aandachtspunt = event.getAandachtspunt();
        this.referentschapId = aandachtspunt.getReferentschapId();
        this.categorie = aandachtspunt.getCategorie();
    }
}
