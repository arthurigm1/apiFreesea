package br.com.arthur.br.com.arthur.Controller;

import javax.print.DocFlavor.STRING;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerPrincipal {
    @GetMapping("/")
    public String getIndex(){
    return "index";
    }
}
