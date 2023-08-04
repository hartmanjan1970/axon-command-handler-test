package nl.ind.onderzoek.domain.command.onderzoek.event.inkomen;

import nl.ind.onderzoek.domain.command.onderzoek.command.inkomen.VerwerkReferentschapInkomenOntvangen;
import org.mapstruct.Mapper;

@Mapper
public interface ReferentschapInkomenOntvangenMapper {

    ReferentschapInkomenOntvangenVerwerkt map(VerwerkReferentschapInkomenOntvangen verwerkReferentschapInkomenOntvangen);
}
