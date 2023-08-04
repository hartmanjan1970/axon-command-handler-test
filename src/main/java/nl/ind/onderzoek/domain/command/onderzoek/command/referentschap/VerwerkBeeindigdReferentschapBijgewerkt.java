package nl.ind.onderzoek.domain.command.onderzoek.command.referentschap;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.command.onderzoek.command.AbstractOnderzoekCommand;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor
@SuperBuilder
@ToString
public class VerwerkBeeindigdReferentschapBijgewerkt extends AbstractOnderzoekCommand {

    private UUID referentschapId;

    private LocalDate einddatum;
}
