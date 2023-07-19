package com.syst.trades.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.syst.trades.dto.get.AddressResponse;
import com.syst.trades.dto.post.AddressCreate;
import com.syst.trades.service.AddressService;
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
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private AddressService service;

	@GetMapping
	public ResponseEntity<List<AddressResponse>> toList() {
		List<AddressResponse> addresses = Optional.ofNullable(service.getAllAddresses())
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ResponseEntity.ok(addresses);
	}

	@PostMapping
	public ResponseEntity<AddressResponse> save(@Valid @RequestBody AddressCreate addressCreate, HttpServletResponse response) {
		AddressResponse addressSaved = service.save(addressCreate);
		publisher.publishEvent(new CreatedResourceEvent(this, addressSaved.getId(), response));
		return ResponseEntity.status(HttpStatus.CREATED).body(addressSaved);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AddressResponse> addressById(@PathVariable Long id) {
		AddressResponse addressResponse = Optional.ofNullable(service.getById(id))
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ResponseEntity.ok(addressResponse);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		service.removeById(id);
	}

}