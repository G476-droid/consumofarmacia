package com.uisrael.consumofarmacia.services;

import java.util.List;

import com.uisrael.consumofarmacia.model.dto.request.VehiculosRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.VehiculosResponseDto;

public interface IVehiculosServices {

	List<VehiculosResponseDto> listarVehiculos();

	void guardarVehiculos(VehiculosRequestDto nuevo);

}
