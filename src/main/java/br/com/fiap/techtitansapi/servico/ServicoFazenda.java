package br.com.fiap.techtitansapi.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fiap.techtitansapi.modelos.Fazenda;
import br.com.fiap.techtitansapi.modelos.Mensagem;
import br.com.fiap.techtitansapi.repositorio.RepositorioFazenda;

@Service
public class ServicoFazenda {
    
    @Autowired
    private Mensagem mensagem;

    @Autowired
    private RepositorioFazenda acao;

    //Metodo para Cadastrar novo Alimento, Fazenda, Distribuidor.
    public ResponseEntity<?> cadastrarFazenda(Fazenda obj){
        
        if(obj.getNomeFazenda().equals("")){
            mensagem.setMensagem("O nome precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getEnderecoFazenda().equals("")){
            mensagem.setMensagem("O endereço precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getContatoFazenda().equals("")){
            mensagem.setMensagem("O contato precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
        }
    }

    //Metodo para selecionar alimentos
    public ResponseEntity<?> selecionarFazenda(){
        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
    }

    //Metodo para selecionar atraves do id
    public ResponseEntity<?> selecionarPeloIdFazenda(int id){

        if(acao.countByid(id) == 0){
            mensagem.setMensagem("Não foi encontrado nenhuma fazenda registrada.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.findByid(id), HttpStatus.OK);
        }
    }

    //Metodo para editar dados
    public ResponseEntity<?> editarFazenda(Fazenda obj){

        if(acao.countByid(obj.getId()) == 0){
            mensagem.setMensagem("O id informado não existe.");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else if(obj.getNomeFazenda().equals("")){
            mensagem.setMensagem("É necessario informar o nome da Fazenda.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getEnderecoFazenda().equals("")){
            mensagem.setMensagem("É necessario informar o endereço da Fazenda.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getContatoFazenda().equals("")){
            mensagem.setMensagem("É necessario informar o contato da Fazenda.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.save(obj), HttpStatus.OK);
        }

    }

    //Metodo para remover registro
    public ResponseEntity<?> removerFazenda(int id){

        if(acao.countByid(id) == 0){
            mensagem.setMensagem("O id informado não existe.");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else{

            Fazenda obj = acao.findByid(id);
            acao.delete(obj);

            mensagem.setMensagem("Fazenda removida com sucesso!");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);

        }

    }
}
