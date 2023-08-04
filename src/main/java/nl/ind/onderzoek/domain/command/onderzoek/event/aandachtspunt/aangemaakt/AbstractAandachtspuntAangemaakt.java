package nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.aangemaakt;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.command.onderzoek.aggregate.Aandachtspunt;
import nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.AbstractAandachtspuntEvent;

@EqualsAndHashCode
@Getter
@SuperBuilder
@ToString
public abstract class AbstractAandachtspuntAangemaakt extends AbstractAandachtspuntEvent {

    private Aandachtspunt aandachtspunt;

}
