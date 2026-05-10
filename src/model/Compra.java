package model;

import java.util.UUID;
import java.time.LocalDate;

public class Compra implements CompraBase{
    private String id;
    private EstadoCompra estado;
    private double total;
    private LocalDate fecha;
    private Asiento asiento;

    public Compra(double total, Asiento asiento) {
        this.id = UUID.randomUUID().toString();
        this.fecha = LocalDate.now();
        this.total = total;
        this.estado = new CompraCreada();
        this.asiento = asiento;
    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setEstado(EstadoCompra estado) {
        this.estado = estado;
    }
    public EstadoCompra getEstado() {
        return estado;
    }

    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return "Entrada = Fila: " + asiento.getFila()  + ", Asiento: " + asiento.getNumero();
    }

    public void procesar() {
        estado.manejarEstado(this);
    }
}
