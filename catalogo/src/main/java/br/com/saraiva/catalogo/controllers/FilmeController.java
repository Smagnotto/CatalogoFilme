package br.com.saraiva.catalogo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping(path = "/")
    public ResponseEntity<Filme> addNewFilme(@RequestBody PojoFilme pojoFilme) {
        Filme filme = new Filme();
        filme.setTitle(pojoFilme.getTitle());

        filme = service.addNewFilme(filme);

        return new ResponseEntity<>(filme, HttpStatus.CREATED);
    } 

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateFilme(@PathVariable long id, @RequestBody PojoFilme pojoFilme) {
        Filme filme = service.getById(id);
        if (filme == null)
            return new ResponseEntity<>("Produto não encontrado", HttpStatus.NOT_FOUND);
        
        filme.setTitle(pojoFilme.getTitle());
        service.updateFilme(filme);

        return new ResponseEntity<>("Produto atualizado com sucesso", HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteFilme(@PathVariable long id) {
        Filme filme = service.getById(id);
        if (filme == null)
            return new ResponseEntity<>("Produto não encontrado", HttpStatus.NOT_FOUND);

        service.deleteFilme(filme);
        return new ResponseEntity<>("Produto deletado com sucesso", HttpStatus.OK);
    }
}