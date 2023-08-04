package nl.ind.onderzoek.domain.command.onderzoek.command.maatregel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.command.onderzoek.command.AbstractOnderzoekCommand;
import nl.ind.onderzoek.domain.maatregel.Maatregel;

import java.util.List;

@SuperBuilder
@NoArgsConstructor
@Getter
public class BewaarBestaandeMaatregelen extends AbstractOnderzoekCommand {

    private List<Maatregel> maatregelen;

}
