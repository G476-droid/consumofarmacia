package com.uisrael.consumofarmacia.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.uisrael.consumofarmacia.model.dto.request.FarmaciasRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.FarmaciasResponseDto;
import com.uisrael.consumofarmacia.services.IFarmaciaServices;

@Service
public class FarmaciasServicesImpl implements IFarmaciaServices {

	private final WebClient webClient;

	public FarmaciasServicesImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public List<FarmaciasResponseDto> listarFarmacias() {

		return webClient.get().uri("/farmacias").retrieve().bodyToFlux(FarmaciasResponseDto.class).collectList()
				.block();
	}

	@Override
	public void guardarFarmacias(FarmaciasRequestDto nuevo) {

		webClient.post().uri("/farmacias").bodyValue(nuevo).retrieve().toBodilessEntity().block();

	}
}