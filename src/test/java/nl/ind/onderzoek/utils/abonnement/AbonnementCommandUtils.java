package nl.ind.onderzoek.utils.abonnement;

import lombok.experimental.UtilityClass;
import nl.ind.onderzoek.domain.Onderwerp;
import nl.ind.onderzoek.domain.command.abonnement.command.MaakAbonnement;
import nl.ind.onderzoek.domain.command.abonnement.command.OpzeggenAbonnement;
import nl.ind.onderzoek.domain.command.onderzoek.command.NeemOnderzoekInBehandeling;

import static nl.ind.onderzoek.domain.Onderwerp.OnderwerpType.ONDERZOEK_INKOMEN_KENNISMIGRANT;
import static nl.ind.onderzoek.utils.TestConstanten.*;
import static nl.ind.onderzoek.utils.abonnement.AbonnementEventUtils.onderwerp;

@UtilityClass
public class AbonnementCommandUtils {
    public static MaakAbonnement maakAbonnement() {
        return MaakAbonnement.builder()
                .abonnementId(ABONNEMENT_ID)
                .externAbonnementId(EXTERN_ABONNEMENT_ID)
                .onderwerp(onderwerp())
                .externOnderwerp(externOnderwerp())
                .build();
    }

    public static NeemOnderzoekInBehandeling neemOnderzoekInBehandeling() {
        return NeemOnderzoekInBehandeling.builder()
                .onderzoekId(ONDERZOEK_ID)
                .build();
    }

    public static OpzeggenAbonnement opzeggenAbonnement() {
        return OpzeggenAbonnement.builder()
                .abonnementId(ABONNEMENT_ID)
                .build();
    }

    public static Onderwerp externOnderwerp() {
        return Onderwerp.builder()
                .id(ONDERZOEK_ID)
                .type(ONDERZOEK_INKOMEN_KENNISMIGRANT)
                .build();
    }
}
