package nl.ind.onderzoek.domain.command.onderzoek.event.referentschap;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import nl.ind.onderzoek.domain.command.onderzoek.event.AbstractOnderzoekEvent;
import nl.ind.onderzoek.domain.referentschap.Beperking;
import nl.ind.onderzoek.domain.referentschap.ReferentschapStatus;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Jacksonized
@SuperBuilder
@ToString
public class ReferentschapOntstaanVerwerkt extends AbstractOnderzoekEvent {

    private UUID referentschapId;
    private UUID organisatieId;
    private UUID persoonId;
    private UUID erkenningId;

    private LocalDate startdatum;

    private String grondslag;
    private Beperking beperking;
    private ReferentschapStatus referentschapStatus;
}
