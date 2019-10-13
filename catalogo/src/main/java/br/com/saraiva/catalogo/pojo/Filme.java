package br.com.saraiva.catalogo.pojo;

/**
 * PojoFilme
 */
public class Filme {

    private String title;
    private String usuario;
    private String gender;

    public String getTitle() {
        return title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}