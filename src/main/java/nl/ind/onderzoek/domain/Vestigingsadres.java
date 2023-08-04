package nl.ind.onderzoek.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Vestigingsadres {

    private String land;
    private String toevoegingAdres;
    private boolean buitenlandsAdresIndicator;
    private boolean afgeschermdIndicator;
    private LocalDate geldigVanafDatum;
    private BuitenlandsAdres buitenlandsAdres;
    private NederlandsAdres nederlandsAdres;

    @Embeddable
    @Getter
    @Setter
    @SuperBuilder
    @NoArgsConstructor
    public static class BuitenlandsAdres {
        private String buitenlandsAdresRegel1;
        private String buitenlandsAdresRegel2;
        private String buitenlandsAdresRegel3;
        private String buitenlandsAdresRegel4;
        private String buitenlandsAdresRegel5;
        private String buitenlandsAdresRegel6;
    }

    @Embeddable
    @Getter
    @Setter
    @SuperBuilder
    @NoArgsConstructor
    public static class NederlandsAdres {
        private String straatnaam;
        private String straatnaamVerkort;
        private String huisnummer;
        private String huisletter;
        private String huisnummerToevoeging;
        private String aanduidingBijHuisnummer;
        private String antwoordnummer;
        private String postbusNummer;
        private String postcode;
        private String plaats;
        private String locatie;
    }

}
