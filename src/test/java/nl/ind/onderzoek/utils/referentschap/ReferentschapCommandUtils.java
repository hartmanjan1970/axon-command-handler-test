package nl.ind.onderzoek.utils.referentschap;

import lombok.experimental.UtilityClass;
import nl.ind.onderzoek.domain.OnderzoekStatus;
import nl.ind.onderzoek.domain.command.onderzoek.Inkomen;
import nl.ind.onderzoek.domain.command.onderzoek.command.inkomen.VerwerkReferentschapInkomenOntvangen;
import nl.ind.onderzoek.domain.command.onderzoek.command.referentschap.*;

import java.util.ArrayList;
import java.util.List;

import static nl.ind.onderzoek.domain.command.onderzoek.command.referentschap.BewaarActieveReferentschappenVoorOrganisatie.builder;
import static nl.ind.onderzoek.utils.TestConstanten.*;
import static nl.ind.onderzoek.utils.referentschap.ReferentschapAggregateMemberUtils.referentschap;

@UtilityClass
public class ReferentschapCommandUtils {
    public static VerwerkReferentschapBeeindigd verwerkReferentschapBeeindigd() {
        return VerwerkReferentschapBeeindigd.builder()
                .onderzoekId(ONDERZOEK_ID)
                .referentschapId(REFERENTSCHAP_ID)
                .einddatum(EINDDATUM_REFERENTSCHAP_BEEINDIGD)
                .build();
    }

    public static VerwerkReferentschapOngedaanGemaakt verwerkReferentschapOngedaanGemaakt() {
        return VerwerkReferentschapOngedaanGemaakt.builder()
                .onderzoekId(ONDERZOEK_ID)
                .referentschapId(REFERENTSCHAP_ID)
                .build();
    }

    public static VerwerkBeeindigdReferentschapBijgewerkt verwerkBeeindigdReferentschapBijgewerkt() {
        return VerwerkBeeindigdReferentschapBijgewerkt.builder()
                .onderzoekId(ONDERZOEK_ID)
                .referentschapId(REFERENTSCHAP_ID)
                .einddatum(EINDDATUM_REFERENTSCHAP_BEEINDIGD_BIJGEWERKT)
                .build();
    }

    public static VerwerkReferentschapOntstaan verwerkReferentschapOntstaan() {
        return VerwerkReferentschapOntstaan.builder()
                .onderzoekId(ONDERZOEK_ID)
                .referentschapId(REFERENTSCHAP_ID)
                .persoonId(PERSOON_ID)
                .organisatieId(ORGANISATIE_ID)
                .erkenningId(ERKENNING_ID)
                .startdatum(STARTDATUM_REFERENTSCHAP_ONTSTAAN)
                .grondslag(GRONDSLAG_REFERENTSCHAP)
                .beperking(BEPERKING_REFERENTSCHAP_ARBEID_ALS_KENNISMIGRANT_ONTSTAAN)
                .referentschapStatus(REFERENTSCHAP_STATUS_REFERENTSCHAP_ONTSTAAN)
                .build();
    }

    public static VerwerkReferentschapInkomenOntvangen verwerkReferentschapInkomenOntvangen() {
        List<Inkomen> inkomens = new ArrayList<>();
        inkomens.add(
                Inkomen.builder()
                        .inkomstenopgaveAanvangDatum(INKOMEN_INKOMSTENOPGAVE_AANVANG_DATUM)
                        .inkomstenopgaveEindDatum(INKOMEN_INKOMSTENOPGAVE_EIND_DATUM)
                        .socialeVerzekeringsloonBedrag(INKOMEN_SOCIALE_VERZEKERINGSLOON_BEDRAG)
                        .verloondeUrenAantal(INKOMEN_VERLOONDE_UREN_AANTAL)
                        .vakantietoeslagBedrag(INKOMEN_VAKANTIETOESLAG_BEDRAG)
                        .vakantietoeslagOpgebouwdBedrag(INKOMEN_VAKANTIETOESLAG_OPGEBOUWD_BEDRAG)
                        .arbeidsvoorwaardenBedrag(INKOMEN_ARBEIDSVOORWAARDEN_BEDRAG)
                        .arbeidsvoorwaardenOpgebouwdBedrag(INKOMEN_ARBEIDSVOORWAARDEN_OPGEBOUWD_BEDRAG)
                        .build()
        );

        return VerwerkReferentschapInkomenOntvangen.builder()
                .onderzoekId(ONDERZOEK_ID)
                .referentschapId(REFERENTSCHAP_ID)
                .persoonId(PERSOON_ID)
                .uwvGegevensOntvangstdatum(INKOMEN_UWV_GEGEVENS_ONTVANGSTDATUM)
                .inkomstenverhoudingAanvangDatum(INKOMEN_INKOMSTENVERHOUDING_AANVANG_DATUM)
                .inkomstenverhoudingEindDatum(INKOMEN_INKOMSTENVERHOUDING_EIND_DATUM)
                .aardArbeidsverhoudingCode(INKOMEN_AARD_ARBEIDSVERHOUDING_CODE)
                .inkomstenverhoudingIncidenteleCode(INKOMEN_INKOMSTENVERHOUDING_INCIDENTELE_CODE)
                .inkomstenverhoudingSoortCode(INKOMEN_INKOMSTENVERHOUDING_SOORT_CODE)
                .arbeidsovereenkomstOnbepaaldeTijdIndicator(INKOMEN_ARBEIDSOVEREENKOMST_ONBEPAALDE_TIJD_INDICATOR_JA)
                .inkomens(inkomens)
                .build();
    }

    public static WerkGegevensEnBescheidenOpvragenBij werkGegevensEnBescheidenOpvragenBij() {
        return werkGegevensEnBescheidenOpvragenBij(ONDERZOEK_STATUS_OPEN);
    }

    public static WerkGegevensEnBescheidenOpvragenBij werkGegevensEnBescheidenOpvragenBij(OnderzoekStatus onderzoekStatus) {
        return WerkGegevensEnBescheidenOpvragenBij.builder()
                .onderzoekId(ONDERZOEK_ID)
                .onderzoekStatus(onderzoekStatus)
                .referentschapId(REFERENTSCHAP_ID)
                .gegevensEnBescheidenOpvragen(GEGEVENS_EN_BESCHEIDEN_OPVRAGEN_JA)
                .build();
    }

    public static BewaarActieveReferentschappenVoorOrganisatie bewaarReferentschappenVoorOrganisatie() {
        return builder()
                .onderzoekId(ONDERZOEK_ID)
                .referentschappen(List.of(referentschap(BEPERKING_REFERENTSCHAP_ARBEID)))
                .build();
    }

    public static BewaarActieveReferentschappenVoorOrganisatie bewaarReferentschappenVoorOrganisatie_zonderReferentschappen() {
        return builder()
                .onderzoekId(ONDERZOEK_ID)
                .build();
    }
}
