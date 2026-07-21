package com.uisrael.consumofarmacia.services;

import java.util.List;

import com.uisrael.consumofarmacia.model.dto.request.CategoriasRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.CategoriasResponseDto;


public interface ICategoriasServices {

	List<CategoriasResponseDto> listarCategorias();

	void guardarCategorias(CategoriasRequestDto nuevo);

}
