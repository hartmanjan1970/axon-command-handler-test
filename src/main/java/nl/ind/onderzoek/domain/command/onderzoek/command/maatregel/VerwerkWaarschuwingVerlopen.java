package nl.ind.onderzoek.domain.command.onderzoek.command.maatregel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.command.onderzoek.command.AbstractOnderzoekCommand;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor
@SuperBuilder
public class VerwerkWaarschuwingVerlopen extends AbstractOnderzoekCommand {

    private UUID waarschuwingId;
    private LocalDate verloopdatum;
}
