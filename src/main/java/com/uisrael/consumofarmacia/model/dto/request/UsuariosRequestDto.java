package com.uisrael.consumofarmacia.model.dto.request;

import lombok.Data;

@Data
public class UsuariosRequestDto {
	
	private String nombre;
	private String correo;
	private String password;
	//private int idRol;
	private Boolean estado;

}
