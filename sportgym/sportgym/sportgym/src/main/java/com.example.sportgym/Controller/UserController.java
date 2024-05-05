package com.example.sportgym.Controller;

import com.example.sportgym.Model.Prestamos;
import com.example.sportgym.Model.Producto;
import com.example.sportgym.Service.ProductoService;
import com.example.sportgym.Service.PrestamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.security.Principal;
import java.util.List;

/**
 * Controlador para las acciones del usuario en el sistema.
 */
@Controller
@RequestMapping("/cliente")
public class UserController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private PrestamosService prestamosService;

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

    /**
     * Maneja las solicitudes GET para mostrar el formulario de solicitud de préstamo.
     *
     * @param model El modelo utilizado para pasar datos a la vista.
     * @return La vista para mostrar el formulario de solicitud de préstamo.
     */
    @GetMapping("/solicitud")
    public String solicitud(Model model){
        Prestamos prestamos = new Prestamos();
        List<Producto> productoList = productoService.listarProducto();
        model.addAttribute("titulo","Solicitar Producto");
        model.addAttribute("prestamo", prestamos);
        model.addAttribute("producto",productoList);
        return "solicitud";
    }

    /**
     * Maneja las solicitudes POST para procesar la solicitud de préstamo.
     *
     * @param prestamo El objeto Prestamos que representa el préstamo a solicitar.
     * @param principal El objeto Principal que contiene información sobre el usuario autenticado.
     * @param redirectAttributes Atributos para redireccionamiento flash.
     * @return Redirecciona al panel principal del USER con un mensaje de éxito.
     */
    @PostMapping("/guardarPrestamos")
    public String procesarSolicitud(Prestamos prestamo, Principal principal, RedirectAttributes redirectAttributes) {
        String nombreUsuario = principal.getName();
        prestamo.setNombreUsuario(nombreUsuario);
        prestamosService.solicitudPrestamo(prestamo);
        redirectAttributes.addFlashAttribute("success","Solicitud Exitosa");
        return "redirect:/usuario/panelPrincipal";
    }

}
