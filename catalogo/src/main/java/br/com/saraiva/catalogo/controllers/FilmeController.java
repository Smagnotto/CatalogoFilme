package br.com.saraiva.catalogo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.saraiva.catalogo.domain.Filme;
import br.com.saraiva.catalogo.service.FilmeService;

/**
 * FilmeController
 */
@RestController
@RequestMapping(path = "/filme")
public class FilmeController {
    
    @Autowired
    private FilmeService service;

    @GetMapping(path = "/")
    public List<Filme> getAll() {
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public Filme getById(@PathVariable long id) {
        return service.getById(id);
    }
}