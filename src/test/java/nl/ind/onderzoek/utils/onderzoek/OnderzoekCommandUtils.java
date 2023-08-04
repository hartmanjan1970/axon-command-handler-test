package nl.ind.onderzoek.utils.onderzoek;

import lombok.experimental.UtilityClass;
import nl.ind.onderzoek.domain.command.onderzoek.command.InitieerOnderzoek;
import nl.ind.onderzoek.domain.command.onderzoek.command.RondOnderzoekAf;
import nl.ind.onderzoek.domain.command.onderzoek.command.VoegMedewerkerToeAanOnderzoek;
import nl.ind.onderzoek.domain.command.onderzoek.command.controleorganisatievooronderzoek.OpenOnderzoek;
import nl.ind.onderzoek.domain.command.onderzoek.command.persoon.RegistreerPersoonGegevens;
import nl.ind.onderzoek.domain.command.onderzoek.command.persoon.WerkPersoonGegevensBij;

import static nl.ind.onderzoek.utils.TestConstanten.*;

@UtilityClass
public class OnderzoekCommandUtils {
    public static InitieerOnderzoek initieerOnderzoek() {
        return InitieerOnderzoek.builder()
                .onderzoekId(ONDERZOEK_ID)
                .kvkNummer(KVK_NUMMER)
                .erkenningsdoel(ERKENNINGSDOEL_ARBEID)
                .reden(REDEN)
                .build();
    }

    public static OpenOnderzoek openOnderzoek() {
        return OpenOnderzoek.builder()
                .onderzoekId(ONDERZOEK_ID)
                .naamErkendeReferent(ORGANISATIE_NAAM)
                .build();
    }

    public static RondOnderzoekAf rondOnderzoekAf() {
        return RondOnderzoekAf.builder()
                .onderzoekId(ONDERZOEK_ID)
                .build();
    }

    public static VoegMedewerkerToeAanOnderzoek voegMedewerkerToeAanOnderzoek() {
        return VoegMedewerkerToeAanOnderzoek.builder()
                .medewerkerId(MEDEWERKER_KEYCLOAK_ID)
                .onderzoekId(ONDERZOEK_ID)
                .build();
    }

    public static WerkPersoonGegevensBij werkPersoonGegevensBij() {
        return WerkPersoonGegevensBij.builder()
                .onderzoekId(ONDERZOEK_ID)
                .persoonId(PERSOON_ID)
                .referentschapId(REFERENTSCHAP_ID)
                .voornamen(PERSOON_VOORNAMEN)
                .voorvoegsel(PERSOON_VOORVOEGSEL)
                .geslachtsnaam(PERSOON_GESLACHTSNAAM)
                .build();
    }

    public static RegistreerPersoonGegevens registreerPersoonGegevens() {
        return RegistreerPersoonGegevens.builder()
                .onderzoekId(ONDERZOEK_ID)
                .referentschapId(REFERENTSCHAP_ID)
                .persoonId(PERSOON_ID)
                .geslachtsnaam(PERSOON_GESLACHTSNAAM)
                .voornamen(PERSOON_VOORNAMEN)
                .voorvoegsel(PERSOON_VOORVOEGSEL)
                .build();
    }
}
