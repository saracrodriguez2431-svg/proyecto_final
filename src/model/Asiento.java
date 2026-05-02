package model;

public class Asiento {

    private String numero;
    private EstadoAsiento estado;

    public Asiento(String numero) {
        this.numero = numero;
        this.estado = EstadoAsiento.DISPONIBLE;
    }

    public boolean estaDisponible() {
        return estado == EstadoAsiento.DISPONIBLE;
    }

    public void reservar() {
        this.estado = EstadoAsiento.RESERVADO;
    }

    public void vender() {
        this.estado = EstadoAsiento.VENDIDO;
    }

    public String getNumero() {
        return numero;
    }

    public EstadoAsiento getEstado() {
        return estado;
    }
}
