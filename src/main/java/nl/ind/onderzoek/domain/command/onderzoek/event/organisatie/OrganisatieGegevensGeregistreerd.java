package nl.ind.onderzoek.domain.command.onderzoek.event.organisatie;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import nl.ind.onderzoek.domain.Vestigingsadres;
import nl.ind.onderzoek.domain.command.onderzoek.event.AbstractOnderzoekEvent;

import java.util.UUID;

@SuperBuilder
@Getter
@Jacksonized
public class OrganisatieGegevensGeregistreerd extends AbstractOnderzoekEvent {

    private UUID organisatieId;
    private String kvkNummer;
    private String naamErkendeReferent;
    private Vestigingsadres vestigingsadres;

}
