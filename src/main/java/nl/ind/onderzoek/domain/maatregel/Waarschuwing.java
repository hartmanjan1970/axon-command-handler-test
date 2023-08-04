package nl.ind.onderzoek.domain.maatregel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
import java.util.UUID;

@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
@Jacksonized
public class Waarschuwing extends Maatregel {

    private UUID waarschuwingId;
    private String documentBriefId;
    private LocalDate verloopdatum;

}
