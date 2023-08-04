package nl.ind.onderzoek.domain.maatregel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.UUID;

@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
@Jacksonized
public class BestuurlijkeBoete extends Maatregel {

    private UUID bestuurlijkeBoeteId;
    private BigDecimal hoogte;
    private String documentBeschikkingId;

}
