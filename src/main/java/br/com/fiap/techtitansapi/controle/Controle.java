package br.com.fiap.techtitansapi.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.techtitansapi.modelos.Alimento;
import br.com.fiap.techtitansapi.modelos.Distribuidor;
import br.com.fiap.techtitansapi.modelos.Fazenda;
import br.com.fiap.techtitansapi.modelos.Nutricao;
import br.com.fiap.techtitansapi.servico.ServicoAlimento;
import br.com.fiap.techtitansapi.servico.ServicoDistribuidor;
import br.com.fiap.techtitansapi.servico.ServicoFazenda;
import br.com.fiap.techtitansapi.servico.ServicoNutricao;
import jakarta.validation.Valid;

@RestController
public class Controle {

    @Autowired
    private ServicoAlimento servicoAlimento;

    @Autowired
    private ServicoFazenda servicoFazenda;

    @Autowired
    private ServicoDistribuidor servicoDistribuidor;
    
    @Autowired
    private ServicoNutricao servicoNutricao;

    @GetMapping("/alimento")
    public ResponseEntity<?> selecionar() {
        return servicoAlimento.selecionar();
    }

    @GetMapping("/alimento/{id}")
    public ResponseEntity<?> selecionarPorId(@PathVariable int id) {
        return servicoAlimento.selecionarPeloId(id);
    }
    
    @PostMapping("/alimento")
    public ResponseEntity<?> cadastrar(@Valid @RequestBody Alimento obj){
        return servicoAlimento.cadastrar(obj);
    }

    @PutMapping("/alimento")
    public ResponseEntity<?> editar(@RequestBody Alimento obj){
        return servicoAlimento.editar(obj);
    }

    @DeleteMapping("/alimento/{id}")
    public ResponseEntity<?> remover(@PathVariable int id){
        return servicoAlimento.remover(id);
    }

    //endpoints Fazenda
    @GetMapping("/fazenda")
    public ResponseEntity<?> selecionarFazenda() {
        return servicoFazenda.selecionarFazenda();
    }

    @GetMapping("/fazenda/{id}")
    public ResponseEntity<?> selecionarPorIdFazenda(@PathVariable int id) {
        return servicoFazenda.selecionarPeloIdFazenda(id);
    }
    
    @PostMapping("/fazenda")
    public ResponseEntity<?> cadastrarFazenda(@Valid @RequestBody Fazenda obj){
        return servicoFazenda.cadastrarFazenda(obj);
    }

    @PutMapping("/fazenda")
    public ResponseEntity<?> editarFazenda(@RequestBody Fazenda obj){
        return servicoFazenda.editarFazenda(obj);
    }

    @DeleteMapping("/fazenda/{id}")
    public ResponseEntity<?> removerFazenda(@PathVariable int id){
        return servicoFazenda.removerFazenda(id);
    }

    //endpoints Distribuidor
    @GetMapping("/distribuidor")
    public ResponseEntity<?> selecionarDistribuidor() {
        return servicoDistribuidor.selecionarDistribuidor();
    }

    @GetMapping("/distribuidor/{id}")
    public ResponseEntity<?> selecionarPorIdDistribuidor(@PathVariable int id) {
        return servicoDistribuidor.selecionarPeloIdDistribuidor(id);
    }
    
    @PostMapping("/distribuidor")
    public ResponseEntity<?> cadastrarDistribuidor(@Valid @RequestBody Distribuidor obj){
        return servicoDistribuidor.cadastrarDistribuidor(obj);
    }

    @PutMapping("/distribuidor")
    public ResponseEntity<?> editarDistribuidor(@RequestBody Distribuidor obj){
        return servicoDistribuidor.editarDistribuidor(obj);
    }

    @DeleteMapping("/distribuidor/{id}")
    public ResponseEntity<?> removerDistribuidor(@PathVariable int id){
        return servicoDistribuidor.removerDistribuidor(id);
    }

    //endpoints Nutrição
    @GetMapping("/nutricao")
    public ResponseEntity<?> selecionarNutricao() {
        return servicoNutricao.selecionarNutricao();
    }

    @GetMapping("/nutricao/{id}")
    public ResponseEntity<?> selecionarPorIdNutricao(@PathVariable int id) {
        return servicoNutricao.selecionarPeloIdNutricao(id);
    }
    
    @PostMapping("/nutricao")
    public ResponseEntity<?> cadastrarNutricao(@Valid @RequestBody Nutricao obj){
        return servicoNutricao.cadastrarNutricao(obj);
    }

    @PutMapping("/nutricao")
    public ResponseEntity<?> editarNutricao(@RequestBody Nutricao obj){
        return servicoNutricao.editarNutricao(obj);
    }

    @DeleteMapping("/nutricao/{id}")
    public ResponseEntity<?> removerNutricao(@PathVariable int id){
        return servicoNutricao.removerNutricao(id);
    }

}
