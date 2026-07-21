package com.uisrael.consumofarmacia.model.dto.response;


import lombok.Data;

@Data
public class FarmaciasResponseDto {
	
	private String nombre;
	private String direccion;
	private String zona;
	private String telefono;
	private boolean estado;

}
