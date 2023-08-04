package nl.ind.onderzoek.domain.command.onderzoek;

import lombok.*;
import lombok.experimental.SuperBuilder;
import nl.ind.onderzoek.domain.Erkenningsdoel;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Enumerated;
import java.util.UUID;

import static javax.persistence.EnumType.STRING;

@Embeddable
@Getter
@NoArgsConstructor
@Setter
@SuperBuilder
@ToString
@EqualsAndHashCode
public class Erkenning {

    @Column(columnDefinition = "uuid")
    private UUID erkenningId;
    @Enumerated(STRING)
    private Erkenningsdoel erkenningsdoel;
    @Enumerated(STRING)
    private Status status;

    public boolean isActief() {
        return Status.ACTIEF.equals(status);
    }

    public void setStatusBeeindigd() {
        setStatus(Status.BEEINDIGD);
    }

    public void setStatusActief() {
        setStatus(Status.ACTIEF);
    }

    public enum Status {
        ACTIEF,
        BEEINDIGD
    }
}
