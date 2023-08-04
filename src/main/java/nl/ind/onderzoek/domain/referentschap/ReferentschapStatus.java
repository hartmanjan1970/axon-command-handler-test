package nl.ind.onderzoek.domain.referentschap;

public enum ReferentschapStatus {
    VOORGENOMEN,
    ACTIEF,
    BEEINDIGD;

    public boolean isActief() {
        return this.equals(ACTIEF);
    }
}