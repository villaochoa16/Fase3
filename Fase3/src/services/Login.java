/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.Usuario;
import java.io.*;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;
import java.util.*;
import javax.json.JsonArray;
import javax.json.JsonValue;
import javax.json.stream.JsonParsingException;
import java.util.HashMap;
import java.util.Map;

/** 
 *
 * @author Jose Luis Ochoa
 */
public class Login {
    public String rutaUsuarios;
    public Login(){
        gestionarArchivoUsuarios();
        this.rutaUsuarios = "usuarios.txt";
    }
    // Método para registrar un nuevo usuario
    public boolean registrarUsuario(List<Usuario> nuevosUsuarios) {
    String directorioActual = System.getProperty("user.dir");
    rutaUsuarios = directorioActual + "/usuarios.txt";
    
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        try {
            List<Usuario> usuariosExistente = new ArrayList<>();

            // Verificar si el archivo existe
            File archivo = new File(rutaUsuarios);
            if (archivo.exists()) {
                // Si el archivo existe, leer su contenido y convertirlo a una lista de usuarios
                try (Reader reader = new FileReader(rutaUsuarios)) {
                    usuariosExistente = gson.fromJson(reader, new TypeToken<List<Usuario>>(){}.getType());
                }
            }

            // Agregar los nuevos usuarios a la lista existente
            if(usuariosExistente==null){
                usuariosExistente=nuevosUsuarios;
            }
            else{
                usuariosExistente.addAll(nuevosUsuarios);
            }
            
            // Escribir la lista combinada de usuarios al archivo
            try (Writer writer = new FileWriter(rutaUsuarios)) {
                gson.toJson(usuariosExistente, writer);
            }
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    // Método para iniciar sesión
    public boolean iniciarSesion(String correoElectronico, String contraseña) {
    String directorioActual = System.getProperty("user.dir");
    rutaUsuarios = directorioActual + "/usuarios.txt";
    
     Gson gson = new GsonBuilder().create();
        
        try (Reader reader = new FileReader(rutaUsuarios)) {
            // Leer el contenido del archivo y convertirlo en una lista de usuarios
            List<Usuario> usuarios = gson.fromJson(reader, new TypeToken<List<Usuario>>(){}.getType());
            
            // Buscar el usuario en la lista por nombre de usuario
            for (Usuario usuario : usuarios) {
                if (usuario.getCorreo().equals(correoElectronico)) {
                    // Si se encuentra el usuario, verificar la contraseña
                    return usuario.getContraseña().equals(contraseña);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Si no se encuentra el usuario o hay un error de lectura, retornar falso
        return false;
    }
    // Método para gestionar el archivo de usuarios
    private void gestionarArchivoUsuarios() {
        // Obtener el directorio actual de trabajo
        String directorioActual = System.getProperty("user.dir");
        rutaUsuarios ="usuarios.txt";

        try {
            File archivoUsuarios = new File(directorioActual, rutaUsuarios);
            // Verificar si el archivo de usuarios no existe
            if (!archivoUsuarios.exists()) {
                // Crear el archivo en el directorio actual de trabajo
                archivoUsuarios.createNewFile();
                System.out.println("Archivo de usuarios creado en: " + archivoUsuarios.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Error al gestionar el archivo de usuarios: " + e.getMessage());
        }
    }
}
