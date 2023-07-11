package com.syst.trades.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "last_address_requested_id")
	private Address lastAddressRequestedId;

	@Column(name = "last_product_requested_id")
	private Long lastProductRequestedId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "cpf_cnpj")
	private String cpfCnpj;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "in_debit_with_me")
	private Boolean inDebitWithMe;
	
	@Column(name = "in_debit_with_other")
	private Boolean inDebitWithOther;
	
	@Column(name = "creation_User")
	private String creationUser;
	
	@Column(name = "update_user")
	private String updateUser;
	
	@Column(name = "creation_date")
	private LocalDateTime creationDate;
	
	@Column(name = "update_date")
	private LocalDateTime updateDate;

}