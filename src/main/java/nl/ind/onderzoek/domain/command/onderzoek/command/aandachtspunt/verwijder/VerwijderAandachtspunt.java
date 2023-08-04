package nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.verwijder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.AbstractAandachtspuntCommand;

@Getter
@NoArgsConstructor
@SuperBuilder
@ToString
public class VerwijderAandachtspunt extends AbstractAandachtspuntCommand {
}
