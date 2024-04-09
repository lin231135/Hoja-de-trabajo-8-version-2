/*
 * Autor: Javier Alexander Linares Chang - 231135
 * Fecha: 08/04/2024
 * Descripción: Este programa maneja un sistema de atención médica que lee pacientes de un archivo de texto,
 *              los agrega a una cola de prioridad y permite al usuario interactuar con ellos mediante un menú.
 */

package uvg.edu.gt;

 import java.io.File;
 import java.io.FileNotFoundException;
 import java.util.PriorityQueue;
 import java.util.Scanner;
 
 public class Main {
     public static void main(String[] args) {
         PriorityQueue<Paciente> pacientes = new PriorityQueue<>();
 
         try {
             File file = new File("pacientes.txt");
             Scanner scanner = new Scanner(file);
             while (scanner.hasNextLine()) {
                 String line = scanner.nextLine();
                 String[] parts = line.split(",");
                 String nombre = parts[0].trim();
                 String sintoma = parts[1].trim();
                 char codigoEmergencia = parts[2].trim().charAt(0);
                 pacientes.add(new Paciente(nombre, sintoma, codigoEmergencia));
             }
             scanner.close();
         } catch (FileNotFoundException e) {
             System.out.println("Error: Archivo no encontrado.");
             e.printStackTrace();
         }
 
         // Menú interactivo
         Scanner input = new Scanner(System.in);
         int opcion;
         do {
             System.out.println("\nMenú:");
             System.out.println("1. Ver próximo paciente a ser atendido");
             System.out.println("2. Atender paciente");
             System.out.println("3. Salir");
             System.out.print("Ingrese su opción: ");
             opcion = input.nextInt();
 
             switch (opcion) {
                 case 1:
                     if (!pacientes.isEmpty()) {
                         System.out.println("Próximo paciente a ser atendido:");
                         System.out.println(pacientes.peek());
                     } else {
                         System.out.println("No hay pacientes en espera.");
                     }
                     break;
                 case 2:
                     if (!pacientes.isEmpty()) {
                         Paciente pacienteAtendido = pacientes.poll();
                         System.out.println("Paciente atendido:");
                         System.out.println(pacienteAtendido);
                     } else {
                         System.out.println("No hay pacientes en espera.");
                     }
                     break;
                 case 3:
                     System.out.println("Saliendo del programa...");
                     break;
                 default:
                     System.out.println("Opción inválida. Intente nuevamente.");
             }
         } while (opcion != 3);
         input.close();
     }
 }
 