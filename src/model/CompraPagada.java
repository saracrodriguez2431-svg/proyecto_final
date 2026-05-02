package model;

public class CompraPagada implements EstadoCompra {
    public void manejarEstado(Compra compra) {
        System.out.println("Compra Pagada");
    }
}
