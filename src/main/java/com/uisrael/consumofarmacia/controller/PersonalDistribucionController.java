package com.uisrael.consumofarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.consumofarmacia.model.dto.request.PersonalDistribucionRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.PersonalDistribucionResponseDto;
import com.uisrael.consumofarmacia.services.IPersonalDistribucionServices;


@Controller
@RequestMapping("/personaldistribucion")
public class PersonalDistribucionController {
	
	@Autowired
    private IPersonalDistribucionServices servicioPersonalDistribucion;

    @GetMapping
    public String leerPagina(Model model) {

        List<PersonalDistribucionResponseDto> resultadoBD =
                servicioPersonalDistribucion.listarPersonalDistribucion();

        model.addAttribute("listarpersonaldistribucion", resultadoBD);

        return "/personaldistribucion/listar";
    }

    @GetMapping("/nuevo")
    public String crearPersonalDistribucion(Model model) {

        model.addAttribute(
                "personalDistribucion",
                new PersonalDistribucionRequestDto()
        );

        return "/personaldistribucion/crear";
    }

    @PostMapping("/guardar")
    public String guardarPersonalDistribucion(
            @ModelAttribute PersonalDistribucionRequestDto personalDistribucion) {

        servicioPersonalDistribucion.guardarPersonalDistribucion(personalDistribucion);

        return "redirect:/personaldistribucion";
    }

}
