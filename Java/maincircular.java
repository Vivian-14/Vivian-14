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
//Polinomio con Lista Enlazada Circular                
//Objetivo: Modificar la representación de un polinomio mediante lista enlazada simple para que se convierta en una lista circular, optimizando el acceso y recorrido continuo.



class Nodo {
    double coeficiente;
    int exponente;
    Nodo siguiente;

    public Nodo(double coef, int exp) {
        this.coeficiente = coef;
        this.exponente = exp;
        this.siguiente = null;
    }
}

// Clase para manejar la lista circular del polinomio
class ListaCircularPolinomio {
    private Nodo ultimo; // referencia al último nodo

    // Método para agregar un término al polinomio
    public void agregarTermino(double coef, int exp) {
        Nodo nuevo = new Nodo(coef, exp);

        if (ultimo == null) {
            // Primer nodo: apunta a sí mismo
            ultimo = nuevo;
            ultimo.siguiente = ultimo;
        } else {
            // Inserta después del último y actualiza referencia circular
            nuevo.siguiente = ultimo.siguiente; // el primero
            ultimo.siguiente = nuevo;
            ultimo = nuevo; // el nuevo se convierte en el último
        }
    }

    // Método para mostrar el polinomio en forma legible
    public void mostrarPolinomio() {
        if (ultimo == null) {
            System.out.println("El polinomio está vacío.");
            return;
        }

        Nodo actual = ultimo.siguiente; // empieza en el primero
        System.out.print("P(x) = ");
        do {
            System.out.print(actual.coeficiente + "x^" + actual.exponente);
            actual = actual.siguiente;
            if (actual != ultimo.siguiente) System.out.print(" + ");
        } while (actual != ultimo.siguiente);
        System.out.println();
    }

    // Método para evaluar el polinomio en un valor dado de x
    public double evaluar(double x) {
        if (ultimo == null) return 0.0;

        double resultado = 0.0;
        Nodo actual = ultimo.siguiente; // comienza desde el primero

        do {
            resultado += actual.coeficiente * Math.pow(x, actual.exponente);
            actual = actual.siguiente;
        } while (actual != ultimo.siguiente);

        return resultado;
    }

    // Muestra una tabla de valores de P(x)
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
        ListaCircularPolinomio polinomio = new ListaCircularPolinomio();

        System.out.println("=== Polinomio con Lista Enlazada Circular ===");
        System.out.print("¿Cuántos términos tendrá el polinomio?: ");
        int n = sc.nextInt();

        // Entrada de coeficientes y exponentes
        for (int i = 0; i < n; i++) {
            System.out.println("\nTérmino " + (i + 1) + ":");
            System.out.print("Coeficiente: ");
            double coef = sc.nextDouble();
            System.out.print("Exponente: ");
            int exp = sc.nextInt();
            polinomio.agregarTermino(coef, exp);
        }

        // Mostrar el polinomio completo
        System.out.println();
        polinomio.mostrarPolinomio();

        // Mostrar tabla de valores
        polinomio.mostrarTablaValores();

        sc.close();
    }
}
