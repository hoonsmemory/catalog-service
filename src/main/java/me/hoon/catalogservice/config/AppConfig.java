package me.hoon.catalogservice.config;

import me.hoon.catalogservice.domain.Catalog;
import me.hoon.catalogservice.repository.CatalogRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class AppConfig {

    @Bean
    ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    @Bean
    ApplicationRunner applicationRunner() {
        return new ApplicationRunner() {

            @Autowired
            CatalogRepository catalogRepository;

            @Override
            public void run(ApplicationArguments args) throws Exception {
                Catalog catalog1 = Catalog.builder()
                        .productId("CATALOG-001")
                        .productName("Berlin")
                        .stock(100)
                        .unitPrice(1500)
                        .build();

                Catalog catalog2 = Catalog.builder()
                        .productId("CATALOG-002")
                        .productName("Tokyo")
                        .stock(110)
                        .unitPrice(1000)
                        .build();

                Catalog catalog3 = Catalog.builder()
                        .productId("CATALOG-003")
                        .productName("Stockholm")
                        .stock(120)
                        .unitPrice(2000)
                        .build();

                catalogRepository.save(catalog1);
                catalogRepository.save(catalog2);
                catalogRepository.save(catalog3);
            }
        };
    }
}
