
package proyecto_automovil;

import java.util.List;


public class Deportivo extends Auto{

    private float fuerza;
    
    public Deportivo(float fuerza, String tipo, String marca, float precio, int cantidad, String color, int id) {
        super(tipo, marca, precio, cantidad, color, id);
        this.fuerza = fuerza;
    }
    
    public float getFuerza() {
        return fuerza;
    }

    public void setFuerza(float fuerza) {
        this.fuerza = fuerza;
    }   

    @Override
    public void setColor(String color) {
        super.setColor(color); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getColor() {
        return super.getColor(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setCantidad(int cantidad) {
        super.setCantidad(cantidad); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public int getCantidad() {
        return super.getCantidad(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setPrecio(float precio) {
        super.setPrecio(precio); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public float getPrecio() {
        return super.getPrecio(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setMarca(String marca) {
        super.setMarca(marca); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getMarca() {
        return super.getMarca(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setTipo(String tipo) {
        super.setTipo(tipo); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getTipo() {
        return super.getTipo(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setId(int id) {
        super.setId(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public int getId() {
        return super.getId(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String MostrarDato() {
        return "\nId: "+getId()+"\nMarca: "+getMarca()+"\nTipo: "+getTipo()+"\nColor: "+getColor()+"\nPrecio: "+getPrecio()+"\nCantidad: "+getCantidad()+"\nFuerza: "+getFuerza();
    }

    @Override
    public String toString() {
        return fuerza+"";
    }
    
    @Override
    public String MostrarDatoVenta() {
        return "\nMarca: "+getMarca()+"\nTipo: "+getTipo()+"\nColor: "+getColor()+"\nPrecio: "+getPrecio()+"\nFuerza: "+getFuerza();
    }
    
}
