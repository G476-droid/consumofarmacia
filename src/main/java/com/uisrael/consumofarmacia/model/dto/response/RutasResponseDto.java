package com.uisrael.consumofarmacia.model.dto.response;

import java.time.LocalDate;


import lombok.Data;
@Data
public class RutasResponseDto {
	
	// private int idPedido;
	// private int idVehiculo;
	// private int idPersonal;
	private String origen;
	private String destino;
	private String distancia;
	private Boolean estado;
	private LocalDate fechaAsignacion;

}
