package nl.ind.onderzoek.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Enumerated;
import java.util.UUID;

import static javax.persistence.EnumType.STRING;
import static lombok.AccessLevel.PROTECTED;

@AllArgsConstructor
@Embeddable
@EqualsAndHashCode
@Getter
@NoArgsConstructor(access = PROTECTED)
@SuperBuilder
public class Onderwerp {

    @Column(columnDefinition = "uuid")
    private UUID id;
    @Enumerated(STRING)
    private OnderwerpType type;

    public enum OnderwerpType {
        ONDERZOEK_INKOMEN_KENNISMIGRANT,
        ORGANISATIE,
        INKOMEN,
        PERSOON
    }
}
