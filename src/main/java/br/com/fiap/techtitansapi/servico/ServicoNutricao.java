package br.com.fiap.techtitansapi.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fiap.techtitansapi.modelos.Mensagem;
import br.com.fiap.techtitansapi.modelos.Nutricao;
import br.com.fiap.techtitansapi.repositorio.RepositorioNutricao;

@Service
public class ServicoNutricao {
    
    @Autowired
    private Mensagem mensagem;

    @Autowired
    private RepositorioNutricao acao;

    //Metodo para Cadastrar novo Alimento, Fazenda, Distribuidor.
    public ResponseEntity<?> cadastrarNutricao(Nutricao obj){
        
        if(obj.getCalorias().equals("")){
            mensagem.setMensagem("A quantidade de calorias precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getGord_totais().equals("")){
            mensagem.setMensagem("A quantidade de gordura total precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getGord_saturada().equals("")){
            mensagem.setMensagem("A quantidade de gordura saturada precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getGord_trans().equals("")){
            mensagem.setMensagem("A quantidade de gordura trans precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getAcucar().equals("")){
            mensagem.setMensagem("A quantidade de Açúcar precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getCarboidratos().equals("")){
            mensagem.setMensagem("A quantidade de carboidratos ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getColesterol().equals("")){
            mensagem.setMensagem("A quantidade de colesterol precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getFibra_alimentar().equals("")){
            mensagem.setMensagem("A quantidade de fibra alimentar precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getSodio().equals("")){
            mensagem.setMensagem("A quantidade de sódio precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getProteinas().equals("")){
            mensagem.setMensagem("A quantidade de proteinas precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
        }
    }

    //Metodo para selecionar Nutrição
    public ResponseEntity<?> selecionarNutricao(){
        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
    }

    //Metodo para selecionar atraves do id
    public ResponseEntity<?> selecionarPeloIdNutricao(int id){

        if(acao.countByid(id) == 0){
            mensagem.setMensagem("Não foi encontrado nenhum id registrado.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.findByid(id), HttpStatus.OK);
        }
    }

    //Metodo para editar dados
    public ResponseEntity<?> editarNutricao(Nutricao obj){

        if(acao.countByid(obj.getId()) == 0){
            mensagem.setMensagem("O id informado não existe.");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else if(obj.getCalorias().equals("")){
            mensagem.setMensagem("A quantidade de calorias precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getGord_totais().equals("")){
            mensagem.setMensagem("A quantidade de gordura total precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getGord_saturada().equals("")){
            mensagem.setMensagem("A quantidade de gordura saturada precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getGord_trans().equals("")){
            mensagem.setMensagem("A quantidade de gordura trans precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getAcucar().equals("")){
            mensagem.setMensagem("A quantidade de Açúcar precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getCarboidratos().equals("")){
            mensagem.setMensagem("A quantidade de carboidratos ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getColesterol().equals("")){
            mensagem.setMensagem("A quantidade de colesterol precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getFibra_alimentar().equals("")){
            mensagem.setMensagem("A quantidade de fibra alimentar precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getSodio().equals("")){
            mensagem.setMensagem("A quantidade de sódio precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getProteinas().equals("")){
            mensagem.setMensagem("A quantidade de proteinas precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.save(obj), HttpStatus.OK);
        }
    }

    //Metodo para remover registro
    public ResponseEntity<?> removerNutricao(int id){

        if(acao.countByid(id) == 0){
            mensagem.setMensagem("O id informado não existe.");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else{

            Nutricao obj = acao.findByid(id);
            acao.delete(obj);

            mensagem.setMensagem("Nutrição removida com sucesso!");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);

        }

    }
}
