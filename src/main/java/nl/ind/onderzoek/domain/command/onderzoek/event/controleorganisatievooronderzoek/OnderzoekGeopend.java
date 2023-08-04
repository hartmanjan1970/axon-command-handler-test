package nl.ind.onderzoek.domain.command.onderzoek.event.controleorganisatievooronderzoek;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import nl.ind.onderzoek.domain.command.onderzoek.Erkenning;
import nl.ind.onderzoek.domain.command.onderzoek.event.AbstractOnderzoekEvent;

import java.util.UUID;

@Getter
@Jacksonized
@SuperBuilder
@ToString
public class OnderzoekGeopend extends AbstractOnderzoekEvent {

    private UUID organisatieId;
    private String naamErkendeReferent;
    private Erkenning erkenningInOnderzoek;

}