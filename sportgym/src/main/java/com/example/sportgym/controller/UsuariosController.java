package com.example.sportgym.controller;

import com.example.sportgym.model.entity.Usuarios;
import com.example.sportgym.service.IUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UsuariosController {

    @Autowired
    private IUsuarios usuariosService;


    @PostMapping("/usuarios")
    public Usuarios create(@RequestBody Usuarios usuarios) {
        return usuariosService.save(usuarios);
    }

    @PutMapping("/usuarios")
    public Usuarios update(@RequestBody Usuarios usuarios) {
        return usuariosService.save(usuarios);
    }

    @DeleteMapping("/usuarios/{id}")
    public void delete(@PathVariable int id) {
        Usuarios usuariosDelete = usuariosService.findById(id);
        usuariosService.delete(usuariosDelete);
    }

    @GetMapping("/usuarios/{id}")
    public Usuarios showById(@PathVariable int id) {
        return usuariosService.findById(id);
    }
}
