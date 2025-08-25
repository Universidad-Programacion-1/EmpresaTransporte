package co.edu.uniquindio.TrabajoUno.services;

import co.edu.uniquindio.TrabajoUno.model.VehiculoCarga;

public interface IVehiculoCargaServices {
    boolean agregarVehiculoCarga(String placa, String modelo, String marca,
                                 String color, double capacidadCarga,
                                 int numeroEjes);

    VehiculoCarga obtenerVehiculoCarga(String placa);

    boolean eliminarVehiculoCarga(String placa);


    boolean actualizarVehiculoCarga(String placa, String modelo, String marca,
                                    String color, double capacidadCarga,
                                    int numeroEjes);
}
