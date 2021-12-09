package com.example.appbasica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveData {
    static boolean PacienteLogExist(String ruta) {
        Path archivo = Paths.get(ruta);
        return archivo.toFile().canWrite();
    }

    static boolean EspecialistaLogExist(String ruta) {
        Path archivo = Paths.get(ruta);
        return archivo.toFile().canWrite();
    }

    static void crearArchivo(String ruta, String contenido) {
        Path archivo = Paths.get(ruta);
        try {
            Files.write(archivo, contenido.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String leerArchivo(String ruta) {
        String contenido = "";
        try {
            Path archivo = Paths.get(ruta);
            contenido = new String(Files.readAllBytes(archivo));
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser leído");
        }
        return contenido;
    }

    static void nuevaLinea(String ruta, String contenido) {
        String oldContenido = leerArchivo(ruta);
        crearArchivo(ruta, oldContenido + "\n" + contenido);
    }

    static void eliminarArchivo(String ruta) {
        try {
            Path archivo = Paths.get(ruta);
            Files.deleteIfExists(archivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void guardarUsers() {
        eliminarArchivo(getRuta());
        crearArchivo(getRuta(), "Nombre,Nickname,Email,ID");
        for (UserProfile u: UserProfile.Users) {
            nuevaLinea(getRuta(), u.toString());
        }
    }

    public static String getRuta() {
        return "src/main/res/Users.CSV";
    }

//    static void guardarPacientes() {
//        eliminarArchivo(Init.rutaP);
//        crearArchivo(Init.rutaP, "Nombre,Apellido,Rut,FechaRealizada");
//        for (Paciente p : Paciente.pacientes) {
//            nuevaLinea(Init.rutaP, p.toString());
//        }
//    }
//
//    static void guardarHoras() {
//        eliminarArchivo(Init.rutaA);
//        crearArchivo(Init.rutaA, "Fecha,Nombre,Especialista,Hora");
//        for (Agenda a : Especialista.horasAgendadas) {
//            nuevaLinea(Init.rutaA, a.toString());
//        }
//    }
}
