package com.syst.trades.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.syst.trades.dto.get.ProductSaleResponse;
import com.syst.trades.dto.post.ProductSaleCreate;
import com.syst.trades.service.ProductSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syst.trades.event.CreatedResourceEvent;

@RestController
@RequestMapping("/productSale")
public class ProductSaleController {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private ProductSaleService service;

	@GetMapping
	public ResponseEntity<List<ProductSaleResponse>> toList() {
		List<ProductSaleResponse> productSalees = Optional.ofNullable(service.getAllProductSales())
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ResponseEntity.ok(productSalees);
	}

	@PostMapping
	public ResponseEntity<ProductSaleResponse> save(@Valid @RequestBody ProductSaleCreate productSaleCreate, HttpServletResponse response) {
		ProductSaleResponse productSaleSaved = service.save(productSaleCreate);
		publisher.publishEvent(new CreatedResourceEvent(this, productSaleSaved.getId(), response));
		return ResponseEntity.status(HttpStatus.CREATED).body(productSaleSaved);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductSaleResponse> productSaleById(@PathVariable Long id) {
		ProductSaleResponse productSaleResponse = Optional.ofNullable(service.getById(id))
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ResponseEntity.ok(productSaleResponse);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		service.removeById(id);
	}

}