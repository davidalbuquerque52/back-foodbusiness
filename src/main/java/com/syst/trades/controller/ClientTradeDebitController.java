package com.syst.trades.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.syst.trades.dto.get.ClientTradeDebitResponse;
import com.syst.trades.dto.post.ClientTradeDebitCreate;
import com.syst.trades.service.ClientTradeDebitService;
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
@RequestMapping("/clientTradeDebit")
public class ClientTradeDebitController {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private ClientTradeDebitService service;

	@GetMapping
	public ResponseEntity<List<ClientTradeDebitResponse>> toList() {
		List<ClientTradeDebitResponse> clientTradeDebites = Optional.ofNullable(service.getAllClientTradeDebits())
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ResponseEntity.ok(clientTradeDebites);
	}

	@PostMapping
	public ResponseEntity<ClientTradeDebitResponse> save(@Valid @RequestBody ClientTradeDebitCreate clientTradeDebitCreate, HttpServletResponse response) {
		ClientTradeDebitResponse clientTradeDebitSaved = service.save(clientTradeDebitCreate);
		publisher.publishEvent(new CreatedResourceEvent(this, Long.valueOf(clientTradeDebitSaved.getId()), response));
		return ResponseEntity.status(HttpStatus.CREATED).body(clientTradeDebitSaved);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClientTradeDebitResponse> clientTradeDebitById(@PathVariable Long id) {
		ClientTradeDebitResponse clientTradeDebitResponse = Optional.ofNullable(service.getById(id))
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ResponseEntity.ok(clientTradeDebitResponse);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		service.removeById(id);
	}

}