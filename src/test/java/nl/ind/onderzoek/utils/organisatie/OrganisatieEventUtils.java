package nl.ind.onderzoek.utils.organisatie;

import lombok.experimental.UtilityClass;
import nl.ind.onderzoek.domain.Erkenningsdoel;
import nl.ind.onderzoek.domain.command.onderzoek.Erkenning;
import nl.ind.onderzoek.domain.command.onderzoek.event.controleorganisatievooronderzoek.OrganisatieHeeftActieveErkenningMetErkenningsdoel;
import nl.ind.onderzoek.domain.command.onderzoek.event.controleorganisatievooronderzoek.OrganisatieHeeftErkenningMetErkenningsdoel;
import nl.ind.onderzoek.domain.command.onderzoek.event.controleorganisatievooronderzoek.OrganisatieIsNietInOnderzoekVoorErkenningsdoel;
import nl.ind.onderzoek.domain.command.onderzoek.event.controleorganisatievooronderzoek.OrganisatieVoorKvkNummerBestaat;
import nl.ind.onderzoek.domain.command.onderzoek.event.erkenning.OrganisatieErkenningVerleend;
import nl.ind.onderzoek.domain.command.onderzoek.event.erkenning.OrganisatieErkenningsdoelGewijzigd;
import nl.ind.onderzoek.domain.command.onderzoek.event.organisatie.OrganisatieGegevensBijgewerkt;
import nl.ind.onderzoek.domain.command.onderzoek.event.organisatie.OrganisatieGegevensGeregistreerd;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static nl.ind.onderzoek.utils.TestConstanten.*;
import static nl.ind.onderzoek.utils.erkenning.ErkenningAggregateMemberUtils.erkenning;

@UtilityClass
public class OrganisatieEventUtils {

    public static OrganisatieGegevensBijgewerkt organisatieGegevensBijgewerkt() {
        return OrganisatieGegevensBijgewerkt.builder()
                .onderzoekId(ONDERZOEK_ID)
                .organisatieId(ORGANISATIE_ID)
                .naamErkendeReferent(ORGANISATIE_NAAM)
                .kvkNummer(KVK_NUMMER)
                .naamErkendeReferent(ORGANISATIE_NAAM)
                .vestigingsadres(ORGANISATIE_VESTIGINGSADRES)
                .build();
    }

    public static OrganisatieGegevensGeregistreerd organisatieGegevensGeregistreerd() {
        return OrganisatieGegevensGeregistreerd.builder()
                .onderzoekId(ONDERZOEK_ID)
                .organisatieId(ORGANISATIE_ID)
                .naamErkendeReferent(ORGANISATIE_NAAM)
                .kvkNummer(KVK_NUMMER)
                .vestigingsadres(ORGANISATIE_VESTIGINGSADRES)
                .build();
    }

    public static OrganisatieHeeftActieveErkenningMetErkenningsdoel organisatieHeeftActieveErkenningMetErkenningsdoel() {
        return OrganisatieHeeftActieveErkenningMetErkenningsdoel.builder()
                .onderzoekId(ONDERZOEK_ID)
                .organisatieId(ORGANISATIE_ID)
                .erkenning(erkenning(ERKENNINGSDOEL_ARBEID, ERKENNING_STATUS_ACTIEF))
                .build();
    }

    public static OrganisatieHeeftErkenningMetErkenningsdoel organisatieHeeftErkenningMetErkenningsdoel() {
        return OrganisatieHeeftErkenningMetErkenningsdoel.builder()
                .onderzoekId(ONDERZOEK_ID)
                .organisatieId(ORGANISATIE_ID)
                .erkenningen(List.of(erkenning(ERKENNINGSDOEL_ARBEID, ERKENNING_STATUS_ACTIEF)))
                .build();
    }

    public static OrganisatieIsNietInOnderzoekVoorErkenningsdoel organisatieIsNietInOnderzoekVoorErkenningsdoel() {
        return OrganisatieIsNietInOnderzoekVoorErkenningsdoel.builder()
                .onderzoekId(ONDERZOEK_ID)
                .organisatieId(ORGANISATIE_ID)
                .build();
    }

    public static OrganisatieVoorKvkNummerBestaat organisatieVoorKvkNummerBestaat() {
        return OrganisatieVoorKvkNummerBestaat.builder()
                .onderzoekId(ONDERZOEK_ID)
                .organisatieId(ORGANISATIE_ID)
                .build();
    }

    public static OrganisatieErkenningVerleend organisatieErkenningVerleend(UUID onderzoekId) {
        return organisatieErkenningVerleend(onderzoekId, ERKENNINGSDOEL_ARBEID);
    }

    public static OrganisatieErkenningVerleend organisatieErkenningVerleend(UUID onderzoekId, Erkenningsdoel erkenningsdoel) {
        return OrganisatieErkenningVerleend.builder()
                .onderzoekId(onderzoekId)
                .organisatieId(ORGANISATIE_ID)
                .erkenning(Erkenning.builder()
                        .erkenningId(ERKENNING_ID)
                        .erkenningsdoel(erkenningsdoel)
                        .status(ERKENNING_STATUS_ACTIEF)
                        .build()
                )
                .ingangsdatum(LocalDate.now())
                .build();
    }

    public static OrganisatieErkenningsdoelGewijzigd organisatieErkenningsdoelGewijzigd(UUID onderzoekId) {
        return organisatieErkenningsdoelGewijzigd(onderzoekId, ERKENNINGSDOEL_ARBEID);
    }

    public static OrganisatieErkenningsdoelGewijzigd organisatieErkenningsdoelGewijzigd(UUID onderzoekId, Erkenningsdoel erkenningsdoel) {
        return OrganisatieErkenningsdoelGewijzigd.builder()
                .onderzoekId(onderzoekId)
                .organisatieId(ORGANISATIE_ID)
                .erkenningId(ERKENNING_ID_1)
                .erkenningsdoel(erkenningsdoel)
                .build();
    }
}
