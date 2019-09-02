package br.com.saraiva.catalogo.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.saraiva.catalogo.domain.Filme;

/**
 * FilmeRepository
 */
public interface FilmeRepository extends CrudRepository<Filme, Long> {
    
}