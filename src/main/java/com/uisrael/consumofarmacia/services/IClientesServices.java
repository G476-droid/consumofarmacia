package com.uisrael.consumofarmacia.services;

import java.util.List;

import com.uisrael.consumofarmacia.model.dto.request.ClientesRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.ClientesResponseDto;

public interface IClientesServices {

	List<ClientesResponseDto> listarClientes();

	void guardarClientes(ClientesRequestDto nuevo);

}
