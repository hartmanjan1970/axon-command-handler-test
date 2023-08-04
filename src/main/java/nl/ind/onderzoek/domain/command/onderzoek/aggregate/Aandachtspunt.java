package nl.ind.onderzoek.domain.command.onderzoek.aggregate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.werkbij.WerkAandachtspuntMaatregelBij;
import nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.bijgewerkt.AbstractAandachtspuntBijgewerkt;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.EntityId;

import java.util.UUID;

@EqualsAndHashCode
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public abstract class Aandachtspunt {

    @EntityId
    private UUID aandachtspuntId;

    private UUID onderzoekId;
    private String beschrijving;

    public void aandachtspuntBijgewerkt(AbstractAandachtspuntBijgewerkt event) {
        Aandachtspunt aandachtspunt = event.getAandachtspunt();
        this.beschrijving = aandachtspunt.getBeschrijving();
    }

    @CommandHandler
    public void werkAandachtspuntBij(WerkAandachtspuntMaatregelBij command) {
        command.getBeschrijving();
    }
}