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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product_sale")
public class ProductSale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "client_id")
	private Integer clientId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sale_id")
	private Sale sale;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@Column(name = "quantity_sold")
	private Integer quantitySold;

	@Column(name = "price_unit_sold")
	private Double priceUnitSold;

	@Column(name = "sale_total")
	private Double saleTotal;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_id")
	private Status status;

	@Column(name = "creation_user")
	private String creationUser;

	@Column(name = "update_user")
	private String updateUser;

	@Column(name = "creation_date")
	private LocalDateTime creationDate;

	@Column(name = "update_date")
	private LocalDateTime updateDate;

}