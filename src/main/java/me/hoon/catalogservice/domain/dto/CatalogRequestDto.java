package me.hoon.catalogservice.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CatalogRequestDto {

    @NotNull(message = "Product name can not be null")
    private String productName;

    @NotNull(message = "Quantity name can not be null")
    private Integer quantity;

    @NotNull(message = "UnitPrice name can not be null")
    private Integer unitPrice;

    @NotNull(message = "TotalPrice name can not be null")
    private Integer totalPrice;
}
