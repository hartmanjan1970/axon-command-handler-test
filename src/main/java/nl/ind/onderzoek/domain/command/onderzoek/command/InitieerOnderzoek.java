package nl.ind.onderzoek.domain.command.onderzoek.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.Erkenningsdoel;
import nl.ind.onderzoek.domain.Reden;

@Getter
@SuperBuilder
@NoArgsConstructor
@ToString
public class InitieerOnderzoek extends AbstractOnderzoekCommand {

    private String kvkNummer;
    private Erkenningsdoel erkenningsdoel;
    private Reden reden;

}
