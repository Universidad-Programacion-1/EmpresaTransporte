package co.edu.uniquindio.TrabajoUno.model;

public class Usuario {
    private int edad;
    private String numeroIdentificacion;

    public Usuario() {}

    public Usuario(int edad, String numeroIdentificacion) {
        this.edad = edad;
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNumeroIdentificacion() {return numeroIdentificacion;}

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;}
}
