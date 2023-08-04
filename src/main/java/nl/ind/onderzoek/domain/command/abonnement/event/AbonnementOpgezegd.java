package nl.ind.onderzoek.domain.command.abonnement.event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@NoArgsConstructor
@SuperBuilder
public class AbonnementOpgezegd {

    private UUID abonnementId;

}