package br.com.fiap.techtitansapi.modelos;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_FAZENDA")
public class Fazenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Digite o nome da Fazenda!")
    private String nomeFazenda;
    
    
    @NotBlank(message = "Digite o endereço da Fazenda!")
    private String enderecoFazenda;
    
    @NotBlank(message = "Digite o contato da Fazenda!")
    private String contatoFazenda;

    


    
    //Get e Set
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNomeFazenda() {
        return this.nomeFazenda;
    }

    public void setNomeFazenda(String nomeFazenda) {
        this.nomeFazenda = nomeFazenda;
    }

    public String getEnderecoFazenda() {
        return this.enderecoFazenda;
    }

    public void setEnderecoFazenda(String enderecoFazenda) {
        this.enderecoFazenda = enderecoFazenda;
    }

    public String getContatoFazenda() {
        return this.contatoFazenda;
    }

    public void setContatoFazenda(String contatoFazenda) {
        this.contatoFazenda = contatoFazenda;
    }
    
    
}

