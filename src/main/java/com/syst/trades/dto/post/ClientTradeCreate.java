package com.syst.trades.dto.post;

import com.syst.trades.dto.get.TradeResponse;
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
public class ClientTradeCreate {

	private ClientCreate client;

	private TradeResponse trade;

}