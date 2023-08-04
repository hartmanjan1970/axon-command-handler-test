package nl.ind.onderzoek.utils.aandachtspunt;

import lombok.experimental.UtilityClass;
import nl.ind.onderzoek.domain.command.onderzoek.aggregate.AandachtspuntAlgemeenBeeld;
import nl.ind.onderzoek.domain.command.onderzoek.aggregate.AandachtspuntInkomenKennismigrant;
import nl.ind.onderzoek.domain.command.onderzoek.aggregate.AandachtspuntKennismigranten;
import nl.ind.onderzoek.domain.command.onderzoek.aggregate.AandachtspuntMaatregel;
import nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.aangemaakt.AandachtspuntAlgemeenBeeldAangemaakt;
import nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.aangemaakt.AandachtspuntInkomenKennismigrantAangemaakt;
import nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.aangemaakt.AandachtspuntKennismigrantenAangemaakt;
import nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.aangemaakt.AandachtspuntMaatregelAangemaakt;
import nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.bijgewerkt.AandachtspuntAlgemeenBeeldBijgewerkt;
import nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.bijgewerkt.AandachtspuntInkomenKennismigrantBijgewerkt;
import nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.bijgewerkt.AandachtspuntKennismigrantenBijgewerkt;
import nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.bijgewerkt.AandachtspuntMaatregelBijgewerkt;
import nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.verwijderd.AandachtspuntVerwijderd;

import static nl.ind.onderzoek.utils.TestConstanten.*;

@UtilityClass
public class AandachtspuntEventUtils {

    public static AandachtspuntAlgemeenBeeldAangemaakt aandachtspuntAlgemeenBeeldAangemaakt() {
        return AandachtspuntAlgemeenBeeldAangemaakt.builder()
                .onderzoekId(ONDERZOEK_ID)
                .aandachtspuntId(AANDACHTSPUNT_ID)
                .aandachtspunt(AandachtspuntAlgemeenBeeld.builder()
                        .onderzoekId(ONDERZOEK_ID)
                        .aandachtspuntId(AANDACHTSPUNT_ID)
                        .beschrijving(BESCHRIJVING_NIEUW_AANDACHTSPUNT)
                        .categorie(VOORWAARDE_CATEGORIE_CONTINUITEIT_EN_SOLVABILITEIT)
                        .build())
                .build();
    }

    public static AandachtspuntKennismigrantenAangemaakt aandachtspuntKennismigrantenAangemaakt() {
        return AandachtspuntKennismigrantenAangemaakt.builder()
                .onderzoekId(ONDERZOEK_ID)
                .aandachtspunt(AandachtspuntKennismigranten.builder()
                        .onderzoekId(ONDERZOEK_ID)
                        .aandachtspuntId(AANDACHTSPUNT_ID)
                        .categorie(VERPLICHTING_CATEGORIE_INFORMATIEPLICHT)
                        .build())
                .build();
    }

    public static AandachtspuntInkomenKennismigrantAangemaakt aandachtspuntInkomenKennismigrantAangemaakt() {
        return AandachtspuntInkomenKennismigrantAangemaakt.builder()
                .onderzoekId(ONDERZOEK_ID)
                .aandachtspunt(aandachtspuntInkomenKennismigrant())
                .build();
    }

    public static AandachtspuntMaatregelAangemaakt aandachtspuntMaatregelAangemaakt() {
        return AandachtspuntMaatregelAangemaakt.builder()
                .onderzoekId(ONDERZOEK_ID)
                .aandachtspunt(AandachtspuntMaatregel.builder()
                        .onderzoekId(ONDERZOEK_ID)
                        .aandachtspuntId(AANDACHTSPUNT_ID)
                        .categorie(VERPLICHTING_CATEGORIE_INFORMATIEPLICHT)
                        .build())
                .build();
    }

    public static AandachtspuntVerwijderd aandachtspuntVerwijderd() {
        return AandachtspuntVerwijderd.builder()
                .aandachtspuntId(AANDACHTSPUNT_ID)
                .onderzoekId(ONDERZOEK_ID)
                .build();
    }

    public static AandachtspuntAlgemeenBeeldBijgewerkt aandachtspuntAlgemeenBeeldBijgewerkt() {
        return AandachtspuntAlgemeenBeeldBijgewerkt.builder()
                .onderzoekId(ONDERZOEK_ID)
                .aandachtspuntId(AANDACHTSPUNT_ID)
                .aandachtspunt(aandachtspuntAlgemeenBeeld())
                .build();
    }

    public static AandachtspuntKennismigrantenBijgewerkt aandachtspuntKennismigrantenBijgewerkt() {
        return AandachtspuntKennismigrantenBijgewerkt.builder()
                .onderzoekId(ONDERZOEK_ID)
                .aandachtspuntId(AANDACHTSPUNT_ID)
                .aandachtspunt(aandachtspuntKennismigranten())
                .build();
    }

    public static AandachtspuntInkomenKennismigrantBijgewerkt aandachtspuntInkomenKennismigrantBijgewerkt() {
        return AandachtspuntInkomenKennismigrantBijgewerkt.builder()
                .onderzoekId(ONDERZOEK_ID)
                .aandachtspuntId(AANDACHTSPUNT_ID)
                .aandachtspunt(aandachtspuntInkomenKennismigrant())
                .build();
    }

    public static AandachtspuntMaatregelBijgewerkt aandachtspuntMaatregelBijgewerkt() {
        return AandachtspuntMaatregelBijgewerkt.builder()
                .onderzoekId(ONDERZOEK_ID)
                .aandachtspuntId(AANDACHTSPUNT_ID)
                .aandachtspunt(aandachtspuntMaatregel())
                .build();
    }

    private static AandachtspuntAlgemeenBeeld aandachtspuntAlgemeenBeeld() {
        return AandachtspuntAlgemeenBeeld.builder()
                .onderzoekId(ONDERZOEK_ID)
                .aandachtspuntId(AANDACHTSPUNT_ID)
                .categorie(VOORWAARDE_CATEGORIE_CONTINUITEIT_EN_SOLVABILITEIT)
                .build();
    }

    private static AandachtspuntKennismigranten aandachtspuntKennismigranten() {
        return AandachtspuntKennismigranten.builder()
                .onderzoekId(ONDERZOEK_ID)
                .aandachtspuntId(AANDACHTSPUNT_ID)
                .categorie(VERPLICHTING_CATEGORIE_INFORMATIEPLICHT)
                .build();
    }

    private static AandachtspuntInkomenKennismigrant aandachtspuntInkomenKennismigrant() {
        return AandachtspuntInkomenKennismigrant.builder()
                .onderzoekId(ONDERZOEK_ID)
                .aandachtspuntId(AANDACHTSPUNT_ID)
                .beschrijving(BESCHRIJVING_NIEUW_AANDACHTSPUNT)
                .referentschapId(REFERENTSCHAP_ID)
                .categorie(VERPLICHTING_CATEGORIE_INFORMATIEPLICHT)
                .build();
    }

    private static AandachtspuntMaatregel aandachtspuntMaatregel() {
        return AandachtspuntMaatregel.builder()
                .onderzoekId(ONDERZOEK_ID)
                .aandachtspuntId(AANDACHTSPUNT_ID)
                .beschrijving(BESCHRIJVING_NIEUW_AANDACHTSPUNT)
                .maatregelId(MAATREGEL_ID)
                .categorie(VERPLICHTING_CATEGORIE_INFORMATIEPLICHT)
                .build();
    }

}
