package nl.ind.onderzoek.domain.command.onderzoek.event.maatregel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.command.onderzoek.event.AbstractOnderzoekEvent;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@SuperBuilder
@NoArgsConstructor
@Getter
public class BestuurlijkeBoeteOpgelegdVerwerkt extends AbstractOnderzoekEvent {

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
