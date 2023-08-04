package nl.ind.onderzoek.domain.command.onderzoek.aggregate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.VerplichtingCategorie;
import nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.werkbij.WerkAandachtspuntMaatregelBij;
import nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.bijgewerkt.AandachtspuntMaatregelBijgewerkt;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;

import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
@SuperBuilder
@ToString
public class AandachtspuntMaatregel extends Aandachtspunt {

    private UUID maatregelId;
    private VerplichtingCategorie categorie;

    @CommandHandler
    public void werkAandachtspuntBij(WerkAandachtspuntMaatregelBij command) {
        apply(AandachtspuntMaatregelBijgewerkt.builder()
                .onderzoekId(command.getOnderzoekId())
                .aandachtspuntId(command.getAandachtspuntId())
                .aandachtspunt(AandachtspuntMaatregel.builder()
                        .onderzoekId(command.getOnderzoekId())
                        .aandachtspuntId(command.getAandachtspuntId())
                        .beschrijving(command.getBeschrijving())
                        .maatregelId(command.getMaatregelId())
                        .categorie(command.getCategorie())
                        .build())
                .build()
        );
    }

    @EventSourcingHandler
    public void aandachtspuntBijgewerkt(AandachtspuntMaatregelBijgewerkt event) {
        super.aandachtspuntBijgewerkt(event);

        AandachtspuntMaatregel aandachtspunt = event.getAandachtspunt();
        this.maatregelId = aandachtspunt.getMaatregelId();
        this.categorie = aandachtspunt.getCategorie();
    }
}
