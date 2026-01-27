package es.uah.filmAffinity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 45)
    private String titulo;

    @Column(name = "anio_estreno", nullable = false)
    private Integer anioEstreno;

    @Column(name = "director", nullable = false, length = 45)
    private String director;

    @Column(name = "duracion", nullable = false)
    private Integer duracion;

    @Column(name = "pais", nullable = false, length = 45)
    private String pais;

    @Column(name = "sinopsis", nullable = false, length = 250)
    private String sinopsis;

    @Column(name = "portada", nullable = false, length = 250)
    private String portada;

    @Column(name = "saga", length = 70)
    private String saga;

    @ManyToMany
    @JoinTable(
        name = "Peliculas_has_Actores",
        joinColumns = @JoinColumn(name = "Peliculas_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "Actores_id", referencedColumnName = "id")
    )
    @JsonIgnoreProperties("peliculas")
    private Set<Actor> actores = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(
        name = "Peliculas_has_Generos",
        joinColumns = @JoinColumn(name = "Peliculas_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "Generos_id", referencedColumnName = "id")
    )
    @JsonIgnoreProperties("peliculas")
    private Set<Genero> generos = new LinkedHashSet<>();

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

    public Set<Actor> getActores() {
        return actores;
    }

    public void setActores(Set<Actor> actores) {
        this.actores = actores;
    }

    public void addActor(Actor actor){
       this.actores.add(actor);
    }

    public void removeActor(Actor actor){
        this.actores.remove(actor);
    }

    public Set<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(Set<Genero> generos) {
        this.generos = generos;
    }

    public void addGenero(Genero genero){
        this.generos.add(genero);
    }

    public void removeGenero(Genero genero){
        this.generos.remove(genero);
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "saga='" + saga + '\'' +
                ", portada='" + portada + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", pais='" + pais + '\'' +
                ", duracion=" + duracion +
                ", director='" + director + '\'' +
                ", anioEstreno=" + anioEstreno +
                ", titulo='" + titulo + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(getId(), pelicula.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}