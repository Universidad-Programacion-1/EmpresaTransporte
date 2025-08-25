package co.edu.uniquindio.TrabajoUno.model;

import co.edu.uniquindio.TrabajoUno.services.IEmpresaTransporteServices;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTransporte implements IEmpresaTransporteServices {
    private String nombre;
    private List<VehiculoCarga> listaVehiculosCarga = new ArrayList<>();
    private List<VehiculoPasajero> listaVehiculosPasajeros = new ArrayList<>();
    private List<Propietario> listaPropietarios = new ArrayList<>();

    public EmpresaTransporte() {}

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<VehiculoCarga> getListaVehiculosCarga() { return listaVehiculosCarga; }
    public List<VehiculoPasajero> getListaVehiculosPasajeros() { return listaVehiculosPasajeros; }
    public List<Propietario> getListaPropietarios() { return listaPropietarios; }

    // Crear propietario con vehículo de carga
    public void crearPropietarioVehiculoCarga(String nombre, String id, String email, String celular, int edad,
                                              String placa, String modelo, String marca, String color, double capacidad, int ejes) {
        VehiculoCarga vehiculoObj = new VehiculoCarga(placa, modelo, marca, color, capacidad);
        vehiculoObj.setNumeroEjes(ejes);

        Propietario propietarioObj = new Propietario(nombre, id, email, celular, edad, vehiculoObj);

        listaPropietarios.add(propietarioObj);
        listaVehiculosCarga.add(vehiculoObj);
    }

    // Lista propietarios con vehículos de carga que superan cierto peso
    public List<Propietario> listaPropietarioPeso(double peso){
        List<Propietario> propietarios = new ArrayList<>();
        System.out.println(listaVehiculosCarga);
        for (VehiculoCarga vehiculo : listaVehiculosCarga) {
            if (vehiculo.getCapacidadCarga() >= peso ){
                Propietario nPropietario = retornarPropietario(vehiculo.getPlaca());
                if (nPropietario != null) {
                    propietarios.add(nPropietario);
                }
            }
        }
        return propietarios;
    }

    private Propietario retornarPropietario(String placa) {
        for (Propietario propietario : listaPropietarios) {
            if (propietario.getVehiculo() != null &&
                    propietario.getVehiculo().getPlaca().equals(placa)) {
                return propietario;
            }
        }
        return null;
    }

    // Propietarios mayores de 40
    public List<Propietario> propietarioMayo(){
        List<Propietario> propietarios = new ArrayList<>();
        for (Propietario propietario : listaPropietarios) {
            if (propietario.getEdad() >= 40 ){
                propietarios.add(propietario);
            }
        }
        return propietarios;
    }

    // Calcular pasajeros transportados en un vehículo por placa
    public int calcularPasajerosPorPlaca(String placa) {
        int pasajeros = 0;
        for (VehiculoPasajero vehiculo : listaVehiculosPasajeros) {
            if (vehiculo.getPlaca().equals(placa)) {
                pasajeros = vehiculo.getNumeroMaximoPasajeros();
            }
        }
        return pasajeros;
    }

    @Override
    public boolean agregarPropietario(String nombre, String numeroIdentificacion, String email, String numeroCelular, int edad) {
        Propietario propietario = obtenerPropietario(numeroIdentificacion);
        if(propietario == null){
            propietario = new Propietario();
            propietario.setNombre(nombre);
            propietario.setNumeroIdentificacion(numeroIdentificacion);
            propietario.setEmail(email);
            propietario.setNumeroCelular(numeroCelular);
            propietario.setEdad(edad);
            getListaPropietarios().add(propietario);

            return true;
        }else{
            return false;
        }
    }

    @Override
    public Propietario obtenerPropietario(String numeroIdentificacion) {
        Propietario propietarioEncontrado = null;
        for (Propietario propietario: getListaPropietarios()) {
            if(propietario.getNumeroIdentificacion().equalsIgnoreCase(numeroIdentificacion)){
                propietarioEncontrado = propietario;
                break;
            }
        }

        return propietarioEncontrado;
    }

    @Override
    public boolean eliminarPropietario(String numeroIdentificacion) {
        Propietario propietario = obtenerPropietario(numeroIdentificacion);
        if(propietario != null){
            getListaPropietarios().remove(propietario);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean actualizarPropietario(String nombre, String numeroIdentificacionActual,
                                         String numeroIdentificacion, String email, String numeroCelular) {
        Propietario propietario = obtenerPropietario(numeroIdentificacionActual);
        if(propietario != null){
            propietario.setNombre(nombre);
            propietario.setNumeroIdentificacion(numeroIdentificacion);
            propietario.setEmail(email);
            propietario.setNumeroCelular(numeroCelular);

            return true;
        }else{
            return false;
        }
    }

}
