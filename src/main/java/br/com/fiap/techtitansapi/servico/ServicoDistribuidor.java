package br.com.fiap.techtitansapi.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fiap.techtitansapi.modelos.Distribuidor;
import br.com.fiap.techtitansapi.modelos.Mensagem;
import br.com.fiap.techtitansapi.repositorio.RepositorioDistribuidor;

@Service
public class ServicoDistribuidor {
    
    @Autowired
    private Mensagem mensagem;

    @Autowired
    private RepositorioDistribuidor acao;

    //Metodo para Cadastrar novo Alimento, Fazenda, Distribuidor.
    public ResponseEntity<?> cadastrarDistribuidor(Distribuidor obj){
        
        if(obj.getNomeDistribuidor().equals("")){
            mensagem.setMensagem("O nome precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getEnderecoDistribuidor().equals("")){
            mensagem.setMensagem("O endereço precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getContatoDistribuidor().equals("")){
            mensagem.setMensagem("O contato precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
        }
    }

    //Metodo para selecionar alimentos
    public ResponseEntity<?> selecionarDistribuidor(){
        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
    }

    //Metodo para selecionar atraves do id
    public ResponseEntity<?> selecionarPeloIdDistribuidor(int id){

        if(acao.countByid(id) == 0){
            mensagem.setMensagem("Não foi encontrado nenhum Distribuidor registrado.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.findByid(id), HttpStatus.OK);
        }
    }

    //Metodo para editar dados
    public ResponseEntity<?> editarDistribuidor(Distribuidor obj){

        if(acao.countByid(obj.getId()) == 0){
            mensagem.setMensagem("O id informado não existe.");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else if(obj.getNomeDistribuidor().equals("")){
            mensagem.setMensagem("É necessario informar o nome do Distribuidor.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getEnderecoDistribuidor().equals("")){
            mensagem.setMensagem("É necessario informar o endereço do Distribuidor.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getContatoDistribuidor().equals("")){
            mensagem.setMensagem("É necessario informar o contato do Distribuidor.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.save(obj), HttpStatus.OK);
        }

    }

    //Metodo para remover registro
    public ResponseEntity<?> removerDistribuidor(int id){

        if(acao.countByid(id) == 0){
            mensagem.setMensagem("O id informado não existe.");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else{

            Distribuidor obj = acao.findByid(id);
            acao.delete(obj);

            mensagem.setMensagem("Distribuidor removido com sucesso!");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);

        }

    }
}
