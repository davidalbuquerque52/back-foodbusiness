package com.syst.trades.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 4, max = 40)
	private String address;

	@NotNull
	@Size(min = 1, max = 10)
	private String number;

	private String neighborhood;

	private String city;

	private String complement;

	@Column(name = "reference_point")
	private String referencePoint;

	@Column(name = "cep")
	private String cep;

	@Column(name = "creation_user")
	private String creationUser;

	@Column(name = "update_user")
	private String updateUser;

	@Column(name = "creation_date", updatable=false)
	private Date creationDate;

	@Column(name = "update_date")
	private Date updateDate;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "last_address_requested_id")
	private List<Client> clients;

}