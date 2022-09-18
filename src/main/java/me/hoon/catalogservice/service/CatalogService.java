package me.hoon.catalogservice.service;

import me.hoon.catalogservice.domain.dto.CatalogResponseDto;

import java.util.List;

public interface CatalogService {
    List<CatalogResponseDto> getAllCatalogs();
}
