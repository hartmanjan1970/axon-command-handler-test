package nl.ind.onderzoek.utils.onderzoek;

import lombok.experimental.UtilityClass;
import nl.ind.onderzoek.domain.command.onderzoek.Erkenning;
import nl.ind.onderzoek.domain.command.onderzoek.command.controleorganisatievooronderzoek.ControleerOfOrganisatieActieveErkenningVoorErkenningsdoelHeeft;
import nl.ind.onderzoek.domain.command.onderzoek.command.controleorganisatievooronderzoek.ControleerOfOrganisatieErkenningVoorErkenningsdoelHeeft;
import nl.ind.onderzoek.domain.command.onderzoek.command.controleorganisatievooronderzoek.ControleerOfOrganisatieVoorErkenningsdoelInOnderzoekIs;
import nl.ind.onderzoek.domain.command.onderzoek.command.controleorganisatievooronderzoek.ControleerOfOrganisatieVoorKvkNummerBestaat;

import java.util.List;

import static nl.ind.onderzoek.utils.TestConstanten.ONDERZOEK_ID;
import static nl.ind.onderzoek.utils.TestConstanten.ORGANISATIE_ID;

@UtilityClass
public class OnderzoekControlCommandUtils {
    public static ControleerOfOrganisatieVoorKvkNummerBestaat controleerOfOrganisatieVoorKvkNummerBestaat_organisatieIdBestaat() {
        return ControleerOfOrganisatieVoorKvkNummerBestaat.builder()
                .onderzoekId(ONDERZOEK_ID)
                .organisatieId(ORGANISATIE_ID)
                .build();
    }

    public static ControleerOfOrganisatieVoorKvkNummerBestaat controleerOfOrganisatieVoorKvkNummerBestaat_organisatieIdBestaatNiet() {
        return ControleerOfOrganisatieVoorKvkNummerBestaat.builder()
                .onderzoekId(ONDERZOEK_ID)
                .build();
    }

    public static ControleerOfOrganisatieErkenningVoorErkenningsdoelHeeft controleerOfOrganisatieErkenningVoorErkenningsdoelHeeft(
            List<Erkenning> erkenningen) {
        return ControleerOfOrganisatieErkenningVoorErkenningsdoelHeeft.builder()
                .onderzoekId(ONDERZOEK_ID)
                .erkenningenVanOrganisatie(erkenningen)
                .build();
    }

    public static ControleerOfOrganisatieActieveErkenningVoorErkenningsdoelHeeft controleerOfOrganisatieActieveErkenningVoorErkenningsdoelHeeft(
            List<Erkenning> erkenningen) {
        return ControleerOfOrganisatieActieveErkenningVoorErkenningsdoelHeeft.builder()
                .onderzoekId(ONDERZOEK_ID)
                .erkenningen(erkenningen)
                .build();
    }

    public static ControleerOfOrganisatieVoorErkenningsdoelInOnderzoekIs controleerOfOrganisatieVoorErkenningsdoelInOnderzoekIs(
            boolean organisatieMetErkenningsdoelIsInOnderzoek) {
        return ControleerOfOrganisatieVoorErkenningsdoelInOnderzoekIs.builder()
                .onderzoekId(ONDERZOEK_ID)
                .organisatieMetErkenningsdoelIsInOnderzoek(organisatieMetErkenningsdoelIsInOnderzoek)
                .build();
    }
}
