/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listasss;
import java.util.Scanner;
/**
 *
 * @author Alondra Vianney Hernandez Torres
 */

//Actividad 03  
//Representación y Evaluación de Polinomios con Listas Enlazadas



class Nodo {
    double coeficiente;
    int exponente;
    Nodo siguiente;

    public Nodo(double coeficiente, int exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
        this.siguiente = null;
    }
}

class ListaPolinomio {
    private Nodo cabeza;

    public void agregarTermino(double coeficiente, int exponente) {
        Nodo nuevo = new Nodo(coeficiente, exponente);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    // Evalúa el polinomio en un valor x
    public double evaluar(double x) {
        double resultado = 0.0;
        Nodo actual = cabeza;
        while (actual != null) {
            resultado += actual.coeficiente * Math.pow(x, actual.exponente);
            actual = actual.siguiente;
        }
        return resultado;
    }

    // Muestra la lista como polinomio
    public void mostrarPolinomio() {
        Nodo actual = cabeza;
        System.out.print("P(x) = ");
        while (actual != null) {
            System.out.print(actual.coeficiente + "x^" + actual.exponente);
            if (actual.siguiente != null) System.out.print(" + ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}

public class Listasss{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaPolinomio polinomio = new ListaPolinomio();

        System.out.println("=== Representación y Evaluación de Polinomios con Listas Enlazadas ===");
        System.out.print("¿Cuántos términos tendrá el polinomio?: ");
        int n = sc.nextInt();

        // Entrada de términos
        for (int i = 0; i < n; i++) {
            System.out.println("\nTérmino " + (i + 1) + ":");
            System.out.print("Coeficiente: ");
            double coef = sc.nextDouble();
            System.out.print("Exponente: ");
            int exp = sc.nextInt();
            polinomio.agregarTermino(coef, exp);
        }

        // Mostrar polinomio
        System.out.println();
        polinomio.mostrarPolinomio();

        // Evaluación del polinomio
        System.out.println("\nTabla de valores:");
        System.out.println(" x\t|\tP(x)");
        System.out.println("------------------------");
        for (double x = 0.0; x <= 5.0; x += 0.5) {
            double px = polinomio.evaluar(x);
            System.out.printf(" %.1f\t|\t%.4f\n", x, px);
        }

        sc.close();
    }
}


