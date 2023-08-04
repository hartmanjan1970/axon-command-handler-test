package nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.command.onderzoek.event.AbstractOnderzoekEvent;

import java.util.UUID;

@EqualsAndHashCode
@Getter
@SuperBuilder
@ToString
public abstract class AbstractAandachtspuntEvent extends AbstractOnderzoekEvent {

    private UUID aandachtspuntId;

}
