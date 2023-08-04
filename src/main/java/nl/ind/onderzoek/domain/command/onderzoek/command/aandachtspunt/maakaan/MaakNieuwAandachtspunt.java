package nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.maakaan;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.AbstractAandachtspuntCommand;
import nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.OnderzoekOnderdeel;

import java.util.UUID;

@Getter
@NoArgsConstructor
@SuperBuilder
@ToString
public class MaakNieuwAandachtspunt extends AbstractAandachtspuntCommand {

    private UUID referentschapId;
    private UUID maatregelId;
    private String categorie;
    private String beschrijving;
    private OnderzoekOnderdeel onderzoekOnderdeel;

}

