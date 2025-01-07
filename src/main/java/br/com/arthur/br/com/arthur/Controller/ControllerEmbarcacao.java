package br.com.arthur.br.com.arthur.Controller;


import br.com.arthur.br.com.arthur.Model.Embarcacao;
import br.com.arthur.br.com.arthur.Model.Locador;
import br.com.arthur.br.com.arthur.Model.Usuario;
import br.com.arthur.br.com.arthur.Service.ServiceEmbarcacao;
import br.com.arthur.br.com.arthur.Service.ServiceLocador;
import br.com.arthur.br.com.arthur.Service.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/embarcacoes")
public class ControllerEmbarcacao {

    @Autowired
    private ServiceEmbarcacao serviceEmbarcacao;
    @Autowired
    private ServiceLocador serviceLocador;

    @GetMapping(value = "")
    public String listAll(Model model) {
        model.addAttribute("embarcacoes", serviceEmbarcacao.getAllUsuarios());

        return "embarcacoes/embarcacoes";
    }

    @GetMapping("/novaembarcacao")
    public String novaembarcacao(Model model) {
        List<Locador> locadores = serviceLocador.listarLocadores();
        model.addAttribute("locadores", locadores);
        model.addAttribute("embarcacao", new Embarcacao());

        return "embarcacoes/novaembarcacao";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Embarcacao embarcacao) {
        serviceEmbarcacao.createOrUpdateUsuario(embarcacao);
        return "redirect:/embarcacoes";
    }

    @GetMapping(value = "/excluir/{codigo}")
    public String excluir(@PathVariable("codigo") int codigo) {
        Embarcacao embarcacao = serviceEmbarcacao.getUsuarioById(codigo);
        serviceEmbarcacao.deleteUsuario(embarcacao);
        return "redirect:/embarcacoes";
    }

    @GetMapping(value = "/editar/{codigo}")
    public String editar(@PathVariable("codigo") int id, Model model) {
        Embarcacao embarcacao = serviceEmbarcacao.getUsuarioById(id);
        model.addAttribute("embarcacao", embarcacao);

        return "embarcacoes/novaembarcacao";
    }
}
