package nl.ind.onderzoek.domain.command.onderzoek.command.controleorganisatievooronderzoek;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.command.onderzoek.Erkenning;
import nl.ind.onderzoek.domain.command.onderzoek.command.AbstractOnderzoekCommand;

import java.util.List;
import java.util.Optional;

import static nl.ind.onderzoek.domain.command.onderzoek.Erkenning.Status.ACTIEF;

@Getter
@NoArgsConstructor
@SuperBuilder
@ToString
public class ControleerOfOrganisatieActieveErkenningVoorErkenningsdoelHeeft extends AbstractOnderzoekCommand {

    private List<Erkenning> erkenningen;

    public boolean heeftGeenActieveErkenning() {
        return erkenningen.stream()
                .map(Erkenning::getStatus)
                .filter(ACTIEF::equals)
                .findFirst()
                .isEmpty();
    }

    public Optional<Erkenning> getActiefErkenning() {
        return erkenningen.stream()
                .filter(Erkenning::isActief)
                .findFirst();

    }

}
