package com.uisrael.consumofarmacia.model.dto.request;

import java.time.LocalDate;

import lombok.Data;
@Data
public class RutasRequestDto {
	
	// private int idPedido;
	// private int idVehiculo;
	// private int idPersonal;
	private String origen;
	private String destino;
	private String distancia;
	private Boolean estado;
	private LocalDate fechaAsignacion;

}
