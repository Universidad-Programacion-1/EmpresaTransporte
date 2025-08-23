package co.edu.uniquindio.TrabajoUno;

import co.edu.uniquindio.TrabajoUno.factory.ModelFactory;
import co.edu.uniquindio.TrabajoUno.model.EmpresaTransporte;
import co.edu.uniquindio.TrabajoUno.model.Propietario;

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
                --- Menú Empresa Transporte ---
                1. Crear propietario y vehículo de carga
                2. Calcular pasajeros transportados por vehículo
                3. Listar propietarios con vehículos que superan un peso
                4. Listar propietarios mayores de 40 años
                0. Salir
                """;

        int opcion;
        boolean centinela=true;
        while(centinela){
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1 -> {
                    String nombre = JOptionPane.showInputDialog("Nombre propietario:");
                    String id = JOptionPane.showInputDialog("Número identificación:");
                    String email = JOptionPane.showInputDialog("Email:");
                    String celular = JOptionPane.showInputDialog("Celular:");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
                    String placa = JOptionPane.showInputDialog("Placa vehículo:");
                    String modelo = JOptionPane.showInputDialog("Modelo vehículo:");
                    String marca = JOptionPane.showInputDialog("Marca vehículo:");
                    String color = JOptionPane.showInputDialog("Color vehículo:");
                    double capacidad = Double.parseDouble(JOptionPane.showInputDialog("Capacidad de carga:"));
                    int ejes = Integer.parseInt(JOptionPane.showInputDialog("Número de ejes:"));

                    modelFactory.crearPropietarioVehiculoCarga(nombre, id, email, celular, edad,
                            placa, modelo, marca, color, capacidad, ejes);

                    JOptionPane.showMessageDialog(null, "Propietario y vehículo creados exitosamente.");
                }
                case 2 -> {
                    String placa = JOptionPane.showInputDialog("Ingrese placa vehículo pasajeros:");
                    int total = modelFactory.calcularPasajerosPorPlaca(placa);
                    JOptionPane.showMessageDialog(null, "Total pasajeros registrados: " + total);
                }
                case 3 -> {
                    double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese peso límite:"));
                    List<Propietario> propietarios = modelFactory.listaPropietarioPeso(peso);
                    JOptionPane.showMessageDialog(null, "Propietarios encontrados:\n" + propietarios);
                }
                case 4 -> {
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
}
