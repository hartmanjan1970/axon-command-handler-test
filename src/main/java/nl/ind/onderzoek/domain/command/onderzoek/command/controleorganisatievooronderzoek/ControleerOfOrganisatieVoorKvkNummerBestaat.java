package nl.ind.onderzoek.domain.command.onderzoek.command.controleorganisatievooronderzoek;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.command.onderzoek.command.AbstractOnderzoekCommand;

import java.util.Objects;
import java.util.UUID;

@Getter
@NoArgsConstructor
@SuperBuilder
@ToString
public class ControleerOfOrganisatieVoorKvkNummerBestaat extends AbstractOnderzoekCommand {

    private UUID organisatieId;

    public boolean organisatieIdBestaatNiet() {
        return Objects.isNull(organisatieId);
    }
}
