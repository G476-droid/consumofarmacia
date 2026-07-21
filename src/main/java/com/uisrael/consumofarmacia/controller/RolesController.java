package com.uisrael.consumofarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.consumofarmacia.model.dto.request.RolesRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.RolesResponseDto;
import com.uisrael.consumofarmacia.services.IRolesServices;


@Controller
@RequestMapping("/rol")
public class RolesController {
	@Autowired
	private IRolesServices servicioRol;

	@GetMapping
	public String leerPagina(Model model) {

		List<RolesResponseDto> resultadoBD = servicioRol.listarRoles();

		model.addAttribute("listarroles", resultadoBD);

		return "/roles/listar";
	}

	@GetMapping("/nuevo")
	public String crearRol(Model model) {

		model.addAttribute("rol", new RolesRequestDto());

		return "/roles/crear";
	}

	@PostMapping("/guardar")
	public String guardarRol(@ModelAttribute RolesRequestDto rol) {

		servicioRol.guardarRoles(rol);

		return "redirect:/rol";
	}

}
