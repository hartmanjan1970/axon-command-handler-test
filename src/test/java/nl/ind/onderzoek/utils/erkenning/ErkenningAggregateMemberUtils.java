package nl.ind.onderzoek.utils.erkenning;

import lombok.experimental.UtilityClass;
import nl.ind.onderzoek.domain.Erkenningsdoel;
import nl.ind.onderzoek.domain.command.onderzoek.Erkenning;
import nl.ind.onderzoek.domain.command.onderzoek.Erkenning.Status;

import static nl.ind.onderzoek.utils.TestConstanten.ERKENNING_ID;

@UtilityClass
public class ErkenningAggregateMemberUtils {

    public static Erkenning erkenning(Erkenningsdoel erkenningsdoel, Status status) {
        return Erkenning.builder()
                .erkenningId(ERKENNING_ID)
                .erkenningsdoel(erkenningsdoel)
                .status(status)
                .build();
    }
}
