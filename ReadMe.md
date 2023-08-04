# Axon CommandHandlers in AggregateMember Not found

I have an aggregate with multiple AggregateMembers. No is the problem that the for 1 aggregateMember (Referentschap) the
CommandHandlers in this aggregate member are not found. This problem also occurs with junit testing using the
AggregateTestFixture<>(Onderzoek.class).

In one AggregateMember Waarschuwing the CommandHandlers are reached as it should, but in the other aggregateMember
Referentschap the CommandHandlers are not found. My question is how can i work around this problem? Is there a way that
i can make a configuration to fix this?

Curious issue is that in a copy of the project for some debugging, the same issue arises but then the problem is swapped
to Waarschuwing and is Referentschap ok. This curious swap of problems gives me the impression that there is an issue in
how the CommandHandlers are collected.

update: On a hint of AxonIQ is placed only the @Aggregate annotation on the root aggregate. Cleared chaches and all from
my Intellij IDE and rerun the junit test. Now the not found CommandHandler issue rises on both the AggregateMembers
Referentschap and Waarschuwing.

I have made some integration test with an Axon testcontainer and they al succeed. As it seems is it a JUnit test
problem, where the order of extending of aggregate classes is relevant for which CommandHandler is found.

Axon 4.5.17
Spring boot 2.7.12
Java temurin 17.0.6