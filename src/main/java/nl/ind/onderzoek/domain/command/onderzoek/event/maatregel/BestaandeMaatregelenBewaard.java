package nl.ind.onderzoek.domain.command.onderzoek.event.maatregel;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import nl.ind.onderzoek.domain.command.onderzoek.event.AbstractOnderzoekEvent;
import nl.ind.onderzoek.domain.maatregel.Maatregel;

import java.util.List;

@SuperBuilder
@Getter
@Jacksonized
public class BestaandeMaatregelenBewaard extends AbstractOnderzoekEvent {

    private List<Maatregel> maatregelen;

}
