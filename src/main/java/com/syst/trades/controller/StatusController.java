package com.syst.trades.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.syst.trades.dto.get.StatusResponse;
import com.syst.trades.dto.post.StatusCreate;
import com.syst.trades.service.StatusService;
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
@RequestMapping("/status")
public class StatusController {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private StatusService service;

	@GetMapping
	public ResponseEntity<List<StatusResponse>> toList() {
		List<StatusResponse> statuses = Optional.ofNullable(service.getAllStatus())
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ResponseEntity.ok(statuses);
	}

	@PostMapping
	public ResponseEntity<StatusResponse> save(@Valid @RequestBody StatusCreate statusCreate, HttpServletResponse response) {
		StatusResponse statusSaved = service.save(statusCreate);
		publisher.publishEvent(new CreatedResourceEvent(this, Long.valueOf(statusSaved.getId()), response));
		return ResponseEntity.status(HttpStatus.CREATED).body(statusSaved);
	}

	@GetMapping("/{id}")
	public ResponseEntity<StatusResponse> statusById(@PathVariable Integer id) {
		StatusResponse statusResponse = Optional.ofNullable(service.getById(id))
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ResponseEntity.ok(statusResponse);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Integer id) {
		service.removeById(id);
	}

}