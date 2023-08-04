package nl.ind.onderzoek.domain.command.onderzoek.aggregate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.VoorwaardeCategorie;
import nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.werkbij.WerkAandachtspuntAlgemeenBeeldBij;
import nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.bijgewerkt.AandachtspuntAlgemeenBeeldBijgewerkt;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
@SuperBuilder
@ToString
public class AandachtspuntAlgemeenBeeld extends Aandachtspunt {

    private VoorwaardeCategorie categorie;

    @CommandHandler
    public void werkAandachtspuntBij(WerkAandachtspuntAlgemeenBeeldBij command) {
        apply(AandachtspuntAlgemeenBeeldBijgewerkt.builder()
                .onderzoekId(command.getOnderzoekId())
                .aandachtspuntId(command.getAandachtspuntId())
                .aandachtspunt(AandachtspuntAlgemeenBeeld.builder()
                        .onderzoekId(command.getOnderzoekId())
                        .aandachtspuntId(command.getAandachtspuntId())
                        .beschrijving(command.getBeschrijving())
                        .categorie(command.getCategorie())
                        .build())
                .build());
    }

    @EventSourcingHandler
    public void aandachtspuntBijgewerkt(AandachtspuntAlgemeenBeeldBijgewerkt event) {
        super.aandachtspuntBijgewerkt(event);

        AandachtspuntAlgemeenBeeld aandachtspunt = event.getAandachtspunt();
        this.categorie = aandachtspunt.getCategorie();
    }
}
