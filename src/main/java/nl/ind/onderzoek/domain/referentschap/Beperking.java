package nl.ind.onderzoek.domain.referentschap;

import lombok.RequiredArgsConstructor;
import nl.ind.onderzoek.domain.Erkenningsdoel;

import java.util.List;
import java.util.Objects;

import static nl.ind.onderzoek.domain.Erkenningsdoel.*;

@RequiredArgsConstructor
public enum Beperking {
    ARBEID_ALS_KENNISMIGRANT(List.of(ARBEID)),
    ARBEID_ALS_NIET_GEPRIVILEGIEERD_MILITAIR_OF_NIET_GEPRIVILEGIEERD_BURGERPERSONEEL(List.of()),
    ARBEID_ALS_ZELFSTANDIGE(List.of()),
    ARBEID_IN_LOONDIENST(List.of(ARBEID)),
    BUITEN_SCOPE(List.of()),
    GRENSOVERSCHRIJDENDE_DIENSTVERLENING(List.of()),
    HET_AFWACHTEN_VAN_EEN_VERZOEK_OP_GROND_VAN_ARTIKEL_17_VAN_DE_RIJKSWET_OP_HET_NEDERLANDERSCHAP(List.of()),
    HET_ZOEKEN_NAAR_EN_VERRICHTEN_VAN_ARBEID_AL_DAN_NIET_IN_LOONDIENST(List.of()),
    LEREND_WERKEN(List.of(ARBEID)),
    MEDISCHE_BEHANDELING(List.of()),
    NIET_TIJDELIJKE_HUMANITAIRE_GRONDEN(List.of()),
    ONDERZOEK_IN_DE_ZIN_VAN_RICHTLIJN_EU_2016_801(List.of(ONDERZOEK_RICHTLIJN)),
    OVERPLAATSING_BINNEN_EEN_ONDERNEMING(List.of(ARBEID)),
    SEIZOENSARBEID(List.of(ARBEID)),
    STUDIE(List.of(Erkenningsdoel.STUDIE, STUDIE_HOGER_ONDERWIJS, STUDIE_MIDDELBAAR_BEROEPSONDERWIJS, STUDIE_VOORTGEZET_ONDERWIJS)),
    TIJDELIJKE_HUMANITAIRE_GRONDEN(List.of()),
    UITWISSELING_AL_DAN_NIET_IN_HET_KADER_VAN_EEN_VERDRAG(
            List.of(UITWISSELING, UITWISSELING_AU_PAIR, UITWISSELING_PARTICULIERE_ORGANISATIE, UITWISSELING_EUROPEES_VRIJWILLIGERSWERK)),
    VERBLIJF_ALS_ECONOMISCH_NIET_ACTIEVE_LANGDURIG_INGEZETENE_OF_ALS_VERMOGENDE_VREEMDELING(List.of()),
    VERBLIJF_ALS_FAMILIE_OF_GEZINSLID(List.of()),
    VERBLIJF_ALS_HOUDER_VAN_DE_EUROPESE_BLAUWE_KAART(List.of(ARBEID)),
    WETENSCHAPPELIJK_ONDERZOEK_IN_DE_ZIN_VAN_RICHTLIJN_2005_71_EG(List.of(ONDERZOEK_RICHTLIJN));

    private final List<Erkenningsdoel> erkenningsdoelen;

    public boolean matchtBeperkingBijErkenningsdoel(Erkenningsdoel erkenningsdoelToMatch) {
        return erkenningsdoelen.stream()
                .anyMatch(erkenningsdoel -> Objects.equals(erkenningsdoel, erkenningsdoelToMatch));
    }

    public boolean isArbeidAlskennismigrant() {
        return ARBEID_ALS_KENNISMIGRANT.equals(this);
    }
}
