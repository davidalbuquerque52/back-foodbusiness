package com.syst.trades.dto.post;

import com.syst.trades.dto.enums.DebtEnum;
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
public class ClientTradeDebitCreate {

	private TradeCreate trade;

	private ClientCreate client;

	@Enumerated(EnumType.STRING)
	private DebtEnum type;

	private Double value;

	private Double totalDebt;

}