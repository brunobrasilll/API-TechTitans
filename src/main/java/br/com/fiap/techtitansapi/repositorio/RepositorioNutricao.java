package br.com.fiap.techtitansapi.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.fiap.techtitansapi.modelos.Nutricao;

public interface RepositorioNutricao extends CrudRepository<Nutricao, Integer> {
    
    //Distribuidor
    List<Nutricao> findAll();
    Nutricao findByid(int id);
    int countByid(int id);
}