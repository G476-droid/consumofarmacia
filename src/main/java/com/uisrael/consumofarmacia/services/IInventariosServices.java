package com.uisrael.consumofarmacia.services;

import java.util.List;

import com.uisrael.consumofarmacia.model.dto.request.InventariosRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.InventariosResponseDto;

public interface IInventariosServices {

	List<InventariosResponseDto> listarInventarios();

	void guardarInventarios(InventariosRequestDto nuevo);

}
