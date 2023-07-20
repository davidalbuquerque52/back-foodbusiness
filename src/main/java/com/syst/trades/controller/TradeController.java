package com.syst.trades.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.syst.trades.dto.get.TradeResponse;
import com.syst.trades.dto.post.TradeCreate;
import com.syst.trades.service.TradeService;
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
@RequestMapping("/trade")
public class TradeController {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private TradeService service;

	@GetMapping
	public ResponseEntity<List<TradeResponse>> toList() {
		List<TradeResponse> tradees = Optional.ofNullable(service.getAllTrades())
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ResponseEntity.ok(tradees);
	}

	@PostMapping
	public ResponseEntity<TradeResponse> save(@Valid @RequestBody TradeCreate tradeCreate, HttpServletResponse response) {
		TradeResponse tradeSaved = service.save(tradeCreate);
		publisher.publishEvent(new CreatedResourceEvent(this, Long.valueOf(tradeSaved.getId()), response));
		return ResponseEntity.status(HttpStatus.CREATED).body(tradeSaved);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TradeResponse> tradeById(@PathVariable Integer id) {
		TradeResponse tradeResponse = Optional.ofNullable(service.getById(id))
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ResponseEntity.ok(tradeResponse);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Integer id) {
		service.removeById(id);
	}

}