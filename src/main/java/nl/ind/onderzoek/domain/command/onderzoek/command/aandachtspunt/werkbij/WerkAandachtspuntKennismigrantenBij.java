package nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.werkbij;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.VerplichtingCategorie;

@Getter
@NoArgsConstructor
@SuperBuilder
@ToString
public class WerkAandachtspuntKennismigrantenBij extends AbstractWerkAandachtspuntBij {

    private VerplichtingCategorie categorie;

}
