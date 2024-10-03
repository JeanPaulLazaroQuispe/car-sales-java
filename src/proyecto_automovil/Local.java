
package proyecto_automovil;

public class Local {
    private String direccion;
    private String correo;
    private String telefono;

    public Local(String direccion, String correo, String telefono) {
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String Informacion(){
        return "\nDireccion: "+direccion+"\nCorreo: "+correo+"\nTelefono: "+telefono;
    }
}

