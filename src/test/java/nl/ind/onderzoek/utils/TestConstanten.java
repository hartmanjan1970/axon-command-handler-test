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
import java.util.List;
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

    public static final String CORRECTE_EXCEL = "onderzoek_lijst-correct.xlsx";
    public static final String INCORRECTE_EXCEL = "onderzoek_lijst-incorrect.xlsx";
    public static final String AFBEELDING = "favicon.ico";
//    public static final Foutmelding FOUTMELDING_KVK_NUMMER_LEEG = KVK_NUMMER_LEEG;
//    public static final Foutmelding FOUTMELDING_KVK_NUMMER_INCORRECT = KVK_NUMMER_INCORRECT;
//    public static final Foutmelding FOUTMELDING_ERKENNINGSDOEL_LEEG = ERKENNINGSDOEL_LEEG;
//    public static final Foutmelding FOUTMELDING_ERKENNINGSDOEL_INCORRECT = ERKENNINGSDOEL_INCORRECT;
//    public static final Foutmelding FOUTMELDING_REDEN_LEEG = REDEN_LEEG;
//    public static final Foutmelding FOUTMELDING_REDEN_INCORRECT = REDEN_INCORRECT;

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
    //    public static final OrganisatieOutput.VestigingsadresOutput ORGANISATIE_VESTIGINGSADRES_OUTPUT =
//            OrganisatieOutput.VestigingsadresOutput.builder().land("Nederland").nederlandsAdres(
//                                     OrganisatieOutput.VestigingsadresOutput.NederlandsAdresOutput.builder()
//                                             .straatnaam("Test vestigingsadres van erkende referent")
//                                             .build())
//                                                             .build();
    public static final String ONDERZOEK_ID_FIELD = "onderzoekId";
    public static final UUID ERKENNING_ID = new UUID(3, 4);
    public static final UUID ERKENNING_ID_1 = new UUID(3, 5);
    public static final UUID ERKENNING_ID_2 = new UUID(3, 6);
    public static final UUID ERKENDE_REFERENT_ID = new UUID(4, 4);
    public static final Erkenningsdoel ERKENNINGSDOEL_ARBEID = ARBEID;
    public static final Erkenningsdoel ERKENNINGSDOEL_ONDERZOEK_RICHTLIJN = ONDERZOEK_RICHTLIJN;
    public static final Erkenningsdoel ERKENNINGSDOEL_STUDIE = STUDIE;
    public static final String ERKENNINGSDOEL_STRING_ARBEID = ARBEID.name();
    //    public static final ErkenningMetStatusOutput.Status ERKENNING_OUTPUT_STATUS_ACTIEF = ErkenningMetStatusOutput.Status.ACTIEF;
    public static final Erkenningsdoel ERKENNINGSDOEL_STUDIE_HOGER_ONDERWIJS = STUDIE_HOGER_ONDERWIJS;
    public static final Erkenning.Status ERKENNING_STATUS_ACTIEF = ACTIEF;
    public static final Erkenning.Status ERKENNING_STATUS_BEEINDIGD = BEEINDIGD;
    public static final LocalDate INGANGSDATUM_ERKENNING = LocalDate.now();

    public static final String KVK_NUMMER = "03475945";
    public static final Reden REDEN = STEEKPROEF;

    public static final UUID MEDEWERKER_KEYCLOAK_ID = new UUID(9, 1);
    //    public static final MedewerkerId MEDEWERKER_ID = new MedewerkerId(MEDEWERKER_KEYCLOAK_ID);
    public static final String MEDEWERKER_NAAM = "naam";
    //    public static final Status ONDERZOEK_LOG_VIEW_STATUS_WORD_GEVALIDEERD = WORDT_GEVALIDEERD;
