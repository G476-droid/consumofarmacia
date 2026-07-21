package com.uisrael.consumofarmacia.model.dto.request;

import lombok.Data;
@Data
public class FarmaciasRequestDto {
	
	private String nombre;
	private String direccion;
	private String zona;
	private String telefono;
	private boolean estado;

}
