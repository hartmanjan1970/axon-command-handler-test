package nl.ind.onderzoek.domain.command.abonnement.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Getter
@NoArgsConstructor
@SuperBuilder
public class OpzeggenAbonnement {

    @TargetAggregateIdentifier
    private UUID abonnementId;

}
