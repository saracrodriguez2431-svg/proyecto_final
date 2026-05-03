package service;

import model.Evento;

import java.util.ArrayList;
import java.util.List;

public class EventoService {
    private static EventoService instancia;

    private List<Evento> eventos = new ArrayList<>();

    private EventoService() {
        eventos = new ArrayList<>();
    }

    public static EventoService getInstancia() {
        if (instancia == null) {
            instancia = new EventoService();
        }
        return instancia;
    }

    public void crearEvento(Evento evento) {
        eventos.add(evento);
    }

    public List<Evento> listarEventos() {
        return eventos;
    }

    public Evento buscarEvento(String id) {
        for (Evento e : eventos) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    public void eliminarEvento(String id) {
        eventos.removeIf(e -> e.getId().equals(id));
    }

}
