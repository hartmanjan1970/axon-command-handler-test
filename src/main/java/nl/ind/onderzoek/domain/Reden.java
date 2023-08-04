package nl.ind.onderzoek.domain;

public enum Reden {
    STEEKPROEF,
    RISICO,
    SIGNAAL;

    public static boolean isGeldig(String reden) {
        try {
            Reden.valueOf(reden);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
