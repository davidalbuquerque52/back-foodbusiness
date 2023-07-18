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

import com.syst.trades.model.Status;
import com.syst.trades.repository.StatusRepository;

@RestController
@RequestMapping("/status")
public class StatusResource {

	@Autowired
	private StatusRepository statusRepository;

	@GetMapping
	public List<Status> toList() {
		return statusRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void toSave(@RequestBody Status status, HttpServletResponse response) {
		Status statusSaved = statusRepository.save(status);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(statusSaved.getId()).toUri();

		response.setHeader("Location", uri.toASCIIString());
	}

}