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
public class WaarschuwingOpgelegdVerwerkt extends AbstractOnderzoekEvent {

    private UUID waarschuwingId;
    private UUID erkenningId;
    private UUID erkendeReferentId;
    private String documentBriefId;
    private LocalDate opleggingsdatum;
    private String plichtCategorie;
    private UUID vastgesteldePlichtId;
}
