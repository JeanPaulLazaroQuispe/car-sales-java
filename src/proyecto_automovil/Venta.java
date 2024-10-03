
package proyecto_automovil;

import java.time.LocalDate;

public class Venta {
    
    private int id;
    private Local local;
    private Auto auto;
    private Cliente cliente;
    private LocalDate date;
    private int cantidad_autos;

    public Venta(int id, Local local, Auto auto, Cliente cliente, LocalDate date, int cantidad_autos) {
        this.id = id;
        this.local = local;
        this.auto = auto;
        this.cliente = cliente;
        this.date = date;
        this.cantidad_autos = cantidad_autos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getCantidad_autos() {
        return cantidad_autos;
    }

    public void setCantidad_autos(int cantidad_autos) {
        this.cantidad_autos = cantidad_autos;
    }
    
    
    
    public String mostrarVenta(){
        return "\nId: "+id+"\nLocal: "+local.getDireccion()+cliente.mostrarDatoVenta()+auto.MostrarDatoVenta()+"\nCantidad: "+cantidad_autos+"\nFecha de compra: "+date;
    }
    
}
