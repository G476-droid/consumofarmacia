package com.uisrael.consumofarmacia.model.dto.request;

import java.time.LocalDate;

import lombok.Data;
@Data
public class ProductosRequestDto {
	private String nombre;
	private String descripcion;
	private String tipoProducto;
	private String precio;
	private LocalDate fechaVencimiento;
	// private int idCategoria;
	// private int idLaboratorio;
	private Boolean estadoRegistro;
}
