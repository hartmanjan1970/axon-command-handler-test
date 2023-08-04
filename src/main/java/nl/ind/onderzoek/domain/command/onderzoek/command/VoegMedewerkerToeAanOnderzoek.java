package nl.ind.onderzoek.domain.command.onderzoek.command;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Getter
@Jacksonized
@SuperBuilder
@ToString
public class VoegMedewerkerToeAanOnderzoek extends AbstractOnderzoekCommand {

    private UUID medewerkerId;
}
