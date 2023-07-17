package com.syst.trades.dto.post;

import com.syst.trades.dto.enums.HisProductEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryProductQuantityCreate {

	private ProductCreate product;
	
	private Integer quantity;
	
	private TradeCreate trade;
	
	@Enumerated(EnumType.STRING)
	private HisProductEnum type;

}