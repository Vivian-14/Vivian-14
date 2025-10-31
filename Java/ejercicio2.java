/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej2;
import java.io.*;
import java.util.*;

/**
 *
 * @author Alondra Vianney Hernandez Torres
 */
// Actividad 02: Lista Enlazada de Palabras desde Archivo
// Objetivo:
// Desarrollar un programa que lea palabras desde un archivo de texto y las almacene en una
// lista enlazada, permitiendo su manipulación dinámica.

public class ejercicio2<T> { // <-- Se agrega <T> para usar tipo genérico
    // Clase interna Nodo, ahora genérica
    class Nodo {
        T palabra;    // dato genérico (puede ser String, Integer, etc.)
        Nodo sig;     // referencia al siguiente nodo

        Nodo(T palabra) { // constructor
            this.palabra = palabra;
            this.sig = null;
        }
    }

    Nodo cabeza = null; // inicio de la lista

    // Inserta un elemento al final de la lista
    void insertar(T palabra) {
        Nodo nuevo = new Nodo(palabra);
        if (cabeza == null) cabeza = nuevo; // si la lista está vacía
        else {
            Nodo temp = cabeza;
            while (temp.sig != null) temp = temp.sig; // recorre hasta el final
            temp.sig = nuevo; // enlaza el nuevo nodo al final
        }
    }

    // Elimina la primera aparición del elemento indicado
    boolean eliminar(T palabra) {
        if (cabeza == null) return false; // lista vacía, no hay nada que borrar

        // Si el primer nodo es el que se debe eliminar
        if (cabeza.palabra.equals(palabra)) {
            cabeza = cabeza.sig; // se salta el primer nodo
            return true;
        }

        // Recorre buscando coincidencia
        Nodo ant = cabeza, temp = cabeza.sig;
        while (temp != null) {
            if (temp.palabra.equals(palabra)) { // si encuentra la palabra
                ant.sig = temp.sig; // desconecta el nodo
                return true;
            }
            ant = temp;
            temp = temp.sig;
        }
        return false; // si no la encontró
    }

    // Muestra el contenido actual de la lista
    void mostrar() {
        Nodo temp = cabeza;
        while (temp != null) {
            System.out.print(temp.palabra + " "); // imprime palabra por palabra
            temp = temp.sig; // avanza al siguiente nodo
        }
        System.out.println(); // salto de línea al final
    }

    // Lee elementos desde un archivo y los inserta en la lista
    void leerArchivo(String nombreArchivo) {
        try (Scanner sc = new Scanner(new File(nombreArchivo))) {
            while (sc.hasNext()) insertar((T) sc.next()); // inserta palabra tras palabra
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }
    }

    // Escribe todos los elementos de la lista a un archivo
    void escribirArchivo(String nombreArchivo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nombreArchivo))) {
            Nodo temp = cabeza;
            while (temp != null) {
                pw.print(temp.palabra + " "); // guarda cada palabra separada por espacio
                temp = temp.sig;
            }
        } catch (IOException e) {
            System.out.println("Error escribiendo archivo: " + e.getMessage());
        }
    }

    // Mainsito
    public static void main(String[] args) {
        // Se usa tipo String en la lista genérica
        ejercicio2<String> lista = new ejercicio2<>();
        Scanner sc = new Scanner(System.in);
        String archivo = "palabras.txt"; // archivo de texto base

        lista.leerArchivo(archivo); // carga las palabras del archivo
        int opc;
        do {
            // Menú interactivo simple
            System.out.println("\n1. Mostrar\n2. Añadir\n3. Eliminar\n4. Guardar y salir");
            System.out.print("Opción: ");
            opc = sc.nextInt();
            sc.nextLine(); // limpia el buffer

            switch (opc) {
                case 1 -> lista.mostrar(); // muestra contenido
                case 2 -> {
                    System.out.print("Palabra nueva: ");
                    lista.insertar(sc.nextLine()); // añade palabra nueva
                }
                case 3 -> {
                    System.out.print("Palabra a eliminar: ");
                    if (lista.eliminar(sc.nextLine())) System.out.println("Eliminada.");
                    else System.out.println("No encontrada.");
                }
                case 4 -> {
                    lista.escribirArchivo(archivo); // guarda cambios
                    System.out.println("Archivo guardado.");
                }
                default -> System.out.println("Opción inválida.");
            }
        } while (opc != 4); 
    }
}


