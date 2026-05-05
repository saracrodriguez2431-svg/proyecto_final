package model;

public class TarjetaAdapter implements PagoStrategy {
    private TarjetaAPI api = new TarjetaAPI();

    public void pago(double cantidad) {
        api.procesoTarjeta(cantidad);
    }
}
