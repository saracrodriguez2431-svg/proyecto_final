package model;

import java.util.ArrayList;
import java.util.List;

public class Zona {

    private String nombre;
    private List<Asiento> asientos;

    public Zona(String nombre) {
        this.nombre = nombre;
        this.asientos = new ArrayList<>();
    }

    public void agregarAsiento(Asiento asiento) {
        asientos.add(asiento);
    }

    public List<Asiento> getAsientos() {
        return asientos;
    }

    public String getNombre() {
        return nombre;
    }
}