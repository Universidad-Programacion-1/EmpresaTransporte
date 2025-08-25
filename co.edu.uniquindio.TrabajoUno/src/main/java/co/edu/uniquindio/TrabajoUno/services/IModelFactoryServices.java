package co.edu.uniquindio.TrabajoUno.services;

public interface IModelFactoryServices extends IPropietarioServices, IVehiculoPasajeroServices{

    String buscarVehiculoCargaPlaca(String placa);
    String buscarPropietarioNombre(String nombre);
}
