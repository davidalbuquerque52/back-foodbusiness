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

import com.syst.trades.model.ProductSale;
import com.syst.trades.repository.ProductSaleRepository;

@RestController
@RequestMapping("/product-sale")
public class ProductSaleResource {

	@Autowired
	private ProductSaleRepository productSaleRepository;

	@GetMapping
	public List<ProductSale> toList() {
		return productSaleRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void toSave(@RequestBody ProductSale productSale, HttpServletResponse response) {
		ProductSale productSaleSaved = productSaleRepository.save(productSale);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(productSaleSaved.getId()).toUri();

		response.setHeader("Location", uri.toASCIIString());
	}

}