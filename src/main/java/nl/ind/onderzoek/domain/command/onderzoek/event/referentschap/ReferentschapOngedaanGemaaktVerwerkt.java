package nl.ind.onderzoek.domain.command.onderzoek.event.referentschap;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import nl.ind.onderzoek.domain.command.onderzoek.event.AbstractOnderzoekEvent;
import nl.ind.onderzoek.domain.referentschap.Beperking;

import java.util.UUID;

@Getter
@Jacksonized
@SuperBuilder
@ToString
public class ReferentschapOngedaanGemaaktVerwerkt extends AbstractOnderzoekEvent {

    private UUID referentschapId;

    private Beperking beperking;
}
