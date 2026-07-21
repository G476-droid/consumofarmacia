package com.uisrael.consumofarmacia.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.consumofarmacia.model.dto.request.RutasRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.RutasResponseDto;
import com.uisrael.consumofarmacia.services.IRutasServices;

@Service
public class RutasServicesImpl implements IRutasServices {

	private final WebClient webClient;

	public RutasServicesImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public List<RutasResponseDto> listarRutas() {

		return webClient.get().uri("/ruta").retrieve().bodyToFlux(RutasResponseDto.class).collectList().block();
	}

	@Override
	public void guardarRutas(RutasRequestDto nuevo) {

		webClient.post().uri("/ruta").bodyValue(nuevo).retrieve().toBodilessEntity().block();
	}

}
