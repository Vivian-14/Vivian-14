/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paqueteColas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 *
 * @author vians
 */

/*
 * Nombre: Alondra Vianney Hernández Torres  GTID141
 * Actividad: Ejercicio 1 - Comparación de Colas
 * Descripción: Programa que compara dos colas y determina si son idénticas,
 * es decir, si tienen los mismos elementos en el mismo orden.
*/

/**
 * Clase Ejercicio1
 * Aquí se trabaja con colas, una estructura FIFO (First In, First Out),
 * donde el primer elemento en entrar es el primero en salir.
 * El objetivo es comparar dos colas y verificar si son iguales.
 */
public class ComparacionDeColas1<T>  { 

   // Método para comparar dos colas sin perder su contenido
    public static boolean compararColas(Queue<Integer> cola1, Queue<Integer> cola2) {
        // Si los tamaños no son iguales, ya no pueden ser idénticas
        if (cola1.size() != cola2.size()) {
            return false;
        }

        // Creo dos colas auxiliares para guardar los datos mientras comparo
        Queue<Integer> aux1 = new LinkedList<>();
        Queue<Integer> aux2 = new LinkedList<>();
        boolean iguales = true; // esta variable servirá para saber si todo coincide

        // Mientras las colas tengan elementos, comparo uno por uno
        while (!cola1.isEmpty()) {
            int elemento1 = cola1.remove(); // saco el elemento de la primera cola
            int elemento2 = cola2.remove(); // saco el elemento de la segunda cola

            // Guardo los valores en las colas auxiliares para restaurar después
            aux1.add(elemento1);
            aux2.add(elemento2);

            // Si los elementos son diferentes, ya no son iguales
            if (elemento1 != elemento2) {
                iguales = false;
            }
        }

        // Restaura las colas originales usando las auxiliares
        // Esto lo hago para que al final las colas queden igual que al inicio
        while (!aux1.isEmpty()) {
            cola1.add(aux1.remove());
            cola2.add(aux2.remove());
        }

        // Retorna el resultado final
        return iguales;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> colaA = new LinkedList<>();
        Queue<Integer> colaB = new LinkedList<>();

        // Pido al usuario cuántos elementos tendrá cada cola
        System.out.print("¿Cuántos elementos tendrá cada cola? ");
        int n = sc.nextInt();

        // Llenar la primera cola
        System.out.println("\n--- Ingrese los elementos de la primera cola ---");
        for (int i = 1; i <= n; i++) {
            System.out.print("Elemento " + i + ": ");
            colaA.add(sc.nextInt()); // agrego a la cola
        }

        // Llenar la segunda cola
        System.out.println("\n--- Ingrese los elementos de la segunda cola ---");
        for (int i = 1; i <= n; i++) {
            System.out.print("Elemento " + i + ": ");
            colaB.add(sc.nextInt());
        }

        // Mostrar el contenido de ambas colas
        System.out.println("\nCola A: " + colaA);
        System.out.println("Cola B: " + colaB);

        // Llamar al método para comparar
        boolean iguales = compararColas(colaA, colaB);

        // Mostrar resultado final
        System.out.println("\n¿Las colas son idénticas? " + iguales);
    }

}
