package br.com.fiap.techtitansapi.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.fiap.techtitansapi.modelos.Distribuidor;

public interface RepositorioDistribuidor extends CrudRepository<Distribuidor, Integer> {
    
    //Distribuidor
    List<Distribuidor> findAll();
    Distribuidor findByid(int id);
    int countByid(int id);
}