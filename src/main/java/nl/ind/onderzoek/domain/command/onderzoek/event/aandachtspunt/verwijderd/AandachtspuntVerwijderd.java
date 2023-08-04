package nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.verwijderd;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.AbstractAandachtspuntEvent;

@EqualsAndHashCode(callSuper = true)
@Getter
@Jacksonized
@SuperBuilder
@ToString
public class AandachtspuntVerwijderd extends AbstractAandachtspuntEvent {
}
