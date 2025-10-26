/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebacola;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Alondra Vianney
 * GTID141 a 24 de Octubre del 2025 (Tema Colas)
 */

public class PruebaCola{
    public static void main(String[] args) {
        Queue<String> colaTareas = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\n=== MENÚ DE COLA DE TAREAS ===");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Consultar frente de la cola");
            System.out.println("3. Ejecutar tarea");
            System.out.println("4. Mostrar estado de la cola");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingresa la tarea a agregar: ");
                    String tarea = sc.nextLine();
                    colaTareas.add(tarea);
                    System.out.println("Tarea agregada: " + tarea);
                    break;
                    
                case 2:
                    if (!colaTareas.isEmpty()) {
                        System.out.println("Frente de la cola: " + colaTareas.peek());
                    } else {
                        System.out.println("La cola está vacía");
                    }
                    break;
                    
                case 3:
                    if (!colaTareas.isEmpty()) {
                        String tareaEjecutada = colaTareas.poll();
                        System.out.println("Tarea ejecutada: " + tareaEjecutada);
                    } else {
                        System.out.println("No hay tareas para ejecutar");
                    }
                    break;
                    
                case 4:
                    System.out.println("Estado actual de la cola: " + colaTareas);
                    break;
                    
                case 5:
                    System.out.println("Saliendo del programa");
                    break;
                    
                default:
                    System.out.println("Opción no válida, intenta de nuevo");
            }
            
        } while (opcion != 5);
        
        sc.close();
    }
}
