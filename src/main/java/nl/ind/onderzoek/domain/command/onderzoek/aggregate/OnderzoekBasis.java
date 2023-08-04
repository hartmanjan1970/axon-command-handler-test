package nl.ind.onderzoek.domain.command.onderzoek.aggregate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.ind.onderzoek.domain.OnderzoekStatus;
import nl.ind.onderzoek.domain.command.onderzoek.Erkenning;
import nl.ind.onderzoek.domain.command.onderzoek.command.NeemOnderzoekInBehandeling;
import nl.ind.onderzoek.domain.command.onderzoek.command.RondOnderzoekAf;
import nl.ind.onderzoek.domain.command.onderzoek.command.VoegMedewerkerToeAanOnderzoek;
import nl.ind.onderzoek.domain.command.onderzoek.command.controleorganisatievooronderzoek.*;
import nl.ind.onderzoek.domain.command.onderzoek.command.erkenning.*;
import nl.ind.onderzoek.domain.command.onderzoek.command.organisatie.RegistreerOrganisatieGegevens;
import nl.ind.onderzoek.domain.command.onderzoek.command.organisatie.WerkOrganisatieGegevensBij;
import nl.ind.onderzoek.domain.command.onderzoek.command.persoon.RegistreerPersoonGegevens;
import nl.ind.onderzoek.domain.command.onderzoek.command.persoon.WerkPersoonGegevensBij;
import nl.ind.onderzoek.domain.command.onderzoek.event.MedewerkerAanOnderzoekToegevoegd;
import nl.ind.onderzoek.domain.command.onderzoek.event.OnderzoekInBehandelingGenomen;
import nl.ind.onderzoek.domain.command.onderzoek.event.OnderzoekIsAfgerond;
import nl.ind.onderzoek.domain.command.onderzoek.event.controleorganisatievooronderzoek.*;
import nl.ind.onderzoek.domain.command.onderzoek.event.erkenning.*;
import nl.ind.onderzoek.domain.command.onderzoek.event.organisatie.OrganisatieGegevensBijgewerkt;
import nl.ind.onderzoek.domain.command.onderzoek.event.organisatie.OrganisatieGegevensGeregistreerd;
import nl.ind.onderzoek.domain.command.onderzoek.event.persoon.PersoonGegevensGeregistreerd;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;

import java.util.UUID;

import static lombok.AccessLevel.PACKAGE;
import static nl.ind.onderzoek.domain.OnderzoekStatus.*;
import static nl.ind.onderzoek.domain.command.onderzoek.Erkenning.Status.ACTIEF;
import static nl.ind.onderzoek.domain.command.onderzoek.event.controleorganisatievooronderzoek.OnderzoekIsNietInBehandelingGenomen.Foutreden.*;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;
import static org.axonframework.modelling.command.AggregateLifecycle.markDeleted;

@Getter
@NoArgsConstructor(access = PACKAGE)
@Slf4j
abstract class OnderzoekBasis {

    public static final String ONDERZOEK_MET_ID_S_EN_STATUS_S_IS_NIET_IN_INITIEEL_DUS_NEGEER_CONTROLE_COMMAND =
            "Onderzoek met id: %s en status: %s is niet in INITIEEL, dus negeer controle command.";

    @AggregateIdentifier
    UUID onderzoekId;
    UUID organisatieId;
    Erkenning erkenning;
    OnderzoekStatus onderzoekStatus;

    @CommandHandler
    public void controleerOfOrganisatieVoorKvkNummerBestaat(ControleerOfOrganisatieVoorKvkNummerBestaat command) {

        if (onderzoekStatus.isNietInitieel()) {
            log.warn(ONDERZOEK_MET_ID_S_EN_STATUS_S_IS_NIET_IN_INITIEEL_DUS_NEGEER_CONTROLE_COMMAND
                    .formatted(onderzoekId, onderzoekStatus));
            return;
        }

        if (command.organisatieIdBestaatNiet()) {
            apply(OnderzoekIsNietInBehandelingGenomen.builder()
                    .onderzoekId(onderzoekId)
                    .foutreden(KVK_NUMMER_NIET_BEKEND_BIJ_BEDRIJF_INSTELLING)
                    .build());
            return;
        }

        apply(OrganisatieVoorKvkNummerBestaat.builder()
                .onderzoekId(onderzoekId)
                .organisatieId(command.getOrganisatieId())
                .build());
    }

    @CommandHandler
    public void controleerOfOrganisatieErkenningVoorErkenningsdoelHeeft(ControleerOfOrganisatieErkenningVoorErkenningsdoelHeeft command) {

        if (onderzoekStatus.isNietInitieel()) {
            log.warn(ONDERZOEK_MET_ID_S_EN_STATUS_S_IS_NIET_IN_INITIEEL_DUS_NEGEER_CONTROLE_COMMAND
                    .formatted(onderzoekId, onderzoekStatus));
            return;
        }

        if (command.heeftGeenErkenningMetErkenningsdoel(this.erkenning.getErkenningsdoel())) {
            apply(OnderzoekIsNietInBehandelingGenomen.builder()
                    .onderzoekId(onderzoekId)
                    .foutreden(ORGANISATIE_HEEFT_GEEN_ERKENNING_VOOR_ERKENNINGSDOEL)
                    .build());
            return;
        }

        apply(OrganisatieHeeftErkenningMetErkenningsdoel.builder()
                .onderzoekId(onderzoekId)
                .organisatieId(organisatieId)
                .erkenningen(command.getErkenningenMetErkenningsdoel(this.erkenning.getErkenningsdoel()))
                .build());
    }