//    public static final OnderzoekLogViewOutput.Status ONDERZOEK_LOG_VIEW_OUTPUT_STATUS_WORDT_GEVALIDEERD =
//            OnderzoekLogViewOutput.Status.WORDT_GEVALIDEERD;
//    public static final Status ONDERZOEK_LOG_VIEW_STATUS_FOUT = FOUT;
//    public static final Status ONDERZOEK_LOG_VIEW_STATUS_GOED = GOED;
    public static final OnderzoekStatus ONDERZOEK_STATUS_INITIEEL = INITIEEL;
    public static final OnderzoekStatus ONDERZOEK_STATUS_OPEN = OPEN;
    public static final OnderzoekStatus ONDERZOEK_STATUS_IN_BEHANDELING = IN_BEHANDELING;
    public static final OnderzoekStatus ONDERZOEK_STATUS_AFGEROND = AFGEROND;
    //    public static final Medewerker DUMMY_MEDEWERKER =
//            Medewerker.builder().id(UUID.fromString("00000000-0000-0000-0000-000000000001")).naam("test").build();
//    public static final UUID MEDEWERKER_ID_1 = UUID.fromString("00000000-0000-0000-0000-000000000001");
//    public static final UUID MEDEWERKER_ID_2 = UUID.fromString("00000000-0000-0000-0000-000000000002");
//    public static final String INPUT = "input";
//    public static final MaatregelType MAATREGEL_TYPE_WAARSCHUWING = WAARSCHUWING;
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
    //    public static final ReferentschapOntstaanEvent.Beperking BEPERKING_REFERENTSCHAP_ONTSTAAN_EVENT =
//            ReferentschapOntstaanEvent.Beperking.ARBEID_ALS_KENNISMIGRANT;
    public static final Beperking BEPERKING_REFERENTSCHAP_ARBEID_ALS_KENNISMIGRANT_ONTSTAAN = Beperking.ARBEID_ALS_KENNISMIGRANT;
    public static final Beperking BEPERKING_ARBEID_REFERENTSCHAP_BEEINDIGD = Beperking.ARBEID_ALS_KENNISMIGRANT;
    public static final ReferentschapStatus REFERENTSCHAP_STATUS_REFERENTSCHAP_ONTSTAAN = ReferentschapStatus.ACTIEF;
    //    public static final ReferentschapOntstaanEvent.ReferentschapStatus REFERENTSCHAP_STATUS_REFERENTSCHAP_ONTSTAAN_EVENT =
