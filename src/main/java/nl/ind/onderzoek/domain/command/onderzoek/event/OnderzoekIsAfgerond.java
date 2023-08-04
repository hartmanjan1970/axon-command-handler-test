package nl.ind.onderzoek.domain.command.onderzoek.event;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@SuperBuilder
@Getter
@Jacksonized
@ToString
public class OnderzoekIsAfgerond extends AbstractOnderzoekEvent {

}
