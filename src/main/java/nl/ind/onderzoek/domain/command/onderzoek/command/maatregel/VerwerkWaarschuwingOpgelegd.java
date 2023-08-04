package nl.ind.onderzoek.domain.command.onderzoek.command.maatregel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.command.onderzoek.command.AbstractOnderzoekCommand;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor
@SuperBuilder
public class VerwerkWaarschuwingOpgelegd extends AbstractOnderzoekCommand {

    private UUID waarschuwingId;
    private UUID erkenningId;
    private UUID erkendeReferentId;
    private String documentBriefId;
    private LocalDate opleggingsdatum;
    private String plichtCategorie;
    private UUID vastgesteldePlichtId;
}
