package com.syst.trades.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressCreate {

	@NotNull
	@Size(min = 4, max = 40)
	private String address;

	@NotNull
	@Size(min = 1, max = 10)
	private String number;

	private String neighborhood;

	private String city;

	private String complement;

	private String referencePoint;

	private String cep;

}