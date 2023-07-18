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
public class ClientCreate {

	private String name;

	private String cpfCnpj;

	private String phoneNumber;

	private String email;

	private Boolean inDebitWithMe;

	private Boolean inDebitWithOther;

}