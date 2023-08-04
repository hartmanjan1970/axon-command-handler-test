package nl.ind.onderzoek.domain.command.onderzoek;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.time.LocalDate;

@EqualsAndHashCode
@Getter
@Jacksonized
@SuperBuilder
@ToString
public class Inkomen {
    private LocalDate inkomstenopgaveAanvangDatum;
    private LocalDate inkomstenopgaveEindDatum;
    private BigDecimal socialeVerzekeringsloonBedrag;
    private int verloondeUrenAantal;
    private BigDecimal vakantietoeslagBedrag;
    private BigDecimal vakantietoeslagOpgebouwdBedrag;
    private BigDecimal arbeidsvoorwaardenBedrag;
    private BigDecimal arbeidsvoorwaardenOpgebouwdBedrag;
}