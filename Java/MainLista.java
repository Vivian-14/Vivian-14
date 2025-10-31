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
// Actividad 01: Manipulación de Lista Enlazada Genérica
// Descripción: Programa que crea, recorre y elimina nodos mayores a un valor dado en una lista enlazada simple genérica.

// Clase Nodo genérica
class Nodo<T> {
    T dato;           // Valor almacenado (genérico)
    Nodo<T> siguiente; // Referencia al siguiente nodo

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

// Clase ListaEnlazada genérica
class ListaEnlazada<T extends Comparable<T>> { // <T> tipo que puede compararse
    Nodo<T> cabeza;

    // Inserta al final de la lista
    public void insertarFinal(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> temp = cabeza;
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
        Nodo<T> temp = cabeza;
        System.out.println("Contenido de la lista:");
        while (temp != null) {
            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        }
        System.out.println("null");
    }

    // Elimina nodos mayores a un valor límite
    public void eliminarMayoresA(T limite) {
        // Eliminar desde la cabeza si el dato es mayor
        while (cabeza != null && cabeza.dato.compareTo(limite) > 0) {
            cabeza = cabeza.siguiente;
        }

        // Recorrer el resto
        Nodo<T> actual = cabeza;
        while (actual != null && actual.siguiente != null) {
            if (actual.siguiente.dato.compareTo(limite) > 0) {
                actual.siguiente = actual.siguiente.siguiente;
            } else {
                actual = actual.siguiente;
            }
        }
    }

    // Crea una lista de enteros aleatorios (solo si T es Integer)
    public void crearListaEnteros(int cantidad) {
        if (!(cabeza instanceof Nodo) || cantidad <= 0) return;
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            @SuppressWarnings("unchecked")
            T valor = (T) (Integer) (random.nextInt(100) + 1);
            insertarFinal(valor);
        }
    }
}

// Clase principal para probar la lista genérica
public class MainLista {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        System.out.println("ACTIVIDAD 01: MANIPULACIÓN DE LISTA ENLAZADA GENÉRICA");

        // Crear lista con números aleatorios
        System.out.print("¿Cuántos números desea generar? ");
        int n = sc.nextInt();
        lista.crearListaEnteros(n);

        System.out.println("\nLista generada:");
        lista.recorrerLista();

        // Eliminar nodos mayores a un valor dado
        System.out.print("\nIngrese un valor límite: ");
        int limite = sc.nextInt();
        lista.eliminarMayoresA(limite);

        System.out.println("\nLista después de eliminar nodos mayores a " + limite + ":");
        lista.recorrerLista();
    }
}
