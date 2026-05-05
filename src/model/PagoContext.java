package model;

public class PagoContext {
    private PagoStrategy strategy;

    public void setStrategy(PagoStrategy strategy) {
        this.strategy = strategy;
    }

    public void pago (double cantidad) {
        strategy.pago(cantidad);
    }
}
