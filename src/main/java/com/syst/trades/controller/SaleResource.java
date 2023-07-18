package com.syst.trades.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.syst.trades.model.Sale;
import com.syst.trades.repository.SaleRepository;

@RestController
@RequestMapping("/sale")
public class SaleResource {

	@Autowired
	private SaleRepository saleRepository;

	@GetMapping
	public List<Sale> toList(){
		return saleRepository.findAll();
	} // esse cara tem que ser refatorado por trade_id

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void toSave(@RequestBody Sale sale, HttpServletResponse response) {
		Sale saleSaved = saleRepository.save(sale);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(saleSaved.getId()).toUri();

		response.setHeader("Location", uri.toASCIIString());
	}

	@GetMapping("/status/{statusId}")
	@ResponseStatus(HttpStatus.OK)
	public List<Sale> getSaleByStatusId(@PathVariable("statusId") Long statusId) {
		return saleRepository.findByStatusId(statusId);
	}

}