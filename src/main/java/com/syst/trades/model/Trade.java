package com.syst.trades.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.syst.trades.model.enums.AccessEnum;
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
@Entity
@Table(name = "trade")
public class Trade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address address;

	@Column(name = "owner_id")
	private Integer ownerId;

	@Column(name = "payment_mode_id")
	private Integer paymentModeId;

	@Column(name = "name")
	private String name;

	@Column(name = "cpf_cnpj")
	private String cpfCnpj;

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;

	@Column(name = "active")
	private Boolean active;

	@Enumerated(EnumType.STRING)
	@Column(name = "access")
	private AccessEnum access;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "activation_date")
	private LocalDateTime activationDate;

	@Column(name = "creation_user")
	private String creationUser;

	@Column(name = "update_user")
	private String updateUser;

	@Column(name = "creation_date")
	private LocalDateTime creationDate;

	@Column(name = "update_date")
	private LocalDateTime updateDate;

}