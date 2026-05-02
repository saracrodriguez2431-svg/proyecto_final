package model;

public class CompraCancelada implements EstadoCompra {

    @Override
    public void manejarEstado(Compra compra) {
        System.out.println("Compra Cancelada");
    }
}
