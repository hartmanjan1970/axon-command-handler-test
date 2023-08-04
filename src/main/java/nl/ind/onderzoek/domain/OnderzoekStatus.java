package nl.ind.onderzoek.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OnderzoekStatus {
    INITIEEL(false, false),
    OPEN(true, false),
    IN_BEHANDELING(true, false),
    AFGEROND(false, true),
    NIET_IN_ONDERZOEK_GENOMEN(false, true);

    private final boolean isInOnderzoek;
    private final boolean isAfgesloten;

    public boolean isInOnderzoek() {
        return this.isInOnderzoek;
    }

    public boolean isNietInOnderzoek() {
        return !this.isInOnderzoek;
    }

    public boolean kanOnderzoekInBehandelingWordenGenomen() {
        return OPEN.equals(this);
    }

    public boolean isNietInitieel() {
        return !this.equals(INITIEEL);
    }

    public boolean isNietAfgesloten() {
        return !this.isAfgesloten;
    }
}