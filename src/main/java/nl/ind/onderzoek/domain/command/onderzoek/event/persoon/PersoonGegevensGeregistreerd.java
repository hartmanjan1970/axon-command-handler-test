package nl.ind.onderzoek.domain.command.onderzoek.event.persoon;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import nl.ind.onderzoek.domain.command.onderzoek.event.AbstractOnderzoekEvent;

import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

@SuperBuilder
@Getter
@Jacksonized
public class PersoonGegevensGeregistreerd extends AbstractOnderzoekEvent {

    private UUID onderzoekId;
    private UUID referentschapId;
    private UUID persoonId;
    private String geslachtsnaam;
    private String voornamen;
    private String voorvoegsel;

    public String getNaamPersoon() {
        return Stream.of(voornamen, voorvoegsel, geslachtsnaam)
                .filter(Objects::nonNull)
                .filter(not(String::isBlank))
                .collect(Collectors.joining(" "));
    }
}
