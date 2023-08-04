package nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.werkbij;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.AbstractAandachtspuntCommand;

@Getter
@NoArgsConstructor
@SuperBuilder
@ToString
public abstract class AbstractWerkAandachtspuntBij extends AbstractAandachtspuntCommand {

    private String beschrijving;

}
