package br.com.fiap.techtitansapi.servico;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.fiap.techtitansapi.modelos.Mensagem;
import br.com.fiap.techtitansapi.modelos.Usuario;
import br.com.fiap.techtitansapi.repositorio.RepositorioCadastro;

@Service
public class ServicoCadastro {
    
    @Autowired
    private Mensagem mensagem;

    @Autowired
    private RepositorioCadastro acao;

    //Metodo para Cadastrar novo Alimento, Fazenda, Distribuidor.
    public ResponseEntity<?> cadastrarUsuario(Usuario obj){
        
        if(obj.getEmail().equals("")){
            mensagem.setMensagem("O email precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getUsername().equals("")){
            mensagem.setMensagem("O nome de usuario precisa ser preenchido!");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getPassword().equals("")){
            mensagem.setMensagem("Digite uma senha valida");;
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
        }
    }

    //Metodo para selecionar usuario
    public ResponseEntity<?> selecionarUsuario(){
        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
    }

    //Metodo para selecionar atraves do id
    public ResponseEntity<?> selecionarPeloIdUsuario(int id){

        if(acao.countByid(id) == 0){
            mensagem.setMensagem("Não foi encontrado nenhum Distribuidor registrado.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.findByid(id), HttpStatus.OK);
        }
    }

    //Metodo para editar dados
    public ResponseEntity<?> editarUsuario(Usuario obj){

        if(acao.countByid(obj.getid()) == 0){
            mensagem.setMensagem("O id informado não existe.");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else if(obj.getEmail().equals("")){
            mensagem.setMensagem("É necessario informar o email do usuario.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getUsername().equals("")){
            mensagem.setMensagem("É necessario informar o nome de usuario.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getPassword().equals("")){
            mensagem.setMensagem("É necessario informar a senha do usuario.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.save(obj), HttpStatus.OK);
        }

    }

    //Metodo para remover registro
    public ResponseEntity<?> removerUsuario(int id){

        if(acao.countByid(id) == 0){
            mensagem.setMensagem("O id informado não existe.");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else{

            Usuario obj = acao.findByid(id);
            acao.delete(obj);

            mensagem.setMensagem("Usuario removido com sucesso!");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);

        }

    }
}
