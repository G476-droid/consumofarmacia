package com.uisrael.consumofarmacia.model.dto.request;

import java.time.LocalDate;

import lombok.Data;
@Data
public class PedidosRequestDto {
	
	//private int idCliente;
	//private int idFarmacia;
	private LocalDate fechaPedido;
	private boolean estadoRegistro;
	private String total;

}
