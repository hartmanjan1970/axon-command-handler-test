package nl.ind.onderzoek.domain.maatregel;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@SuperBuilder
@Getter
@EqualsAndHashCode
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "_type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BestuurlijkeBoete.class, name = "BestuurlijkeBoete"),
        @JsonSubTypes.Type(value = Waarschuwing.class, name = "Waarschuwing")
})
public abstract class Maatregel {

    private UUID erkenningId;
    private String erkenningsdoel;
    private UUID erkendeReferentId;
    private LocalDate opleggingsdatum;
    private UUID vastgesteldePlichtId;
    private PlichtErkenningCategorie plichtCategorie;

    public enum PlichtErkenningCategorie {
        ZORGPLICHT,
        ADMINISTRATIEPLICHT,
        INFORMATIEPLICHT
    }

}
