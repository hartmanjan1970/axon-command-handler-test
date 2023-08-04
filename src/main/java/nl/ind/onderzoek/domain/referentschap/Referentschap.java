package nl.ind.onderzoek.domain.referentschap;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode
@Getter
@Jacksonized
@SuperBuilder
@ToString
public class Referentschap {

    private UUID referentschapId;
    private UUID organisatieId;
    private UUID persoonId;
    private UUID erkenningId;

    private LocalDate startdatum;

    private String grondslag;
    private Beperking beperking;
    private ReferentschapStatus referentschapStatus;
}
