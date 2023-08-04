package nl.ind.onderzoek.utils.organisatie;

import lombok.experimental.UtilityClass;
import nl.ind.onderzoek.domain.command.onderzoek.command.erkenning.VerleenOrganisatieErkenning;
import nl.ind.onderzoek.domain.command.onderzoek.command.erkenning.WijzigOrganisatieErkenningsdoel;
import nl.ind.onderzoek.domain.command.onderzoek.command.organisatie.RegistreerOrganisatieGegevens;
import nl.ind.onderzoek.domain.command.onderzoek.command.organisatie.WerkOrganisatieGegevensBij;

import java.time.LocalDate;
import java.util.UUID;

import static nl.ind.onderzoek.utils.TestConstanten.*;

@UtilityClass
public class OrganisatieCommandUtils {

    public static WerkOrganisatieGegevensBij werkOrganisatieGegevensBij() {
        return WerkOrganisatieGegevensBij.builder()
                .onderzoekId(ONDERZOEK_ID)
                .organisatieId(ORGANISATIE_ID)
                .kvkNummer(KVK_NUMMER)
                .naamErkendeReferent(ORGANISATIE_NAAM)
                .vestigingsadres(ORGANISATIE_VESTIGINGSADRES)
                .build();
    }

    public static RegistreerOrganisatieGegevens registreerOrganisatieGegevens() {
        return RegistreerOrganisatieGegevens.builder()
                .onderzoekId(ONDERZOEK_ID)
                .organisatieId(ORGANISATIE_ID)
                .kvkNummer(KVK_NUMMER)
                .naamErkendeReferent(ORGANISATIE_NAAM)
                .vestigingsadres(ORGANISATIE_VESTIGINGSADRES)
                .build();
    }

    public static VerleenOrganisatieErkenning verleenOrganisatieErkenning(UUID onderzoekId) {
        return VerleenOrganisatieErkenning.builder()
                .onderzoekId(onderzoekId)
                .organisatieId(ORGANISATIE_ID)
                .erkenningId(ERKENNING_ID)
                .erkenningsdoel(ERKENNINGSDOEL_ARBEID)
                .ingangsdatum(LocalDate.now())
                .build();
    }

    public static WijzigOrganisatieErkenningsdoel wijzigOrganisatieErkenningsdoel(UUID onderzoekId) {
        return WijzigOrganisatieErkenningsdoel.builder()
                .onderzoekId(onderzoekId)
                .organisatieId(ORGANISATIE_ID)
                .erkenningId(ERKENNING_ID_1)
                .erkenningsdoel(ERKENNINGSDOEL_ARBEID)
                .build();
    }

}
