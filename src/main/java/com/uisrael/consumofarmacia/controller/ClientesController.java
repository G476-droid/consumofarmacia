package com.uisrael.consumofarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.consumofarmacia.model.dto.request.ClientesRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.ClientesResponseDto;
import com.uisrael.consumofarmacia.services.IClientesServices;


@Controller
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	private IClientesServices servicioCliente;

	@GetMapping
	public String leerPagina(Model model) {

		List<ClientesResponseDto> resultadoBD = servicioCliente.listarClientes();

		model.addAttribute("listarclientes", resultadoBD);

		return "clientes/listarclientes";
	}

	@GetMapping("/nuevo")
	public String crearCliente(Model model) {

		model.addAttribute("cliente", new ClientesRequestDto());

		return "clientes/nuevocliente";
	}

	@PostMapping("/guardar")
	public String guardarCliente(@ModelAttribute ClientesRequestDto cliente) {

		servicioCliente.guardarClientes(cliente);

		return "redirect:/clientes";
	}

}
