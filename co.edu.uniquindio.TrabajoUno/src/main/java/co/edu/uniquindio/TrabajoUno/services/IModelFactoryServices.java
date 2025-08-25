package co.edu.uniquindio.TrabajoUno.services;

public interface IModelFactoryServices extends IPropietarioServices, IUsuarioServices, IVehiculoCargaServices{

    String buscarVehiculoCargaPlaca(String placa);
    String buscarPropietarioNombre(String nombre);
}
