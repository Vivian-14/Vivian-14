/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Circular;
import java.util.Scanner;
/**
 *
 * @author Alondra Vianney Hernandez Torres
 */
//Actividad 04 
//Polinomio con Lista Enlazada Circular (usando clase genérica <T>)
//Objetivo: Aplicar listas enlazadas circulares usando tipos genéricos para mayor flexibilidad.


class Nodo<T> {
    T coeficiente;
    int exponente;
    Nodo<T> siguiente;

    public Nodo(T coef, int exp) {
        this.coeficiente = coef;
        this.exponente = exp;
        this.siguiente = null;
    }
}

// Clase genérica que maneja un polinomio usando lista circular
class ListaCircularPolinomio<T extends Number> {
    private Nodo<T> ultimo; // referencia al último nodo (permite recorrer circularmente)

    // Agrega un término al final del polinomio
    public void agregarTermino(T coef, int exp) {
        Nodo<T> nuevo = new Nodo<>(coef, exp);

        if (ultimo == null) {
            // Primer nodo: apunta a sí mismo (lista circular)
            ultimo = nuevo;
            ultimo.siguiente = ultimo;
        } else {
            // Inserta el nuevo después del último y mantiene el enlace circular
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
            ultimo = nuevo; // ahora el nuevo se convierte en el último
        }
    }

    // Muestra el polinomio completo
    public void mostrarPolinomio() {
        if (ultimo == null) {
            System.out.println("El polinomio está vacío.");
            return;
        }

        Nodo<T> actual = ultimo.siguiente; // empieza desde el primero
        System.out.print("P(x) = ");
        do {
            System.out.print(actual.coeficiente + "x^" + actual.exponente);
            actual = actual.siguiente;
            if (actual != ultimo.siguiente) System.out.print(" + ");
        } while (actual != ultimo.siguiente);
        System.out.println();
    }

    // Evalúa el polinomio para un valor de x
    public double evaluar(double x) {
        if (ultimo == null) return 0.0;

        double resultado = 0.0;
        Nodo<T> actual = ultimo.siguiente;

        do {
            // Se convierte el coeficiente genérico a double para operar con Math.pow()
            double coef = actual.coeficiente.doubleValue();
            resultado += coef * Math.pow(x, actual.exponente);
            actual = actual.siguiente;
        } while (actual != ultimo.siguiente);

        return resultado;
    }

    // Genera una tabla con valores de P(x)
    public void mostrarTablaValores() {
        System.out.println("\nTabla de valores:");
        System.out.println(" x\t|\tP(x)");
        System.out.println("------------------------");

        for (double x = 0.0; x <= 5.0; x += 0.5) {
            double px = evaluar(x);
            System.out.printf(" %.1f\t|\t%.4f\n", x, px);
        }
    }
}

public class maincircular {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // La clase se instancia usando Double para permitir operaciones numéricas
        ListaCircularPolinomio<Double> polinomio = new ListaCircularPolinomio<>();

        System.out.println("=== Polinomio con Lista Enlazada Circular (Genérica) ===");
        System.out.print("¿Cuántos términos tendrá el polinomio?: ");
        int n = sc.nextInt();

        // Ingreso de datos del usuario
        for (int i = 0; i < n; i++) {
            System.out.println("\nTérmino " + (i + 1) + ":");
            System.out.print("Coeficiente: ");
            double coef = sc.nextDouble();
            System.out.print("Exponente: ");
            int exp = sc.nextInt();
            polinomio.agregarTermino(coef, exp);
        }

        // Mostrar polinomio y tabla de valores
        System.out.println();
        polinomio.mostrarPolinomio();
        polinomio.mostrarTablaValores();

        sc.close();
    }
}

