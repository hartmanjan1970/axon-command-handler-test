package nl.ind.onderzoek.domain.command.onderzoek.event.referentschap;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import nl.ind.onderzoek.domain.command.onderzoek.event.AbstractOnderzoekEvent;
import nl.ind.onderzoek.domain.referentschap.Referentschap;

import java.util.List;

@Getter
@Jacksonized
@SuperBuilder
@ToString
public class ActieveReferentschappenVoorOrganisatieBewaard extends AbstractOnderzoekEvent {

    private List<Referentschap> referentschappen;
}
