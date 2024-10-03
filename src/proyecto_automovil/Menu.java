
package proyecto_automovil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    static ArrayList<Cliente> list_cliente = new ArrayList<Cliente>();
    static ArrayList<Auto> list_auto = new ArrayList<Auto>();
    static ArrayList<Local> list_local = new ArrayList<Local>();
    static ArrayList<Venta> list_venta = new ArrayList<Venta>();
    
    public static boolean login(String dni, String password) {
        boolean resultado = false;
        for(int i = 0; i<list_cliente.size(); i++) {
            if(list_cliente.get(i).getDni().equals(dni) && list_cliente.get(i).getPassword().equals(password)){
                resultado = true;
            }
        }
        
        return resultado;
    }
    
    public static void Registro(Cliente cliente) {
        list_cliente.add(cliente);
    }
    
    public static void RegistrarAuto(Auto auto) {
        list_auto.add(auto);
    }
    
    public static void EditarAuto(int id) {
        Scanner entrada = new Scanner(System.in);
        
        String tipo;
        String marca;
        float precio;
        int cantidad;
        String color;

        float fuerza;
        int N_asientos = 0;
        
        for (int i = 0; i < list_auto.size(); i++) {
            if (list_auto.get(i).getId() == id) {
                String mostrar = list_auto.get(i).MostrarDato();
                
                if(list_auto.get(i).getTipo().equals("Deportivo") || list_auto.get(i).getTipo().equals("deportivo")){
                                    
                    System.out.println("\n\n..............:DATOS DEL AUTO DEPORTIVO:...............");
                    System.out.println("\n"+mostrar);
                    
                    System.out.println("\n\n...........:EDICION DE AUTO DEPORTIVO:...........");
                    System.out.print("Color: ");
                    color = entrada.nextLine();
                    System.out.print("Precio: ");
                    precio = entrada.nextFloat();
                    System.out.print("Cantidad: ");
                    cantidad = entrada.nextInt();
                    
                    tipo = list_auto.get(i).getTipo();
                    String dato = list_auto.get(i).toString();
                    fuerza = Float.parseFloat(dato);
                    marca = list_auto.get(i).getMarca();
                    
                    Auto auto = new Deportivo(fuerza, tipo, marca, precio, cantidad, color, id);
                    
                    list_auto.set(i, auto);
                    
                }else{
                    
                    System.out.println("\n\n............:DATOS DEL AUTO CASUAL:...............");
                    System.out.println("\n"+mostrar);
                    
                    System.out.println("\n\n...........:EDICION DE AUTO CASUAL:...........");
                    System.out.print("Color: ");
                    color = entrada.nextLine();
                    System.out.print("Precio: ");
                    precio = entrada.nextFloat();
                    System.out.print("Cantidad: ");
                    cantidad = entrada.nextInt();
                    
                    tipo = list_auto.get(i).getTipo();
                    String dato = list_auto.get(i).toString();
                    N_asientos = Integer.parseInt(dato);
                    marca = list_auto.get(i).getMarca();
                    
                    Auto auto = new Casual(N_asientos, tipo, marca, precio, cantidad, color, id);
                    
                    list_auto.set(i, auto);
                }

            }else{
                System.out.println("\n\nEl auto que usted quier modificar no existe, ingrese otro por favor");
            }
        }
    }
    
    public static void Eliminar(int id) {

        for (int i = 0; i < list_auto.size(); i++) {
            if (list_auto.get(i).getId() == id) {
                String mostrar = list_auto.get(i).MostrarDato();
                list_auto.remove(i);
                
                System.out.println("\nAuto eliminado con exito");
            }
        }
    }
    
    public static void RegistrarVenta(Cliente cliente, int id) {
        Scanner entrada = new Scanner(System.in);

        Local local;
        
        Auto auto;
        
        LocalDate date = LocalDate.now();
        
        System.out.println("\n............:LISTA DE AUTOS:............");
        for (int i = 0; i < list_auto.size(); i++) {
            String mostrar = list_auto.get(i).MostrarDato();
            System.out.println("\n" + mostrar);
        }
        
        System.out.println("\n\n.............:REALIZANOD COMPRA:...........\n");
        int id_auto = 0, cantidad = 0;
        System.out.print("\nIngrese el id del auto que quiera comprar: ");
        id_auto = entrada.nextInt();
        System.out.print("\nIngrese cuantos autos va querer: ");
        cantidad = entrada.nextInt();
        
        
        System.out.println("\n\n............:LOCALES:............");
        for (int i = 0; i < list_local.size(); i++) {
            String mostrar = list_local.get(i).Informacion();
            System.out.println("\n" + mostrar);
        }
        
        entrada.nextLine();
        System.out.println("\n\n.............:REALIZANOD COMPRA:...........\n");
        String direccion;
        System.out.print("\nIngrese el local donde recogera el auto: ");
        direccion = entrada.nextLine();
        
        boolean resultadoLocal = false;
        boolean resultadoAuto = false;
        
        for (int i = 0; i < list_local.size(); i++) {
            if (list_local.get(i).getDireccion().equals(direccion)) {
                local = list_local.get(i);
                resultadoLocal = true;
                
                for (int j = 0; j < list_auto.size(); j++) {
                    if (list_auto.get(j).getId() == id_auto) {
                                             
                        auto = list_auto.get(j);
                        
                        int resultado = list_auto.get(j).getCantidad();
                        resultado = resultado - cantidad;
                        list_auto.get(j).setCantidad(resultado);
                        
                        Venta venta = new Venta(id, local, auto, cliente, date, cantidad);
                        list_venta.add(venta);
                        System.out.println("\n!!!!!!!!!!Compra realizada con exito!!!!!!!!!!!!!!!!!!!!!!!");
                        resultadoAuto = true;
                    } 
                }
                
            } 

        }

        if(resultadoLocal == false) {
            System.out.println("\nLocal no registrado en la lista, escoga uno valido");
            
        }else{
            if(resultadoAuto == false){
                System.out.println("\nAuto no registrado en la lista, escoga uno valido");
            }
        }
    }
    
    public static void main(String[] args) {
    
        Local local1 = new Local("Comas", "automovilisticoComas@gamil.com", "111111111");
        Local local2 = new Local("Lo Olivos", "automovilisticoOlivos@gamil.com", "222222222");
        Local local3 = new Local("Rimac", "automovilisticoRimac@gamil.com", "333333333");
        
        list_local.add(local1);
        list_local.add(local2);
        list_local.add(local3);

        Auto autoa = new Deportivo(2500, "Deportivo", "Ferrari", 4500f, 7, "Rojo", 1);
        Auto autob = new Casual(4, "Casual", "Audi", 4700.4f, 5, "Verde", 2);
        Auto autoc = new Deportivo(2800, "Deportivo", "Chevrolet", 4200.4f, 8, "Negro", 3);
        
        list_auto.add(autoa);
        list_auto.add(autob);
        list_auto.add(autoc);
        
        Cliente clientea = new Cliente("11111111", "Jean", "Lazaro", "Peru", "Lima", "Av zorritos", "lazarex0@gmail.com", "1111");
        Cliente clienteb = new Cliente("22222222", "Gael", "Lopez", "Argentina", "Buenos Aires", "Av Calle car", "gael0@gmail.com", "2222");
        
        list_cliente.add(clientea);
        list_cliente.add(clienteb);
        
        int opcion=0;
        Scanner entrada = new Scanner(System.in);
        int id = 3; 
        int id_venta = 0;
        do{
        
            System.out.println("\n........:Empresa Automovilista:........");
            System.out.println("1. Iniciar Sesion");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            System.out.print("Digite su opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine();
            
            switch(opcion){
   
                case 1:
                    String dni_log = "";
                    String password_log = "";
                
                    
                    System.out.println("\n...........:LOGIN:...........");
                    System.out.print("Dni: ");
                    dni_log = entrada.nextLine();
                    System.out.print("Password: ");
                    password_log = entrada.nextLine();
                    
                    boolean login = login(dni_log, password_log);
                    
                    if(login == false){
                        System.out.println("Cliente no registrado");
                        break;
                        
                    }else{
                       
                        int opcionMenu = 0;
                        
                        do{
                            System.out.println("\n........:Menu:........");
                            System.out.println("1. Autos");
                            System.out.println("2. Ventas");
                            System.out.println("3. Ver clientes");
                            System.out.println("4. Cerrar Sesion");
                            System.out.print("Digite su opcion: ");
                            opcionMenu = entrada.nextInt();
                            entrada.nextLine();
                            
                            switch(opcionMenu){
                                
                                case 1:
                                    int opcionAuto = 0;
                                    
                                    do{
                                        System.out.println("\n........:Menu Autos:........");
                                        System.out.println("1. Registrar Auto");
                                        System.out.println("2. Editar información del Auto");
                                        System.out.println("3. Eliminar Auto");
                                        System.out.println("4. Ver Autos");
                                        System.out.println("5. Regresar al Menu Principal");
                                        System.out.print("Digite su opcion: ");
                                        opcionAuto = entrada.nextInt();
                                        entrada.nextLine();
                                        
                                        switch(opcionAuto) {
                                            case 1:
                                                int opcionAutoR = 0;
                                                
                                                do{
                                                    System.out.println("\n........:Menu Registrar:........");
                                                    System.out.println("1. Registrar Auto Deportivo");
                                                    System.out.println("2. Registrar Auto Casual");
                                                    System.out.println("3. Volver al Menu Autos");
                                                    System.out.print("Digite su opcion: ");
                                                    opcionAutoR = entrada.nextInt();
                                                    entrada.nextLine();
                                                    
                                                            String tipo;
                                                            String marca;
                                                            float precio;
                                                            int cantidad;
                                                            String color;
                                                            
                                                            float fuerza;
                                                            int N_asientos = 0;         
                                                    
                                                    switch(opcionAutoR){
                                                        
                                                        
                                                        case 1:
                                                            
                                                            
                                                            System.out.println("\n...........:REGISTRO AUTO DEPORTIVO:...........");
                                                            System.out.print("Marca: ");
                                                            marca = entrada.nextLine();
                                                            System.out.print("Color: ");
                                                            color = entrada.nextLine();
                                                            System.out.print("Precio: ");
                                                            precio = entrada.nextFloat();
                                                            System.out.print("Cantidad: ");
                                                            cantidad = entrada.nextInt();
                                                            System.out.print("Caballos de fuerza: ");
                                                            fuerza = entrada.nextFloat();
                                                            
                                                            id += 1;
                                                            tipo = "Deportivo";
                                                            
                                                            Auto auto = new Deportivo(fuerza, tipo, marca, precio, cantidad, color, id);
                                                            
                                                            RegistrarAuto(auto);
                                                            break;
                                                            
                                                        case 2:
                                                            
                                                            System.out.println("\n...........:REGISTRO AUTO CASUAL:...........");
                                                            System.out.print("Marca: ");
                                                            marca = entrada.nextLine();
                                                            System.out.print("Color: ");
                                                            color = entrada.nextLine();
                                                            System.out.print("Precio: ");
                                                            precio = entrada.nextFloat();
                                                            System.out.print("Cantidad: ");
                                                            cantidad = entrada.nextInt();
                                                            System.out.print("Numero de asientos: ");
                                                            N_asientos = entrada.nextInt();
                                                            
                                                            id += 1;
                                                            tipo = "Casual";
                                                            
                                                            Auto auto1 = new Casual(N_asientos, tipo, marca, precio, cantidad, color, id);
                                                            
                                                            RegistrarAuto(auto1);
                                                            break;
                                                            
                                                        case 3:
                                                            break;
                                                            
                                                        default:
                                                            System.out.println("\nPor favor digite una opcion valida.\n");
                                                            break;
                                                    }
                                                    
                                                }while(opcionAutoR != 3);
                                             
                                                break;
                                                
                                            case 2:
                                                int id_auto = 0;
                                                System.out.print("\nIngrese el id del auto que quiera modificar: ");
                                                id_auto = entrada.nextInt();
                                                
                                                EditarAuto(id_auto);
                                                break;
                                            
                                            case 3:
                                                int id_autoE = 0;
                                                System.out.print("\nIngrese el id del auto que quiera eliminar: ");
                                                id_autoE = entrada.nextInt();
                                                
                                                Eliminar(id_autoE);
                                                break;
                                            
                                            case 4:
                                                System.out.println("\n............:LISTA DE AUTOS:............");
                                                for (int i = 0; i < list_auto.size(); i++) {
                                                    String mostrar  = list_auto.get(i).MostrarDato();
                                                    System.out.println("\n"+mostrar);
                                                }
                                           
                                            case 5:
                                                break;
                                                
                                            default:
                                                System.out.println("\nPor favor digite una opcion valida.\n");
                                                break;
                                        }
                                    }while(opcionAuto != 5);
                                    
                                    break;
                                    
                                case 2:
                                    
                                    int opcionVentas = 0;
                                    do{
                                    System.out.println("\n........:Menu Ventas:........");
                                        System.out.println("1. Realizar una Venta");
                                        System.out.println("2. Listar Ventas");
                                        System.out.println("3. Regresar al Menu Principal");
                                        System.out.print("Digite su opcion: ");
                                        opcionVentas = entrada.nextInt();
                                        entrada.nextLine();
                                        
                                        switch(opcionVentas){
                                            
                                            case 1:

                                                Cliente cliente;
                                                for (int i = 0; i < list_cliente.size(); i++) {
                                                    if (list_cliente.get(i).getDni().equals(dni_log)) {
                                                        cliente = list_cliente.get(i);
                                                        id_venta += 1;
                                                        RegistrarVenta(cliente,id_venta);
                                                    }
                                                }

                                                break;
                                            case 2:
                                                System.out.println("\n............:VENTAS:............");
                                                for (int i = 0; i < list_venta.size(); i++) {
                                                    String mostrar  = list_venta.get(i).mostrarVenta();
                                                    System.out.println("\n"+mostrar);
                                                }
                                                break;
                                            case 3:
                                                break;

                                            default:
                                                System.out.println("\nPor favor digite una opcion valida.\n");
                                                break;
                                        }
                                    }while(opcionVentas!=3);
                                    
                                case 3:
                                    System.out.println("\n.............:LISTA DE USUARIOS:..............");
                                    for (int i = 0; i < list_cliente.size(); i++) {
                                        String mostrar = list_cliente.get(i).mostrarDato();
                                        System.out.println("\n" + mostrar);
                                    }
                                    break;
                                    
                                case 4:
                                    System.out.println("!!!!!!!!!!LOGOUT EXITOSO!!!!!!!!!!!!!");
                                    break;
                                    
                                default:
                                    System.out.println("Debe ingresar una opción correcta por favor");
                                    break;
                            }
                        }while(opcionMenu != 4);

                        break;
                    }
                    
                case 2:
                    String dni = "";
                    String nombre = "";
                    String apellido = "";
                    String pais = "";
                    String ciudad = "";
                    String direccion = "";
                    String correo = "";
                    String password = "";
                    
                    
                    System.out.println("\n...........:REGISTRO:...........");
                    System.out.print("Dni: ");
                    dni = entrada.nextLine();
                    System.out.print("Nombre: ");
                    nombre = entrada.nextLine();
                    System.out.print("Apellido: ");
                    apellido = entrada.nextLine();
                    System.out.print("Pais: ");
                    pais = entrada.nextLine();
                    System.out.print("Ciudad: ");
                    ciudad = entrada.nextLine();
                    System.out.print("Direccion: ");
                    direccion = entrada.nextLine();
                    System.out.print("Correo: ");
                    correo = entrada.nextLine();
                    System.out.print("Password: ");
                    password = entrada.nextLine();
                    
                    Cliente cliente = new Cliente(dni,nombre,apellido,pais,ciudad,direccion,correo,password);
                    Registro(cliente);
                    break;
                    
                case 3:
                    System.out.println("!!!!!!!!!!GRACIAS POR SU VISITA!!!!!!!!!!!!!");
                    break;
                default:
                    System.out.println("Debe ingresar una opción correcta por favor");
                    break;
            }
        
        }while(opcion != 3);
        
    }
}
