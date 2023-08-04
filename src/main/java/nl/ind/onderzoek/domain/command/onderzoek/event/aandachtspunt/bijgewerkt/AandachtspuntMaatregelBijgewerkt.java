package nl.ind.onderzoek.domain.command.onderzoek.event.aandachtspunt.bijgewerkt;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import nl.ind.onderzoek.domain.command.onderzoek.aggregate.AandachtspuntMaatregel;

@EqualsAndHashCode(callSuper = true)
@Getter
@Jacksonized
@SuperBuilder
@ToString
public class AandachtspuntMaatregelBijgewerkt extends AbstractAandachtspuntBijgewerkt {

    private AandachtspuntMaatregel aandachtspunt;

}
