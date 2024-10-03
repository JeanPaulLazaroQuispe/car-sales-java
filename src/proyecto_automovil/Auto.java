
package proyecto_automovil;

import java.util.List;

public abstract class Auto {
    private String tipo;
    private String marca;
    private float precio;
    private int cantidad;
    private String color;
    private int id;

    public Auto(String tipo, String marca, float precio, int cantidad, String color, int id) {
        this.tipo = tipo;
        this.marca = marca;
        this.precio = precio;
        this.cantidad = cantidad;
        this.color = color;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public abstract String MostrarDato();

    public abstract String toString();
    
    public abstract String MostrarDatoVenta();
}
