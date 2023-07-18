package com.syst.trades.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class CreatedResourceEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;

	private Long codigo;
	private HttpServletResponse response;

	public CreatedResourceEvent(Object source, Long codigo, HttpServletResponse response) {
		super(source);
		this.codigo = codigo;
		this.response = response;
	}

	public Long getCodigo() {
		return codigo;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

}