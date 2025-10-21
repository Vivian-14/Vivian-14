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
//Actividad 02: Lista Enlazada de Palabras desde Archivo
//Objetivo:
//Desarrollar un programa que lea palabras desde un archivo de texto y las almacene en una
//lista enlazada, permitiendo su manipulación dinámica.


public class ejercicio2 {
    // cada nodo tiene una palabra y el enlace al siguiente
    class Nodo {
        String palabra;
        Nodo sig;
        Nodo(String palabra) {
            this.palabra = palabra;
            this.sig = null;
        }
    }

    Nodo cabeza = null; // inicio de la lista

    // Inserta una palabra al final de la lista
    void insertar(String palabra) {
        Nodo nuevo = new Nodo(palabra);
        if (cabeza == null) cabeza = nuevo;
        else {
            Nodo temp = cabeza;
            while (temp.sig != null) temp = temp.sig;
            temp.sig = nuevo;
        }
    }

    // Elimina la primera aparición de la palabra
    boolean eliminar(String palabra) {
        if (cabeza == null) return false;
        if (cabeza.palabra.equals(palabra)) {
            cabeza = cabeza.sig;
            return true;
        }
        Nodo ant = cabeza, temp = cabeza.sig;
        while (temp != null) {
            if (temp.palabra.equals(palabra)) {
                ant.sig = temp.sig;
                return true;
            }
            ant = temp;
            temp = temp.sig;
        }
        return false;
    }

    // Muestra las palabras en consola
    void mostrar() {
        Nodo temp = cabeza;
        while (temp != null) {
            System.out.print(temp.palabra + " ");
            temp = temp.sig;
        }
        System.out.println();
    }

    // Lee palabras desde un archivo y las guarda en la lista
    void leerArchivo(String nombreArchivo) {
        try (Scanner sc = new Scanner(new File(nombreArchivo))) {
            while (sc.hasNext()) insertar(sc.next());
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }
    }

    // Escribe todas las palabras de la lista al archivo
    void escribirArchivo(String nombreArchivo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nombreArchivo))) {
            Nodo temp = cabeza;
            while (temp != null) {
                pw.print(temp.palabra + " ");
                temp = temp.sig;
            }
        } catch (IOException e) {
            System.out.println("Error escribiendo archivo: " + e.getMessage());
        }
    }

    // Programa principal con menú
    public static void main(String[] args) {
        ListaArchivo lista = new ListaArchivo();
        Scanner sc = new Scanner(System.in);
        String archivo = "palabras.txt";

        lista.leerArchivo(archivo);
        int opc;
        do {
            System.out.println("\n1. Mostrar\n2. Añadir\n3. Eliminar\n4. Guardar y salir");
            System.out.print("Opción: ");
            opc = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opc) {
                case 1 -> lista.mostrar();
                case 2 -> {
                    System.out.print("Palabra nueva: ");
                    lista.insertar(sc.nextLine());
                }
                case 3 -> {
                    System.out.print("Palabra a eliminar: ");
                    if (lista.eliminar(sc.nextLine())) System.out.println("Eliminada.");
                    else System.out.println("No encontrada.");
                }
                case 4 -> {
                    lista.escribirArchivo(archivo);
                    System.out.println("Archivo guardado.");
                }
            }
        } while (opc != 4);
    }
}

