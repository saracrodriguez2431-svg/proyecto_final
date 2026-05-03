package model;

import java.util.UUID;

public class Asiento {

    private String idAsiento;
    private String fila;
    private String numero;
    private EstadoAsiento estado;

    public Asiento(String numero, String fila) {
        this.idAsiento = UUID.randomUUID().toString();
        this.fila = fila;
        this.numero = numero;
        this.estado = EstadoAsiento.DISPONIBLE;
    }

    public boolean estaDisponible() {
        return estado == EstadoAsiento.DISPONIBLE;
    }

    public void reservar() {
        if (estado == EstadoAsiento.DISPONIBLE) {
            estado = EstadoAsiento.RESERVADO;
        }
    }

    public void vender() {
        if (estado == EstadoAsiento.RESERVADO) {
            estado = EstadoAsiento.VENDIDO;
        }
    }

    public void liberar() {
        estado = EstadoAsiento.DISPONIBLE;
    }

    public String getNumero() {
        return numero;
    }

    public EstadoAsiento getEstado() {
        return estado;
    }

    public String getIdAsiento() {
        return idAsiento;
    }

    public String getFila() {
        return fila;
    }
}
