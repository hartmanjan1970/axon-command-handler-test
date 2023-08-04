package nl.ind.onderzoek.utils.aandachtspunt;

import lombok.experimental.UtilityClass;
import nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.OnderzoekOnderdeel;
import nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.maakaan.MaakNieuwAandachtspunt;
import nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.werkbij.WerkAandachtspuntAlgemeenBeeldBij;
import nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.werkbij.WerkAandachtspuntInkomenKennismigrantBij;
import nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.werkbij.WerkAandachtspuntKennismigrantenBij;
import nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.werkbij.WerkAandachtspuntMaatregelBij;

import static nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.werkbij.WerkAandachtspuntKennismigrantenBij.builder;
import static nl.ind.onderzoek.utils.TestConstanten.*;

@UtilityClass
public class AandachtspuntCommandUtils {

    public static MaakNieuwAandachtspunt maakNieuwAandachtspuntAan(OnderzoekOnderdeel onderzoekOnderdeel, String categorie) {
        return MaakNieuwAandachtspunt.builder()
                .onderzoekId(ONDERZOEK_ID)
                .aandachtspuntId(AANDACHTSPUNT_ID)
                .beschrijving(BESCHRIJVING_NIEUW_AANDACHTSPUNT)
                .referentschapId(REFERENTSCHAP_ID)
                .categorie(categorie)
                .onderzoekOnderdeel(onderzoekOnderdeel)
                .build();
    }

    public static WerkAandachtspuntAlgemeenBeeldBij werkAandachtspuntAlgemeenBeeldBij() {
        return WerkAandachtspuntAlgemeenBeeldBij.builder()
                .onderzoekId(ONDERZOEK_ID)
                .aandachtspuntId(AANDACHTSPUNT_ID)
                .beschrijving(BESCHRIJVING_BIJGEWERKT_AANDACHTSPUNT)
                .categorie(VOORWAARDE_CATEGORIE_CONTINUITEIT_EN_SOLVABILITEIT)
                .build();
    }

    public static WerkAandachtspuntKennismigrantenBij werkAandachtspuntKennismigrantenBij() {
        return builder()
                .onderzoekId(ONDERZOEK_ID)
                .aandachtspuntId(AANDACHTSPUNT_ID)
                .beschrijving(BESCHRIJVING_BIJGEWERKT_AANDACHTSPUNT)
                .categorie(VERPLICHTING_CATEGORIE_INFORMATIEPLICHT)
                .build();
    }

    public static WerkAandachtspuntInkomenKennismigrantBij werkAandachtspuntInkomenKennismigrantBij() {
        return WerkAandachtspuntInkomenKennismigrantBij.builder()
                .onderzoekId(ONDERZOEK_ID)
                .aandachtspuntId(AANDACHTSPUNT_ID)
                .beschrijving(BESCHRIJVING_BIJGEWERKT_AANDACHTSPUNT)
                .referentschapId(REFERENTSCHAP_ID)
                .categorie(VERPLICHTING_CATEGORIE_INFORMATIEPLICHT)
                .build();
    }

    public static WerkAandachtspuntMaatregelBij werkAandachtspuntMaatregelBij() {
        return WerkAandachtspuntMaatregelBij.builder()
                .onderzoekId(ONDERZOEK_ID)
                .aandachtspuntId(AANDACHTSPUNT_ID)
                .beschrijving(BESCHRIJVING_BIJGEWERKT_AANDACHTSPUNT)
                .maatregelId(MAATREGEL_ID)
                .categorie(VERPLICHTING_CATEGORIE_INFORMATIEPLICHT)
                .build();
    }

}
