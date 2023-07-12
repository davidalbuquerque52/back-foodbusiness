package com.syst.trades.resource;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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
import com.syst.trades.model.Address;
import com.syst.trades.repository.AddressRepository;

@RestController
@RequestMapping("/address")
public class AddressResource {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Address> toList() {
		return addressRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Address> save(@Valid @RequestBody Address address, HttpServletResponse response) {

		address.setCreationDate(new Date());
		Address addressSaved = addressRepository.save(address);
		publisher.publishEvent(new CreatedResourceEvent(this, addressSaved.getId(), response));
		return ResponseEntity.status(HttpStatus.CREATED).body(addressSaved);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Address> addressById(@PathVariable Long id) {
		Address address = addressRepository.findOne(id);
		return address != null ? ResponseEntity.ok(address) : ResponseEntity.notFound().build();

	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		addressRepository.delete(id);
	}

}
