package com.example.sportgym.Controller;

import com.example.sportgym.Model.CatProductos;
import com.example.sportgym.Service.CatProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador para la gestión de categorías de los productos de la tienda del gimnasio .
 */
@Controller
@RequestMapping("/administrador")
public class CategoriaController {

    @Autowired
    private CatProductosService catProductosService;

    /**
     * Maneja las solicitudes GET para mostrar el listado paginado de categorías.
     *
     * @param model El modelo utilizado para pasar datos a la vista.
     * @param page El número de página solicitado (por defecto es 0).
     * @return La vista para mostrar el listado de categorías.
     */
    @GetMapping("/listarCategorias")
    public String listarCategorias(Model model, @RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page, 10);
        Page<CatProductos> listadoProducto = catProductosService.listarCategoriasPaginado(pageable);
        model.addAttribute("titulo","Lista de Categorias");
        model.addAttribute("categorias",listadoProducto);
        return "listarCategorias";
    }

    /**
     * Maneja las solicitudes GET para mostrar el formulario de creación de categorías.
     *
     * @param model El modelo utilizado para pasar datos a la vista.
     * @return La vista para mostrar el formulario de creación de categorías.
     */
    @GetMapping("/nuevaCategoria")
    public String crear(Model model){
        CatProductos catProductos = new CatProductos();
        model.addAttribute("titulo","Agregar una Categoria");
        model.addAttribute("categoria",catProductos);
        return "crearCategoria";
    }

    /**
     * Maneja las solicitudes POST para guardar una nueva categoría.
     *
     * @param catProductos El objeto CatImplementos que representa la categoría a guardar.
     * @param redirectAttributes Atributos para redireccionamiento flash.
     * @return Redirecciona al formulario de creación de implementos con un mensaje de éxito.
     */
    @PostMapping("/guardarCategoria")
    public String guadar(@ModelAttribute("categorias") CatProductos catProductos,
                         RedirectAttributes redirectAttributes){
        catProductosService.guadar_categoria(catProductos);
        redirectAttributes.addFlashAttribute("success","Categoria creada con Éxito");
        return "redirect:/administrador/crearProducto";
    }

}
