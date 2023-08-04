package nl.ind.onderzoek.domain.command.onderzoek.event.inkomen;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import nl.ind.onderzoek.domain.command.onderzoek.Inkomen;
import nl.ind.onderzoek.domain.command.onderzoek.event.AbstractOnderzoekEvent;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Jacksonized
@SuperBuilder
@ToString
public class ReferentschapInkomenOntvangenVerwerkt extends AbstractOnderzoekEvent {

    private UUID referentschapId;
    private UUID persoonId;
    @Setter
    private BigDecimal gemiddeldSocialeVerzekeringsloonBedrag;
    private LocalDateTime uwvGegevensOntvangstdatum;
    private LocalDate inkomstenverhoudingAanvangDatum;
    private LocalDate inkomstenverhoudingEindDatum;

    private String aardArbeidsverhoudingCode;
    private String inkomstenverhoudingIncidenteleCode;
    private String inkomstenverhoudingSoortCode;
    private boolean arbeidsovereenkomstOnbepaaldeTijdIndicator;

    private List<Inkomen> inkomens;

}
