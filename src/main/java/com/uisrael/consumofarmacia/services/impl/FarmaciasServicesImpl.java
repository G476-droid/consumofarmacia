package com.uisrael.consumofarmacia.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

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

		return webClient.get()
				.uri("/farmacia")
				.retrieve()
				.bodyToFlux(FarmaciasResponseDto.class)
				.collectList()
				.block();
	}

	@Override
	public void guardarFarmacias(FarmaciasRequestDto nuevo) {

		webClient.post()
				.uri("/farmacia")
				.bodyValue(nuevo)
				.retrieve()
				.toBodilessEntity()
				.block();
	}

}
