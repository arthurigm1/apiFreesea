package br.com.arthur.br.com.arthur.Controller;


import br.com.arthur.br.com.arthur.Model.Usuario;
import br.com.arthur.br.com.arthur.Service.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class ControllerUsuario {
    @Autowired
    private ServiceUsuario serviceUsuario;


    @GetMapping(value = "")
    public String listAll(Model model) {
        model.addAttribute("usuarios", serviceUsuario.getAllUsuarios());

        return "usuarios/usuarios";
    }

    @GetMapping("/novousuario")
    public String novousuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/novousuario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Usuario usuario) {
        serviceUsuario.createOrUpdateUsuario(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping(value = "/excluir/{codigo}")
    public String excluir(@PathVariable("codigo") int codigo) {
        Usuario usuario = serviceUsuario.getUsuarioById(codigo);
        serviceUsuario.deleteUsuario(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping(value = "/editar/{codigo}")
    public String editar(@PathVariable("codigo") int id, Model model) {
        Usuario usuario = serviceUsuario.getUsuarioById(id);
        model.addAttribute("usuario", usuario);

        return "usuarios/novousuario";
    }
}
