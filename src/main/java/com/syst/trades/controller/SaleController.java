package com.syst.trades.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.syst.trades.dto.get.SaleResponse;
import com.syst.trades.dto.post.SaleCreate;
import com.syst.trades.service.SaleService;
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
@RequestMapping("/sale")
public class SaleController {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private SaleService service;

	@GetMapping
	public ResponseEntity<List<SaleResponse>> toList() {
		List<SaleResponse> salees = Optional.ofNullable(service.getAllSales())
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ResponseEntity.ok(salees);
	}

	@PostMapping
	public ResponseEntity<SaleResponse> save(@Valid @RequestBody SaleCreate saleCreate, HttpServletResponse response) {
		SaleResponse saleSaved = service.save(saleCreate);
		publisher.publishEvent(new CreatedResourceEvent(this, saleSaved.getId(), response));
		return ResponseEntity.status(HttpStatus.CREATED).body(saleSaved);
	}

	@GetMapping("/{id}")
	public ResponseEntity<SaleResponse> saleById(@PathVariable Long id) {
		SaleResponse saleResponse = Optional.ofNullable(service.getById(id))
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ResponseEntity.ok(saleResponse);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		service.removeById(id);
	}

}