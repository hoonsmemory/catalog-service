package me.hoon.catalogservice.messagequeue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hoon.catalogservice.domain.Catalog;
import me.hoon.catalogservice.exception.CatalogNotFoundException;
import me.hoon.catalogservice.repository.CatalogRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 리스너를 이용해 데이터를 가져와 DB 업데이트 로직 구현
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaConsumer {

    private final CatalogRepository catalogRepository;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "example-catalog-topic")
    public void updateQuantity(String kafkaMessage) {
        log.info("kafka Message ->", kafkaMessage);

        Map<Object, Object> map = new HashMap<>();

        try {
          //Spring to JSON
          map = objectMapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>() {});
        } catch (JsonProcessingException e) {
          log.error("error = {}", e);
        }

        Catalog findCatalog = catalogRepository.findByProductId((String) map.get("productId"))
                .orElseThrow(() -> new CatalogNotFoundException());

        findCatalog.changeStock((Integer) map.get("quantity"));
    }

}
