package nl.ind.onderzoek.domain.command.onderzoek.event.erkenning;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import nl.ind.onderzoek.domain.Erkenningsdoel;
import nl.ind.onderzoek.domain.command.onderzoek.event.AbstractOnderzoekEvent;

import java.util.UUID;

@SuperBuilder
@Getter
@Jacksonized
@ToString
public class OrganisatieErkenningsdoelGewijzigd extends AbstractOnderzoekEvent {

    private UUID erkenningId;
    private UUID organisatieId;
    private Erkenningsdoel erkenningsdoel;

}
