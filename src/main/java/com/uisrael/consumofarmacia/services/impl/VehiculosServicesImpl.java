package com.uisrael.consumofarmacia.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.consumofarmacia.model.dto.request.VehiculosRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.VehiculosResponseDto;
import com.uisrael.consumofarmacia.services.IVehiculosServices;

@Service
public class VehiculosServicesImpl implements IVehiculosServices {

	private final WebClient webClient;

	public VehiculosServicesImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public List<VehiculosResponseDto> listarVehiculos() {

		return webClient.get().uri("/vehiculo").retrieve().bodyToFlux(VehiculosResponseDto.class).collectList().block();
	}

	@Override
	public void guardarVehiculos(VehiculosRequestDto nuevo) {

		webClient.post().uri("/vehiculo").bodyValue(nuevo).retrieve().toBodilessEntity().block();
	}

}
