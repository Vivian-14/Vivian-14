/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to edit this license
 */

package com.mycompany.pruebacola;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Alondra Vianney
 * GTID141 - 24 de Octubre del 2025 (Tema Colas)
 */

public class Cola<T> {  
    public static void main(String[] args) {
        // Crear una cola usando el tipo String
        Cola<String> cola = new Cola<>();
        cola.ejecutarCola();
    }

    public void ejecutarCola() {
        
        Queue<T> colaTareas = new LinkedList<>();

        // Agregar elementos (cast explícito para mantener la lógica sin cambiar nada)
        colaTareas.add((T) "Preparar café");   // T1
        colaTareas.add((T) "Revisar emails");  // T2
        colaTareas.add((T) "Iniciar proyecto"); // T3

        // Solicitar el tamaño
        System.out.println("Tamaño de la cola: " + colaTareas.size());

        // Consultar frente
        System.out.println("Frente de la cola: " + colaTareas.peek());

        // Quitar tarea 1 y desplegar tarea ejecutada
        T tareaEjecutada = colaTareas.poll();
        System.out.println("Tarea ejecutada: " + tareaEjecutada);

        // Quitar tarea 2 y desplegar tarea solicitada
        T tareaSiguiente = colaTareas.poll();
        System.out.println("Tarea siguiente ejecutada: " + tareaSiguiente);

        // Estado final de la cola
        System.out.println("Estado final de la cola: " + colaTareas);
    }
}
