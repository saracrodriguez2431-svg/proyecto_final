package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Evento implements Subject{
    private String id;
    private String nombre;
    private String descripcion;
    private LocalDateTime fecha;
    private EstadoEvento estado;
    private List<Zona> zonas;
    private List<Observer> observers;

    public Evento() {}

    public Evento(String nombre, String descripcion, LocalDateTime fecha) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = EstadoEvento.BORRADOR;
        this.zonas = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void agregarObserver(Observer observer) {
        observers.add(observer);
    }

    public void eliminarObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notificarObservers(String mensaje) {
        for (Observer o : observers) {
            o.actualizar(mensaje);
        }
    }

    public void publicar() {
        this.estado = EstadoEvento.PUBLICADO;
        notificarObservers("El evento" + nombre + "ha sido publicado");
    }

    public void pausar() {
        this.estado = EstadoEvento.PAUSADO;
        notificarObservers("El evento" + nombre + "ha sido pausado");
    }

    public void cancelar() {
        this.estado = EstadoEvento.CANCELADO;
        notificarObservers("El evento" + nombre + "ha sido cancelado");
    }

    public void finalizar() {
        this.estado = EstadoEvento.FINALIZADO;
        notificarObservers("El evento" + nombre + "ha sido finalizado");
    }

    public void agregarZona(Zona zona) {
        zonas.add(zona);
    }

    public int asientosDisponibles() {
        int total = 0;
        for (Zona z : zonas) {
           total += z.asientosDisponibles();
        }

        return total;
    }

    public int disponibilidadPorZona(String nombreZona) {
        for (Zona zona : zonas) {
            if (zona.getNombre().equals(nombreZona)) {
                int disponibles = 0;
                for (Asiento a : zona.getAsientos()) {
                    if (a.estaDisponible()) {
                        disponibles++;
                    }
                }

                return disponibles;
            }
        }
        return 0;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public EstadoEvento getEstado() {
        return estado;
    }

    public void setEstado(EstadoEvento estado) {
        this.estado = estado;
    }

    public List<Zona> getZonas() {
        return zonas;
    }

    public void setZonas(List<Zona> zonas) {
        this.zonas = zonas;
    }

}
