package nl.ind.onderzoek.domain.command.onderzoek.aggregate;

import lombok.NoArgsConstructor;
import nl.ind.onderzoek.domain.command.onderzoek.command.maatregel.BewaarBestaandeMaatregelen;
import nl.ind.onderzoek.domain.command.onderzoek.command.maatregel.VerwerkBestuurlijkeBoeteOpgelegd;
import nl.ind.onderzoek.domain.command.onderzoek.command.maatregel.VerwerkWaarschuwingOpgelegd;
import nl.ind.onderzoek.domain.command.onderzoek.event.maatregel.BestaandeMaatregelenBewaard;
import nl.ind.onderzoek.domain.command.onderzoek.event.maatregel.MaatregelCommandToEventMapper;
import nl.ind.onderzoek.domain.command.onderzoek.event.maatregel.WaarschuwingOpgelegdVerwerkt;
import nl.ind.onderzoek.domain.command.onderzoek.event.maatregel.WaarschuwingVerwijderdVerwerkt;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateMember;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static lombok.AccessLevel.PACKAGE;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@NoArgsConstructor(access = PACKAGE)
abstract class OnderzoekMaatregel extends OnderzoekReferentschap {

    @AggregateMember
    private final Map<UUID, Waarschuwing> waarschuwingen = new HashMap<>();

    @CommandHandler
    public void bewaarBestaandeMaatregelen(BewaarBestaandeMaatregelen command) {
        if (command.getMaatregelen() == null) {
            return;
        }

        apply(BestaandeMaatregelenBewaard.builder()
                .onderzoekId(command.getOnderzoekId())
                .maatregelen(command.getMaatregelen())
                .build()
        );
    }

    @CommandHandler
    public void verwerkBestuurlijkeBoeteOpgelegd(VerwerkBestuurlijkeBoeteOpgelegd command,
                                                 MaatregelCommandToEventMapper maatregelCommandToEventMapper) {
        apply(maatregelCommandToEventMapper.map(command));
    }

    @CommandHandler
    public void verwerkWaarschuwingOpgelegd(VerwerkWaarschuwingOpgelegd command, MaatregelCommandToEventMapper maatregelCommandToEventMapper) {
        apply(maatregelCommandToEventMapper.map(command));
    }

    @EventSourcingHandler
    public void waarschuwingOpgelegdVerwerkt(WaarschuwingOpgelegdVerwerkt event) {
        voegNieuweWaarschuwingToe(event.getWaarschuwingId());
    }

    private void voegNieuweWaarschuwingToe(UUID waarschuwingId) {
        waarschuwingen.put(waarschuwingId, Waarschuwing.builder()
                .waarschuwingId(waarschuwingId)
                .build()
        );
    }

    @EventSourcingHandler
    public void bestaandeMaatregelenBewaard(BestaandeMaatregelenBewaard event) {
        event.getMaatregelen().stream()
                .filter(nl.ind.onderzoek.domain.maatregel.Waarschuwing.class::isInstance)
                .map(nl.ind.onderzoek.domain.maatregel.Waarschuwing.class::cast)
                .map(nl.ind.onderzoek.domain.maatregel.Waarschuwing::getWaarschuwingId)
                .forEach(this::voegNieuweWaarschuwingToe);
    }

    @EventSourcingHandler
    public void waarschuwingVerwijderdVerwerkt(WaarschuwingVerwijderdVerwerkt event) {
        waarschuwingen.remove(event.getWaarschuwingId());
    }

}
