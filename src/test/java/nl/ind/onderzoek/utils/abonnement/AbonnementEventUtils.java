package nl.ind.onderzoek.utils.abonnement;

import lombok.experimental.UtilityClass;
import nl.ind.onderzoek.domain.Onderwerp;
import nl.ind.onderzoek.domain.command.abonnement.event.AbonnementGemaakt;
import nl.ind.onderzoek.domain.command.abonnement.event.AbonnementOpgezegd;

import static nl.ind.onderzoek.domain.Onderwerp.OnderwerpType.ONDERZOEK_INKOMEN_KENNISMIGRANT;
import static nl.ind.onderzoek.domain.Onderwerp.OnderwerpType.ORGANISATIE;
import static nl.ind.onderzoek.utils.TestConstanten.*;

@UtilityClass
public class AbonnementEventUtils {
    public static AbonnementGemaakt abonnementGemaakt() {
        return AbonnementGemaakt.builder()
                .abonnementId(ABONNEMENT_ID)
                .externAbonnementId(EXTERN_ABONNEMENT_ID)
                .onderwerp(onderwerp())
                .externOnderwerp(externOnderwerp())
                .build();
    }

    public static Onderwerp onderwerp() {
        return Onderwerp.builder()
                .id(ORGANISATIE_ID)
                .type(ORGANISATIE)
                .build();
    }

    public static Onderwerp externOnderwerp() {
        return Onderwerp.builder()
                .id(ONDERZOEK_ID)
                .type(ONDERZOEK_INKOMEN_KENNISMIGRANT)
                .build();
    }

    public static AbonnementOpgezegd abonnementOpgezegd() {
        return AbonnementOpgezegd.builder()
                .abonnementId(ABONNEMENT_ID)
                .build();
    }
}
