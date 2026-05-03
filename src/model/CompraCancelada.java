package model;

public class CompraCancelada implements EstadoCompra {
    public void manejarEstado(Compra compra) {
        System.out.println("Compra Cancelada");
    }
}
