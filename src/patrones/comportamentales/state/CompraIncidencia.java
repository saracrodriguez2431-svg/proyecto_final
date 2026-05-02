package patrones.comportamentales.state;

import interfaces.EstadoCompra;
import model.Compra;

public class CompraIncidencia implements EstadoCompra {
    public void manejarEstado(Compra compra) {
        System.out.println("Compra con incidencia");
    }
}
