package com.syst.trades.dto.get;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.syst.trades.helper.DateDeserializer;
import com.syst.trades.helper.DateSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {

	private Long id;

	private TradeResponse trade;

	private String name;

	private String description;

	private Double price;

	private Boolean controlQuantity;

	private Integer quantity;

	private Integer quantityReserved;

	private Double lastPrice;

	private Boolean active;

	private String productImage;

	private String creationUser;

	private String updateUser;

	@JsonDeserialize(using = DateDeserializer.class)
	@JsonSerialize(using = DateSerializer.class)
	private Date creationDate;

	@JsonDeserialize(using = DateDeserializer.class)
	@JsonSerialize(using = DateSerializer.class)
	private Date updateDate;

	private List<ProductSaleResponse> productSales;

}