package com.uisrael.consumofarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.consumofarmacia.model.dto.request.PedidosRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.PedidosResponseDto;
import com.uisrael.consumofarmacia.services.IPedidosServices;


@Controller
@RequestMapping("/pedido")
public class PedidosController {
	@Autowired
	private IPedidosServices servicioPedido;

	@GetMapping
	public String leerPagina(Model model) {

		List<PedidosResponseDto> resultadoBD = servicioPedido.listarPedidos();

		model.addAttribute("listarpedidos", resultadoBD);

		return "/pedidos/listar";
	}

	@GetMapping("/nuevo")
	public String crearPedido(Model model) {

		model.addAttribute("pedido", new PedidosRequestDto());

		return "/pedidos/crear";
	}

	@PostMapping("/guardar")
	public String guardarPedido(@ModelAttribute PedidosRequestDto pedido) {

		servicioPedido.guardarPedidos(pedido);

		return "redirect:/pedido";
	}

}
