package br.com.saraiva.catalogo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saraiva.catalogo.domain.Filme;
import br.com.saraiva.catalogo.repository.FilmeRepository;

/**
 * FilmeService
 */
@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;

    public List<Filme> getAll() {
        List<Filme> filmes = new ArrayList<>();
        repository.findAll().forEach(filme -> filmes.add(filme));
        return filmes;
    }

    public Filme getById(long id) {
        return repository.findById(id).orElse(null);
    }
}