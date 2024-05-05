package com.example.sportgym.Controller;

import com.example.sportgym.Model.CatImplementos;
import com.example.sportgym.Model.Inventario;
import com.example.sportgym.Service.CatImplementosService;
import com.example.sportgym.Service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

/**
 * Controlador para la gestión del inventario de implementos deportivos en el sistema.
 */
@Controller
@RequestMapping("/administrador")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private CatImplementosService catImplementosService;

    /**
     * Maneja las solicitudes GET para mostrar el listado paginado de inventario.
     *
     * @param model El modelo utilizado para pasar datos a la vista.
     * @param page El número de página solicitado (por defecto es 0).
     * @return La vista para mostrar el listado de inventario.
     */
    @GetMapping("/inventarioImplementos")
    public String listarInventario(Model model, @RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page, 8);
        Page<Inventario> listadoInventario = inventarioService.listarInventarioPaginado(pageable);
        model.addAttribute("titulo","Tienda");
        model.addAttribute("inventario",listadoInventario);
        return "listarInventario";
    }

    /**
     * Maneja las solicitudes GET para mostrar el formulario de creación de implementos.
     *
     * @param model El modelo utilizado para pasar datos a la vista.
     * @return La vista para mostrar el formulario de creación de implementos.
     */
    @GetMapping("/crearImplemento")
    public String crear(Model model){
        Inventario inventario = new Inventario();
        List<CatImplementos> listCategorias = catImplementosService.listarCategorias();
        model.addAttribute("titulo","Crear un producto");
        model.addAttribute("implemento",inventario);
        model.addAttribute("categorias",listCategorias);
        return "crearImplemento";
    }

    /**
     * Maneja las solicitudes POST para guardar un nuevo implemento.
     *
     * @param inventario El objeto Inventario que representa el implemento a guardar.
     * @param redirectAttributes Atributos para redireccionamiento flash.
     * @return Redirecciona al listado de inventario con un mensaje de éxito.
     */

    @PostMapping("/guardarImplemento")
    public String guardar(@ModelAttribute Inventario inventario,
                          RedirectAttributes redirectAttributes) {

        // Guardar el inventario sin verificar la disponibilidad
        inventarioService.guardar(inventario);

        // Agregar mensaje de éxito para redireccionamiento
        redirectAttributes.addFlashAttribute("success", "Implemento guardado con éxito");

        // Redirigir al listado de inventario
        return "redirect:/administrador/inventarioImplementos";
    }


    /**
     * Maneja las solicitudes GET para mostrar el formulario de edición de implementos.
     *
     * @param idInventario El ID del implemento a editar.
     * @param model El modelo utilizado para pasar datos a la vista.
     * @param redirectAttributes Atributos para redireccionamiento flash.
     * @return La vista para mostrar el formulario de edición de implementos.
     */
    @GetMapping("/editarImplemento/{id}")
    public String editar(@PathVariable("id")Long idInventario, Model model, RedirectAttributes redirectAttributes){

        if(idInventario <= 0){
            redirectAttributes.addFlashAttribute("error", "Atención: Error con el ID del implemento");
            return "redirect:/administrador/inventarioImplementos";
        }

        Inventario inventario = inventarioService.buscarPorId(idInventario);

        if(inventario == null){
            redirectAttributes.addFlashAttribute("error", "Atención: El ID del implemento no existe");
            return "redirect:/administrador/inventarioImplementos";
        }

        List<CatImplementos> listCategorias = catImplementosService.listarCategorias();
        model.addAttribute("titulo","Editar Implemento");
        model.addAttribute("implemento",inventario);
        model.addAttribute("categorias",listCategorias);
        return "crearImplemento";
    }

    /**
     * Maneja las solicitudes GET para eliminar un implemento.
     *
     * @param idInventario El ID del implemento a eliminar.
     * @param redirectAttributes Atributos para redireccionamiento flash.
     * @return Redirecciona al listado de inventario con un mensaje de éxito.
     */
    @GetMapping("/eliminarImplemento/{id}")
    public String eliminar(@PathVariable ("id")Long idInventario, RedirectAttributes redirectAttributes){

        if(idInventario <= 0){
            redirectAttributes.addFlashAttribute("error", "Atención: El ID del implemento no es válido");
            return "redirect:/administrador/inventarioImplementos";
        }

        Inventario inventario = inventarioService.buscarPorId(idInventario);

        if(inventario == null){
            redirectAttributes.addFlashAttribute("error", "Atención: El ID del implemento no existe");
            return "redirect:/administrador/inventarioImplementos";
        }

        inventarioService.eliminar(idInventario);
        redirectAttributes.addFlashAttribute("warning", "Implemento eliminado con éxito");
        return "redirect:/administrador/inventarioImplementos";
    }
}
