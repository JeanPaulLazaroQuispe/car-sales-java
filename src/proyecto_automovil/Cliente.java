
package proyecto_automovil;

public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;
    private String pais;
    private String ciudad;
    private String direccion;
    private String correo;
    private String password;

    public Cliente(String dni, String nombre, String apellido, String pais, String ciudad, String direccion, String correo, String password) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.correo = correo;
        this.password = password;
    }
    
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPais() {
        return pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String mostrarDato(){
        return "\nDni: "+dni+"\nNombre: "+nombre+"\nApellido: "+apellido+"\nPais: "+pais+"\nCiudad: "+ciudad+"\nDireccion: "+direccion+"\nCorreo: "+correo+"\nPassword: "+password;
    }
    
    public String mostrarDatoVenta(){
        return "\nDni: "+dni+"\nNombre: "+nombre+"\nApellido: "+apellido+"\nPais: "+pais+"\nCiudad: "+ciudad;
    }
}
