package br.com.saraiva.catalogo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "filme")
public class FilmeDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="title", nullable = false, length = 30)
    private String title;

    @Column(name="usuario", nullable = false, length = 50)
    private String usuario;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario(String usuario) {
        return this.usuario;
    }
}