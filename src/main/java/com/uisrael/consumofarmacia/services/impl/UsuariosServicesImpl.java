package com.uisrael.consumofarmacia.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.consumofarmacia.model.dto.request.UsuariosRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.UsuariosResponseDto;
import com.uisrael.consumofarmacia.services.IUsuariosServices;

@Service
public class UsuariosServicesImpl implements IUsuariosServices {

	private final WebClient webClient;

	public UsuariosServicesImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public List<UsuariosResponseDto> listarUsuarios() {

		return webClient.get().uri("/usuario").retrieve().bodyToFlux(UsuariosResponseDto.class).collectList().block();
	}

	@Override
	public void guardarUsuarios(UsuariosRequestDto nuevo) {

		webClient.post().uri("/usuario").bodyValue(nuevo).retrieve().toBodilessEntity().block();
	}

}
