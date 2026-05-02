package model;

public class CompraCreada implements EstadoCompra {
    public void manejarEstado(Compra compra) {
        System.out.println("Compra creada");
    }
}
