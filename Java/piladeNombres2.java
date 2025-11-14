/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquetePilas;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author vians
 */
/*
 * Nombre: Alondra Vianney Hernández Torres GTID141
 * Actividad: Ejercicio 2 - Pila de nombres
 * Descripción: Programa que permite al usuario ingresar varios nombres
 * y luego los muestra en orden inverso usando una pila.
 */

/**
 * Clase que representa el ejercicio de la pila de nombres.
 * El objetivo es comprender cómo se comporta una pila (estructura LIFO)
 * y practicar su uso en Java con la clase Stack.
 */
public class piladeNombres2<T> { 

    public static void main(String[] args) {
        
        // Scanner sirve para leer los datos que el usuario escribe en consola
        Scanner sc = new Scanner(System.in);
        
        // Se declara una pila de tipo String para almacenar los nombres
        Stack<String> pila = new Stack<>();
        
        // Variable temporal donde se guardará el nombre ingresado por el usuario
        String nombre;
        
        System.out.println("=== Pila de Nombres ===");
        System.out.println("Ingrese nombres uno por uno. Escriba 'FIN' para terminar.\n");
        
        // Aquí empieza el ciclo de lectura de nombres
        while (true) {
            System.out.print("Ingrese un nombre (FIN para salir): ");
            nombre = sc.nextLine(); // Se lee lo que el usuario escribe
            
            // Si el usuario escribe FIN (sin importar mayúsculas), el ciclo se detiene
            if (nombre.equalsIgnoreCase("FIN")) {
                break;
            }
            
            // Apilamos el nombre, o sea, lo agregamos al tope de la pila
            pila.push(nombre);
            // Cada vez que hago push, el nombre queda encima del anterior,
            // como si fuera una torre de nombres.
        }
        
        System.out.println("\nNombres en orden inverso:");
        
        // Ahora desapilamos los nombres para mostrarlos al revés
        while (!pila.isEmpty()) {
            // pop() saca el nombre que está hasta arriba
            System.out.println(pila.pop());
        }
        
        // el último nombre que ingresé será el primero en mostrarse.
        
        sc.close(); // Cerramos el Scanner para liberar recursos
    }
}

