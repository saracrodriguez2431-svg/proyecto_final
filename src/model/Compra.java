package model;

public class Compra {
    private String id;
    private EstadoCompra estado;

    public Compra(String id, EstadoCompra estadoInicial) {
        this.id = id;
        this.estado = estadoInicial;
    }

    public void setEstado(EstadoCompra estado) {
        this.estado = estado;
    }

    public void procesar() {
        estado.manejarEstado(this);
    }
}
