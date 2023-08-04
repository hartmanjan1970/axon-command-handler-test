package nl.ind.onderzoek.domain.command.onderzoek.command.organisatie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.Vestigingsadres;
import nl.ind.onderzoek.domain.command.onderzoek.command.AbstractOnderzoekCommand;

import java.util.UUID;

@Getter
@NoArgsConstructor
@SuperBuilder
@ToString
public class RegistreerOrganisatieGegevens extends AbstractOnderzoekCommand {

    private UUID organisatieId;
    private String kvkNummer;
    private String naamErkendeReferent;
    private Vestigingsadres vestigingsadres;

}
