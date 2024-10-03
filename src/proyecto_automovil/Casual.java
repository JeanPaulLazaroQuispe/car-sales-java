
package proyecto_automovil;

public class Casual extends Auto{
    
    private int N_asientos;

    public Casual(int N_asientos, String tipo, String marca, float precio, int cantidad, String color, int id) {
        super(tipo, marca, precio, cantidad, color, id);
        this.N_asientos = N_asientos;
    }
    
    public int getN_asientos() {
        return N_asientos;
    }

    public void setN_asientos(int N_asientos) {
        this.N_asientos = N_asientos;
    }
    
    public void Modificar(Casual casual) {
        
        setTipo(casual.getTipo());
        setMarca(casual.getMarca());
        setPrecio(casual.getPrecio());
        setCantidad(casual.getCantidad());
        setColor(casual.getColor());
        setN_asientos(casual.getN_asientos());
        
    } 
    
    @Override
    public String MostrarDato() {
        return "\nId: "+getId()+"\nMarca: "+getMarca()+"\nTipo: "+getTipo()+"\nColor: "+getColor()+"\nPrecio: "+getPrecio()+"\nCantidad: "+getCantidad()+"\nNumero de asientos: "+getN_asientos();
    }
    
    @Override
    public String toString() {
        return N_asientos+"";
    }

    @Override
    public String MostrarDatoVenta() {
        return "\nMarca: "+getMarca()+"\nTipo: "+getTipo()+"\nColor: "+getColor()+"\nPrecio: "+getPrecio()+"\nNumero de asientos: "+getN_asientos();
    }
    
}
