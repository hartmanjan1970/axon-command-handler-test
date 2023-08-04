package nl.ind.onderzoek.domain.command.onderzoek.aggregate;

import lombok.NoArgsConstructor;
import nl.ind.onderzoek.domain.command.onderzoek.command.referentschap.BewaarActieveReferentschappenVoorOrganisatie;
import nl.ind.onderzoek.domain.command.onderzoek.command.referentschap.VerwerkReferentschapOntstaan;
import nl.ind.onderzoek.domain.command.onderzoek.command.referentschap.WerkGegevensEnBescheidenOpvragenBij;
import nl.ind.onderzoek.domain.command.onderzoek.event.inkomen.GegevensEnBescheidenOpvragenBijgewerkt;
import nl.ind.onderzoek.domain.command.onderzoek.event.referentschap.ActieveReferentschappenVoorOrganisatieBewaard;
import nl.ind.onderzoek.domain.command.onderzoek.event.referentschap.ReferentschapOntstaanVerwerkt;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateMember;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static lombok.AccessLevel.PACKAGE;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@NoArgsConstructor(access = PACKAGE)
public abstract class OnderzoekReferentschap extends OnderzoekBasis {

    @AggregateMember
    private final Map<UUID, Referentschap> referentschappen = new HashMap<>();

    @CommandHandler
    public void bewaarActieveReferentschappenVoorOrganisatie(BewaarActieveReferentschappenVoorOrganisatie command) {
        if (command.getReferentschappen() == null) {
            return;
        }

        if (onderzoekStatus.isInOnderzoek()) {
            apply(ActieveReferentschappenVoorOrganisatieBewaard.builder()
                    .onderzoekId(command.getOnderzoekId())
                    .referentschappen(command.getReferentschappen())
                    .build());
        }
    }

    @CommandHandler
    public void verwerkReferentschapOntstaan(VerwerkReferentschapOntstaan command) {
        if (this.getOnderzoekStatus().isInOnderzoek()) {
            apply(ReferentschapOntstaanVerwerkt.builder()
                    .onderzoekId(command.getOnderzoekId())
                    .referentschapId(command.getReferentschapId())
                    .persoonId(command.getPersoonId())
                    .organisatieId(command.getOrganisatieId())
                    .erkenningId(command.getErkenningId())
                    .startdatum(command.getStartdatum())
                    .grondslag(command.getGrondslag())
                    .beperking(command.getBeperking())
                    .referentschapStatus(command.getReferentschapStatus())
                    .build());
        }
    }

    // Fixme, als het command `WerkGegevensEnBescheidenOpvragenBij` in Referentschap staat wordt de CommandHandler niet gevonden.
    @CommandHandler
    public void werkGegevensEnBescheidenOpvragenBij(WerkGegevensEnBescheidenOpvragenBij command) {
        if (command.getOnderzoekStatus().isInOnderzoek())
            apply(GegevensEnBescheidenOpvragenBijgewerkt.builder()
                    .onderzoekId(command.getOnderzoekId())
                    .referentschapId(command.getReferentschapId())
                    .gegevensEnBescheidenOpvragen(command.isGegevensEnBescheidenOpvragen())
                    .build());
    }

    @EventSourcingHandler
    public void referentschappenVoorOrganisatieBewaard(ActieveReferentschappenVoorOrganisatieBewaard event) {
        event.getReferentschappen()
                .forEach(referentschap ->
                        referentschappen.put(
                                referentschap.getReferentschapId(),
                                Referentschap.builder()
                                        .referentschapId(referentschap.getReferentschapId())
                                        .persoonId(referentschap.getPersoonId())
                                        .beperking(referentschap.getBeperking())
                                        .build()
                        )
                );
    }

    @EventSourcingHandler
    public void referentschapOntstaanVerwerkt(ReferentschapOntstaanVerwerkt event) {
        UUID referentschapId = event.getReferentschapId();
        Referentschap referentschap = Referentschap.builder()
                .referentschapId(referentschapId)
                .persoonId(event.getPersoonId())
                .beperking(event.getBeperking())
                .build();

        referentschappen.put(referentschapId, referentschap);
    }

}
