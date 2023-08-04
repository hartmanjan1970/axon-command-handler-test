package nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.bijgewerkt;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.command.onderzoek.aggregate.Aandachtspunt;
import nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.AbstractAandachtspuntEvent;

@EqualsAndHashCode
@Getter
@SuperBuilder
@ToString
public abstract class AbstractAandachtspuntBijgewerkt extends AbstractAandachtspuntEvent {

    public abstract Aandachtspunt getAandachtspunt();

}
