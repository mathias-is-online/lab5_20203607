package com.example.lab5_20203607.controllers;


import com.example.lab5_20203607.entity.Lugares;
import com.example.lab5_20203607.entity.Mascotas;
import com.example.lab5_20203607.repository.LugaresRepository;
import com.example.lab5_20203607.repository.MascotasRepository;
import com.example.lab5_20203607.repository.PersonaRepository;
import com.example.lab5_20203607.repository.ViajesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mascotas")
public class LugaresController {

    final ViajesRepository viajesRepository;
    final PersonaRepository personaRepository;
    final LugaresRepository lugaresRepository;
    final MascotasRepository mascotasRepository;
    public LugaresController(ViajesRepository viajesRepository,
                              PersonaRepository personaRepository,
                              LugaresRepository lugaresRepository,
                              MascotasRepository mascotasRepository){

        this.viajesRepository = viajesRepository;
        this.personaRepository = personaRepository;
        this.lugaresRepository = lugaresRepository;
        this.mascotasRepository = mascotasRepository;

    }



    @GetMapping(value = {"/list", ""})
    public String listarlugares(Model model) {

        List<Lugares> lista = lugaresRepository.findAll();
        model.addAttribute("lista", lista);

        return "lugares/list";
    }

}
