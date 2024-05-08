package com.example.sportgym.Controller;

import com.example.sportgym.Model.Producto;
import com.example.sportgym.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Controlador para las acciones del usuario en el sistema.
 */
@Controller
@RequestMapping("/cliente")
public class UserController {

    @Autowired
    private ProductoService productoService;

    /**
     * Maneja las solicitudes GET para mostrar el panel principal del USER.
     *
     * @param model El modelo utilizado para pasar datos a la vista.
     * @param page El número de página solicitado (por defecto es 0).
     * @return La vista para mostrar el panel principal.
     */
    @GetMapping("/panelPrincipal")
    public String verInventario(Model model,@RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page, 8);
        Page<Producto> listadoProducto = productoService.listarProductoPaginado(pageable);
        model.addAttribute("titulo","Lista Productos");
        model.addAttribute("producto",listadoProducto);
        return "panel";
    }

}
