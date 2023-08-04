package nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.aangemaakt;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import nl.ind.onderzoek.domain.command.onderzoek.aggregate.AandachtspuntMaatregel;

@EqualsAndHashCode
@Getter
@Jacksonized
@SuperBuilder
@ToString
public class AandachtspuntMaatregelAangemaakt extends AbstractAandachtspuntAangemaakt {

    private AandachtspuntMaatregel aandachtspunt;

}
