package nl.ind.onderzoek.domain.command.onderzoek.command.referentschap;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import nl.ind.onderzoek.domain.OnderzoekStatus;
import nl.ind.onderzoek.domain.command.onderzoek.command.AbstractOnderzoekCommand;

import java.util.UUID;

@Getter
@Jacksonized
@SuperBuilder
@ToString
public class WerkGegevensEnBescheidenOpvragenBij extends AbstractOnderzoekCommand {

    private UUID referentschapId;

    private OnderzoekStatus onderzoekStatus;
    private boolean gegevensEnBescheidenOpvragen;
}
