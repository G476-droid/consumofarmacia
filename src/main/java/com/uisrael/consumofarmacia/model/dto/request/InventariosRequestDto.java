package com.uisrael.consumofarmacia.model.dto.request;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class InventariosRequestDto {
	
	// private int idFarmacia;
	// private int idProducto;

	private String stock;
	private String stockMinimo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaActualizacion;
	private boolean estado;

}
