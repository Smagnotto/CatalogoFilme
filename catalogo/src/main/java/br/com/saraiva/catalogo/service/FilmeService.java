package br.com.saraiva.catalogo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saraiva.catalogo.domain.FilmeDomain;
import br.com.saraiva.catalogo.repository.FilmeRepository;

/**
 * FilmeService
 */
@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;

    public List<FilmeDomain> getAll() {
        List<FilmeDomain> filmes = new ArrayList<>();
        repository.findAll().forEach(filme -> filmes.add(filme));
        return filmes;
    }

    public List<FilmeDomain> getAllByUser(String usuario) {
        List<FilmeDomain> filmes = new ArrayList<>();
        repository.findAllByusuario(usuario).forEach(filme -> filmes.add(filme));
        return filmes;
    }

    public FilmeDomain getById(long id) {
        return repository.findById(id).orElse(null);
    }

    public FilmeDomain addNewFilme(FilmeDomain filme) {
        return repository.save(filme);
    }

    public void updateFilme (FilmeDomain filme) {
        repository.save(filme);
    }

    public void deleteFilme(FilmeDomain filme) {
        repository.delete(filme);
    }
}