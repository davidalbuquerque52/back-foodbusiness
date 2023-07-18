package com.syst.trades.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Client owner;

	@OneToOne
	@JoinColumn(name = "payment_mode_id")
	private PaymentMode paymentMode;

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
	private Date activationDate;

	@Column(name = "creation_user")
	private String creationUser;

	@Column(name = "update_user")
	private String updateUser;

	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "update_date")
	private Date updateDate;

}