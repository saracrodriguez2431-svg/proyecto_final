package model;

import service.EventoService;

public class SistemaFacade {
    private EventoService eventoService;

    public SistemaFacade() {
        eventoService = EventoService.getInstancia();
    }

    public void crearEvento(Evento evento) {
        eventoService.crearEvento(evento);
    }

    public Evento buscarEvento(String nombre) {
        return eventoService.buscarEvento(nombre);
    }

    public CompraBase comprarEntrada( Evento evento, String fila, String numero, boolean parqueadero, boolean foto) {
        Asiento asiento = null;
        Zona zonaSeleccionada = null;

        for (Zona z : evento.getZonas()) {
            asiento = z.buscarAsiento(numero, fila);
            if (asiento != null && asiento.estaDisponible()) {
                asiento.vender();
                zonaSeleccionada = z;
                break;
            }
        }

        if (asiento == null) {
            return null;
        }

        CompraBase compra = new Compra(zonaSeleccionada.getPrecioBase(), asiento);


        if (parqueadero) {
            compra = new ParqueaderoDecorator(compra);
        }

        if (foto) {
            compra = new FotoDecorator(compra);
        }

        return compra;
    }

    public void procesarPago(PagoStrategy estrategia, double total) {
        estrategia.pago(total);
    }

    public void notificarObservers(Evento evento, String mensaje) {
        evento.notificarObservers(mensaje);
    }

}
