package com.syst.trades.dto.post;

import com.syst.trades.dto.enums.AccessEnum;
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
public class TradeCreate {

	private AddressCreate address;

	private ClientCreate owner;

	private PaymentModeCreate paymentMode;

	private String name;

	private String cpfCnpj;

	private String login;

	private String password;

	private Boolean active;

	@Enumerated(EnumType.STRING)
	private AccessEnum access;

	private String phoneNumber;

}