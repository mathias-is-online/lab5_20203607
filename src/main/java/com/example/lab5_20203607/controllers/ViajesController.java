package com.example.lab5_20203607.controllers;


import com.example.lab5_20203607.entity.Viajes;
import com.example.lab5_20203607.repository.LugaresRepository;
import com.example.lab5_20203607.repository.PersonaRepository;
import com.example.lab5_20203607.repository.ViajesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/viajes")
public class ViajesController {

    final ViajesRepository viajesRepository;
    final PersonaRepository personaRepository;
    final LugaresRepository lugaresRepository;
    public ViajesController(ViajesRepository viajesRepository,
                            PersonaRepository personaRepository,
                            LugaresRepository lugaresRepository){

        this.viajesRepository = viajesRepository;
        this.personaRepository = personaRepository;
        this.lugaresRepository = lugaresRepository;

    }

    @GetMapping(value = {"/list", ""})
    public String listarViaje(Model model) {

        List<Viajes> lista = viajesRepository.findAll();
        model.addAttribute("lista", lista);

        return "viajes/list";
    }
    int id = 5;
    @GetMapping("/new") //EL CREAR NO guarda pro alguna razon ,e l editar si funciona bien
    public String nuevoViaje(Model model) {
        model.addAttribute("listapersonas",personaRepository.findAll());
        model.addAttribute("listalugares",lugaresRepository.findAll());
        return "viajes/newFrm";
    }

    @PostMapping("/save")
    public String guardarViaje(Viajes viajes) {
        viajesRepository.save(viajes);
        return "redirect:/viajes";
    }



    @GetMapping("/edit")
    public String editarviajes(Model model, @RequestParam("id") int id) {

        Optional<Viajes> optionalViajes = viajesRepository.findById(id);

        if (optionalViajes.isPresent()) {
            Viajes viajes = optionalViajes.get();
            model.addAttribute("viajes", viajes);
            model.addAttribute("listapersonas",personaRepository.findAll());
            model.addAttribute("listalugares",lugaresRepository.findAll());
            return "viajes/editFrm";
        } else {
            return "redirect:/viajes";
        }
    }


    @GetMapping("/delete")
    public String borrarviaje(Model model,
                                      @RequestParam("id") int id) {

        Optional<Viajes> optProduct = viajesRepository.findById(id);

        if (optProduct.isPresent()) {
            viajesRepository.deleteById(id);
        }
        return "redirect:/viajes";

    }


}
