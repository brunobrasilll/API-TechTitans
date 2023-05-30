package br.com.fiap.techtitansapi.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_NUTRICAO")
public class Nutricao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String calorias;
    @NotBlank
    private String gord_totais;
    @NotBlank
    private String gord_saturada;
    @NotBlank
    private String gord_trans;
    @NotBlank
    private String colesterol;
    @NotBlank
    private String sodio;
    @NotBlank
    private String carboidratos;
    @NotBlank
    private String acucar;
    @NotBlank
    private String proteinas;
    @NotBlank
    private String fibra_alimentar;
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalorias() {
        return this.calorias;
    }

    public void setCalorias(String calorias) {
        this.calorias = calorias;
    }

    public String getGord_totais() {
        return this.gord_totais;
    }

    public void setGord_totais(String gord_totais) {
        this.gord_totais = gord_totais;
    }

    public String getGord_saturada() {
        return this.gord_saturada;
    }

    public void setGord_saturada(String gord_saturada) {
        this.gord_saturada = gord_saturada;
    }

    public String getGord_trans() {
        return this.gord_trans;
    }

    public void setGord_trans(String gord_trans) {
        this.gord_trans = gord_trans;
    }

    public String getColesterol() {
        return this.colesterol;
    }

    public void setColesterol(String colesterol) {
        this.colesterol = colesterol;
    }

    public String getSodio() {
        return this.sodio;
    }

    public void setSodio(String sodio) {
        this.sodio = sodio;
    }

    public String getCarboidratos() {
        return this.carboidratos;
    }

    public void setCarboidratos(String carboidratos) {
        this.carboidratos = carboidratos;
    }

    public String getAcucar() {
        return this.acucar;
    }

    public void setAcucar(String acucar) {
        this.acucar = acucar;
    }

    public String getProteinas() {
        return this.proteinas;
    }

    public void setProteinas(String proteinas) {
        this.proteinas = proteinas;
    }

    public String getFibra_alimentar() {
        return this.fibra_alimentar;
    }

    public void setFibra_alimentar(String fibra_alimentar) {
        this.fibra_alimentar = fibra_alimentar;
    }


}
