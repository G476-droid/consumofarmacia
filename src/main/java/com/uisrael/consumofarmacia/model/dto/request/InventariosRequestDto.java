package com.uisrael.consumofarmacia.model.dto.request;

import java.util.Date;

import lombok.Data;
@Data
public class InventariosRequestDto {
	
	// private int idFarmacia;
	// private int idProducto;

	private String stock;
	private String stockMinimo;
	private Date fechaActualizacion;
	private boolean estado;

}
