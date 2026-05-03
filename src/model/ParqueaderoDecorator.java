package model;

public class ParqueaderoDecorator extends CompraDecorator{
    public ParqueaderoDecorator(CompraBase compra) {
        super(compra);
    }

    public double getTotal() {
        return super.getTotal() + 50000;
    }

    public String getDescripcion() {
        return super.getDescripcion() + " + Parqueadero";
    }
}
