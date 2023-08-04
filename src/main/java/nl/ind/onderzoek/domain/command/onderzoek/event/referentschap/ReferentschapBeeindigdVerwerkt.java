package nl.ind.onderzoek.domain.command.onderzoek.event.referentschap;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import nl.ind.onderzoek.domain.command.onderzoek.event.AbstractOnderzoekEvent;
import nl.ind.onderzoek.domain.referentschap.Beperking;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Jacksonized
@SuperBuilder
@ToString
public class ReferentschapBeeindigdVerwerkt extends AbstractOnderzoekEvent {

    private UUID referentschapId;
    private LocalDate einddatum;
    private Beperking beperking;
}
