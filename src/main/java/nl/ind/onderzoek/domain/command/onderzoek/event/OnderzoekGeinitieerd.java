package nl.ind.onderzoek.domain.command.onderzoek.event;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import nl.ind.onderzoek.domain.Erkenningsdoel;
import nl.ind.onderzoek.domain.Reden;

@SuperBuilder
@Getter
@Jacksonized
@ToString
public class OnderzoekGeinitieerd extends AbstractOnderzoekEvent {

    private String kvkNummer;
    private Erkenningsdoel erkenningsdoel;
    private Reden reden;
}