    @CommandHandler
    public void controleerOfOrganisatieActieveErkenningVoorErkenningsdoelHeeft(
            ControleerOfOrganisatieActieveErkenningVoorErkenningsdoelHeeft command) {

        if (onderzoekStatus.isNietInitieel()) {
            log.warn(ONDERZOEK_MET_ID_S_EN_STATUS_S_IS_NIET_IN_INITIEEL_DUS_NEGEER_CONTROLE_COMMAND
                    .formatted(onderzoekId, onderzoekStatus));
            return;
        }

        if (command.heeftGeenActieveErkenning()) {
            apply(OnderzoekIsNietInBehandelingGenomen.builder()
                    .onderzoekId(onderzoekId)
                    .foutreden(ORGANISATIE_HEEFT_GEEN_ACTIEVE_ERKENNING_VOOR_ERKENNINGSDOEL)
                    .build());
            return;
        }

        command.getActiefErkenning()
                .ifPresent(actiefErkenning ->
                        apply(OrganisatieHeeftActieveErkenningMetErkenningsdoel.builder()
                                .onderzoekId(onderzoekId)
                                .organisatieId(organisatieId)
                                .erkenning(actiefErkenning)
                                .build()
                        )
                );
    }

    @CommandHandler
    public void controleerOfOrganisatieVoorErkenningsdoelInOnderzoekIs(ControleerOfOrganisatieVoorErkenningsdoelInOnderzoekIs command) {

        if (onderzoekStatus.isNietInitieel()) {
            log.warn(ONDERZOEK_MET_ID_S_EN_STATUS_S_IS_NIET_IN_INITIEEL_DUS_NEGEER_CONTROLE_COMMAND
                    .formatted(onderzoekId, onderzoekStatus));
            return;
        }

        if (command.isOrganisatieMetErkenningsdoelIsInOnderzoek()) {
            apply(OnderzoekIsNietInBehandelingGenomen.builder()
                    .onderzoekId(onderzoekId)
                    .foutreden(ORGANISATIE_MET_ERKENNING_VOOR_ERKENNINGSDOEL_IS_AL_IN_ONDERZOEK)
                    .build());
            return;
        }

        apply(OrganisatieIsNietInOnderzoekVoorErkenningsdoel.builder()
                .onderzoekId(onderzoekId)
                .organisatieId(organisatieId)
                .build());
    }

    @CommandHandler
    public void openOnderzoek(OpenOnderzoek command) {
        apply(OnderzoekGeopend.builder()
                .onderzoekId(onderzoekId)
                .organisatieId(organisatieId)
                .naamErkendeReferent(command.getNaamErkendeReferent())
                .erkenningInOnderzoek(this.erkenning)
                .build());
    }

    @CommandHandler
    public void neemOnderzoekInBehandeling(NeemOnderzoekInBehandeling command) {
        if (onderzoekStatus.kanOnderzoekInBehandelingWordenGenomen()) {
            apply(OnderzoekInBehandelingGenomen.builder()
                    .onderzoekId(onderzoekId)
                    .build());
        }
    }

    // Todo aanroep commando is er nog niet, maar dan kan juiste afhandeling wel gemaakt kan worden.
    @CommandHandler
    public void rondOnderzoekAf(RondOnderzoekAf command) {
        if (onderzoekStatus.isInOnderzoek()) {
            apply(OnderzoekIsAfgerond.builder()
                    .onderzoekId(this.onderzoekId)
                    .build());
        }
    }

    @CommandHandler
    public void bewaarErkenningenVoorOrganisatie(BewaarErkenningenVoorOrganisatie command) {
        apply(ErkenningenVoorOrganisatieBewaard.builder()
                .onderzoekId(onderzoekId)
                .erkenningen(command.getErkenningen())
                .build());
    }

    @CommandHandler
    public void voegMedewerkerToeAanOnderzoek(VoegMedewerkerToeAanOnderzoek command) {
        if (onderzoekStatus.isInOnderzoek()) {
            apply(MedewerkerAanOnderzoekToegevoegd.builder()
                    .onderzoekId(onderzoekId)
                    .medewerkerId(command.getMedewerkerId())
                    .build()
            );
        }
    }

    @CommandHandler
    public void registreerOrganisatieGegevens(RegistreerOrganisatieGegevens command) {
        if (onderzoekStatus.isInOnderzoek()) {
            apply(OrganisatieGegevensGeregistreerd.builder()
                    .onderzoekId(onderzoekId)
                    .organisatieId(command.getOrganisatieId())
                    .kvkNummer(command.getKvkNummer())
                    .naamErkendeReferent(command.getNaamErkendeReferent())
                    .vestigingsadres(command.getVestigingsadres())
                    .build());
        }
    }

