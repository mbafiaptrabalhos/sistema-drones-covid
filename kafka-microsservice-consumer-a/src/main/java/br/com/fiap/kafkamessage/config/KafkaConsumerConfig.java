package br.com.fiap.kafkamessage.config;

import br.com.fiap.kafkamessage.model.DroneInfo;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value(value = "${kafka.broker}")
    private String kafkaBroker;

    @Value(value = "${kafka.consumer.group-id}")
    private String consumerGroupId;

    public ConsumerFactory<String, DroneInfo> droneInfoConsumerFactory() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBroker);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);

        JsonDeserializer<DroneInfo> deserializer = new JsonDeserializer<>(DroneInfo.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);

        return new DefaultKafkaConsumerFactory<>(properties, new StringDeserializer(), deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, DroneInfo> droneInfoKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, DroneInfo> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(droneInfoConsumerFactory());
        return factory;
    }
}
