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
public class ClientResponse {

	private Long id;

	private AddressResponse lastAddressRequestedId;

	private Long lastProductRequestedId;
	
	private String name;
	
	private String cpfCnpj;
	
	private String phoneNumber;

	private String email;
	
	private Boolean inDebitWithMe;
	
	private Boolean inDebitWithOther;
	
	private String creationUser;
	
	private String updateUser;

	@JsonDeserialize(using = DateDeserializer.class)
	@JsonSerialize(using = DateSerializer.class)
	private Date creationDate;

	@JsonDeserialize(using = DateDeserializer.class)
	@JsonSerialize(using = DateSerializer.class)
	private Date updateDate;

}