package nl.ind.onderzoek.utils.waarschuwing;

import lombok.experimental.UtilityClass;
import nl.ind.onderzoek.domain.command.onderzoek.command.maatregel.*;
import nl.ind.onderzoek.domain.maatregel.BestuurlijkeBoete;
import nl.ind.onderzoek.domain.maatregel.Waarschuwing;

import java.util.List;
import java.util.UUID;

import static nl.ind.onderzoek.utils.TestConstanten.*;

@UtilityClass
public class WaarschuwingCommandUtils {
    public static VerwerkBestuurlijkeBoeteOpgelegd verwerkBestuurlijkeBoeteOpgelegd(UUID onderzoekId) {
        return VerwerkBestuurlijkeBoeteOpgelegd.builder()
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

    public static VerwerkWaarschuwingOpgelegd verwerkWaarschuwingOpgelegd(UUID onderzoekId, UUID erkenningId) {
        return VerwerkWaarschuwingOpgelegd.builder()
                .onderzoekId(onderzoekId)
                .waarschuwingId(WAARSCHUWING_ID)
                .opleggingsdatum(OPLEGGINGSDATUM)
                .erkenningId(erkenningId)
                .erkendeReferentId(ERKENDE_REFERENT_ID)
                .documentBriefId(DOCUMENT_ID)
                .plichtCategorie(PLICHT_CATEGORIE)
                .vastgesteldePlichtId(VASTGESTELDE_PLICHT_ID)
                .build();
    }

    public static VerwerkWaarschuwingVerlopen verwerkWaarschuwingVerlopen(UUID onderzoekId) {
        return VerwerkWaarschuwingVerlopen.builder()
                .onderzoekId(onderzoekId)
                .waarschuwingId(WAARSCHUWING_ID)
                .verloopdatum(VERLOOPDATUM)
                .build();
    }

    public static VerwerkWaarschuwingVerwijderd verwerkWaarschuwingVerwijderd(UUID onderzoekId) {
        return VerwerkWaarschuwingVerwijderd.builder()
                .onderzoekId(onderzoekId)
                .waarschuwingId(WAARSCHUWING_ID)
                .verwijderingsdatum(VERWIJDERINGSDATUM)
                .build();
    }

    public static BewaarBestaandeMaatregelen bewaarBestaandeMaatregelen() {
        return BewaarBestaandeMaatregelen.builder()
                .onderzoekId(ONDERZOEK_ID)
                .maatregelen(List.of(bestuurlijkeBoete(), waarschuwing(), waarschuwingVerlopen()))
                .build();
    }

    public static BestuurlijkeBoete bestuurlijkeBoete() {
        return BestuurlijkeBoete.builder()
                .erkendeReferentId(ERKENDE_REFERENT_ID)
                .erkenningId(ERKENNING_ID)
                .erkenningsdoel(ERKENNINGSDOEL_STRING_ARBEID)
                .opleggingsdatum(OPLEGGINGSDATUM)
                .vastgesteldePlichtId(VASTGESTELDE_PLICHT_ID)
                .plichtCategorie(PLICHT_CATEGORIE_ZORGPLICHT)
                .bestuurlijkeBoeteId(BESTUURLIJKE_BOETE_ID)
                .hoogte(HOOGTE)
                .documentBeschikkingId(DOCUMENT_ID)
                .build();
    }

    public static Waarschuwing waarschuwing() {
        return Waarschuwing.builder()
                .erkendeReferentId(ERKENDE_REFERENT_ID)
                .erkenningId(ERKENNING_ID)
                .erkenningsdoel(ERKENNINGSDOEL_STRING_ARBEID)
                .opleggingsdatum(OPLEGGINGSDATUM)
                .vastgesteldePlichtId(VASTGESTELDE_PLICHT_ID)
                .plichtCategorie(PLICHT_CATEGORIE_ZORGPLICHT)
                .waarschuwingId(WAARSCHUWING_ID)
                .documentBriefId(DOCUMENT_2_ID)
                .build();
    }

    public static Waarschuwing waarschuwingVerlopen() {
        return Waarschuwing.builder()
                .erkendeReferentId(ERKENDE_REFERENT_ID)
                .erkenningsdoel(ERKENNINGSDOEL_STRING_ARBEID)
                .opleggingsdatum(OPLEGGINGSDATUM)
                .vastgesteldePlichtId(VASTGESTELDE_PLICHT_ID)
                .plichtCategorie(PLICHT_CATEGORIE_ZORGPLICHT)
                .waarschuwingId(WAARSCHUWING_2_ID)
                .documentBriefId(DOCUMENT_3_ID)
                .verloopdatum(VERLOOPDATUM)
                .build();
    }
}
