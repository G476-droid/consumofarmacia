package com.uisrael.consumofarmacia.model.dto.response;

import java.util.Date;


import lombok.Data;
@Data
public class InventariosResponseDto {
	
	// private int idFarmacia;
	// private int idProducto;

	private String stock;
	private String stockMinimo;
	private Date fechaActualizacion;
	private boolean estado;

}
