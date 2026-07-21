package com.uisrael.consumofarmacia.services.impl;

import java.util.List;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.consumofarmacia.model.dto.request.ClientesRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.ClientesResponseDto;
import com.uisrael.consumofarmacia.services.IClientesServices;

@Service
public class ClientesServicesImpl implements IClientesServices {

	private final WebClient webClient;

	public ClientesServicesImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	
	@Override
	public List<ClientesResponseDto> listarClientes() {

		return webClient.get().uri("/clientes").retrieve().bodyToFlux(ClientesResponseDto.class).collectList().block();
	}

	@Override
	public void guardarClientes(ClientesRequestDto nuevo) {

		webClient.post().uri("/clientes").bodyValue(nuevo).retrieve().toBodilessEntity().block();

	}
}
