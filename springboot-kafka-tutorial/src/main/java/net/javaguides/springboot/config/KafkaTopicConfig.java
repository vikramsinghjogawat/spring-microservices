package net.javaguides.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic javaguides(){
        return TopicBuilder.name("javaguides")
                .build();
    }

    public NewTopic javaguidesJson(){
        return TopicBuilder.name("javaguides_json")
                .build();
    }
}
