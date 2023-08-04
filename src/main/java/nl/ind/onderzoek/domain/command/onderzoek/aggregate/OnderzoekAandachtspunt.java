package nl.ind.onderzoek.domain.command.onderzoek.aggregate;

import lombok.NoArgsConstructor;
import nl.ind.onderzoek.domain.VerplichtingCategorie;
import nl.ind.onderzoek.domain.VoorwaardeCategorie;
import nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.maakaan.MaakNieuwAandachtspunt;
import nl.ind.onderzoek.domain.command.onderzoek.command.aandachtspunt.verwijder.VerwijderAandachtspunt;
import nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.AbstractAandachtspuntEvent;
import nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.aangemaakt.*;
import nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.verwijderd.AandachtspuntVerwijderd;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateMember;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static lombok.AccessLevel.PACKAGE;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@NoArgsConstructor(access = PACKAGE)
abstract class OnderzoekAandachtspunt extends OnderzoekMaatregel {

    @AggregateMember
    private final Map<UUID, Aandachtspunt> aandachtspunten = new HashMap<>();

    @CommandHandler
    public void maakNieuwAandachtspunt(MaakNieuwAandachtspunt command) {
        if (onderzoekStatus.isNietInOnderzoek()) {
            return;
        }

        UUID aandachtspuntId = command.getAandachtspuntId();
        UUID onderzoekId = command.getOnderzoekId();
        String beschrijving = command.getBeschrijving();

        AbstractAandachtspuntEvent aandachtspuntGemaaktEvent = switch (command.getOnderzoekOnderdeel()) {
            case ALGEMEEN_BEELD -> AandachtspuntAlgemeenBeeldAangemaakt.builder()
                    .onderzoekId(onderzoekId)
                    .aandachtspuntId(aandachtspuntId)
                    .aandachtspunt(
                            AandachtspuntAlgemeenBeeld.builder()
                                    .aandachtspuntId(aandachtspuntId)
                                    .onderzoekId(onderzoekId)
                                    .beschrijving(beschrijving)
                                    .categorie(VoorwaardeCategorie.valueOf(command.getCategorie()))
                                    .build()
                    )
                    .build();
            case KENNISMIGRANTEN -> AandachtspuntKennismigrantenAangemaakt.builder()
                    .onderzoekId(onderzoekId)
                    .aandachtspuntId(aandachtspuntId)
                    .aandachtspunt(
                            AandachtspuntKennismigranten.builder()
                                    .aandachtspuntId(aandachtspuntId)
                                    .onderzoekId(onderzoekId)
                                    .beschrijving(beschrijving)
                                    .categorie(VerplichtingCategorie.valueOf(command.getCategorie()))
                                    .build()
                    )
                    .build();
            case INKOMEN_KENNISMIGRANT -> AandachtspuntInkomenKennismigrantAangemaakt.builder()
                    .onderzoekId(onderzoekId)
                    .aandachtspuntId(aandachtspuntId)
                    .aandachtspunt(
                            AandachtspuntInkomenKennismigrant.builder()
                                    .aandachtspuntId(aandachtspuntId)
                                    .onderzoekId(onderzoekId)
                                    .beschrijving(beschrijving)
                                    .categorie(VerplichtingCategorie.valueOf(command.getCategorie()))
                                    .referentschapId(command.getReferentschapId())
                                    .build()
                    )
                    .build();
            case MAATREGELEN -> AandachtspuntMaatregelAangemaakt.builder()
                    .onderzoekId(onderzoekId)
                    .aandachtspuntId(aandachtspuntId)
                    .aandachtspunt(
                            AandachtspuntMaatregel.builder()
                                    .aandachtspuntId(aandachtspuntId)
                                    .onderzoekId(onderzoekId)
                                    .beschrijving(beschrijving)
                                    .categorie(VerplichtingCategorie.valueOf(command.getCategorie()))
                                    .maatregelId(command.getMaatregelId())
                                    .build()
                    )
                    .build();
        };

        apply(aandachtspuntGemaaktEvent);
    }

    @CommandHandler
    public void verwijderAandachtspunt(VerwijderAandachtspunt command) {
        if (onderzoekStatus.isNietInOnderzoek()) {
            return;
        }

        apply(AandachtspuntVerwijderd.builder()
                .aandachtspuntId(command.getAandachtspuntId())
                .build());
    }

    @EventSourcingHandler
    public void nieuwAandachtspuntAangemaakt(AbstractAandachtspuntAangemaakt event) {
        aandachtspunten.put(event.getAandachtspuntId(), event.getAandachtspunt());
    }

    @EventSourcingHandler
    public void aandachtspuntVerwijderd(AandachtspuntVerwijderd event) {
        aandachtspunten.remove(event.getAandachtspuntId());
    }
}
