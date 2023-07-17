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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleResponse {
	
	private Long id;

	private TradeResponse trade;
	
	private Long destinationId;
	
	private Double amountPaid;
	
	private Double change;

	private Long statusId;
	
	private Boolean paid;
	
	private String creationUser;
	
	private String updateUser;

	@JsonDeserialize(using = DateDeserializer.class)
	@JsonSerialize(using = DateSerializer.class)
	private Date creationDate;

	@JsonDeserialize(using = DateDeserializer.class)
	@JsonSerialize(using = DateSerializer.class)
	private Date updateDate;
	
}