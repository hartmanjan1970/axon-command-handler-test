package nl.ind.onderzoek.utils;

import lombok.experimental.UtilityClass;
import nl.ind.onderzoek.domain.*;
import nl.ind.onderzoek.domain.command.onderzoek.Erkenning;
import nl.ind.onderzoek.domain.command.onderzoek.event.controleorganisatievooronderzoek.OnderzoekIsNietInBehandelingGenomen.Foutreden;
import nl.ind.onderzoek.domain.maatregel.Maatregel.PlichtErkenningCategorie;
import nl.ind.onderzoek.domain.referentschap.Beperking;
import nl.ind.onderzoek.domain.referentschap.ReferentschapStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static java.time.LocalDate.parse;
import static nl.ind.onderzoek.domain.Erkenningsdoel.*;
import static nl.ind.onderzoek.domain.OnderzoekStatus.*;
import static nl.ind.onderzoek.domain.Reden.STEEKPROEF;
import static nl.ind.onderzoek.domain.command.onderzoek.Erkenning.Status.ACTIEF;
import static nl.ind.onderzoek.domain.command.onderzoek.Erkenning.Status.BEEINDIGD;
import static nl.ind.onderzoek.domain.command.onderzoek.event.controleorganisatievooronderzoek.OnderzoekIsNietInBehandelingGenomen.Foutreden.*;

@UtilityClass
public class TestConstanten {

    public static final Foutreden FOUTREDEN_KVK_NUMMER_NIET_BEKEND_BIJ_BEDRIJF_INSTELLING = KVK_NUMMER_NIET_BEKEND_BIJ_BEDRIJF_INSTELLING;
    public static final Foutreden FOUTREDEN_ORGANISATIE_HEEFT_GEEN_ERKENNING_VOOR_ERKENNINGSDOEL =
            ORGANISATIE_HEEFT_GEEN_ERKENNING_VOOR_ERKENNINGSDOEL;
    public static final Foutreden FOUTREDEN_ORGANISATIE_HEEFT_GEEN_ACTIEVE_ERKENNING_VOOR_ERKENNINGSDOEL =
            ORGANISATIE_HEEFT_GEEN_ACTIEVE_ERKENNING_VOOR_ERKENNINGSDOEL;
    public static final Foutreden FOUTREDEN_ORGANISATIE_MET_ERKENNING_VOOR_ERKENNINGSDOEL_IS_AL_IN_ONDERZOEK =
            ORGANISATIE_MET_ERKENNING_VOOR_ERKENNINGSDOEL_IS_AL_IN_ONDERZOEK;
    public static final UUID ABONNEMENT_ID = new UUID(3, 1);
    public static final UUID EXTERN_ABONNEMENT_ID = new UUID(3, 2);
    public static final UUID AANDACHTSPUNT_ID = new UUID(10, 1);
    public static final UUID ONDERZOEK_ID = new UUID(1, 1);
    public static final UUID ONDERZOEK_ID_2 = new UUID(1, 2);
    public static final String ONDERZOEK_ID_STRING = ONDERZOEK_ID.toString();

    public static final UUID ORGANISATIE_ID = new UUID(4, 4);
    public static final String ORGANISATIE_NAAM = "Test naam van erkende referent";
    public static final Vestigingsadres ORGANISATIE_VESTIGINGSADRES = Vestigingsadres.builder()
            .land("Nederland")
            .nederlandsAdres(Vestigingsadres.NederlandsAdres.builder().straatnaam("Test vestigingsadres van erkende referent").build())
            .build();
    public static final String ONDERZOEK_ID_FIELD = "onderzoekId";
    public static final UUID ERKENNING_ID = new UUID(3, 4);
    public static final UUID ERKENNING_ID_1 = new UUID(3, 5);
    public static final UUID ERKENNING_ID_2 = new UUID(3, 6);
    public static final UUID ERKENDE_REFERENT_ID = new UUID(4, 4);
    public static final Erkenningsdoel ERKENNINGSDOEL_ARBEID = ARBEID;
    public static final Erkenningsdoel ERKENNINGSDOEL_ONDERZOEK_RICHTLIJN = ONDERZOEK_RICHTLIJN;
    public static final Erkenningsdoel ERKENNINGSDOEL_STUDIE = STUDIE;
    public static final String ERKENNINGSDOEL_STRING_ARBEID = ARBEID.name();
    public static final Erkenningsdoel ERKENNINGSDOEL_STUDIE_HOGER_ONDERWIJS = STUDIE_HOGER_ONDERWIJS;
    public static final Erkenning.Status ERKENNING_STATUS_ACTIEF = ACTIEF;
    public static final Erkenning.Status ERKENNING_STATUS_BEEINDIGD = BEEINDIGD;
    public static final LocalDate INGANGSDATUM_ERKENNING = LocalDate.now();

