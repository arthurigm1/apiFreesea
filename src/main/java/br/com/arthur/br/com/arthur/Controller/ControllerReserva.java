package br.com.arthur.br.com.arthur.Controller;

import br.com.arthur.br.com.arthur.Model.*;
import br.com.arthur.br.com.arthur.Repository.RepositoryEmbarcacao;
import br.com.arthur.br.com.arthur.Repository.RepositoryLocador;
import br.com.arthur.br.com.arthur.Repository.RepositoryLocatario;
import br.com.arthur.br.com.arthur.Repository.RepositoryReserva;
import br.com.arthur.br.com.arthur.Service.ServiceReserva;
import br.com.arthur.br.com.arthur.Service.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservas")
public class ControllerReserva {

    @Autowired
    private RepositoryEmbarcacao embarcacaoRepository;

    @Autowired
    private RepositoryLocatario repositoryLocatario;

    @Autowired
    private RepositoryReserva reservaRepository;
    @Autowired
    private ServiceReserva serviceReserva;


    @GetMapping(value = "")
    public String listAll(Model model) {
        model.addAttribute("reservas", serviceReserva.getAllUsuarios());

        return "reservas/reservas";
    }

    @GetMapping("/novareserva")
    public String novareserva(Model model) {
        List<Embarcacao> embarcacoes = embarcacaoRepository.findAll();
        List<Locatario> locatarios = repositoryLocatario.findAll();
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("embarcacoes", embarcacoes);
        model.addAttribute("locatarios", locatarios);

        return "reservas/novareserva";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Reserva reserva) {
        serviceReserva.createOrUpdateUsuario(reserva);
        return "redirect:/reservas";
    }

    @GetMapping(value = "/excluir/{codigo}")
    public String excluir(@PathVariable("codigo") int codigo) {
        Reserva reserva = serviceReserva.getUsuarioById(codigo);
        serviceReserva.deleteUsuario(reserva);
        return "redirect:/reservas";
    }

    @GetMapping(value = "/editar/{codigo}")
    public String editar(@PathVariable("codigo") int id, Model model) {
        Reserva reserva = serviceReserva.getUsuarioById(id);
        model.addAttribute("reserva", reserva);

        return "reservas/novareserva";
    }
}
