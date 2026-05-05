package model;

public class PseAdapter implements PagoStrategy{
    private PseAPI api = new PseAPI();

    public void pago(double cantidad) {
        api.transferencia(cantidad);
    }

}
