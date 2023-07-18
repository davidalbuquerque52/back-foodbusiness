package com.syst.trades.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syst.trades.event.CreatedResourceEvent;
import com.syst.trades.model.Product;
import com.syst.trades.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Product> toList() {
		return productRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Product> toSave(@Valid @RequestBody Product product, HttpServletResponse response) {

		Product productSaved = productRepository.save(product);
		publisher.publishEvent(new CreatedResourceEvent(this, productSaved.getId(), response));
		return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> productById(@PathVariable Long id) {
		Product product = productRepository.findOne(id);
		return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();

	}

}