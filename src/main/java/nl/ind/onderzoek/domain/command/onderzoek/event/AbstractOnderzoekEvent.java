package nl.ind.onderzoek.domain.command.onderzoek.event;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString
public abstract class AbstractOnderzoekEvent {

    private UUID onderzoekId;

}
