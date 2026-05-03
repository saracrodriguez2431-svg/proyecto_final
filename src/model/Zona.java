package model;

import java.util.ArrayList;
import java.util.List;

public class Zona {

    private String nombre;
    private double precioBase;
    private List<Asiento> asientos;

    public Zona(String nombre, double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.asientos = new ArrayList<>();
    }

    public List<Asiento> getAsientos() {
        return asientos;
    }

    public String getNombre() {
        return nombre;
    }
    public double getPrecioBase() {
        return precioBase;
    }

    public void agregarAsiento(Asiento asiento) {
        asientos.add(asiento);
    }

    public int asientosDisponibles() {
        int contador = 0;
        for (Asiento a : asientos) {
            if (a.estaDisponible()) {
                contador++;
            }
        }
        return contador;
    }

    public Asiento buscarAsiento(String numero, String fila) {
        for (Asiento a : asientos) {
            if (a.getFila().equals(fila) && a.getNumero().equals(numero)) {
                return a;
            }
        }
        return null;
    }

    public void eliminarAsiento(String numero) {
        asientos.removeIf(a -> a.getNumero().equals(numero));
    }

    public void mostrarMapaAsientos() {
        for (Asiento a : asientos) {
            System.out.println(
                    "Fila: " + a.getFila() +
                    "Número Asiento: " + a.getNumero() +
                    "Estado: " + a.getEstado()
            );
        }
    }

    public void mapaVisual() {
        for (Asiento a : asientos) {

            String simbolo;

            switch (a.getEstado()) {
                case DISPONIBLE:
                    simbolo = "[DISPONIBLE]";
                    break;
                case RESERVADO:
                    simbolo = "[RESERVADO]";
                    break;
                case VENDIDO:
                    simbolo = "[VENDIDO]";
                    break;
                default:
                    simbolo = "[BLOQUEADO]";
            }

            System.out.print("\nZona " + nombre);
        }
    }

}