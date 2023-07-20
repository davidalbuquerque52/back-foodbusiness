package com.syst.trades.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.syst.trades.dto.get.ProductResponse;
import com.syst.trades.dto.post.ProductCreate;
import com.syst.trades.service.ProductService;
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
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private ProductService service;

	@GetMapping
	public ResponseEntity<List<ProductResponse>> toList() {
		List<ProductResponse> productes = Optional.ofNullable(service.getAllProducts())
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ResponseEntity.ok(productes);
	}

	@PostMapping
	public ResponseEntity<ProductResponse> save(@Valid @RequestBody ProductCreate productCreate, HttpServletResponse response) {
		ProductResponse productSaved = service.save(productCreate);
		publisher.publishEvent(new CreatedResourceEvent(this, productSaved.getId(), response));
		return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> productById(@PathVariable Long id) {
		ProductResponse productResponse = Optional.ofNullable(service.getById(id))
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ResponseEntity.ok(productResponse);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		service.removeById(id);
	}

}