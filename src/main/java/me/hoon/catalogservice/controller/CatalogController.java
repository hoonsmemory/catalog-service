package me.hoon.catalogservice.controller;

import lombok.RequiredArgsConstructor;
import me.hoon.catalogservice.domain.dto.CatalogResponseDto;
import me.hoon.catalogservice.service.CatalogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/catalog-service")
@RestController
public class CatalogController {

    private final CatalogService catalogService;

    @GetMapping("/catalogs")
    public ResponseEntity getCatalogs() {

        List<CatalogResponseDto> catalogResponseDtoList = catalogService.getAllCatalogs();

        if(catalogResponseDtoList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Catalog is empty");
        }

        return ResponseEntity.status(HttpStatus.OK).body(catalogResponseDtoList);
    }


}
