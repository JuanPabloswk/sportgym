package com.example.sportgym.Controller;
import com.example.sportgym.Model.Suscripcion;
import com.example.sportgym.Service.SuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class SuscripcionController {

    @Autowired
    private SuscripcionService suscripcionService;

    @GetMapping("/suscripcion")
    public String listarSuscripcion(Model model){
        List<Suscripcion> listadoSuscripciones = suscripcionService.listarSuscripcion();
        model.addAttribute("titulo","Suscripciones");
        model.addAttribute("suscripcion",listadoSuscripciones);
        return "suscripcion";
    }
}
