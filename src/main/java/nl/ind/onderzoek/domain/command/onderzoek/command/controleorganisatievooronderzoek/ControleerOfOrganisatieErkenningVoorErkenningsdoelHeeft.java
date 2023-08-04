package nl.ind.onderzoek.domain.command.onderzoek.command.controleorganisatievooronderzoek;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.Erkenningsdoel;
import nl.ind.onderzoek.domain.command.onderzoek.Erkenning;
import nl.ind.onderzoek.domain.command.onderzoek.command.AbstractOnderzoekCommand;

import java.util.List;

@Getter
@NoArgsConstructor
@SuperBuilder
@ToString
public class ControleerOfOrganisatieErkenningVoorErkenningsdoelHeeft extends AbstractOnderzoekCommand {

    private List<Erkenning> erkenningenVanOrganisatie;

    public boolean heeftGeenErkenningMetErkenningsdoel(Erkenningsdoel erkenningsdoel) {
        return erkenningenVanOrganisatie.stream()
                .filter(erkenning -> erkenning.getErkenningsdoel().equals(erkenningsdoel))
                .findFirst()
                .isEmpty();
    }

    @SuppressWarnings("java:S6202")
    public List<Erkenning> getErkenningenMetErkenningsdoel(Erkenningsdoel erkenningsdoel) {
        return erkenningenVanOrganisatie.stream()
                .filter(erkenning -> erkenning.getErkenningsdoel().equals(erkenningsdoel))
                .toList();
    }
}
