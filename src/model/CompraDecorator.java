package model;

public abstract class CompraDecorator implements CompraBase {
    protected CompraBase compra;

    public CompraDecorator(CompraBase compra) {
        this.compra = compra;
    }

    public double getTotal() {
        return compra.getTotal();
    }

    public String getDescripcion() {
        return compra.getDescripcion();
    }

}
