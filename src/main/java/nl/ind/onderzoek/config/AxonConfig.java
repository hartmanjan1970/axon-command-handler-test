package nl.ind.onderzoek.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.json.JacksonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AxonConfig {

    @Bean
    @Primary
    public Serializer defaultSerializer() {
        ObjectMapper mapper = JacksonSerializer.defaultSerializer().getObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.activateDefaultTyping(
                mapper.getPolymorphicTypeValidator(),
                DefaultTyping.OBJECT_AND_NON_CONCRETE
        );

        return JacksonSerializer.builder()
                .objectMapper(mapper)
                .lenientDeserialization()
                .build();
    }

}
