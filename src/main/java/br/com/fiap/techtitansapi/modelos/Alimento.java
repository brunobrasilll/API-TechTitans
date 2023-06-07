package br.com.fiap.techtitansapi.modelos;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_ALIMENTOS")
public class Alimento {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotBlank(message = "Digite o nome do produto!")
    private String nome;

    @NotBlank(message = "Digite uma descrição para o produto!")
    private String descricao;
    @NotBlank(message = "Digite a categoria do produto!")
    private String categoria;
    @NotBlank(message = "Digite a origem do produto!")
    private String origem;
    private Date data;

    @ManyToOne
    @JoinColumn(name = "id_distribuidor")
    private Distribuidor distribuidor;

    @ManyToOne
    @JoinColumn(name = "id_fazenda")
    private Fazenda fazenda;


    //Getters e Setters
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getOrigem() {
        return this.origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
