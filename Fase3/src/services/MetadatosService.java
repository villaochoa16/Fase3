/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.Metadatos;
import entities.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Luis Ochoa
 */
public class MetadatosService {

    public List<Metadatos> leerArchivo(String rutaArchivo) {
        List<Metadatos> listaMetadatos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            // Leer la primera línea (encabezado) y descartarla
            br.readLine();

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("~");
                if (partes.length == 11) { // Asegurarse de que hay suficientes campos en la línea
                    Metadatos metadato = new Metadatos(
                            partes[0], partes[1], partes[2], partes[3], partes[4],
                            partes[5], partes[6], partes[7], partes[8], partes[9],
                            partes[10]
                    );
                    listaMetadatos.add(metadato);
                } else if (partes.length == 12) {
                    Metadatos metadato = new Metadatos(
                            partes[0], partes[1], partes[2], partes[3], partes[4],
                            partes[5], partes[6], partes[7], partes[8], partes[9],
                            partes[10], partes[11]
                    );
                    listaMetadatos.add(metadato);
                } else {
                    System.out.println("La línea no tiene el formato esperado: " + linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return listaMetadatos;
    }

    private void gestionarArchivoUsuarios() {
        // Obtener el directorio actual de trabajo
        String directorioActual = System.getProperty("user.dir");

        try {
            File archivoUsuarios = new File(directorioActual, "metadatos.txt");
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
    public List<Metadatos> obtenerReporte(Date fechaInicio, Date fechaFin) {
        List<Metadatos> listaMetadatos = new ArrayList<>();
        List<Metadatos> resultados = new ArrayList<>();

        String rutaArchivo = System.getProperty("user.dir") + "/metadatos.txt";
         Gson gson = new GsonBuilder().create();
        
        try (Reader reader = new FileReader(rutaArchivo)) {
            // Leer el contenido del archivo y convertirlo en una lista de usuarios
            listaMetadatos = gson.fromJson(reader, new TypeToken<List<Metadatos>>(){}.getType());
            //return listaMetadatos;
        } catch (IOException e) {
            e.printStackTrace();
        }
        Date fechaMetadato = null;
            
        for (Metadatos metadato : listaMetadatos) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                fechaMetadato = sdf.parse(metadato.getFechaEmision());
            } catch (ParseException e) {
                e.printStackTrace();
                continue;
            }
            if (fechaMetadato != null && fechaMetadato.compareTo(fechaInicio) >= 0 && fechaMetadato.compareTo(fechaFin) <= 0) {
                resultados.add(metadato);
            }
        }

        return resultados;
    }

    public boolean registrarMetadatos(List<Metadatos> nuevosMetadatos) {
        String directorioActual = System.getProperty("user.dir");
        String rutaMetadatos = directorioActual + "/metadatos.txt";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            List<Metadatos> existentesMetadatos = new ArrayList<>();

            // Verificar si el archivo existe
            File archivo = new File(rutaMetadatos);
            if (archivo.exists()) {
                // Si el archivo existe, leer su contenido y convertirlo a una lista de metadatos
                try (Reader reader = new FileReader(rutaMetadatos)) {
                    existentesMetadatos = gson.fromJson(reader, new TypeToken<List<Metadatos>>() {
                    }.getType());
                }
            }

            // Iterar sobre los nuevos metadatos
            for (Metadatos nuevoMetadato : nuevosMetadatos) {
                boolean encontrado = false;
                // Buscar si el UUID del nuevo metadato ya existe en la lista de metadatos existentes
                for (Metadatos existenteMetadato : existentesMetadatos) {
                    if (existenteMetadato.getUuid().equals(nuevoMetadato.getUuid())) {
                        if (!existenteMetadato.getEstatus().equals(nuevoMetadato.getEstatus())) {
                            // Si el UUID existe, actualizar los campos estatus y fechaCancelacion
                            existenteMetadato.setEstatus(nuevoMetadato.getEstatus());
                            existenteMetadato.setFechaCancelacion(nuevoMetadato.getFechaCancelacion());
                            encontrado = true;
                            break; // Salir del bucle, ya que se ha encontrado el metadato
                        }
                        encontrado = true;
                        break;
                    }
                }
                // Si el UUID no existe, agregar el nuevo metadato a la lista de metadatos existentes
                if (!encontrado) {
                    existentesMetadatos.add(nuevoMetadato);
                }
            }

            // Escribir la lista combinada de metadatos al archivo
            try (Writer writer = new FileWriter(rutaMetadatos)) {
                gson.toJson(existentesMetadatos, writer);
            }
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
