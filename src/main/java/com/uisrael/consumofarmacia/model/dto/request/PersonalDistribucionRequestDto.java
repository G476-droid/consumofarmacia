package com.uisrael.consumofarmacia.model.dto.request;

import lombok.Data;
@Data
public class PersonalDistribucionRequestDto {
	
	private String nombre;
	private String cedula;
	private String telefono;

	private Boolean estado;

}
