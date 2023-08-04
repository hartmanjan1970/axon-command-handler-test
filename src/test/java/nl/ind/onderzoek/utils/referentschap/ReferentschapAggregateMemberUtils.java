package nl.ind.onderzoek.utils.referentschap;

import lombok.experimental.UtilityClass;
import nl.ind.onderzoek.domain.referentschap.Beperking;
import nl.ind.onderzoek.domain.referentschap.Referentschap;

import static nl.ind.onderzoek.utils.TestConstanten.*;

@UtilityClass
public class ReferentschapAggregateMemberUtils {
    public static Referentschap referentschap(Beperking beperkingReferentschapArbeid) {
        return Referentschap.builder()
                .referentschapId(REFERENTSCHAP_ID)
                .organisatieId(ORGANISATIE_ID)
                .persoonId(PERSOON_ID)
                .erkenningId(ERKENNING_ID)
                .startdatum(STARTDATUM_REFERENTSCHAP_ONTSTAAN)
                .grondslag(GRONDSLAG_REFERENTSCHAP)
                .beperking(beperkingReferentschapArbeid)
                .referentschapStatus(REFERENTSCHAP_STATUS_ACTIEF)
                .build();
    }
}
