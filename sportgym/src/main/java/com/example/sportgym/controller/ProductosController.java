package com.example.sportgym.controller;

import com.example.sportgym.model.Productos;
import com.example.sportgym.service.IProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ProductosController {

    @Autowired
    private IProductos productosService;


    @PostMapping("/productos")
    public Productos create(@RequestBody Productos productos) {
        return productosService.save(productos);
    }

    @PutMapping("/productos")
    public Productos update(@RequestBody Productos productos) {
        return productosService.save(productos);
    }

    @DeleteMapping("/productos/{id}")
    public void delete(@PathVariable int  id) {
        Productos productosDelete = productosService.findById(id);
        productosService.delete(productosDelete);
    }

    @GetMapping("/productos/{id}")
    public Productos showById(@PathVariable int id) {
        return productosService.findById(id);
    }

}
