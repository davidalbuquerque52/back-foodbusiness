package com.syst.trades.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.syst.trades.dto.get.PaymentModeResponse;
import com.syst.trades.dto.post.PaymentModeCreate;
import com.syst.trades.service.PaymentModeService;
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
@RequestMapping("/paymentMode")
public class PaymentModeController {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private PaymentModeService service;

	@GetMapping
	public ResponseEntity<List<PaymentModeResponse>> toList() {
		List<PaymentModeResponse> paymentModees = Optional.ofNullable(service.getAllPaymentModes())
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ResponseEntity.ok(paymentModees);
	}

	@PostMapping
	public ResponseEntity<PaymentModeResponse> save(@Valid @RequestBody PaymentModeCreate paymentModeCreate, HttpServletResponse response) {
		PaymentModeResponse paymentModeSaved = service.save(paymentModeCreate);
		publisher.publishEvent(new CreatedResourceEvent(this, Long.valueOf(paymentModeSaved.getId()), response));
		return ResponseEntity.status(HttpStatus.CREATED).body(paymentModeSaved);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PaymentModeResponse> paymentModeById(@PathVariable Long id) {
		PaymentModeResponse paymentModeResponse = Optional.ofNullable(service.getById(id))
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ResponseEntity.ok(paymentModeResponse);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		service.removeById(id);
	}

}