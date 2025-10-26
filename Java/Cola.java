/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


package com.mycompany.pruebacola;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Alondra Vianney Hernandez Torres
 * //GTID141 a 24 de Octubre del 2025 (Tema Colas)
 */

public class Cola {
    public static void main(String[] args) {
        // Crear un objeto cola
        Queue<String> colaTareas = new LinkedList<>();

        //tareas agg
        colaTareas.add("Preparar café");   // T1
        colaTareas.add("Revisar emails");  // T2
        colaTareas.add("Iniciar proyecto"); // T3

        // Solicitar el tamaño
        System.out.println("Tamaño de la cola: " + colaTareas.size());

        //Consultar frente
        System.out.println("Frente de la cola: " + colaTareas.peek());

        // Quitar tarea 1 y desplegar tarea ejecutada
        String tareaEjecutada = colaTareas.poll();
        System.out.println("Tarea ejecutada: " + tareaEjecutada);

        // Quitar tarea 2 y desplegar tarea solicitada
        String tareaSiguiente = colaTareas.poll();
        System.out.println("Tarea siguiente ejecutada: " + tareaSiguiente);

        // Estado final de la cola
        System.out.println("Estado final de la cola: " + colaTareas);
    }
    
}


