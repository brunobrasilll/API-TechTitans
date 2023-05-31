package br.com.fiap.techtitansapi.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.fiap.techtitansapi.modelos.Usuario;

public interface RepositorioCadastro extends CrudRepository<Usuario, Integer> {
    
    //Distribuidor
    List<Usuario> findAll();
    Usuario findByid(int id);
    int countByid(int id);
}