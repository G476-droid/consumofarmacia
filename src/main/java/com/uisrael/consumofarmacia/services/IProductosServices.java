package com.uisrael.consumofarmacia.services;

import java.util.List;

import com.uisrael.consumofarmacia.model.dto.request.ProductosRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.ProductosResponseDto;

public interface IProductosServices {

	List<ProductosResponseDto> listarProductos();

	void guardarProductos(ProductosRequestDto nuevo);

}
