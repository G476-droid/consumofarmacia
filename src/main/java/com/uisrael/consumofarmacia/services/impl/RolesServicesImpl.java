package com.uisrael.consumofarmacia.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.consumofarmacia.model.dto.request.RolesRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.RolesResponseDto;
import com.uisrael.consumofarmacia.services.IRolesServices;

@Service
public class RolesServicesImpl implements IRolesServices {
	
	private final WebClient webClient;

	public RolesServicesImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public List<RolesResponseDto> listarRoles() {

		return webClient.get()
				.uri("/rol")
				.retrieve()
				.bodyToFlux(RolesResponseDto.class)
				.collectList()
				.block();
	}

	@Override
	public void guardarRoles(RolesRequestDto nuevo) {

		webClient.post()
				.uri("/rol")
				.bodyValue(nuevo)
				.retrieve()
				.toBodilessEntity()
				.block();
	}


}
