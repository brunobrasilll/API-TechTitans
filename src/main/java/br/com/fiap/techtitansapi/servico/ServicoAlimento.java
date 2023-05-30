package br.com.fiap.techtitansapi.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fiap.techtitansapi.modelos.Alimento;
import br.com.fiap.techtitansapi.modelos.Mensagem;
import br.com.fiap.techtitansapi.repositorio.RepositorioAlimento;

@Service
public class ServicoAlimento {
    
    @Autowired
    private Mensagem mensagem;

    @Autowired
    private RepositorioAlimento acao;

    //Metodo para Cadastrar novo Alimento, Fazenda, Distribuidor.
    public ResponseEntity<?> cadastrar(Alimento obj){
        
        if(obj.getNome().equals("")){
            mensagem.setMensagem("O nome precisa ser preenchido");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
        }
    }

    //Metodo para selecionar alimentos
    public ResponseEntity<?> selecionar(){
        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
    }

    //Metodo para selecionar atraves do id
    public ResponseEntity<?> selecionarPeloId(int id){

        if(acao.countByid(id) == 0){
            mensagem.setMensagem("Não foi encontrado nenhum alimento.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.findByid(id), HttpStatus.OK);
        }
    }

    //Metodo para editar dados
    public ResponseEntity<?> editar(Alimento obj){

        if(acao.countByid(obj.getId()) == 0){
            mensagem.setMensagem("O id informado não existe.");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else if(obj.getNome().equals("")){
            mensagem.setMensagem("É necessario informar um nome.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getDescricao().equals("")){
            mensagem.setMensagem("É necessario informar uma descrição.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getCategoria().equals("")){
            mensagem.setMensagem("É necessario informar uma categoria.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.save(obj), HttpStatus.OK);
        }

    }

    //Metodo para remover registro
    public ResponseEntity<?> remover(int id){

        if(acao.countByid(id) == 0){
            mensagem.setMensagem("O id informado não existe.");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else{

            Alimento obj = acao.findByid(id);
            acao.delete(obj);

            mensagem.setMensagem("Alimento removido com sucesso!");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);

        }

    }
}
