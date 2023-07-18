package com.syst.trades.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.syst.trades.model.Trade;
import com.syst.trades.repository.TradeRepository;

@RestController
@RequestMapping("/trade")
public class TradeResource {

	@Autowired
	private TradeRepository tradeRepository;

	@GetMapping
	public List<Trade> toList() {
		return tradeRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void toSave(@RequestBody Trade trade, HttpServletResponse response) {
		Trade tradeSaved = tradeRepository.save(trade);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(tradeSaved.getId()).toUri();

		response.setHeader("Location", uri.toASCIIString());
	}

}