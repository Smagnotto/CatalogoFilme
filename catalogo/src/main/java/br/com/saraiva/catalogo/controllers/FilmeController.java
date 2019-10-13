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

import br.com.saraiva.catalogo.domain.FilmeDomain;
import br.com.saraiva.catalogo.pojo.Filme;
import br.com.saraiva.catalogo.service.FilmeService;

/**
 * FilmeController
 */
@RestController
@RequestMapping(path = "/filme")
public class FilmeController {
    
    @Autowired
    private FilmeService service;

    @GetMapping(path="/")
    public List<FilmeDomain> getAll() {
        return service.getAll();
    }

    @GetMapping(path = "/usuario/{usuario}")
    public List<FilmeDomain> getAllByUser(@PathVariable String usuario) {
        return service.getAllByUser(usuario);
    }


    @GetMapping(path = "/{id}")
    public FilmeDomain getById(@PathVariable long id) {
        return service.getById(id);
    }

    @PostMapping(path = "/")
    public ResponseEntity<FilmeDomain> addNewFilme(@RequestBody Filme pojoFilme) {
        //TODO Adicionar chave de usuario no objeto filme para relacionamento
        FilmeDomain filme = new FilmeDomain();
        filme.setTitle(pojoFilme.getTitle());
        filme.setGender(pojoFilme.getGender());
        filme.setUsuario(pojoFilme.getUsuario());

        filme = service.addNewFilme(filme);

        return new ResponseEntity<>(filme, HttpStatus.CREATED);
    } 

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateFilme(@PathVariable long id, @RequestBody Filme pojoFilme) {
        FilmeDomain filme = service.getById(id);
        if (filme == null)
            return new ResponseEntity<>("Filme não encontrado", HttpStatus.NOT_FOUND);
        
        filme.setTitle(pojoFilme.getTitle());
        filme.setGender(pojoFilme.getGender());

        service.updateFilme(filme);

        return new ResponseEntity<>("Filme atualizado com sucesso", HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteFilme(@PathVariable long id) {
        FilmeDomain filme = service.getById(id);
        if (filme == null)
            return new ResponseEntity<>("Filme não encontrado", HttpStatus.NOT_FOUND);

        service.deleteFilme(filme);
        return new ResponseEntity<>("Filme deletado com sucesso", HttpStatus.OK);
    }
}
