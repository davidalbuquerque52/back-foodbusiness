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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trade_id")
	private Trade trade; // aqui deve ser alterado para entity, o tipo não será mais Integer e sim Trade

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private Double price;

	@Column(name = "control_quantity")
	private Boolean controlQuantity;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "quantity_reserved")
	private Integer quantityReserved;

	@Column(name = "last_price")
	private Double lastPrice;

	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "product_image")
	private String productImage;

	@Column(name = "creation_user")
	private String creationUser;

	@Column(name = "update_user")
	private String updateUser;

	@Column(name = "creation_date", updatable=false)
	private Date creationDate;

	@Column(name = "update_date")
	private Date updateDate;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductSale> productSales;

}