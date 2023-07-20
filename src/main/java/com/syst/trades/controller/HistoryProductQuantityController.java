package com.syst.trades.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.syst.trades.dto.get.HistoryProductQuantityResponse;
import com.syst.trades.dto.post.HistoryProductQuantityCreate;
import com.syst.trades.service.HistoryProductQuantityService;
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
@RequestMapping("/historyProductQuantity")
public class HistoryProductQuantityController {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private HistoryProductQuantityService service;

	@GetMapping
	public ResponseEntity<List<HistoryProductQuantityResponse>> toList() {
		List<HistoryProductQuantityResponse> historyProductQuantityes = Optional.ofNullable(service.getAllHistoryProductQuantities())
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ResponseEntity.ok(historyProductQuantityes);
	}

	@PostMapping
	public ResponseEntity<HistoryProductQuantityResponse> save(@Valid @RequestBody HistoryProductQuantityCreate historyProductQuantityCreate, HttpServletResponse response) {
		HistoryProductQuantityResponse historyProductQuantitySaved = service.save(historyProductQuantityCreate);
		publisher.publishEvent(new CreatedResourceEvent(this, historyProductQuantitySaved.getId(), response));
		return ResponseEntity.status(HttpStatus.CREATED).body(historyProductQuantitySaved);
	}

	@GetMapping("/{id}")
	public ResponseEntity<HistoryProductQuantityResponse> historyProductQuantityById(@PathVariable Long id) {
		HistoryProductQuantityResponse historyProductQuantityResponse = Optional.ofNullable(service.getById(id))
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ResponseEntity.ok(historyProductQuantityResponse);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		service.removeById(id);
	}

}