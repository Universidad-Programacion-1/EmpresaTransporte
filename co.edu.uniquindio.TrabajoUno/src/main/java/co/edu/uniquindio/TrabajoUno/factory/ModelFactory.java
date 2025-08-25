package co.edu.uniquindio.TrabajoUno.factory;

import co.edu.uniquindio.TrabajoUno.model.*;
import co.edu.uniquindio.TrabajoUno.services.IModelFactoryServices;

import java.util.List;

public class ModelFactory implements IModelFactoryServices {
    private static ModelFactory instance;
    EmpresaTransporte empresaTransporte;


    private ModelFactory() {}

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    public EmpresaTransporte inicializarDatos() {
        EmpresaTransporte empresa = new EmpresaTransporte();
        empresa.setNombre("La carreta");

        // Vehículos de carga
        VehiculoCarga vehiculoCarga = new VehiculoCarga("33A", "2020", "Chevrolet", "Rojo", 200);
        vehiculoCarga.setNumeroEjes(2);

        VehiculoCarga vehiculoCarga2 = new VehiculoCarga("33B", "2021", "Renault", "Blanco", 500);
        vehiculoCarga2.setNumeroEjes(4);

        // Vehículos de pasajeros
        VehiculoPasajero vehiculoPasajero1 = new VehiculoPasajero("44A", "2018", "Toyota", "Azul", 10);
        VehiculoPasajero vehiculoPasajero2 = new VehiculoPasajero("44B", "2019", "ferrari", "Gris", 15);
        VehiculoPasajero vehiculoPasajero3 = new VehiculoPasajero("44C", "2020", "tinto", "Negro", 20);

        // Propietario
        Propietario propietario = new Propietario("Pedro", "123", "pedro.com", "414141", 45, vehiculoCarga);
        propietario.getListaVehiculosAsociados().add(vehiculoCarga2);

        empresa.getListaVehiculosCarga().add(vehiculoCarga);
        empresa.getListaVehiculosCarga().add(vehiculoCarga2);
        empresa.getListaVehiculosPasajeros().add(vehiculoPasajero1);
        empresa.getListaVehiculosPasajeros().add(vehiculoPasajero2);
        empresa.getListaVehiculosPasajeros().add(vehiculoPasajero3);
        empresa.getListaPropietarios().add(propietario);

        this.empresaTransporte = empresa;
        return empresa;
    }

    public EmpresaTransporte getEmpresaTransporte() {
        return empresaTransporte;
    }

    public void crearPropietarioVehiculoCarga(String nombre, String id, String email, String celular, int edad,
                                              String placa, String modelo, String marca, String color, double capacidad, int ejes){
        getEmpresaTransporte().crearPropietarioVehiculoCarga(nombre, id, email, celular, edad, placa, modelo, marca, color, capacidad, ejes);
    }



    public int calcularPasajerosPorPlaca(String placa) {
        return  getEmpresaTransporte().calcularPasajerosPorPlaca(placa);
    }

    public List<Propietario> listaPropietarioPeso(double peso) {
        return getEmpresaTransporte().listaPropietarioPeso(peso);
    }
    public List<Propietario> propietarioMayo(){
        return getEmpresaTransporte().propietarioMayo();
    }


    @Override
    public String buscarVehiculoCargaPlaca(String placa) {
        return "";
    }

    @Override
    public String buscarPropietarioNombre(String nombre) {
        return "";
    }

    @Override
    public boolean agregarPropietario(String nombre, String numeroIdentificacion, String email, String numeroCelular, int edad) {
        return empresaTransporte.agregarPropietario(nombre, numeroIdentificacion, email, numeroCelular);
    }

    @Override
    public Propietario obtenerPropietario(String numeroIdentificacion) {
        return empresaTransporte.obtenerPropietario(numeroIdentificacion);
    }

    @Override
    public boolean eliminarPropietario(String numeroIdentificacion) {
        return empresaTransporte.eliminarPropietario(numeroIdentificacion);
    }

    @Override
    public boolean actualizarPropietario(String nombre, String numeroIdentificacionActual, String numeroIdentificacion, String email, String numeroCelular) {
        return empresaTransporte.actualizarPropietario(nombre, numeroIdentificacionActual, numeroIdentificacion, email, numeroCelular);
    }

    @Override
    public boolean agregarUsuario(int edad, String numeroIdentificacion) {
        return empresaTransporte.agregarUsuario(edad, numeroIdentificacion);
    }

    @Override
    public Usuario obtenerUsuario(String numeroIdentificacion) {
        return empresaTransporte.obtenerUsuario(numeroIdentificacion);
    }

    @Override
    public boolean eliminarUsuario(String numeroIdentificacion) {
        return empresaTransporte.eliminarUsuario(numeroIdentificacion);
    }

    @Override
    public boolean actualizarUsuario(int edad, String numeroIdentificacion) {
        return empresaTransporte.actualizarUsuario(edad, numeroIdentificacion);
    }

    @Override
    public boolean agregarVehiculoCarga(String placa, String modelo, String marca,
                                        String color, double capacidadCarga,
                                        int numeroEjes) {
        return empresaTransporte.agregarVehiculoCarga(placa, modelo, marca, color,
                capacidadCarga, numeroEjes);
    }

    @Override
    public VehiculoCarga obtenerVehiculoCarga(String placa) {
        return empresaTransporte.obtenerVehiculoCarga(placa);
    }

    @Override
    public boolean eliminarVehiculoCarga(String numeroIdentificacion) {
        return empresaTransporte.eliminarUsuario(numeroIdentificacion);
    }

    @Override
    public boolean actualizarVehiculoCarga(String placa, String modelo, String marca,
                                           String color, double capacidadCarga, int numeroEjes) {
        return empresaTransporte.actualizarVehiculoCarga(placa, modelo, marca,
                color, capacidadCarga, numeroEjes);
    }
}

