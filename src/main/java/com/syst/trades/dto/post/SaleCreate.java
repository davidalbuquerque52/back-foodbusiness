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
public class SaleCreate {

	private TradeCreate trade;

	private AddressCreate destination;

	private Double amountPaid;

	private Double change;

	private StatusCreate status;

	private Boolean paid;

}