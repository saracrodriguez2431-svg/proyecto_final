package patrones.comportamentales.state;

import interfaces.EstadoCompra;
import model.Compra;

public class CompraCancelada implements EstadoCompra {

    @Override
    public void manejarEstado(Compra compra) {
        System.out.println("Compra Cancelada");
    }
}
