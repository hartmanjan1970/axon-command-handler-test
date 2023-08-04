package nl.ind.onderzoek.utils.onderzoek;

import lombok.experimental.UtilityClass;
import nl.ind.onderzoek.domain.command.onderzoek.event.MedewerkerAanOnderzoekToegevoegd;
import nl.ind.onderzoek.domain.command.onderzoek.event.OnderzoekGeinitieerd;
import nl.ind.onderzoek.domain.command.onderzoek.event.OnderzoekInBehandelingGenomen;
import nl.ind.onderzoek.domain.command.onderzoek.event.OnderzoekIsAfgerond;
import nl.ind.onderzoek.domain.command.onderzoek.event.controleorganisatievooronderzoek.OnderzoekGeopend;
import nl.ind.onderzoek.domain.command.onderzoek.event.controleorganisatievooronderzoek.OnderzoekIsNietInBehandelingGenomen;
import nl.ind.onderzoek.domain.command.onderzoek.event.persoon.PersoonGegevensGeregistreerd;

import static nl.ind.onderzoek.utils.TestConstanten.*;
import static nl.ind.onderzoek.utils.erkenning.ErkenningAggregateMemberUtils.erkenning;

@UtilityClass
public class OnderzoekEventUtils {

    public static OnderzoekGeinitieerd onderzoekGeinitieerd() {
        return OnderzoekGeinitieerd.builder()
                .onderzoekId(ONDERZOEK_ID)
                .kvkNummer(KVK_NUMMER)
                .erkenningsdoel(ERKENNINGSDOEL_ARBEID)
                .reden(REDEN)
                .build();
    }

    public static OnderzoekGeopend onderzoekGeopend() {
        return OnderzoekGeopend.builder()
                .onderzoekId(ONDERZOEK_ID)
                .organisatieId(ORGANISATIE_ID)
                .naamErkendeReferent(ORGANISATIE_NAAM)
                .erkenningInOnderzoek(erkenning(ERKENNINGSDOEL_ARBEID, ERKENNING_STATUS_ACTIEF))
                .build();
    }

    public static MedewerkerAanOnderzoekToegevoegd medewerkerAanOnderzoekToegevoegd() {
        return MedewerkerAanOnderzoekToegevoegd.builder()
                .medewerkerId(MEDEWERKER_KEYCLOAK_ID)
                .onderzoekId(ONDERZOEK_ID)
                .build();
    }

    public static OnderzoekGeopend onderzoekGeopend_zonderNaamErkendeReferent() {
        return OnderzoekGeopend.builder()
                .onderzoekId(ONDERZOEK_ID)
                .build();
    }

    public static OnderzoekInBehandelingGenomen onderzoekInBehandelingGenomen() {
        return OnderzoekInBehandelingGenomen.builder()
                .onderzoekId(ONDERZOEK_ID)
                .build();
    }

    public static OnderzoekIsAfgerond onderzoekIsAfgerond() {
        return OnderzoekIsAfgerond.builder()
                .onderzoekId(ONDERZOEK_ID)
                .build();
    }

    public static OnderzoekIsNietInBehandelingGenomen onderzoekIsNietInBehandelingGenomen() {
        return onderzoekIsNietInBehandelingGenomen(null);
    }

    public static OnderzoekIsNietInBehandelingGenomen onderzoekIsNietInBehandelingGenomen(OnderzoekIsNietInBehandelingGenomen.Foutreden foutreden) {
        return OnderzoekIsNietInBehandelingGenomen.builder()
                .onderzoekId(ONDERZOEK_ID)
                .foutreden(foutreden)
                .build();
    }

    public static PersoonGegevensGeregistreerd persoonGegevensGeregistreerd() {
        return PersoonGegevensGeregistreerd.builder()
                .onderzoekId(ONDERZOEK_ID)
                .referentschapId(REFERENTSCHAP_ID)
                .persoonId(PERSOON_ID)
                .geslachtsnaam(PERSOON_GESLACHTSNAAM)
                .voornamen(PERSOON_VOORNAMEN)
                .voorvoegsel(PERSOON_VOORVOEGSEL)
                .build();
    }

}
