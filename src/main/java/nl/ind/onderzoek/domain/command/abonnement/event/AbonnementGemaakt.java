package nl.ind.onderzoek.domain.command.abonnement.event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.Onderwerp;

import java.util.UUID;

@Getter
@NoArgsConstructor
@SuperBuilder
public class AbonnementGemaakt {

    private UUID abonnementId;
    private UUID externAbonnementId;
    private Onderwerp onderwerp;
    private Onderwerp externOnderwerp;

}
