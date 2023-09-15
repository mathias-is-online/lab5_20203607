package com.example.lab5_20203607.controllers;


import com.example.lab5_20203607.entity.Mascotas;
import com.example.lab5_20203607.entity.Viajes;
import com.example.lab5_20203607.repository.LugaresRepository;
import com.example.lab5_20203607.repository.MascotasRepository;
import com.example.lab5_20203607.repository.PersonaRepository;
import com.example.lab5_20203607.repository.ViajesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/mascotas")
public class MascotasController {

    final ViajesRepository viajesRepository;
    final PersonaRepository personaRepository;
    final LugaresRepository lugaresRepository;
    final MascotasRepository mascotasRepository;
    public MascotasController(ViajesRepository viajesRepository,
                            PersonaRepository personaRepository,
                            LugaresRepository lugaresRepository,
                              MascotasRepository mascotasRepository){

        this.viajesRepository = viajesRepository;
        this.personaRepository = personaRepository;
        this.lugaresRepository = lugaresRepository;
        this.mascotasRepository = mascotasRepository;

    }


    @GetMapping(value = {"/list", ""})
    public String listarmascota(Model model) {

        List<Mascotas> lista = mascotasRepository.findAll();
        model.addAttribute("lista", lista);

        return "mascotas/list";
    }


    @GetMapping("/new") //EL CREAR NO guarda pro alguna razon ,e l editar si funciona bien
    public String nuevomascota(Model model) {
        model.addAttribute("listapersonas",personaRepository.findAll());
        model.addAttribute("listalugares",lugaresRepository.findAll());
        List<String> list=new ArrayList<String>();
        list.add("si");
        list.add("no");
        model.addAttribute("opciones",list);
        return "mascotas/newFrm";
    }

    @PostMapping("/save")
    public String gaurdarmascota(Mascotas mascotas) {
        mascotasRepository.save(mascotas);
        return "redirect:/mascotas";
    }

    @PostMapping("/saveeditar")
    public String guardarespecial(Mascotas mascotas) {
        mascotasRepository.saveeditar(mascotas.getIdMascotas(),mascotas.getNombre_mascota(),mascotas.getVacunado(),mascotas.getDesparasitado());
        return "redirect:/mascotas";
    }





    @GetMapping("/edit")
    public String editarmascotas(Model model, @RequestParam("id") int id) {

        Optional<Mascotas> optionalMascotas = mascotasRepository.findById(id);

        if (optionalMascotas.isPresent()) {
            Mascotas mascotas = optionalMascotas.get();
            model.addAttribute("mascotas", mascotas);
            List<String> list=new ArrayList<String>();
            list.add("si");
            list.add("no");
            model.addAttribute("opciones",list);
            model.addAttribute("listapersonas",personaRepository.findAll());
            model.addAttribute("listalugares",lugaresRepository.findAll());
            return "mascotas/editFrm";
        } else {
            return "redirect:/mascotas";
        }
    }


    @GetMapping("/delete")
    public String borrarmascota(Model model,
                              @RequestParam("id") int id) {

        Optional<Mascotas> optionalMascotas = mascotasRepository.findById(id);

        if (optionalMascotas.isPresent()) {
            mascotasRepository.deleteById(id);
        }
        return "redirect:/mascotas";

    }





}
