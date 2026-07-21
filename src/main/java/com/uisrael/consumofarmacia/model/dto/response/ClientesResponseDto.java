package com.uisrael.consumofarmacia.model.dto.response;


import lombok.Data;

@Data
public class ClientesResponseDto {
	private String nombre;
	private String apellido;
	private String cedula;
	private String correo;
	private String telefono;
	private String direccion;
	private boolean estado;

}
