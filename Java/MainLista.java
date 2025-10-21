/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alondra Vianney Hernandez Torres
 */
// Actividad 01: Manipulación de Lista Enlazada
// Descripción: Programa que crea, recorre y elimina nodos mayores a un valor dado en una lista enlazada simple.



// Clase Nodo representa un elemento de la lista
class Nodo {
    int dato;       // valor almacenado
    Nodo siguiente; // referencia al siguiente nodo
    String palabras;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

// Clase ListaEnlazada para gestionar los métodos solicitados
class ListaEnlazada {
    Nodo cabeza;

    // Crea la lista enlanzada con numeros aleatorios
    public void crearLista(int cantidad) {
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            int numero = random.nextInt(100) + 1; // genera número entre 1 y 100
            insertarFinal(numero);
        }
    }

    // Inserta al final de la lista
    public void insertarFinal(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        }
    }

    // Recorre la lista y muestra los datos
    public void recorrerLista() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        Nodo temp = cabeza;
        System.out.println("Contenido de la lista:");
        while (temp != null) {
            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        }
        System.out.println("null");
    }

    //Elimina nodos mayores dados que
    public void eliminarMayoresA(int limite) {
        // Eliminar nodos desde la cabeza si son mayores
        while (cabeza != null && cabeza.dato > limite) {
            cabeza = cabeza.siguiente;
        }

        // Recorrer el resto de la lista
        Nodo actual = cabeza;
        while (actual != null && actual.siguiente != null) {
            if (actual.siguiente.dato > limite) {
                actual.siguiente = actual.siguiente.siguiente;
            } else {
                actual = actual.siguiente;
            }
        }
    }
}

/**
 *
 * @author Alondra Vianney Hernandez Torres
 */

public class MainLista {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();

        System.out.println("ACTIVIDAD 01: MANIPULACIÓN DE LISTA ENLAZADA");

        // Crear lista con números aleatorios
        System.out.print("¿Cuántos números desea generar? ");
        int n = sc.nextInt();
        lista.crearLista(n);
        System.out.println("\nLista generada:");
        lista.recorrerLista();

        // Eliminar nodos mayores a un valor
        System.out.print("\nIngrese un valor límite: ");
        int limite = sc.nextInt();
        lista.eliminarMayoresA(limite);

        System.out.println("\nLista después de eliminar nodos mayores a " + limite + ":");
        lista.recorrerLista();
    }
}
