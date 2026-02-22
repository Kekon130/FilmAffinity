package es.uah.filmAffinity.dto.response.genero;

public class GeneroResponseMin {
    private Integer id;
    private String nombre;

    public GeneroResponseMin() {
    }

    public GeneroResponseMin(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