//            ReferentschapOntstaanEvent.ReferentschapStatus.ACTIEF;
    public static final List<Erkenning> ALLE_ACTIEVE_ERKENNINGEN = List.of(
            Erkenning.builder().erkenningId(UUID.randomUUID()).erkenningsdoel(ERKENNINGSDOEL_ARBEID).status(ACTIEF).build(),
            Erkenning.builder().erkenningId(UUID.randomUUID()).erkenningsdoel(ERKENNINGSDOEL_STUDIE).status(ACTIEF).build(),
            Erkenning.builder().erkenningId(UUID.randomUUID()).erkenningsdoel(ERKENNINGSDOEL_ONDERZOEK_RICHTLIJN).status(ACTIEF).build()
    );
    public static final String KENNISMIGRANT_NAAM = PERSOON_ID.toString();
    public static final BigDecimal KENNISMIGRANT_GEMIDDELD_SOCIALE_VERZEKERINGSLOON_LOON_BEDRAG = BigDecimal.valueOf(3400.00);
    public static final LocalDate KENNISMIGRANT_INKOMSTENOPGAVE_AANVANG_DATUM = LocalDate.parse("2023-06-05");
    public static final LocalDate KENNISMIGRANT_INKOMSTENOPGAVE_EIND_DATUM = LocalDate.parse("2023-06-30");
    public static final BigDecimal KENNISMIGRANT_SOCIALE_VERZEKERINGSLOON_LOON = BigDecimal.valueOf(3500.11);
    public static final int KENNISMIGRANT_VERLOONDE_UREN_AANTAL = 123;
    public static final BigDecimal KENNISMIGRANT_VAKANTIETOESLAG_BEDRAG = BigDecimal.valueOf(500.11);
    public static final BigDecimal KENNISMIGRANT_VAKANTIETOESLAG_OPGEBOUWD_BEDRAG = BigDecimal.valueOf(3500.22);
    public static final BigDecimal KENNISMIGRANT_ARBEIDSVOORWAARDEN_BEDRAG = BigDecimal.valueOf(3500.33);
    public static final BigDecimal KENNISMIGRANT_ARBEIDSVOORWAARDEN_OPGEBOUWD_BEDRAG = BigDecimal.valueOf(3500.44);
    public static final LocalDateTime KENNISMIGRANT_ONTVANGSTDATUM_GEGEVENS_UWV = LocalDateTime.parse("2023-06-01T12:34:56");
    public static final LocalDate KENNISMIGRANT_INKOMSTENVERHOUDING_AANVANG_DATUM = LocalDate.parse("2023-01-01");
    public static final LocalDate KENNISMIGRANT_INKOMSTENVERHOUDING_EIND_DATUM = LocalDate.parse("2023-12-31");
    public static final String KENNISMIGRANT_CODE_AARD_ARBEIDSVERHOUDING = "code aard arbeidsverhouding";
    public static final String KENNISMIGRANT_CODE_INCIDENTELE_INKOMSTENVERMINDERING = "code incidentele inkomstenvermindering";
    public static final String KENNISMIGRANT_INKOMSTENVERHOUDING_SOORT_CODE = "code soort inkomstenverhouding";
    public static final boolean KENNISMIGRANT_ARBEIDSOVEREENKOMST_ONBEPAALDE_TIJD_INDICATOR_NEE = false;
    public static final LocalDate KENNISMIGRANT_STARTDATUM_ERKEND_REFERENTSCHAP = LocalDate.parse("2023-06-01");
    public static final LocalDate KENNISMIGRANT_EINDDATUM_ERKEND_REFERENTSCHAP = LocalDate.parse("2023-06-30");
    public static final String PERSOON_VREEMDELINGENNUMMER = "0987654321";
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
    public static final UUID EVENT_ID = new UUID(9, 9);
    public static final String AANDACHTSPUNT_ID_FIELD = "aandachtspuntId";
    public static final String REFERENTSCHAP_ID_FIELD = "referentschapId";
    public static final String ONDERZOEK_ONDERDEEL_FIELD = "onderzoekOnderdeel";
    public static final String MAATREGEL_IF_FIELD = "maatregelId";
    public static final LocalDate INKOMEN_ABONNEMENT_BEGINDATUM = STARTDATUM_REFERENTSCHAP.minusYears(5);
    public static final boolean GEGEVENS_EN_BESCHEIDEN_OPVRAGEN_JA = true;
    public static final boolean GEGEVENS_EN_BESCHEIDEN_OPVRAGEN_NEE = false;
    public static final VoorwaardeCategorie VOORWAARDE_CATEGORIE_CONTINUITEIT_EN_SOLVABILITEIT = VoorwaardeCategorie.CONTINUITEIT_EN_SOLVABILITEIT;
    public static final String VOORWAARDE_CATEGORIE_CONTINUITEIT_EN_SOLVABILITEIT_NAME = VOORWAARDE_CATEGORIE_CONTINUITEIT_EN_SOLVABILITEIT.name();
    public static final VerplichtingCategorie VERPLICHTING_CATEGORIE_INFORMATIEPLICHT = VerplichtingCategorie.INFORMATIEPLICHT;
    public static final String VERPLICHTING_CATEGORIE_INFORMATIEPLICHT_NAME = VERPLICHTING_CATEGORIE_INFORMATIEPLICHT.name();
    public static final String BESCHRIJVING_NIEUW_AANDACHTSPUNT = "Mijn test beschrijving voor nieuw aan te maken test aandachtspunt";
    public static final String BESCHRIJVING_BIJGEWERKT_AANDACHTSPUNT = "Bijgewerkte beschrijving voor bestaand test aandachtspunt";
}
