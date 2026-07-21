package com.uisrael.consumofarmacia.services;

import java.util.List;

import com.uisrael.consumofarmacia.model.dto.request.PedidosRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.PedidosResponseDto;

public interface IPedidosServices {

	List<PedidosResponseDto> listarPedidos();

	void guardarPedidos(PedidosRequestDto nuevo);

}
