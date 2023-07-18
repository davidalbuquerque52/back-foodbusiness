package com.syst.trades.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.syst.trades.event.CreatedResourceEvent;
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

import com.syst.trades.model.Client;
import com.syst.trades.repository.ClientRepository;

@RestController
@RequestMapping("/client")
public class ClientResource {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Client> toList() {
		return clientRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Client> clientById(@PathVariable Long id) {
		Client client = clientRepository.findOne(id);
		return client != null ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();

	}

	@PostMapping
	public ResponseEntity<Client> toSave(@Valid @RequestBody Client client, HttpServletResponse response) {

		client.setCreationDate(new Date());
		Client clientSaved = clientRepository.save(client);
		publisher.publishEvent(new CreatedResourceEvent(this, clientSaved.getId(), response));

		return ResponseEntity.status(HttpStatus.CREATED).body(clientSaved);
	}

}