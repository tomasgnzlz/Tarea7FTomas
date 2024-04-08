/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package tarea7f;

import com.mycompany.tarea7ctomas.LecturaEscritura;
import com.mycompany.tarea7ctomas.Persona;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

/**
 *
 * @author tomas
 */
public class Tarea7FTomas {

    public static void main(String[] args) {
        List<String> listaString = new ArrayList<>();
        listaString = LecturaEscritura.leerFichero("personas.csv");
        listaString.forEach(System.out::println);
        System.out.println("\n");

        // Creo la lista de personas en la que guardar los datos del método
        List<Persona> listaPersonas = obtenerListaPersonas(listaString);
        listaPersonas.forEach(System.out::println);

        // 
    }

    // Método que devuelve lista de personas a partir de la lista de String
    public static List<Persona> obtenerListaPersonas(List<String> listaLineas) {
        List<Persona> listaPersonas = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for (String l : listaLineas) {
            // Separo la lineas por las comas que tengan
            String[] array = l.split(",");

            // Guardo lada elemento del array en una variable
            String id = array[0];
            String nombre = array[1];
            String apellido = array[2];
            String email = array[3];
            String genero = array[4];
            LocalDate fechaNacimiento = LocalDate.parse(array[5], formatter);
            boolean jubilado = Boolean.valueOf(array[6]);
            String ciudad = array[7];

            // Creo el objeto persona a partir de los parametros obtenids.
            Persona pAux = new Persona(id, nombre, apellido, email, genero, fechaNacimiento, jubilado, ciudad);
            listaPersonas.add(pAux);
        }
        return listaPersonas;
    }

    // Método que ordena por email
    // Obtener una lista de personas nacidas en 1985, ordenadas por su email.
    public static List<Persona> listasViejosClasicos(List<Persona> listaPersonas) {
        List<Persona> listasViejos = new ArrayList<>();
        for (Persona pAux : listaPersonas) {
            if (pAux.getFechaNacimiento().getYear() == 1985) {
                listasViejos.add(pAux);
            }
        }
        return listasViejos;
    }

    public static Stream<Persona> listaViejosStream(List<Persona> listaPersonas) {
        return listaPersonas.stream().filter(p -> p.getFechaNacimiento().getYear() == 1985);
    }
}
