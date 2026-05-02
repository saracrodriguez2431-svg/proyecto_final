package model;

public class CompraConfirmada implements EstadoCompra {
    public void manejarEstado(Compra compra) {
        System.out.println("Compra Confirmada");
    }
}
