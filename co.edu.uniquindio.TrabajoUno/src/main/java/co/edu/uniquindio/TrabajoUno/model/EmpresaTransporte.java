package co.edu.uniquindio.TrabajoUno.model;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTransporte {
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
}
