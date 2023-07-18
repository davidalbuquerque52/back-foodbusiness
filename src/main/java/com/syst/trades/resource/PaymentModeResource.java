package com.syst.trades.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.syst.trades.model.PaymentMode;
import com.syst.trades.repository.PaymentModeRepository;

@RestController
@RequestMapping("/payment-mode")
public class PaymentModeResource {

	@Autowired
	private PaymentModeRepository paymentModeRepository;

	@GetMapping
	public List<PaymentMode> toList() {
		return paymentModeRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void toSave(@RequestBody PaymentMode paymentMode, HttpServletResponse response) {
		PaymentMode paymentModeSaved = paymentModeRepository.save(paymentMode);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(paymentModeSaved.getId()).toUri();

		response.setHeader("Location", uri.toASCIIString());
	}

}