/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasDobleC;
import java.util.Scanner;
/**
 *
 * @author Alondra Vianney Hernandez Torres
 */
//Actividad 05 
//Lista Doblemente Enlazada de Caracteres (usando clase genérica <T>)
//Objetivo: Implementar una lista doblemente enlazada genérica con ordenamiento básico.



// Clase Nodo genérica: puede almacenar cualquier tipo de dato (por ejemplo, Character)
class Nodo<T> {
    T dato;
    Nodo<T> anterior;
    Nodo<T> siguiente;

    public Nodo(T dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }
}

// Clase genérica para manejar la lista doblemente enlazada
// Se limita a tipos que implementen Comparable (para poder comparar y ordenar)
class ListaDoble<T extends Comparable<T>> {
    private Nodo<T> cabeza;
    private Nodo<T> cola;

    // Agrega un elemento al final de la lista
    public void agregarElemento(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);

        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    // Muestra la lista de inicio a fin
    public void mostrarLista() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // Ordena la lista con el método burbuja
    public void ordenarLista() {
        if (cabeza == null) return;

        boolean huboIntercambio;
        do {
            huboIntercambio = false;
            Nodo<T> actual = cabeza;

            while (actual.siguiente != null) {
                // Compara los datos usando compareTo()
                if (actual.dato.compareTo(actual.siguiente.dato) > 0) {
                    // Intercambio de valores
                    T temp = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = temp;
                    huboIntercambio = true;
                }
                actual = actual.siguiente;
            }
        } while (huboIntercambio);
    }
}

// Clase principal con el flujo del programa
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Se usa tipo Character para trabajar con caracteres individuales
        ListaDoble<Character> lista = new ListaDoble<>();

        System.out.println("=== Lista Doblemente Enlazada de Caracteres (Genérica) ===");
        System.out.print("Ingresa una cadena de texto: ");
        String cadena = sc.nextLine();

        // 1. Crear la lista con cada carácter ingresado
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            lista.agregarElemento(c);
        }

        // 2. Mostrar lista original
        System.out.println("\nLista original:");
        lista.mostrarLista();

        // 3. Ordenar lista alfabéticamente
        lista.ordenarLista();

        // 4. Mostrar lista ordenada
        System.out.println("\nLista ordenada alfabéticamente:");
        lista.mostrarLista();

        sc.close();
    }
}

