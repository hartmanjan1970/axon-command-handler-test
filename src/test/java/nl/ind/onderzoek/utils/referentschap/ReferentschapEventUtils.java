package nl.ind.onderzoek.utils.referentschap;

import lombok.experimental.UtilityClass;
import nl.ind.onderzoek.domain.command.onderzoek.Inkomen;
import nl.ind.onderzoek.domain.command.onderzoek.event.inkomen.GegevensEnBescheidenOpvragenBijgewerkt;
import nl.ind.onderzoek.domain.command.onderzoek.event.inkomen.ReferentschapInkomenOntvangenVerwerkt;
import nl.ind.onderzoek.domain.command.onderzoek.event.referentschap.*;
import nl.ind.onderzoek.domain.referentschap.Referentschap;

import java.util.ArrayList;
import java.util.List;

import static nl.ind.onderzoek.utils.TestConstanten.*;
import static nl.ind.onderzoek.utils.referentschap.ReferentschapAggregateMemberUtils.referentschap;

@UtilityClass
public class ReferentschapEventUtils {
    public static ReferentschapBeeindigdVerwerkt referentschapBeeindigdVerwerkt() {
        return ReferentschapBeeindigdVerwerkt.builder()
                .onderzoekId(ONDERZOEK_ID)
                .referentschapId(REFERENTSCHAP_ID)
                .beperking(BEPERKING_ARBEID_REFERENTSCHAP_BEEINDIGD)
                .einddatum(EINDDATUM_REFERENTSCHAP_BEEINDIGD)
                .build();
    }

    public static ReferentschapOngedaanGemaaktVerwerkt referentschapOngedaanGemaaktVerwerkt() {
        return ReferentschapOngedaanGemaaktVerwerkt.builder()
                .onderzoekId(ONDERZOEK_ID)
                .referentschapId(REFERENTSCHAP_ID)
                .beperking(BEPERKING_ARBEID_REFERENTSCHAP_BEEINDIGD)
                .build();
    }

    public static ReferentschapOngedaanGemaaktVerwerkt referentschapOngedaanGemaaktVerwerkt_zonderReferentschapVoorErkenningsdoel() {
        return ReferentschapOngedaanGemaaktVerwerkt.builder()
                .onderzoekId(ONDERZOEK_ID)
                .referentschapId(REFERENTSCHAP_ID)
                .beperking(BEPERKING_REFERENTSCHAP_STUDIE)
                .build();
    }

    public static ReferentschapOntstaanVerwerkt referentschapOntstaanVerwerkt() {
        return ReferentschapOntstaanVerwerkt.builder()
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

    public static ReferentschapInkomenOntvangenVerwerkt referentschapInkomenOntvangenVerwerkt() {
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
        return ReferentschapInkomenOntvangenVerwerkt.builder()
                .onderzoekId(ONDERZOEK_ID)
                .referentschapId(REFERENTSCHAP_ID)
                .persoonId(PERSOON_ID)
                .gemiddeldSocialeVerzekeringsloonBedrag(INKOMEN_SOCIALE_VERZEKERINGSLOON_BEDRAG)
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

    public static ActieveReferentschappenVoorOrganisatieBewaard referentschappenVoorOrganisatieBewaard() {
        return ActieveReferentschappenVoorOrganisatieBewaard.builder()
                .onderzoekId(ONDERZOEK_ID)
                .referentschappen(List.of(referentschap(BEPERKING_REFERENTSCHAP_ARBEID)))
                .build();
    }

    public static ActieveReferentschappenVoorOrganisatieBewaard referentschappenVoorOrganisatieBewaard_zonderReferentschapVoorErkenningsdoel() {
        List<Referentschap> referentschappen = new ArrayList<>();
        referentschappen.add(referentschap(BEPERKING_REFERENTSCHAP_STUDIE));
        return ActieveReferentschappenVoorOrganisatieBewaard.builder()
                .onderzoekId(ONDERZOEK_ID)
                .referentschappen(referentschappen)
                .build();
    }

    public static GegevensEnBescheidenOpvragenBijgewerkt gegevensEnBescheidenOpvragenBijgewerkt() {
        return GegevensEnBescheidenOpvragenBijgewerkt.builder()
                .onderzoekId(ONDERZOEK_ID)
                .referentschapId(REFERENTSCHAP_ID)
                .gegevensEnBescheidenOpvragen(GEGEVENS_EN_BESCHEIDEN_OPVRAGEN_JA)
                .build();
    }

    public static ActieveReferentschappenVoorOrganisatieBewaard actieveReferentschappenVoorOrganisatieBewaard() {
        return ActieveReferentschappenVoorOrganisatieBewaard.builder()
                .onderzoekId(ONDERZOEK_ID)
                .referentschappen(List.of(referentschap(BEPERKING_REFERENTSCHAP_ARBEID_ALS_KENNISMIGRANT_ONTSTAAN)))
                .build();
    }

    public static BeeindigdReferentschapBijgewerktVerwerkt beeindigdReferentschapBijgewerktVerwerkt() {
        return BeeindigdReferentschapBijgewerktVerwerkt.builder()
                .onderzoekId(ONDERZOEK_ID)
                .referentschapId(REFERENTSCHAP_ID)
                .beperking(BEPERKING_ARBEID_REFERENTSCHAP_BEEINDIGD)
                .einddatum(EINDDATUM_REFERENTSCHAP_BEEINDIGD_BIJGEWERKT)
                .build();
    }
}
