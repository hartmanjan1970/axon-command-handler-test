package nl.ind.onderzoek.domain.command.onderzoek.command.maatregel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.command.onderzoek.command.AbstractOnderzoekCommand;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor
@SuperBuilder
public class VerwerkBestuurlijkeBoeteOpgelegd extends AbstractOnderzoekCommand {

    private UUID bestuurlijkeBoeteId;
    private BigDecimal hoogte;
    private UUID erkenningId;
    private UUID erkendeReferentId;
    private String documentBeschikkingId;
    private String grondslag;
    private LocalDate opleggingsdatum;
    private String plichtCategorie;
    private UUID vastgesteldePlichtId;
}
