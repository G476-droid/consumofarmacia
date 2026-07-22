package com.uisrael.consumofarmacia.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.uisrael.consumofarmacia.model.dto.request.InventariosRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.InventariosResponseDto;
import com.uisrael.consumofarmacia.services.IInventariosServices;

@Service
public class InventariosServicesImpl implements IInventariosServices {

	private final WebClient webClient;

	public InventariosServicesImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public List<InventariosResponseDto> listarInventarios() {

		return webClient.get().uri("/inventarios").retrieve().bodyToFlux(InventariosResponseDto.class).collectList()
				.block();
	}

	@Override
	public void guardarInventarios(InventariosRequestDto nuevo) {

		webClient.post().uri("/inventarios").bodyValue(nuevo).retrieve().toBodilessEntity().block();

	}
}
