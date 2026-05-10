package model;

public class FotoDecorator extends CompraDecorator {
    public FotoDecorator(CompraBase compra) {
        super(compra);
    }

    public double getTotal() {
        return super.getTotal() + 150000;
    }

    public String getDescripcion() {
        return super.getDescripcion() + " + Foto con artista";
    }
}
