package nl.ind.onderzoek.domain.command.onderzoek.event;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Getter
@Jacksonized
@SuperBuilder
@ToString
public class MedewerkerAanOnderzoekToegevoegd extends AbstractOnderzoekEvent {

    private UUID medewerkerId;
}
