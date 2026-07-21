package com.uisrael.consumofarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.consumofarmacia.model.dto.request.LaboratoriosRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.LaboratoriosResponseDto;
import com.uisrael.consumofarmacia.services.ILaboratoriosServices;


@Controller
@RequestMapping("/laboratorio")
public class LaboratoriosController {
	@Autowired
	private ILaboratoriosServices servicioLaboratorio;

	@GetMapping
	public String leerPagina(Model model) {

		List<LaboratoriosResponseDto> resultadoBD = servicioLaboratorio.listarLaboratorios();

		model.addAttribute("listarlaboratorios", resultadoBD);

		return "/laboratorios/listar";
	}

	@GetMapping("/nuevo")
	public String crearLaboratorio(Model model) {

		model.addAttribute("laboratorio", new LaboratoriosRequestDto());

		return "/laboratorios/crear";
	}

	@PostMapping("/guardar")
	public String guardarLaboratorio(@ModelAttribute LaboratoriosRequestDto laboratorio) {

		servicioLaboratorio.guardarLaboratorios(laboratorio);

		return "redirect:/laboratorio";
	}

}