    public static final String KVK_NUMMER = "03475945";
    public static final Reden REDEN = STEEKPROEF;

    public static final UUID MEDEWERKER_KEYCLOAK_ID = new UUID(9, 1);
    public static final String MEDEWERKER_NAAM = "naam";
    public static final OnderzoekStatus ONDERZOEK_STATUS_INITIEEL = INITIEEL;
    public static final OnderzoekStatus ONDERZOEK_STATUS_OPEN = OPEN;
    public static final OnderzoekStatus ONDERZOEK_STATUS_IN_BEHANDELING = IN_BEHANDELING;
    public static final OnderzoekStatus ONDERZOEK_STATUS_AFGEROND = AFGEROND;
    public static final PlichtErkenningCategorie PLICHT_CATEGORIE_ZORGPLICHT = PlichtErkenningCategorie.ZORGPLICHT;
    public static final LocalDate OPLEGGINGSDATUM = LocalDate.parse("2022-05-12");
    public static final BigDecimal HOOGTE = BigDecimal.valueOf(44.3);
    public static final String DOCUMENT_ID = "AAAA";
    public static final String DOCUMENT_2_ID = "BBBB";
    public static final String DOCUMENT_3_ID = "CCCC";

    public static final UUID BESTUURLIJKE_BOETE_ID = new UUID(1, 1);
    public static final UUID WAARSCHUWING_ID = new UUID(1, 2);
    public static final UUID WAARSCHUWING_2_ID = new UUID(1, 3);
    public static final UUID VASTGESTELDE_PLICHT_ID = new UUID(2, 2);
    public static final LocalDate VERLOOPDATUM = parse("2022-06-21");
    public static final LocalDate VERWIJDERINGSDATUM = parse("2022-07-21");
    public static final String PLICHT_GRONDSLAG = "ART_4_18_LID_2_SUB_C_VV";
    public static final String PLICHT_CATEGORIE = "ZORGPLICHT";
    public static final UUID PERSOON_ID = new UUID(5, 1);
    public static final UUID REFERENTSCHAP_ID = new UUID(6, 1);
    public static final UUID MAATREGEL_ID = new UUID(7, 1);
    public static final LocalDate STARTDATUM_REFERENTSCHAP = LocalDate.parse("2023-05-03");
    public static final LocalDate EINDDATUM_REFERENTSCHAP_BEEINDIGD = LocalDate.parse("2023-05-10");
    public static final LocalDate EINDDATUM_REFERENTSCHAP_BEEINDIGD_BIJGEWERKT = LocalDate.parse("2023-05-15");
    public static final String GRONDSLAG_REFERENTSCHAP = "VERBLIJFSVERGUNNING_REGULIER_VOOR_BEPAALDE_TIJD";
    public static final Beperking BEPERKING_REFERENTSCHAP_ARBEID = Beperking.ARBEID_IN_LOONDIENST;
    public static final Beperking BEPERKING_REFERENTSCHAP_STUDIE = Beperking.STUDIE;
    public static final ReferentschapStatus REFERENTSCHAP_STATUS_ACTIEF = ReferentschapStatus.ACTIEF;

