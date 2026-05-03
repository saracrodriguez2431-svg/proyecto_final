package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class EventoBuilder {
    private Evento evento;

    public EventoBuilder() {
        evento = new Evento();
    }

    public EventoBuilder setId(String id) {
        evento.setId(id);
        return this;
    }
    public EventoBuilder setNombre(String nombre) {
        evento.setNombre(nombre);
        return this;
    }
    public EventoBuilder setDescripcion(String descripcion) {
        evento.setDescripcion(descripcion);
        return this;
    }
    public EventoBuilder setFecha(LocalDateTime fecha) {
        evento.setFecha(fecha);
        return this;
    }
    public EventoBuilder setEstado (EstadoEvento estado) {
        evento.setEstado(estado);
        return this;
    }

    public Evento build(){
        return evento;
    }
}
