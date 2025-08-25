package co.edu.uniquindio.TrabajoUno.services;

import co.edu.uniquindio.TrabajoUno.model.Propietario;
import co.edu.uniquindio.TrabajoUno.model.VehiculoPasajero;

public interface IVehiculoPasajeroServices {
    boolean agregarVehiculoPasajero(String placa, String modelo, String marca, String color, int numeroMaximoPasajeros);

    VehiculoPasajero obtenerVehiculoPasajero(String placa);

    boolean eliminarVehiculoPasajero(String placa);


    boolean actualizarVehiculoPasajero(String placa, String modelo, String marca, String color, int numeroMaximoPasajeros);
}
