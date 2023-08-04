package nl.ind.onderzoek.domain.command.onderzoek.command.controleorganisatievooronderzoek;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.command.onderzoek.command.AbstractOnderzoekCommand;

@Getter
@NoArgsConstructor
@SuperBuilder
@ToString
public class OpenOnderzoek extends AbstractOnderzoekCommand {

    private String naamErkendeReferent;

}
