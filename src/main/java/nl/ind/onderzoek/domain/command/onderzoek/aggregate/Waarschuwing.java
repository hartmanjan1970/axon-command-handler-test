package nl.ind.onderzoek.domain.command.onderzoek.aggregate;

import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.command.onderzoek.command.maatregel.VerwerkWaarschuwingVerlopen;
import nl.ind.onderzoek.domain.command.onderzoek.command.maatregel.VerwerkWaarschuwingVerwijderd;
import nl.ind.onderzoek.domain.command.onderzoek.event.maatregel.MaatregelCommandToEventMapper;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.EntityId;

import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@EqualsAndHashCode
@SuperBuilder
public class Waarschuwing {

    @EntityId
    private final UUID waarschuwingId;

    @CommandHandler
    public void verwerkWaarschuwingVerlopen(VerwerkWaarschuwingVerlopen command, MaatregelCommandToEventMapper maatregelCommandToEventMapper) {
        apply(maatregelCommandToEventMapper.map(command));
    }

    @CommandHandler
    public void verwerkWaarschuwingVerwijderd(VerwerkWaarschuwingVerwijderd command, MaatregelCommandToEventMapper maatregelCommandToEventMapper) {
        apply(maatregelCommandToEventMapper.map(command));
    }
}
