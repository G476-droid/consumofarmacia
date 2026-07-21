package com.uisrael.consumofarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.consumofarmacia.model.dto.request.UsuariosRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.UsuariosResponseDto;
import com.uisrael.consumofarmacia.services.IUsuariosServices;


@Controller
@RequestMapping("/usuario")
public class UsuariosController {

	@Autowired
	private IUsuariosServices servicioUsuario;

	@GetMapping
	public String leerPagina(Model model) {

		List<UsuariosResponseDto> resultadoBD = servicioUsuario.listarUsuarios();

		model.addAttribute("listarusuarios", resultadoBD);

		return "/usuarios/listar";
	}

	@GetMapping("/nuevo")
	public String crearUsuario(Model model) {

		model.addAttribute("usuario", new UsuariosRequestDto());

		return "/usuarios/crear";
	}

	@PostMapping("/guardar")
	public String guardarUsuario(@ModelAttribute UsuariosRequestDto usuario) {

		servicioUsuario.guardarUsuarios(usuario);

		return "redirect:/usuario";
	}

}
