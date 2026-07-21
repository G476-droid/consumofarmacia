package com.uisrael.consumofarmacia.services;

import java.util.List;

import com.uisrael.consumofarmacia.model.dto.request.RutasRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.RutasResponseDto;

public interface IRutasServices {

	List<RutasResponseDto> listarRutas();

	void guardarRutas(RutasRequestDto nuevo);

}
