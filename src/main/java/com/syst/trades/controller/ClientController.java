package com.syst.trades.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.syst.trades.dto.get.ClientResponse;
import com.syst.trades.dto.post.ClientCreate;
import com.syst.trades.service.ClientService;
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
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private ClientService service;

	@GetMapping
	public ResponseEntity<List<ClientResponse>> toList() {
		List<ClientResponse> clientes = Optional.ofNullable(service.getAllClients())
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ResponseEntity.ok(clientes);
	}

	@PostMapping
	public ResponseEntity<ClientResponse> save(@Valid @RequestBody ClientCreate clientCreate, HttpServletResponse response) {
		ClientResponse clientSaved = service.save(clientCreate);
		publisher.publishEvent(new CreatedResourceEvent(this, clientSaved.getId(), response));
		return ResponseEntity.status(HttpStatus.CREATED).body(clientSaved);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClientResponse> clientById(@PathVariable Long id) {
		ClientResponse clientResponse = Optional.ofNullable(service.getById(id))
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ResponseEntity.ok(clientResponse);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		service.removeById(id);
	}

}