package nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.werkbij;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.VerplichtingCategorie;

import java.util.UUID;

@Getter
@NoArgsConstructor
@SuperBuilder
@ToString
public class WerkAandachtspuntInkomenKennismigrantBij extends AbstractWerkAandachtspuntBij {

    private UUID referentschapId;
    private VerplichtingCategorie categorie;

}
