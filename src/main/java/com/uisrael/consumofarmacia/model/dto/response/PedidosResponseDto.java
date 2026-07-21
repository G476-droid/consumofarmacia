package com.uisrael.consumofarmacia.model.dto.response;

import java.time.LocalDate;


import lombok.Data;
@Data
public class PedidosResponseDto {
	
	//private int idCliente;
	//private int idFarmacia;
	private LocalDate fechaPedido;
	private boolean estadoRegistro;
	private String total;


}
