package nl.ind.onderzoek.utils.erkenning;

import lombok.experimental.UtilityClass;
import nl.ind.onderzoek.domain.command.onderzoek.command.erkenning.HerleefOnderzoekErkenning;
import nl.ind.onderzoek.domain.command.onderzoek.command.erkenning.TrekOnderzoekErkenningIn;

import java.time.LocalDate;
import java.util.UUID;

import static nl.ind.onderzoek.utils.TestConstanten.*;

@UtilityClass
public class ErkenningCommandUtils {

    public static TrekOnderzoekErkenningIn trekOnderzoekErkenningIn(UUID onderzoekId) {
        return TrekOnderzoekErkenningIn.builder()
                .onderzoekId(onderzoekId)
                .erkenningId(ERKENNING_ID)
                .einddatum(LocalDate.now())
                .build();
    }

    public static HerleefOnderzoekErkenning herleefOnderzoekErkenning(UUID onderzoekId) {
        return HerleefOnderzoekErkenning.builder()
                .onderzoekId(onderzoekId)
                .erkenningId(ERKENNING_ID)
                .erkenningsdoel(ERKENNINGSDOEL_ARBEID)
                .organisatieId(ORGANISATIE_ID)
                .build();
    }

}
