package nl.ind.onderzoek.domain.command.onderzoek.command.erkenning;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.Erkenningsdoel;
import nl.ind.onderzoek.domain.command.onderzoek.command.AbstractOnderzoekCommand;

import java.util.UUID;

@Getter
@NoArgsConstructor
@SuperBuilder
@ToString
public class WijzigOrganisatieErkenningsdoel extends AbstractOnderzoekCommand {

    private UUID erkenningId;
    private UUID organisatieId;
    private Erkenningsdoel erkenningsdoel;

}
