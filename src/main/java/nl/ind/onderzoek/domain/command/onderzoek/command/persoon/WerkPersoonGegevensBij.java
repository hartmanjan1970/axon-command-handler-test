package nl.ind.onderzoek.domain.command.onderzoek.command.persoon;

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
public class WerkPersoonGegevensBij extends AbstractOnderzoekCommand {

    private UUID referentschapId;

    private UUID persoonId;
    private String geslachtsnaam;
    private String voornamen;
    private String voorvoegsel;

}
