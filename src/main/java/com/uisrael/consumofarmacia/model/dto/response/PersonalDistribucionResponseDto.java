package com.uisrael.consumofarmacia.model.dto.response;


import lombok.Data;

@Data
public class PersonalDistribucionResponseDto {
	
	private String nombre;
	private String cedula;
	private String telefono;

	private Boolean estado;

}
