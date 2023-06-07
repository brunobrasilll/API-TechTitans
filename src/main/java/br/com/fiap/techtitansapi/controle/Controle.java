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
import br.com.fiap.techtitansapi.modelos.Usuario;
import br.com.fiap.techtitansapi.servico.ServicoAlimento;
import br.com.fiap.techtitansapi.servico.ServicoCadastro;
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

    @Autowired
    private ServicoCadastro servicoCadastro;

    // Cadastro de Usuario
    @GetMapping("/usuario")
    public ResponseEntity<?> selecionarUsuario() {
        return servicoCadastro.selecionarUsuario();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> selecionarPorIdUsuario(@PathVariable int id) {
        return servicoCadastro.selecionarPeloIdUsuario(id);
    }
    
    @PostMapping("/usuario")
    public ResponseEntity<?> cadastrarUsuario(@Valid @RequestBody Usuario obj){
        return servicoCadastro.cadastrarUsuario(obj);
    }

    @PutMapping("/usuario")
    public ResponseEntity<?> editarUsuario(@RequestBody Usuario obj){
        return servicoCadastro.editarUsuario(obj);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<?> removerUsuario(@PathVariable int id){
        return servicoCadastro.removerUsuario(id);
    }


    // Alimentos
    @GetMapping("/alimento")
    public ResponseEntity<?> selecionar() {
        return servicoAlimento.selecionar();
    }

    @GetMapping("/alimento/{id}")
    public ResponseEntity<?> selecionarPorId(@PathVariable int id) {
        return servicoAlimento.selecionarPeloId(id);
    }

    @GetMapping("/alimento/sortByNome")
    public ResponseEntity<?> ordernarPorNome() {
        return servicoAlimento.ordernarPorNome();
    }

    @GetMapping("/alimento/sortByData")
    public ResponseEntity<?> ordernarPorData() {
        return servicoAlimento.ordernarPorData();
    }
    
    @PostMapping("/alimento")
    public ResponseEntity<?> cadastrar(@RequestBody Alimento obj){
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

    @GetMapping("/fazenda/sortByNomeFazenda")
    public ResponseEntity<?> ordernarPorNomeFazenda() {
        return servicoFazenda.ordernarPorNomeFazenda();
    }

    @GetMapping("/fazenda/sortByEnderecoFazenda")
    public ResponseEntity<?> ordernarPorEnderecoFazenda() {
        return servicoFazenda.ordernarPorEnderecoFazenda();
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

    @GetMapping("/distribuidor/sortByNomeDistribuidor")
    public ResponseEntity<?> ordernarPorNomeDistribuidor() {
        return servicoDistribuidor.ordernarPorNomeDistribuidor();
    }

    @GetMapping("/distribuidor/sortByEnderecoDistribuidor")
    public ResponseEntity<?> ordernarPorEnderecoDistribuidor() {
        return servicoDistribuidor.ordernarPorEnderecoDistribuidor();
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
