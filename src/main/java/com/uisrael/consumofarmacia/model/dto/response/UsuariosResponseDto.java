package com.uisrael.consumofarmacia.model.dto.response;


import lombok.Data;

@Data
public class UsuariosResponseDto {
	
	private String nombre;
	private String correo;
	private String password;
	//private int idRol;
	private Boolean estado;

}
