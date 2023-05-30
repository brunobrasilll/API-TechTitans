package br.com.fiap.techtitansapi.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.fiap.techtitansapi.modelos.Alimento;

public interface RepositorioAlimento extends CrudRepository<Alimento, Integer> {
    
    //Alimentos
    List<Alimento> findAll();
    Alimento findByid(int id);
    int countByid(int id);
}


