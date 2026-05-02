package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String id;
    private String nombre;
    private String email;
    private List<Compra> compras;

    public Usuario(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.compras = new ArrayList<>();
    }

    public void agregarCompra(Compra compra) {
        compras.add(compra);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
}
