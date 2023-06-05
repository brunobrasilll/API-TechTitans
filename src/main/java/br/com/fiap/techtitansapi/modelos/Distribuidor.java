package br.com.fiap.techtitansapi.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_DISTRIBUIDOR")
public class Distribuidor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Digite o nome do distribuidor!")
    private String nomeDistribuidor;
    @NotBlank(message = "Digite o endereço do distribuidor!")
    private String enderecoDistribuidor;
    @NotBlank(message = "Digite o contato do distribuidor!")
    private String contatoDistribuidor;

    @OneToMany
    @JoinColumn(name = "id_fazenda")
    private Fazenda fazenda;

    //Get e Set
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNomeDistribuidor() {
        return this.nomeDistribuidor;
    }

    public void setNomeDistribuidor(String nomeDistribuidor) {
        this.nomeDistribuidor = nomeDistribuidor;
    }

    public String getEnderecoDistribuidor() {
        return this.enderecoDistribuidor;
    }

    public void setEnderecoDistribuidor(String enderecoDistribuidor) {
        this.enderecoDistribuidor = enderecoDistribuidor;
    }

    public String getContatoDistribuidor() {
        return this.contatoDistribuidor;
    }

    public void setContatoDistribuidor(String contatoDistribuidor) {
        this.contatoDistribuidor = contatoDistribuidor;
    }
    


}
