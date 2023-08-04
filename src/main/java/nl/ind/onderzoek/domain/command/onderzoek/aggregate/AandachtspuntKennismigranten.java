package nl.ind.onderzoek.domain.command.onderzoek.aggregate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.VerplichtingCategorie;
import nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.werkbij.WerkAandachtspuntKennismigrantenBij;
import nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.bijgewerkt.AandachtspuntKennismigrantenBijgewerkt;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
@SuperBuilder
@ToString
public class AandachtspuntKennismigranten extends Aandachtspunt {

    private VerplichtingCategorie categorie;

    @CommandHandler
    public void werkAandachtspuntBij(WerkAandachtspuntKennismigrantenBij command) {
        apply(AandachtspuntKennismigrantenBijgewerkt.builder()
                .onderzoekId(command.getOnderzoekId())
                .aandachtspuntId(command.getAandachtspuntId())
                .aandachtspunt(AandachtspuntKennismigranten.builder()
                        .onderzoekId(command.getOnderzoekId())
                        .aandachtspuntId(command.getAandachtspuntId())
                        .beschrijving(command.getBeschrijving())
                        .categorie(command.getCategorie())
                        .build())
                .build()
        );
    }

    @EventSourcingHandler
    public void aandachtspuntBijgewerkt(AandachtspuntKennismigrantenBijgewerkt event) {
        super.aandachtspuntBijgewerkt(event);

        AandachtspuntKennismigranten aandachtspunt = event.getAandachtspunt();
        this.categorie = aandachtspunt.getCategorie();
    }
}
