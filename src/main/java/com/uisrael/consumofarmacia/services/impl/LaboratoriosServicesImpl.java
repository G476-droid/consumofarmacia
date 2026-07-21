package com.uisrael.consumofarmacia.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.consumofarmacia.model.dto.request.LaboratoriosRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.LaboratoriosResponseDto;
import com.uisrael.consumofarmacia.services.ILaboratoriosServices;

@Service
public class LaboratoriosServicesImpl implements ILaboratoriosServices {

	private final WebClient webClient;

	public LaboratoriosServicesImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public List<LaboratoriosResponseDto> listarLaboratorios() {

		return webClient.get().uri("/laboratorio").retrieve().bodyToFlux(LaboratoriosResponseDto.class).collectList()
				.block();
	}

	@Override
	public void guardarLaboratorios(LaboratoriosRequestDto nuevo) {

		webClient.post()
				.uri("/laboratorio")
				.bodyValue(nuevo)
				.retrieve()
				.toBodilessEntity()
				.block();
	}
}
