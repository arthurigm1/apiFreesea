package br.com.arthur.br.com.arthur.Model;

import jakarta.persistence.*;

@Entity
public class Embarcacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Locador locador;
    private String nome;

    private String tipo;
    private Integer valor_locacao;

    public Integer getValor_locacao() {
        return valor_locacao;
    }

    public void setValor_locacao(Integer valor_locacao) {
        this.valor_locacao = valor_locacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Locador getLocador() {
        return locador;
    }

    public void setLocador(Locador locador) {
        this.locador = locador;
    }
}
