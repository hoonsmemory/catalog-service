package me.hoon.catalogservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hoon.catalogservice.domain.Catalog;
import me.hoon.catalogservice.domain.dto.CatalogResponseDto;
import me.hoon.catalogservice.repository.CatalogRepository;
import me.hoon.catalogservice.service.CatalogService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CatalogResponseDto> getAllCatalogs() {

        List<CatalogResponseDto> catalogResponseDtoList = new ArrayList<>();

        catalogRepository.findAll()
                .forEach(x -> catalogResponseDtoList.add(modelMapper.map(x, CatalogResponseDto.class)));

        return catalogResponseDtoList;
    }
}
