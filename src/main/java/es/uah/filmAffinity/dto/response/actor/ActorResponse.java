package es.uah.filmAffinity.dto.response.actor;

import java.time.LocalDate;

public class ActorResponse {
    private Integer id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String paisNacimiento;

    public ActorResponse() {
    }

    public ActorResponse(Integer id, String nombre, LocalDate fechaNacimiento, String paisNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.paisNacimiento = paisNacimiento;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }
}
