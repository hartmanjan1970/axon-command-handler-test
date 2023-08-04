package nl.ind.onderzoek.utils.waarschuwing;

import lombok.experimental.UtilityClass;
import nl.ind.onderzoek.domain.command.onderzoek.event.maatregel.*;

import java.util.List;
import java.util.UUID;

import static nl.ind.onderzoek.utils.TestConstanten.*;
import static nl.ind.onderzoek.utils.waarschuwing.WaarschuwingCommandUtils.*;

@UtilityClass
public class WaarschuwingEventUtils {
    public static BestaandeMaatregelenBewaard bestaandeMaatregelenBewaard() {
        return BestaandeMaatregelenBewaard.builder()
                .onderzoekId(ONDERZOEK_ID)
                .maatregelen(List.of(bestuurlijkeBoete(), waarschuwing(), waarschuwingVerlopen()))
                .build();
    }

    public static BestuurlijkeBoeteOpgelegdVerwerkt bestuurlijkeBoeteOpgelegdVerwerkt(UUID onderzoekId) {
        return BestuurlijkeBoeteOpgelegdVerwerkt.builder()
                .onderzoekId(onderzoekId)
                .bestuurlijkeBoeteId(BESTUURLIJKE_BOETE_ID)
                .opleggingsdatum(OPLEGGINGSDATUM)
                .erkenningId(ERKENNING_ID)
                .erkendeReferentId(ERKENDE_REFERENT_ID)
                .grondslag(PLICHT_GRONDSLAG)
                .hoogte(HOOGTE)
                .documentBeschikkingId(DOCUMENT_ID)
                .plichtCategorie(PLICHT_CATEGORIE)
                .vastgesteldePlichtId(VASTGESTELDE_PLICHT_ID)
                .build();
    }

    public static WaarschuwingOpgelegdVerwerkt waarschuwingOpgelegdVerwerkt(UUID onderzoekId, String documentId) {
        return WaarschuwingOpgelegdVerwerkt.builder()
                .onderzoekId(onderzoekId)
                .waarschuwingId(WAARSCHUWING_ID)
                .opleggingsdatum(OPLEGGINGSDATUM)
                .erkenningId(ERKENNING_ID)
                .erkendeReferentId(ERKENDE_REFERENT_ID)
                .documentBriefId(documentId)
                .plichtCategorie(PLICHT_CATEGORIE)
                .vastgesteldePlichtId(VASTGESTELDE_PLICHT_ID)
                .build();
    }

    public static WaarschuwingVerlopenVerwerkt waarschuwingVerlopenVerwerkt(UUID onderzoekId) {
        return WaarschuwingVerlopenVerwerkt.builder()
                .onderzoekId(onderzoekId)
                .waarschuwingId(WAARSCHUWING_ID)
                .verloopdatum(VERLOOPDATUM)
                .build();
    }

    public static WaarschuwingVerwijderdVerwerkt waarschuwingVerwijderdVerwerkt(UUID onderzoekId) {
        return WaarschuwingVerwijderdVerwerkt.builder()
                .onderzoekId(onderzoekId)
                .waarschuwingId(WAARSCHUWING_ID)
                .verwijderingsdatum(VERWIJDERINGSDATUM)
                .build();
    }
}
