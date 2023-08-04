package nl.ind.onderzoek.domain.command.onderzoek.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString
public abstract class AbstractOnderzoekCommand {

    @TargetAggregateIdentifier
    private UUID onderzoekId;
}
