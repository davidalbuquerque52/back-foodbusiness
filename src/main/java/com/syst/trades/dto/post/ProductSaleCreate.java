package com.syst.trades.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductSaleCreate {

	private ClientCreate client;

	private SaleCreate sale;

	private ProductCreate product;

	private Integer quantitySold;

	private Double priceUnitSold;

	private Double saleTotal;

	private StatusCreate status;

}