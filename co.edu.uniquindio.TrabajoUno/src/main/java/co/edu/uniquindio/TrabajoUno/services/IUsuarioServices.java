package co.edu.uniquindio.TrabajoUno.services;

import co.edu.uniquindio.TrabajoUno.model.Usuario;

public interface IUsuarioServices {

    boolean agregarUsuario(int edad, String numeroIdentificacion);

    Usuario obtenerUsuario(String numeroIdentificacion);

    boolean eliminarUsuario(String numeroIdentificacion);


    boolean actualizarUsuario(int edad, String numeroIdentificacion);
}
