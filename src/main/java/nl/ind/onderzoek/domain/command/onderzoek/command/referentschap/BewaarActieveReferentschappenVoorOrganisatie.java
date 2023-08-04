package nl.ind.onderzoek.domain.command.onderzoek.command.referentschap;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import nl.ind.onderzoek.domain.command.onderzoek.command.AbstractOnderzoekCommand;
import nl.ind.onderzoek.domain.referentschap.Referentschap;

import java.util.List;

@Getter
@Jacksonized
@SuperBuilder
@ToString
public class BewaarActieveReferentschappenVoorOrganisatie extends AbstractOnderzoekCommand {

    private List<Referentschap> referentschappen;

}
