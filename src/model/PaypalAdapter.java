package model;

public class PaypalAdapter implements PagoStrategy {
    private PaypalAPI api = new PaypalAPI();

    public void pago(double cantidad) {
        api.pagoEnviado(cantidad);
    }
}