    @CommandHandler
    public void registreerPersoonGegevens(RegistreerPersoonGegevens command) {
        if (onderzoekStatus.isInOnderzoek()) {
            apply(PersoonGegevensGeregistreerd.builder()
                    .onderzoekId(onderzoekId)
                    .referentschapId(command.getReferentschapId())
                    .persoonId(command.getPersoonId())
                    .geslachtsnaam(command.getGeslachtsnaam())
                    .voornamen(command.getVoornamen())
                    .voorvoegsel(command.getVoorvoegsel())
                    .build());
        }
    }

    @CommandHandler
    public void werkPersoonGegevensBij(WerkPersoonGegevensBij command) {
        if (onderzoekStatus.isInOnderzoek()) {
            apply(PersoonGegevensGeregistreerd.builder()
                    .onderzoekId(command.getOnderzoekId())
                    .referentschapId(command.getReferentschapId())
                    .persoonId(command.getPersoonId())
                    .geslachtsnaam(command.getGeslachtsnaam())
                    .voornamen(command.getVoornamen())
                    .voorvoegsel(command.getVoorvoegsel())
                    .build());
        }
    }

    @CommandHandler
    public void werkOrganisatieGegevensBij(WerkOrganisatieGegevensBij command) {
        if (onderzoekStatus.isNietAfgesloten()) {
            apply(OrganisatieGegevensBijgewerkt.builder()
                    .onderzoekId(onderzoekId)
                    .organisatieId(command.getOrganisatieId())
                    .kvkNummer(command.getKvkNummer())
                    .naamErkendeReferent(command.getNaamErkendeReferent())
                    .vestigingsadres(command.getVestigingsadres())
                    .build());
        }
    }

    @CommandHandler
    public void verleenOrganisatieErkenning(VerleenOrganisatieErkenning command) {
        if (onderzoekStatus.isInOnderzoek()) {
            apply(OrganisatieErkenningVerleend.builder()
                    .onderzoekId(onderzoekId)
                    .erkenning(Erkenning.builder()
                            .erkenningId(command.getErkenningId())
                            .erkenningsdoel(command.getErkenningsdoel())
                            .status(ACTIEF)
                            .build())
                    .organisatieId(command.getOrganisatieId())
                    .ingangsdatum(command.getIngangsdatum())
                    .build()
            );
        }
    }

    @CommandHandler
    public void trekOnderzoekErkenningIn(TrekOnderzoekErkenningIn command) {
        if (onderzoekStatus.isInOnderzoek()) {
            apply(OnderzoekErkenningIngetrokken.builder()
                    .onderzoekId(onderzoekId)
                    .erkenningId(command.getErkenningId())
                    .einddatum(command.getEinddatum())
                    .build()
            );
        }
    }

    @CommandHandler
    public void herleefOnderzoekErkenning(HerleefOnderzoekErkenning command) {
        if (onderzoekStatus.isInOnderzoek()) {
            apply(OnderzoekErkenningHerleefd.builder()
                    .onderzoekId(onderzoekId)
                    .organisatieId(organisatieId)
                    .erkenning(Erkenning.builder()
                            .erkenningId(command.getErkenningId())
                            .erkenningsdoel(command.getErkenningsdoel())
                            .status(ACTIEF)
                            .build()
                    )
                    .build()
            );
        }
    }

    @CommandHandler
    public void wijzigOrganisatieErkenningsdoel(WijzigOrganisatieErkenningsdoel command) {
        if (onderzoekStatus.isInOnderzoek()) {
            apply(OrganisatieErkenningsdoelGewijzigd.builder()
                    .onderzoekId(onderzoekId)
                    .organisatieId(command.getOrganisatieId())
                    .erkenningId(command.getErkenningId())
                    .erkenningsdoel(command.getErkenningsdoel())
                    .build()
            );
        }
    }

    @EventSourcingHandler
    public void onderzoekGeopend(OnderzoekGeopend event) {
        this.onderzoekStatus = OPEN;
    }

    @EventSourcingHandler
    public void onderzoekInBehandelingGenomen(OnderzoekInBehandelingGenomen event) {
        this.onderzoekStatus = IN_BEHANDELING;
    }

    @EventSourcingHandler
    public void onderzoekIsAfgerond(OnderzoekIsAfgerond event) {
        this.onderzoekStatus = AFGEROND;
    }

    @EventSourcingHandler
    public void organisatieVoorKvkNummerBestaat(OrganisatieVoorKvkNummerBestaat event) {
        this.organisatieId = event.getOrganisatieId();
    }

    @EventSourcingHandler
    public void organisatieHeeftActieveErkenningMetErkenningsdoel(OrganisatieHeeftActieveErkenningMetErkenningsdoel event) {
        this.erkenning = event.getErkenning();
    }

    @EventSourcingHandler
    public void onderzoekIsNietInBehandelingGenomen(OnderzoekIsNietInBehandelingGenomen event) {
        markDeleted();
    }

}
