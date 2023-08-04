package nl.ind.onderzoek.domain.command.onderzoek.command;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Getter
@Jacksonized
@SuperBuilder
@ToString
public class NeemOnderzoekInBehandeling extends AbstractOnderzoekCommand {
}
