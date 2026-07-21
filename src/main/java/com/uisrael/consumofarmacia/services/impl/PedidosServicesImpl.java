package com.uisrael.consumofarmacia.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.consumofarmacia.model.dto.request.PedidosRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.PedidosResponseDto;
import com.uisrael.consumofarmacia.services.IPedidosServices;

@Service
public class PedidosServicesImpl implements IPedidosServices {
	
	private final WebClient webClient;

	public PedidosServicesImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public List<PedidosResponseDto> listarPedidos() {

		return webClient.get()
				.uri("/pedido")
				.retrieve()
				.bodyToFlux(PedidosResponseDto.class)
				.collectList()
				.block();
	}

	@Override
	public void guardarPedidos(PedidosRequestDto nuevo) {

		webClient.post()
				.uri("/pedido")
				.bodyValue(nuevo)
				.retrieve()
				.toBodilessEntity()
				.block();
	}
}
