package com.syst.trades.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreate {

	private TradeCreate trade;

	private String name;

	private String description;

	private Double price;

	private Boolean controlQuantity;

	private Integer quantity;

	private Integer quantityReserved;

	private Double lastPrice;

	private Boolean active;
	
	private String productImage;
	
    private List<ProductSaleCreate> productSales;

}