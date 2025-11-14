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
 * Actividad: Ejercicio 4 - Invertir una palabra
 * Descripción: Este programa invierte una palabra usando una pila de caracteres.
 */

/**
 * Clase Ejercicio4
 * En este ejercicio se usa una pila para invertir el orden de los caracteres
 * de una palabra. La pila nos ayuda porque el último carácter en entrar
 * será el primero en salir, logrando así la inversión.
 */
public class invertirPalabra4<T> { 
    public static void main(String[] args) {
        
        // Scanner sirve para leer lo que escribe el usuario
        Scanner sc = new Scanner(System.in);
        
        // Pedimos la palabra
        System.out.print("Ingrese una palabra: ");
        String palabra = sc.nextLine(); // Se guarda la palabra ingresada
        
        // Se crea una pila de caracteres para ir guardando las letras
        Stack<Character> pila = new Stack<>();
        
        // Recorremos la palabra y apilamos cada letra
        for (char c : palabra.toCharArray()) {
            pila.push(c); // Se apila cada carácter
            // cada letra se va guardando una encima de la otra
        }
        
        System.out.print("Palabra invertida: ");
        
        // Mientras la pila tenga elementos, los sacamos (desapilamos)
        while (!pila.isEmpty()) {
            System.out.print(pila.pop()); // Imprimimos sin salto de línea
            //Aquí se imprime la palabra al revés
        }
        
        sc.close(); // Cerramos el Scanner pa la memoria osisissisi
    }
}

