package model;

import java.util.ArrayList;
import java.util.List;

public class Administrador {
    private String id;
    private String nombre;
    private String email;
    private List<Evento> eventos;

    public Administrador(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.eventos = new ArrayList<>();
    }

    public void crearEvento(Evento evento) {
        eventos.add(evento);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}
