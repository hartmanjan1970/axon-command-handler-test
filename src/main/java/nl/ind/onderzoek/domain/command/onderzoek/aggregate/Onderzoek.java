package nl.ind.onderzoek.domain.command.onderzoek.aggregate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.ind.onderzoek.domain.command.onderzoek.Erkenning;
import nl.ind.onderzoek.domain.command.onderzoek.command.InitieerOnderzoek;
import nl.ind.onderzoek.domain.command.onderzoek.event.OnderzoekGeinitieerd;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import static nl.ind.onderzoek.domain.OnderzoekStatus.INITIEEL;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Getter
@NoArgsConstructor
@Slf4j
@Aggregate
public class Onderzoek extends OnderzoekAandachtspunt {

    @CommandHandler
    public Onderzoek(InitieerOnderzoek command) {
        apply(OnderzoekGeinitieerd.builder()
                .onderzoekId(command.getOnderzoekId())
                .kvkNummer(command.getKvkNummer())
                .erkenningsdoel(command.getErkenningsdoel())
                .reden(command.getReden())
                .build());
    }

    @EventSourcingHandler
    public void onderzoekGeinitieerd(OnderzoekGeinitieerd event) {
        this.onderzoekId = event.getOnderzoekId();
        this.erkenning = Erkenning.builder()
                .erkenningsdoel(event.getErkenningsdoel())
                .build();
        this.onderzoekStatus = INITIEEL;
    }
}