    public static final LocalDate STARTDATUM_REFERENTSCHAP_ONTSTAAN = LocalDate.parse("2023-05-03");
    public static final String GRONDSLAG_REFERENTSCHAP_ONTSTAAN = "VERBLIJFSVERGUNNING_REGULIER_VOOR_BEPAALDE_TIJD";
    public static final Beperking BEPERKING_REFERENTSCHAP_ARBEID_ALS_KENNISMIGRANT_ONTSTAAN = Beperking.ARBEID_ALS_KENNISMIGRANT;
    public static final Beperking BEPERKING_ARBEID_REFERENTSCHAP_BEEINDIGD = Beperking.ARBEID_ALS_KENNISMIGRANT;
    public static final ReferentschapStatus REFERENTSCHAP_STATUS_REFERENTSCHAP_ONTSTAAN = ReferentschapStatus.ACTIEF;
    public static final String PERSOON_VOORNAMEN = "Jack";
    public static final String PERSOON_VOORVOEGSEL = "the";
    public static final String PERSOON_GESLACHTSNAAM = "Sparrow";
    public static final LocalDateTime INKOMEN_UWV_GEGEVENS_ONTVANGSTDATUM = LocalDateTime.parse("2023-06-19T12:34:00");
    public static final LocalDate INKOMEN_INKOMSTENVERHOUDING_AANVANG_DATUM = LocalDate.parse("2023-01-01");
    public static final LocalDate INKOMEN_INKOMSTENVERHOUDING_EIND_DATUM = LocalDate.parse("2023-12-31");
    public static final String INKOMEN_AARD_ARBEIDSVERHOUDING_CODE = "01 aardArbeidsverhoudingCode";
    public static final String INKOMEN_INKOMSTENVERHOUDING_INCIDENTELE_CODE = "02 inkomstenverhoudingIncidenteleCode";
    public static final String INKOMEN_INKOMSTENVERHOUDING_SOORT_CODE = "03 inkomstenverhoudingSoortCode";
    public static final boolean INKOMEN_ARBEIDSOVEREENKOMST_ONBEPAALDE_TIJD_INDICATOR_JA = true;
    public static final LocalDate INKOMEN_INKOMSTENOPGAVE_AANVANG_DATUM = LocalDate.parse("2023-06-01");
    public static final LocalDate INKOMEN_INKOMSTENOPGAVE_EIND_DATUM = LocalDate.parse("2023-06-30");
    public static final BigDecimal INKOMEN_SOCIALE_VERZEKERINGSLOON_BEDRAG = BigDecimal.valueOf(12.34d);
    public static final int INKOMEN_VERLOONDE_UREN_AANTAL = 1234;
    public static final BigDecimal INKOMEN_VAKANTIETOESLAG_BEDRAG = BigDecimal.valueOf(12.34d);
    public static final BigDecimal INKOMEN_VAKANTIETOESLAG_OPGEBOUWD_BEDRAG = BigDecimal.valueOf(12.34d);
    public static final BigDecimal INKOMEN_ARBEIDSVOORWAARDEN_BEDRAG = BigDecimal.valueOf(12.34d);
    public static final BigDecimal INKOMEN_ARBEIDSVOORWAARDEN_OPGEBOUWD_BEDRAG = BigDecimal.valueOf(12.34d);
    public static final boolean GEGEVENS_EN_BESCHEIDEN_OPVRAGEN_JA = true;
    public static final boolean GEGEVENS_EN_BESCHEIDEN_OPVRAGEN_NEE = false;
    public static final VoorwaardeCategorie VOORWAARDE_CATEGORIE_CONTINUITEIT_EN_SOLVABILITEIT = VoorwaardeCategorie.CONTINUITEIT_EN_SOLVABILITEIT;
    public static final String VOORWAARDE_CATEGORIE_CONTINUITEIT_EN_SOLVABILITEIT_NAME = VOORWAARDE_CATEGORIE_CONTINUITEIT_EN_SOLVABILITEIT.name();
    public static final VerplichtingCategorie VERPLICHTING_CATEGORIE_INFORMATIEPLICHT = VerplichtingCategorie.INFORMATIEPLICHT;
    public static final String VERPLICHTING_CATEGORIE_INFORMATIEPLICHT_NAME = VERPLICHTING_CATEGORIE_INFORMATIEPLICHT.name();
    public static final String BESCHRIJVING_NIEUW_AANDACHTSPUNT = "Mijn test beschrijving voor nieuw aan te maken test aandachtspunt";
    public static final String BESCHRIJVING_BIJGEWERKT_AANDACHTSPUNT = "Bijgewerkte beschrijving voor bestaand test aandachtspunt";
}
