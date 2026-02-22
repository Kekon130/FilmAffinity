package es.uah.filmAffinity.dto.response.pelicula;

import es.uah.filmAffinity.dto.response.actor.ActorResponseMin;
import es.uah.filmAffinity.dto.response.genero.GeneroResponseMin;

import java.util.List;

public class PeliculaResponse {
    private Integer id;
    private String titulo;
    private Integer anioEstreno;
    private String director;
    private Integer duracion;
    private String pais;
    private String sinopsis;
    private String portada;
    private String saga;
    private List<ActorResponseMin> actores;
    private List<GeneroResponseMin> generos;

    public PeliculaResponse() {
    }

    public PeliculaResponse(Integer id, String titulo, Integer anioEstreno, String director, Integer duracion, String pais, String sinopsis, String portada, String saga, List<ActorResponseMin> actores, List<GeneroResponseMin> generos) {
        this.id = id;
        this.titulo = titulo;
        this.anioEstreno = anioEstreno;
        this.director = director;
        this.duracion = duracion;
        this.pais = pais;
        this.sinopsis = sinopsis;
        this.portada = portada;
        this.saga = saga;
        this.actores = actores;
        this.generos = generos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(Integer anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getSaga() {
        return saga;
    }

    public void setSaga(String saga) {
        this.saga = saga;
    }

    public List<ActorResponseMin> getActores() {
        return actores;
    }

    public void setActores(List<ActorResponseMin> actores) {
        this.actores = actores;
    }

    public List<GeneroResponseMin> getGeneros() {
        return generos;
    }

    public void setGeneros(List<GeneroResponseMin> generos) {
        this.generos = generos;
    }
}
