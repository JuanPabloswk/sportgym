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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador para la gestión de la tienda de productos del gimnasio
 */
@Controller
@RequestMapping("/administrador")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    /**
     * Maneja las solicitudes GET para mostrar el listado paginado de productos.
     *
     * @param model El modelo utilizado para pasar datos a la vista.
     * @param page El número de página solicitado (por defecto es 0).
     * @return La vista para mostrar el listado de producto.
     */
    @GetMapping("/tiendaProductos")
    public String listarProducto(Model model, @RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page, 8);
        Page<Producto> listadoProducto = productoService.listarProductoPaginado(pageable);
        model.addAttribute("titulo","Tienda");
        model.addAttribute("producto",listadoProducto);
        return "listarProducto";
    }

    /**
     * Maneja las solicitudes GET para mostrar el formulario de creación de productos.
     *
     * @param model El modelo utilizado para pasar datos a la vista.
     * @return La vista para mostrar el formulario de creación de productos.
     */
    @GetMapping("/crearProducto")
    public String crear(Model model){
        Producto producto = new Producto();
        model.addAttribute("titulo","Crear un Producto");
        model.addAttribute("producto",producto);
        return "crearProducto";
    }

    /**
     * Maneja las solicitudes POST para guardar un nuevo producto.
     *
     * @param producto El objeto Producto que representa el producto a guardar.
     * @param redirectAttributes Atributos para redireccionamiento flash.
     * @return Redirecciona al listado de producto con un mensaje de éxito.
     */
    @PostMapping("/guardarProducto")
    public String guardar(@ModelAttribute Producto producto,
                          RedirectAttributes redirectAttributes) {

        productoService.guardar(producto);
        redirectAttributes.addFlashAttribute("success","Producto guardado con éxito");
        return "redirect:/administrador/tiendaProductos";
    }

    /**
     * Maneja las solicitudes GET para mostrar el formulario de edición de productos.
     *
     * @param idProducto El ID del producto a editar.
     * @param model El modelo utilizado para pasar datos a la vista.
     * @param redirectAttributes Atributos para redireccionamiento flash.
     * @return La vista para mostrar el formulario de edición de productos.
     */
    @GetMapping("/editarProducto/{id}")
    public String editar(@PathVariable("id")Long idProducto, Model model, RedirectAttributes redirectAttributes){

        if(idProducto <= 0){
            redirectAttributes.addFlashAttribute("error", "Atención: Error con el ID del producto");
            return "redirect:/administrador/tiendaProductos";
        }

        Producto producto = productoService.buscarPorId(idProducto);

        if(producto == null){
            redirectAttributes.addFlashAttribute("error", "Atención: El ID del producto no existe");
            return "redirect:/administrador/tiendaProductos";
        }

        model.addAttribute("titulo","Editar ProductoTienda");
        model.addAttribute("producto",producto);
        return "crearProducto";
    }

    /**
     * Maneja las solicitudes GET para eliminar un producto.
     *
     * @param idProducto El ID del producto a eliminar.
     * @param redirectAttributes Atributos para redireccionamiento flash.
     * @return Redirecciona al listado de producto con un mensaje de éxito.
     */
    @GetMapping("/eliminarProducto/{id}")
    public String eliminar(@PathVariable ("id")Long idProducto, RedirectAttributes redirectAttributes){

        if(idProducto <= 0){
            redirectAttributes.addFlashAttribute("error", "Atención: El ID del producto no es válido");
            return "redirect:/administrador/tiendaProductos";
        }

        Producto producto = productoService.buscarPorId(idProducto);

        if(producto == null){
            redirectAttributes.addFlashAttribute("error", "Atención: El ID del producto no existe");
            return "redirect:/administrador/tiendaProductos";
        }

        productoService.eliminar(idProducto);
        redirectAttributes.addFlashAttribute("warning", "Producto eliminado con éxito");
        return "redirect:/administrador/tiendaProductos";
    }


}
