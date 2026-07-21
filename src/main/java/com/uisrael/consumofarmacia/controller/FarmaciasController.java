package com.uisrael.consumofarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.consumofarmacia.model.dto.request.FarmaciasRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.FarmaciasResponseDto;
import com.uisrael.consumofarmacia.services.IFarmaciaServices;


@Controller
@RequestMapping("/farmacia")
public class FarmaciasController {
	@Autowired
	private IFarmaciaServices servicioFarmacia;

	@GetMapping
	public String leerPagina(Model model) {

		List<FarmaciasResponseDto> resultadoBD = servicioFarmacia.listarFarmacias();

		model.addAttribute("listarfarmacias", resultadoBD);

		return "/farmacias/listar";
	}

	@GetMapping("/nuevo")
	public String crearFarmacia(Model model) {

		model.addAttribute("farmacia", new FarmaciasRequestDto());

		return "/farmacias/crear";
	}

	@PostMapping("/guardar")
	public String guardarFarmacia(@ModelAttribute FarmaciasRequestDto farmacia) {

		servicioFarmacia.guardarFarmacias(farmacia);

		return "redirect:/farmacia";
	}

}
