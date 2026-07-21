package com.uisrael.consumofarmacia.services;

import java.util.List;

import com.uisrael.consumofarmacia.model.dto.request.RolesRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.RolesResponseDto;

public interface IRolesServices {

	List<RolesResponseDto> listarRoles();

	void guardarRoles(RolesRequestDto nuevo);

}
