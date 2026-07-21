package com.uisrael.consumofarmacia.services;

import java.util.List;

import com.uisrael.consumofarmacia.model.dto.request.ClientesRequestDto;
import com.uisrael.consumofarmacia.model.dto.request.FarmaciasRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.ClientesResponseDto;
import com.uisrael.consumofarmacia.model.dto.response.FarmaciasResponseDto;

public interface IFarmaciaServices {

	List<FarmaciasResponseDto> listarFarmacias();

	void guardarFarmacias(FarmaciasRequestDto nuevo);

}
