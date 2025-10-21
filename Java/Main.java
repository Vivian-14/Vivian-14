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
//Lista Doblemente Enlazada de Caracteres  


class Nodo {
    char dato;
    Nodo anterior;
    Nodo siguiente;

    public Nodo(char dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }
}

// Clase ListaDoble que maneja la estructura y el ordenamiento
class ListaDoble {
    private Nodo cabeza;
    private Nodo cola;

    // Agrega un carácter al final de la lista
    public void agregarCaracter(char c) {
        Nodo nuevo = new Nodo(c);

        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    // Método para mostrar la lista (de inicio a fin)
    public void mostrarLista() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // Método para ordenar alfabéticamente usando burbuja
    public void ordenarLista() {
        if (cabeza == null) return;

        boolean huboIntercambio;
        do {
            huboIntercambio = false;
            Nodo actual = cabeza;

            while (actual.siguiente != null) {
                if (actual.dato > actual.siguiente.dato) {
                    // Intercambio de valores
                    char temp = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = temp;
                    huboIntercambio = true;
                }
                actual = actual.siguiente;
            }
        } while (huboIntercambio);
    }
}

// Clase principal con la lógica del programa
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDoble lista = new ListaDoble();

        System.out.println(" Lista Doblemente Enlazada de Caracteres ");
        System.out.print("Ingresa una cadena de texto: ");
        String cadena = sc.nextLine();

        // 1. Lectura y construcción de la lista
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            lista.agregarCaracter(c);
        }

        System.out.println("\nLista original:");
        lista.mostrarLista();

        // 2. Ordenamiento alfabético
        lista.ordenarLista();

        // 3. Mostrar lista ordenada
        System.out.println("\nLista ordenada alfabéticamente:");
        lista.mostrarLista();

        sc.close();
    }
}
