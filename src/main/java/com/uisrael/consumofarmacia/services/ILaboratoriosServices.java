package com.uisrael.consumofarmacia.services;

import java.util.List;

import com.uisrael.consumofarmacia.model.dto.request.LaboratoriosRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.LaboratoriosResponseDto;

public interface ILaboratoriosServices {

	List<LaboratoriosResponseDto> listarLaboratorios();

	void guardarLaboratorios(LaboratoriosRequestDto nuevo);

}
