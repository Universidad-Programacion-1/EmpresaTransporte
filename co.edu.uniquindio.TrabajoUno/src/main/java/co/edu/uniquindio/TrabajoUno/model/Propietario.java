package co.edu.uniquindio.TrabajoUno.model;

import java.util.ArrayList;
import java.util.List;

public class Propietario {
    private String nombre;
    private String numeroIdentificacion;
    private String email;
    private String numeroCelular;
    private int edad;
    private Vehiculo vehiculo;
    private List<VehiculoCarga> listaVehiculosAsociados = new ArrayList<>();

    public Propietario() {}

    public Propietario(String nombre, String numeroIdentificacion,
                       String email, String numeroCelular, int edad, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.email = email;
        this.numeroCelular = numeroCelular;
        this.edad = edad;
        this.vehiculo = vehiculo;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNumeroIdentificacion() { return numeroIdentificacion; }
    public void setNumeroIdentificacion(String numeroIdentificacion) { this.numeroIdentificacion = numeroIdentificacion; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNumeroCelular() { return numeroCelular; }
    public void setNumeroCelular(String numeroCelular) { this.numeroCelular = numeroCelular; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }

    public List<VehiculoCarga> getListaVehiculosAsociados() { return listaVehiculosAsociados; }
    public void setListaVehiculosAsociados(List<VehiculoCarga> listaVehiculosAsociados) { this.listaVehiculosAsociados = listaVehiculosAsociados; }

    @Override
    public String toString() {
        return "Propietario{" +
                "nombre='" + nombre + '\'' +
                ", id='" + numeroIdentificacion + '\'' +
                ", edad=" + edad +
                ", email='" + email + '\'' +
                ", celular='" + numeroCelular + '\'' +
                '}';
    }
}





