package co.edu.uniquindio.TrabajoUno;

import co.edu.uniquindio.TrabajoUno.factory.ModelFactory;
import co.edu.uniquindio.TrabajoUno.model.*;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();
        EmpresaTransporte empresaTransporte = modelFactory.inicializarDatos();
        menu(modelFactory);
    }

    public static void menu ( ModelFactory modelFactory) {

        String menu = """
                --- Menú Empresa Transporte La Carreta---
                1. Gestion propietario
                2. Gestion Vehiculo de Carga
                3. Gestion Vehiculo de Pasajeros
                4. Gestion Usuario
                5. Calcular pasajeros transportados por vehículo
                6. Listar propietarios con vehículos que superan un peso
                7. Listar propietarios mayores de 40 años
                0. Salir
                """;

        int opcion;
        boolean centinela=true;
        while(centinela){
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1 -> {
                    menuPropietario(modelFactory);
                }
                case 2 -> {
                    menuVehiculoCarga(modelFactory);
                }
                case 3 -> {
                    menuVehiculoPasajero(modelFactory);
                }
                case 4 -> {
                    menuUsuarios(modelFactory);
                }
                case 5 -> {
                    String placa = JOptionPane.showInputDialog("Ingrese placa vehículo pasajeros:");
                    int total = modelFactory.calcularPasajerosPorPlaca(placa);
                    JOptionPane.showMessageDialog(null, "Total pasajeros registrados: " + total);
                }
                case 6 -> {
                    double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese peso límite:"));
                    List<Propietario> propietarios = modelFactory.listaPropietarioPeso(peso);
                    JOptionPane.showMessageDialog(null, "Propietarios encontrados:\n" + propietarios);
                }
                case 7 -> {
                    List<Propietario> propietarios = modelFactory.propietarioMayo();
                    JOptionPane.showMessageDialog(null, "Propietarios mayores de 40:\n" + propietarios);
                }
                case 0 -> {
                    centinela = false;
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                }
                default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    public static void menuPropietario ( ModelFactory modelFactory) {

        String menu = """
                --- Menú Empresa Transporte La Carreta---
                --- Gestion de Propietarios---
                1. Crear propietario
                2. Actualizar propietario
                3. Buscar propietario
                4. Eliminar propietario
                0. Atras
                """;

        int opcion;
        boolean centinela=true;
        while(centinela){
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1 -> {
                    if (agregarPropietario(modelFactory)){
                        JOptionPane.showMessageDialog(null, "Propietario creado exitosamente.");
                        break;
                    }else {
                        JOptionPane.showMessageDialog(null, "Fallo al crear Propietario.");
                        break;
                    }
                }
                case 2 -> {
                    if (actualizarPropietario(modelFactory)){
                        JOptionPane.showMessageDialog(null, "Propietario actualizado exitosamente.");
                        break;
                    }else  {
                        JOptionPane.showMessageDialog(null, "Fallo al actualizar Propietario.");
                        break;
                    }
                }
                case 3 -> {
                    Propietario propietario = buscarPropietario(modelFactory);
                    if (propietario != null){
                        JOptionPane.showMessageDialog(null, "Propietario buscado exitosamente \n" + propietario);
                        break;
                    }else  {
                        JOptionPane.showMessageDialog(null, "Fallo al buscar Propietario.");
                        break;
                    }
                }
                case 4 -> {
                    if (eliminarPropietario(modelFactory)){
                        JOptionPane.showMessageDialog(null, "Propietario eliminado exitosamente.");
                        break;
                    }else  {
                        JOptionPane.showMessageDialog(null, "Fallo al eliminar Propietario.");
                        break;
                    }
                }
                case 0 -> {
                    centinela = false;
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                }
                default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    public static void menuVehiculoPasajero ( ModelFactory modelFactory) {

        String menu = """
                --- Menú Empresa Transporte La Carreta---
                --- Gestion de Vehiculo de pasajeros---
                1. Crear vehiculo de pasajeros
                2. Actualizar vehiculo de pasajeros
                3. Buscar vehiculo de pasajeros
                4. Eliminar vehiculo de pasajeros
                0. Atras
                """;

        int opcion;
        boolean centinela=true;
        while(centinela){
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1 -> {
                    if (agregarVehiculoPasajero(modelFactory)){
                        JOptionPane.showMessageDialog(null, "Vehiculo de pasajeros creado exitosamente.");
                        break;
                    }else {
                        JOptionPane.showMessageDialog(null, "Fallo al crear Vehiculo de pasajeros.");
                        break;
                    }
                }
                case 2 -> {
                    if (actualizarVehiculoPasajero(modelFactory)){
                        JOptionPane.showMessageDialog(null, "Vehiculo de pasajeros actualizado exitosamente.");
                        break;
                    }else  {
                        JOptionPane.showMessageDialog(null, "Fallo al actualizar Vehiculo de pasajeros.");
                        break;
                    }
                }
                case 3 -> {
                    VehiculoPasajero vehiculoPasajero = buscarVehiculoPasajero(modelFactory);
                    if (vehiculoPasajero != null){
                        JOptionPane.showMessageDialog(null, "Vehiculo de pasajeros buscado exitosamente \n" + vehiculoPasajero);
                        break;
                    }else  {
                        JOptionPane.showMessageDialog(null, "Fallo al buscar Vehiculo de pasajeros.");
                        break;
                    }
                }
                case 4 -> {
                    if (eliminarVehiculoPasajero(modelFactory)){
                        JOptionPane.showMessageDialog(null, "Vehiculo de pasajeros eliminado exitosamente.");
                        break;
                    }else  {
                        JOptionPane.showMessageDialog(null, "Fallo al eliminar Vehiculo de pasajeros.");
                        break;
                    }
                }
                case 0 -> {
                    centinela = false;
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                }
                default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    public static void menuVehiculoCarga ( ModelFactory modelFactory) {

        String menu = """
                --- Menú Empresa Transporte La Carreta---
                --- Gestion de Vehiculo de Carga---
                1. Crear vehiculo de carga
                2. Actualizar vehiculo de carga
                3. Buscar vehiculo de carga
                4. Eliminar vehiculo de carga
                0. Atras
                """;

        int opcion;
        boolean centinela=true;
        while(centinela){
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1 -> {
                    if (agregarVehiculoCarga(modelFactory)){
                        JOptionPane.showMessageDialog(null, "Vehiculo de Carga creado exitosamente.");
                        break;
                    }else {
                        JOptionPane.showMessageDialog(null, "Fallo al crear Vehiculo de Carga.");
                        break;
                    }
                }
                case 2 -> {
                    if (actualizarVehiculoCarga(modelFactory)){
                        JOptionPane.showMessageDialog(null, "Vehiculo de Carga actualizado exitosamente.");
                        break;
                    }else  {
                        JOptionPane.showMessageDialog(null, "Fallo al actualizar Vehiculo de Carga.");
                        break;
                    }
                }
                case 3 -> {
                    VehiculoCarga vehiculoCarga = obtenerVehiculoCarga(modelFactory);
                    if (vehiculoCarga != null){
                        JOptionPane.showMessageDialog(null, "Vehiculo de Carga buscado exitosamente \n" + vehiculoCarga);
                        break;
                    }else  {
                        JOptionPane.showMessageDialog(null, "Fallo al buscar Vehiculo de Carga.");
                        break;
                    }
                }
                case 4 -> {
                    if (eliminarVehiculoCarga(modelFactory)){
                        JOptionPane.showMessageDialog(null, "Vehiculo de Carga eliminado exitosamente.");
                        break;
                    }else  {
                        JOptionPane.showMessageDialog(null, "Fallo al eliminar Vehiculo de Carga.");
                        break;
                    }
                }
                case 0 -> {
                    centinela = false;
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                }
                default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    public static void menuUsuarios ( ModelFactory modelFactory) {

        String menu = """
                --- Menú Empresa Transporte La Carreta---
                --- Gestion de Usuarios---
                1. Crear usuario
                2. Actualizar usuario
                3. Buscar usuario
                4. Eliminar usuario
                0. Atras
                """;

        int opcion;
        boolean centinela=true;
        while(centinela){
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1 -> {
                    if (agregarUsuario(modelFactory)){
                        JOptionPane.showMessageDialog(null, "Usuario creado exitosamente.");
                        break;
                    }else {
                        JOptionPane.showMessageDialog(null, "Fallo al crear Usuario.");
                        break;
                    }
                }
                case 2 -> {
                    if (actualizarUsuario(modelFactory)){
                        JOptionPane.showMessageDialog(null, "Usuario actualizado exitosamente.");
                        break;
                    }else  {
                        JOptionPane.showMessageDialog(null, "Fallo al actualizar Usuario.");
                        break;
                    }
                }
                case 3 -> {
                    Usuario usuario = buscarUsuario(modelFactory);
                    if (usuario != null){
                        JOptionPane.showMessageDialog(null, "Usuario buscado exitosamente \n" + usuario);
                        break;
                    }else  {
                        JOptionPane.showMessageDialog(null, "Fallo al buscar Usuario.");
                        break;
                    }
                }
                case 4 -> {
                    if (eliminarUsuario(modelFactory)){
                        JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente.");
                        break;
                    }else  {
                        JOptionPane.showMessageDialog(null, "Fallo al eliminar Usuario.");
                        break;
                    }
                }
                case 0 -> {
                    centinela = false;
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                }
                default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    public static boolean agregarPropietario (ModelFactory modelFactory) {
        String nombre = JOptionPane.showInputDialog("Nombre propietario:");
        String id = JOptionPane.showInputDialog("Número identificación:");
        String email = JOptionPane.showInputDialog("Email:");
        String celular = JOptionPane.showInputDialog("Celular:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
        boolean exito = modelFactory.agregarPropietario(nombre, id, email, celular, edad);
        return exito;
    }

    public static boolean actualizarPropietario (ModelFactory modelFactory) {
        String id = JOptionPane.showInputDialog("Número identificación:");
        String nombre = JOptionPane.showInputDialog("Nuevo nombre propietario:");
        String idnuevo = JOptionPane.showInputDialog("Nuevo número identificación:");
        String email = JOptionPane.showInputDialog("Nuevo email:");
        String celular = JOptionPane.showInputDialog("Nuevo celular:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Nuevo edad:"));
        boolean exito = modelFactory.actualizarPropietario(nombre, id,idnuevo, email, celular, edad);
        return exito;
    }

    public static Propietario buscarPropietario (ModelFactory modelFactory) {
        String id = JOptionPane.showInputDialog("Número identificación:");
        Propietario propietario = modelFactory.obtenerPropietario(id);
        return propietario;
    }

    public static boolean eliminarPropietario (ModelFactory modelFactory) {
        String id = JOptionPane.showInputDialog("Número identificación:");
        boolean exito = modelFactory.eliminarPropietario(id);
        return exito;
    }

    public static boolean agregarVehiculoPasajero (ModelFactory modelFactory) {
        String placa = JOptionPane.showInputDialog("Placa del vehiculo:");
        String modelo = JOptionPane.showInputDialog("Modelo del vehiculo:");
        String marca = JOptionPane.showInputDialog("Marca del vehiculo:");
        String color = JOptionPane.showInputDialog("Color  del vehiculo:");
        int numeroMaximoPasajeros = Integer.parseInt(JOptionPane.showInputDialog("Numero maximo pasajeros:"));
        boolean exito = modelFactory.agregarVehiculoPasajero(placa, modelo, marca, color, numeroMaximoPasajeros);
        return exito;
    }

    public static boolean actualizarVehiculoPasajero (ModelFactory modelFactory) {
        String placa = JOptionPane.showInputDialog("Placa del vehiculo:");
        String modelo = JOptionPane.showInputDialog("Modelo del vehiculo:");
        String marca = JOptionPane.showInputDialog("Marca del vehiculo:");
        String color = JOptionPane.showInputDialog("Color  del vehiculo:");
        int numeroMaximoPasajeros = Integer.parseInt(JOptionPane.showInputDialog("Numero maximo pasajeros:"));
        boolean exito = modelFactory.actualizarVehiculoPasajero(placa, modelo, marca, color, numeroMaximoPasajeros);
        return exito;
    }

    public static VehiculoPasajero buscarVehiculoPasajero (ModelFactory modelFactory) {
        String placa = JOptionPane.showInputDialog("Placa del vehiculo:");
        VehiculoPasajero vehiculoPasajero = modelFactory.obtenerVehiculoPasajero(placa);
        return vehiculoPasajero;
    }

    public static boolean eliminarVehiculoPasajero (ModelFactory modelFactory) {
        String placa = JOptionPane.showInputDialog("Placa del  vehiculo:");
        boolean exito = modelFactory.eliminarVehiculoPasajero(placa);
        return exito;
    }

    public static boolean agregarVehiculoCarga (ModelFactory modelFactory) {

        String placa = JOptionPane.showInputDialog("placa del Vehiculo deCarga:");
        String modelo = JOptionPane.showInputDialog("modelo del Vehiculo de Carga:");
        String marca = JOptionPane.showInputDialog("marca del Vehiculo deCarga:");
        String color = JOptionPane.showInputDialog("color del Vehiculo deCarga:");
        double capacidadCarga = Double.parseDouble(JOptionPane.showInputDialog("capacidad de carga:"));
        int numeroEjes = Integer.parseInt(JOptionPane.showInputDialog("numero de ejes:"));

        boolean exito = modelFactory.agregarVehiculoCarga(placa, modelo, marca, color, capacidadCarga, numeroEjes);
        return exito;

    }

    public static boolean actualizarVehiculoCarga (ModelFactory modelFactory) {
        String placa = JOptionPane.showInputDialog("Placa del vehiculo:");
        String modelo = JOptionPane.showInputDialog("Modelo del vehiculo:");
        String marca = JOptionPane.showInputDialog("Marca del vehiculo:");
        String color = JOptionPane.showInputDialog("Color  del vehiculo:");
        double capacidadCarga = Double.parseDouble(JOptionPane.showInputDialog("capacidad de carga:"));
        int numeroEjes = Integer.parseInt(JOptionPane.showInputDialog("numero de ejes:"));

        boolean exito = modelFactory.actualizarPropietario(placa, modelo, marca, color, String.valueOf(capacidadCarga), numeroEjes);
        return exito;
    }

    public static VehiculoCarga obtenerVehiculoCarga (ModelFactory modelFactory) {
        String placa = JOptionPane.showInputDialog("placa del Vehiculo de Carga:");
        VehiculoCarga vehiculoCarga = modelFactory.obtenerVehiculoCarga(placa);
        return vehiculoCarga;
    }

    public static boolean eliminarVehiculoCarga (ModelFactory modelFactory) {
        String placa = JOptionPane.showInputDialog("placa del Vehiculo de Carga:");
        boolean exito = modelFactory.eliminarPropietario(placa);
        return exito;
    }

    public static boolean agregarUsuario (ModelFactory modelFactory) {
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del usuario:"));
        String numeroIdentificacion = JOptionPane.showInputDialog("Número de identificación del usuario:");
        boolean exito = modelFactory.agregarUsuario(edad, numeroIdentificacion);
        return exito;
    }

    public static boolean actualizarUsuario (ModelFactory modelFactory) {
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del usuario:"));
        String numeroIdentificacion = JOptionPane.showInputDialog("Número de identificación del usuario:");
        boolean exito = modelFactory.actualizarUsuario(edad, numeroIdentificacion);
        return exito;
    }

    public static Usuario buscarUsuario (ModelFactory modelFactory) {
        String numeroIdentificacion = JOptionPane.showInputDialog("Número de identificación del usuario:");
        Usuario usuario = modelFactory.obtenerUsuario(numeroIdentificacion);
        return usuario;
    }

    public static boolean eliminarUsuario (ModelFactory modelFactory) {
        String numeroIdentificacion = JOptionPane.showInputDialog("Número de identificación del usuario:");
        boolean exito = modelFactory.eliminarUsuario(numeroIdentificacion);
        return exito;
    }
}
