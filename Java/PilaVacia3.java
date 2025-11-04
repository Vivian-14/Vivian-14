

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquetePilas;
import java.util.Stack;
/**
 *
 * @author vians
 */
/*
 * Nombre: Alondra Vianney Hernández Torres GTID141
 * Actividad: Ejercicio 3 - Verificar si una pila está vacía
 * Descripción: Este programa comprueba si una pila tiene elementos
 * utilizando el método isEmpty().
 */


/**
 * Clase Ejercicio3
 * En este ejercicio se aprende a verificar si una pila está vacía.
 * El método isEmpty() devuelve true si la pila no tiene elementos,
 * y false si ya contiene algo.
 */
public class PilaVacia3<T> { // <-- Se agregó la clase genérica <T>
    public static void main(String[] args) {
        
        // Se crea una pila vacía de tipo entero
        Stack<Integer> pila = new Stack<>();
        
        // Comprobamos si la pila está vacía (debería ser true)
        System.out.println("¿Está vacía la pila? " + pila.isEmpty());
        // Como no hemos agregado nada, el resultado será true.
        
        // Agregamos un elemento a la pila
        pila.push(1);
        // Ahora la pila tiene un número, así que ya no está vacía.
        
        // Volvemos a comprobar
        System.out.println("¿Está vacía la pila? " + pila.isEmpty());
        //Ahora debe mostrar false, porque ya hay un elemento dentro.
    }
}
