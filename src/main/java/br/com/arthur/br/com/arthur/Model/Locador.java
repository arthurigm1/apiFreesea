package br.com.arthur.br.com.arthur.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity

public class Locador extends Usuario {

    @OneToMany()
    private List<Embarcacao> embarcacoes;

    public List<Embarcacao> getEmbarcacoes() {
        return embarcacoes;
    }

    public void setEmbarcacoes(List<Embarcacao> embarcacoes) {
        this.embarcacoes = embarcacoes;
    }

    // Getters e Setters
}
