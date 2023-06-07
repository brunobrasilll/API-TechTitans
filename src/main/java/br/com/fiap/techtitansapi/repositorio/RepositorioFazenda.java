package br.com.fiap.techtitansapi.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.fiap.techtitansapi.modelos.Fazenda;

public interface RepositorioFazenda extends CrudRepository<Fazenda, Integer> {
    
    //Fazendas
    List<Fazenda> findAll();
    Fazenda findByid(int id);
    int countByid(int id);

    public List<Fazenda> findByOrderByNomeFazenda();
    public List<Fazenda> findByOrderByEnderecoFazenda();
}


