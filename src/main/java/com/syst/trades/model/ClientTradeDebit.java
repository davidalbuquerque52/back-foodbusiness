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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.syst.trades.model.enums.DebtEnum;
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
@Table(name = "client_trade_debit")
public class ClientTradeDebit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trade_id")
	private Trade trade;
	
	@Column(name = "client_id")
	private Integer clientId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private DebtEnum type;
	
	@Column(name = "value")
	private Double value;
	
	@Column(name = "total_debt")
	private Double totalDebt;
	
	@Column(name = "creation_user")
	private String creationUser;
	
	@Column(name = "update_user")
	private String updateUser;
	
	@Column(name = "creation_date")
	private LocalDateTime creationDate;
	
	@Column(name = "update_date")
	private LocalDateTime updateDate;

}