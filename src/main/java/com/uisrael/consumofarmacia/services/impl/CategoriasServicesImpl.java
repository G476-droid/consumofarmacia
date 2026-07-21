package com.uisrael.consumofarmacia.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.consumofarmacia.model.dto.request.CategoriasRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.CategoriasResponseDto;
import com.uisrael.consumofarmacia.services.ICategoriasServices;

@Service
public class CategoriasServicesImpl implements ICategoriasServices {

	private final WebClient webClient;

	public CategoriasServicesImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public List<CategoriasResponseDto> listarCategorias() {

		return webClient.get().uri("/categorias").retrieve().bodyToFlux(CategoriasResponseDto.class).collectList()
				.block();
	}

	@Override
	public void guardarCategorias(CategoriasRequestDto nuevo) {

		webClient.post().uri("/categorias").bodyValue(nuevo).retrieve().toBodilessEntity().block();
	}

}
