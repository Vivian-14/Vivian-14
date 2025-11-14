
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquetePilas;

import java.util.Stack;
import java.util.Scanner;
/**
 *
 * @author vians
 */

/*
 * Nombre: Alondra Vianney Hernández Torres GTID141
 * Actividad: Ejercicio 6 - Decimal a Binario
 * Descripción: Este programa convierte un número decimal a binario
 * usando una pila para almacenar los restos de las divisiones.
 */
/**
 * Clase Ejercicio6
 * Aquí se practica el uso de una pila para resolver un problema matemático:
 * convertir un número decimal en binario sin usar funciones predefinidas.
 * La pila ayuda a invertir el orden de los restos obtenidos.
 */
public class DecimalBinario6<T> { 
    public static void main(String[] args) {
        
        // Scanner para leer el número ingresado por el usuario
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese un número decimal: ");
        int num = sc.nextInt(); // Se guarda el número
        
        // Pila de enteros para guardar los restos de las divisiones
        Stack<Integer> pila = new Stack<>();
        
        // Mientras el número sea mayor que cero, se calculan los restos
        while (num > 0) {
            int residuo = num % 2; // Se obtiene el residuo de la división entre 2
            pila.push(residuo);    // Se apila el residuo
            num = num / 2;         // Se actualiza el número dividiéndolo entre 2
        }
        
        System.out.print("Número en binario: ");
        
        // Se desapilan los elementos para mostrarlos en el orden correcto
        while (!pila.isEmpty()) {
            System.out.print(pila.pop());
            // El pop saca el último residuo guardado,
            // permitiendo imprimir el número binario completo en orden correcto.
        }
        
        sc.close(); // Se cierra el Scanner shi
    }
}
