package me.hoon.catalogservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CatalogResponseDto {
    private String productId;
    private String productName;
    private Integer stock;
    private Integer unitPrice;
    private Date createdAt;
}
