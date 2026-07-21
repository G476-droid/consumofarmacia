package com.uisrael.consumofarmacia.services;

import java.util.List;

import com.uisrael.consumofarmacia.model.dto.request.PersonalDistribucionRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.PersonalDistribucionResponseDto;

public interface IPersonalDistribucionServices {
	List<PersonalDistribucionResponseDto> listarPersonalDistribucion();

	void guardarPersonalDistribucion(PersonalDistribucionRequestDto nuevo);

}
