package nl.ind.onderzoek.domain.command.onderzoek.command.referentschap;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.command.onderzoek.command.AbstractOnderzoekCommand;

import java.util.UUID;

@Getter
@NoArgsConstructor
@SuperBuilder
@ToString
public class VerwerkReferentschapOngedaanGemaakt extends AbstractOnderzoekCommand {

    private UUID referentschapId;
}
