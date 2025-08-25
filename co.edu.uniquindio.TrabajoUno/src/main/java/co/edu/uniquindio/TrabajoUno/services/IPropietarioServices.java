package co.edu.uniquindio.TrabajoUno.services;

import co.edu.uniquindio.TrabajoUno.model.Propietario;

public interface IPropietarioServices {


    boolean agregarPropietario(String nombre,
                               String numeroIdentificacion,
                               String email,
                               String numeroCelular,
                               int edad);

    Propietario obtenerPropietario(String numeroIdentificacion);

    boolean eliminarPropietario(String numeroIdentificacion);


    boolean actualizarPropietario(String nombre,
                                  String numeroIdentificacionActual,
                                  String numeroIdentificacion,
                                  String email,
                                  String numeroCelular,
                                  int edad);

}