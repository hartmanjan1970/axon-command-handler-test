package nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.command.onderzoek.command.AbstractOnderzoekCommand;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString
public class AbstractAandachtspuntCommand extends AbstractOnderzoekCommand {

    private UUID aandachtspuntId;

}
