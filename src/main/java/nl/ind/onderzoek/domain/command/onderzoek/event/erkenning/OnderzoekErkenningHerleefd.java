package nl.ind.onderzoek.domain.command.onderzoek.event.erkenning;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import nl.ind.onderzoek.domain.command.onderzoek.Erkenning;
import nl.ind.onderzoek.domain.command.onderzoek.event.AbstractOnderzoekEvent;

import java.util.UUID;

@SuperBuilder
@Getter
@Jacksonized
@ToString
public class OnderzoekErkenningHerleefd extends AbstractOnderzoekEvent {

    private UUID organisatieId;
    private Erkenning erkenning;

}
