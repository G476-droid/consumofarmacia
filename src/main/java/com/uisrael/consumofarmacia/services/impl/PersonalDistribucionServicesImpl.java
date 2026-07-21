package com.uisrael.consumofarmacia.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.consumofarmacia.model.dto.request.PersonalDistribucionRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.PersonalDistribucionResponseDto;
import com.uisrael.consumofarmacia.services.IPersonalDistribucionServices;

@Service
public class PersonalDistribucionServicesImpl implements IPersonalDistribucionServices {

	private final WebClient webClient;

	public PersonalDistribucionServicesImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public List<PersonalDistribucionResponseDto> listarPersonalDistribucion() {

		return webClient.get().uri("/personaldistribucion").retrieve().bodyToFlux(PersonalDistribucionResponseDto.class)
				.collectList().block();
	}

	@Override
	public void guardarPersonalDistribucion(PersonalDistribucionRequestDto nuevo) {

		webClient.post().uri("/personaldistribucion").bodyValue(nuevo).retrieve().toBodilessEntity().block();
	}

}
