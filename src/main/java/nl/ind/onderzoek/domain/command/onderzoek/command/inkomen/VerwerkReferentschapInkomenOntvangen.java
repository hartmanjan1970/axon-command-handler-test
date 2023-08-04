package nl.ind.onderzoek.domain.command.onderzoek.command.inkomen;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import nl.ind.onderzoek.domain.command.onderzoek.Inkomen;
import nl.ind.onderzoek.domain.command.onderzoek.command.AbstractOnderzoekCommand;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Jacksonized
@SuperBuilder
@ToString
public class VerwerkReferentschapInkomenOntvangen extends AbstractOnderzoekCommand {

    private UUID referentschapId;
    private UUID persoonId;

    private LocalDateTime uwvGegevensOntvangstdatum;
    private LocalDate inkomstenverhoudingAanvangDatum;
    private LocalDate inkomstenverhoudingEindDatum;
    private String aardArbeidsverhoudingCode;
    private String inkomstenverhoudingIncidenteleCode;
    private String inkomstenverhoudingSoortCode;
    private boolean arbeidsovereenkomstOnbepaaldeTijdIndicator;
    private List<Inkomen> inkomens;

}
