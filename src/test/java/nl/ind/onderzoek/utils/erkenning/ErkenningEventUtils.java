package nl.ind.onderzoek.utils.erkenning;

import lombok.experimental.UtilityClass;
import nl.ind.onderzoek.domain.Erkenningsdoel;
import nl.ind.onderzoek.domain.command.onderzoek.Erkenning;
import nl.ind.onderzoek.domain.command.onderzoek.event.erkenning.OnderzoekErkenningHerleefd;
import nl.ind.onderzoek.domain.command.onderzoek.event.erkenning.OnderzoekErkenningIngetrokken;

import java.time.LocalDate;
import java.util.UUID;

import static nl.ind.onderzoek.utils.TestConstanten.*;

@UtilityClass
public class ErkenningEventUtils {
    public static OnderzoekErkenningIngetrokken onderzoekErkenningIngetrokken(UUID onderzoekId) {
        return OnderzoekErkenningIngetrokken.builder()
                .onderzoekId(onderzoekId)
                .erkenningId(ERKENNING_ID)
                .einddatum(LocalDate.now())
                .build();
    }

    public static OnderzoekErkenningHerleefd onderzoekErkenningHerleefd(UUID onderzoekId) {
        return onderzoekErkenningHerleefd(onderzoekId, ERKENNINGSDOEL_ARBEID);
    }

    public static OnderzoekErkenningHerleefd onderzoekErkenningHerleefd(UUID onderzoekId, Erkenningsdoel erkenningsdoel) {
        return OnderzoekErkenningHerleefd.builder()
                .onderzoekId(onderzoekId)
                .organisatieId(ORGANISATIE_ID)
                .erkenning(Erkenning.builder()
                        .erkenningId(ERKENNING_ID)
                        .erkenningsdoel(erkenningsdoel)
                        .status(ERKENNING_STATUS_ACTIEF)
                        .build()
                )
                .build();
    }
}
