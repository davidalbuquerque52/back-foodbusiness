package com.syst.trades.controller;

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

import com.syst.trades.model.ClientTradeDebit;
import com.syst.trades.repository.ClientTradeDebitRepository;

@RestController
@RequestMapping("/client-trade")
public class ClientTradeResource {

	@Autowired
	private ClientTradeDebitRepository clientTradeDebitRepository;

	@GetMapping
	public List<ClientTradeDebit> toList() {
		return clientTradeDebitRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void toSave(@RequestBody ClientTradeDebit clientTradeDebit, HttpServletResponse response) {
		ClientTradeDebit clientTradeDebitSaved = clientTradeDebitRepository.save(clientTradeDebit);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(clientTradeDebitSaved.getId()).toUri();

		response.setHeader("Location", uri.toASCIIString());
	}

}