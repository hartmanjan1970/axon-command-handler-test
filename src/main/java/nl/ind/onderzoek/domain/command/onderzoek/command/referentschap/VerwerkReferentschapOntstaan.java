package nl.ind.onderzoek.domain.command.onderzoek.command.referentschap;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.command.onderzoek.command.AbstractOnderzoekCommand;
import nl.ind.onderzoek.domain.referentschap.Beperking;
import nl.ind.onderzoek.domain.referentschap.ReferentschapStatus;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor
@SuperBuilder
@ToString
public class VerwerkReferentschapOntstaan extends AbstractOnderzoekCommand {

    private UUID referentschapId;
    private UUID erkenningId;
    private UUID persoonId;
    private UUID organisatieId;
    private String grondslag;
    private LocalDate startdatum;
    private Beperking beperking;
    private ReferentschapStatus referentschapStatus;

}
