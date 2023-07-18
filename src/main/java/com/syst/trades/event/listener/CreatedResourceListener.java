package com.syst.trades.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.syst.trades.event.CreatedResourceEvent;

@Component
public class CreatedResourceListener implements ApplicationListener<CreatedResourceEvent> {

	@Override
	public void onApplicationEvent(CreatedResourceEvent createdResourceEvent) {
		Long codigo = createdResourceEvent.getCodigo();
		HttpServletResponse response = createdResourceEvent.getResponse();
		addsResponse(codigo, response);
	}

	private void addsResponse(Long codigo, HttpServletResponse response) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(codigo)
				.toUri();
		response.setHeader("Location", uri.toASCIIString());
	}


}