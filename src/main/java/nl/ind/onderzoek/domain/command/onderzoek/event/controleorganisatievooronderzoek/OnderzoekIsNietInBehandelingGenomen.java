package nl.ind.onderzoek.domain.command.onderzoek.event.controleorganisatievooronderzoek;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import nl.ind.onderzoek.domain.command.onderzoek.event.AbstractOnderzoekEvent;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Jacksonized
@SuperBuilder
@ToString
public class OnderzoekIsNietInBehandelingGenomen extends AbstractOnderzoekEvent {

    private Foutreden foutreden;

    public String getFoutreden() {
        return foutreden.omschrijving;
    }

    @AllArgsConstructor
    @Getter
    public enum Foutreden {
        KVK_NUMMER_NIET_BEKEND_BIJ_BEDRIJF_INSTELLING("Het KVK nummer is niet bekend de organisatie niet vast kunnen stellen."),
        ORGANISATIE_HEEFT_GEEN_ERKENNING_VOOR_ERKENNINGSDOEL("De organisatie heeft geen erkenning voor erkenningsdoel."),
        ORGANISATIE_HEEFT_GEEN_ACTIEVE_ERKENNING_VOOR_ERKENNINGSDOEL("De organisatie heeft geen actieve erkenning voor erkenningsdoel."),
        ORGANISATIE_MET_ERKENNING_VOOR_ERKENNINGSDOEL_IS_AL_IN_ONDERZOEK("De organisatie met erkenning voor erkenningsdoel is al in onderzoek.");

        private static final Map<String, Foutreden> formatMap = Stream
                .of(Foutreden.values())
                .collect(Collectors.toMap(reden -> reden.omschrijving, Function.identity()));

        private final String omschrijving;

        @JsonCreator
        public static Foutreden fromString(String omschrijving) {
            return Optional
                    .ofNullable(formatMap.get(omschrijving))
                    .orElseThrow(() -> new IllegalArgumentException(omschrijving));
        }
    }
}