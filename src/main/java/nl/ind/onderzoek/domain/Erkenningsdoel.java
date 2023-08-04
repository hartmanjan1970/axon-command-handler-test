package nl.ind.onderzoek.domain;

public enum Erkenningsdoel {
    ARBEID,
    ONDERZOEK_RICHTLIJN,
    STUDIE,
    STUDIE_HOGER_ONDERWIJS,
    STUDIE_MIDDELBAAR_BEROEPSONDERWIJS,
    STUDIE_VOORTGEZET_ONDERWIJS,
    UITWISSELING,
    UITWISSELING_AU_PAIR,
    UITWISSELING_PARTICULIERE_ORGANISATIE,
    UITWISSELING_EUROPEES_VRIJWILLIGERSWERK;

    public static boolean isGeldig(String erkenningsdoel) {
        try {
            Erkenningsdoel.valueOf(erkenningsdoel);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isArbeid() {
        return ARBEID.equals(this);
    }
}
