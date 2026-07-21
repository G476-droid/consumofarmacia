package com.uisrael.consumofarmacia.services;

import java.util.List;

import com.uisrael.consumofarmacia.model.dto.request.UsuariosRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.UsuariosResponseDto;

public interface IUsuariosServices {

	List<UsuariosResponseDto> listarUsuarios();

	void guardarUsuarios(UsuariosRequestDto nuevo);

}
