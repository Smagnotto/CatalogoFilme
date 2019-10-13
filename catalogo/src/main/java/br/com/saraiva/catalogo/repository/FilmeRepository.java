package br.com.saraiva.catalogo.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.saraiva.catalogo.domain.FilmeDomain;

/**
 * FilmeRepository
 */
public interface FilmeRepository extends CrudRepository<FilmeDomain, Long> {
    Iterable<FilmeDomain> findAllByusuario(String usuario);
}