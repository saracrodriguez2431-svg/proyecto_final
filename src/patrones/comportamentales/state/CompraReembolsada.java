package patrones.comportamentales.state;

import interfaces.EstadoCompra;
import model.Compra;

public class CompraReembolsada implements EstadoCompra {
    public void manejarEstado(Compra compra) {
        System.out.println("Compra Reembolsada");
    }
}
