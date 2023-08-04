package nl.ind.onderzoek.domain.command.onderzoek.event.maatregel;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import nl.ind.onderzoek.domain.command.onderzoek.event.AbstractOnderzoekEvent;

import java.time.LocalDate;
import java.util.UUID;

@SuperBuilder
@Getter
@Jacksonized
public class WaarschuwingVerwijderdVerwerkt extends AbstractOnderzoekEvent {

    private UUID waarschuwingId;
    private LocalDate verwijderingsdatum;
}
