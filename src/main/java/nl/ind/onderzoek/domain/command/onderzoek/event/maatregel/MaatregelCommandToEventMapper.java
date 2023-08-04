package nl.ind.onderzoek.domain.command.onderzoek.event.maatregel;

import nl.ind.onderzoek.domain.command.onderzoek.command.maatregel.VerwerkBestuurlijkeBoeteOpgelegd;
import nl.ind.onderzoek.domain.command.onderzoek.command.maatregel.VerwerkWaarschuwingOpgelegd;
import nl.ind.onderzoek.domain.command.onderzoek.command.maatregel.VerwerkWaarschuwingVerlopen;
import nl.ind.onderzoek.domain.command.onderzoek.command.maatregel.VerwerkWaarschuwingVerwijderd;
import org.mapstruct.Mapper;

@Mapper
public interface MaatregelCommandToEventMapper {

    BestuurlijkeBoeteOpgelegdVerwerkt map(VerwerkBestuurlijkeBoeteOpgelegd command);

    WaarschuwingOpgelegdVerwerkt map(VerwerkWaarschuwingOpgelegd command);

    WaarschuwingVerlopenVerwerkt map(VerwerkWaarschuwingVerlopen command);

    WaarschuwingVerwijderdVerwerkt map(VerwerkWaarschuwingVerwijderd command);

}
