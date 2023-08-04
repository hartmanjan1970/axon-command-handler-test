package nl.ind.onderzoek.domain.command.abonnement.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.Onderwerp;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Getter
@SuperBuilder
@NoArgsConstructor
@ToString
public class MaakAbonnement {

    @TargetAggregateIdentifier
    private UUID abonnementId;
    private UUID externAbonnementId;
    private Onderwerp onderwerp;
    private Onderwerp externOnderwerp;

}
