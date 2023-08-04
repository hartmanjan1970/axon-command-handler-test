package nl.ind.onderzoek.domain.command.onderzoek.command.erkenning;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import nl.ind.onderzoek.domain.command.onderzoek.Erkenning;
import nl.ind.onderzoek.domain.command.onderzoek.command.AbstractOnderzoekCommand;

import java.util.List;

@Getter
@Jacksonized
@SuperBuilder
@ToString
public class BewaarErkenningenVoorOrganisatie extends AbstractOnderzoekCommand {

    private List<Erkenning> erkenningen;

}
