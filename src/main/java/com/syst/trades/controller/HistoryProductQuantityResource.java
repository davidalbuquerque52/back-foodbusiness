package com.syst.trades.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.syst.trades.model.HistoryProductQuantity;
import com.syst.trades.repository.HistoryProductQuantityRepository;

@RestController
@RequestMapping("/history-product-quantity")
public class HistoryProductQuantityResource {

	@Autowired
	private HistoryProductQuantityRepository historyProductQuantityRepository;

	@GetMapping
	public List<HistoryProductQuantity> toList() {
		return historyProductQuantityRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void toSave(HistoryProductQuantity historyProductQuantity, HttpServletResponse response) {
		HistoryProductQuantity historyProductQuantitySaved =
				historyProductQuantityRepository.save(historyProductQuantity);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(historyProductQuantitySaved.getId()).toUri();

		response.setHeader("Location", uri.toASCIIString());
	}

}