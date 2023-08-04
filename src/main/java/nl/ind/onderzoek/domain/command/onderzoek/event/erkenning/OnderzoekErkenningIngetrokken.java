package nl.ind.onderzoek.domain.command.onderzoek.event.erkenning;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import nl.ind.onderzoek.domain.command.onderzoek.event.AbstractOnderzoekEvent;

import java.time.LocalDate;
import java.util.UUID;

@SuperBuilder
@Getter
@Jacksonized
@ToString
public class OnderzoekErkenningIngetrokken extends AbstractOnderzoekEvent {

    private UUID erkenningId;
    private LocalDate einddatum;

}
