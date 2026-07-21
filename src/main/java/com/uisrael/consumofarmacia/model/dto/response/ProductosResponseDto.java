package com.uisrael.consumofarmacia.model.dto.response;

import java.time.LocalDate;


import lombok.Data;
@Data
public class ProductosResponseDto {
	
	private String nombre;
	private String descripcion;
	private String tipoProducto;
	private String precio;
	private LocalDate fechaVencimiento;
	// private int idCategoria;
	// private int idLaboratorio;
	private Boolean estadoRegistro;

}
