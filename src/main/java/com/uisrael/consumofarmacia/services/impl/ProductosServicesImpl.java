package com.uisrael.consumofarmacia.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.consumofarmacia.model.dto.request.ProductosRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.ProductosResponseDto;
import com.uisrael.consumofarmacia.services.IProductosServices;

@Service
public class ProductosServicesImpl implements IProductosServices {
	
	private final WebClient webClient;

	public ProductosServicesImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public List<ProductosResponseDto> listarProductos() {

		return webClient.get()
				.uri("/producto")
				.retrieve()
				.bodyToFlux(ProductosResponseDto.class)
				.collectList()
				.block();
	}

	@Override
	public void guardarProductos(ProductosRequestDto nuevo) {

		webClient.post()
				.uri("/producto")
				.bodyValue(nuevo)
				.retrieve()
				.toBodilessEntity()
				.block();
	}

}
