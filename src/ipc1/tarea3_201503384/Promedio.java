/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.tarea3_201503384;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class Promedio {

    Scanner teclado = new Scanner(System.in);
    private int opcion;
    private final String[][] titulos = {{"ID", "Nota 1", "Nota 2", "Nota 3", "Nota 4", "Promedio"}};
    private final int[][] notas;

    public Promedio() {
        notas = new int[6][6];
    }

    public void menu() {
        do {
            try {
                System.out.println("\nIngrese a una opcion (1-3): \n1. Ingresar las notas \n2. Mostrar las notas \n3. Menu");
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        ingresar();
                        break;
                    case 2:
                        mostrar();
                        break;
                    case 3:
                        System.out.println("");
                        Menu menuPrincipal = new Menu();
                        menuPrincipal.principal();
                        break;
                    default:
                        System.out.println("Opcion incorrecta. Intente de nuevo.\n");
                        menu();
                }
            } catch (InputMismatchException e) {
                teclado.nextLine();
            }
        } while (opcion < 1 || opcion > 3);
    }

    public void ingresar() {
        int i, j, nota, contador;
        contador = 1;
        for (i = 0; i < 6; i++) {
            System.out.print("\nIngrese el id del estudiante: ");
            notas[i][0] = teclado.nextInt();
            for (j = 1; j < 5; j++) {
                do {
                    System.out.print("Ingrese la nota " + contador + " del estudiante " + notas[i][0] + ": ");
                    nota = teclado.nextInt();
                    if (nota < 0 || nota > 100) {
                        System.out.println("\nDebe de ingresar una nota menor a 100 y mayor a 0");
                    }
                } while (nota < 0 || nota > 100);
                notas[i][j] = nota;
                contador++;
                if (contador == 5) {
                    contador = 1;
                }
            }
        }
        calcularPromedio();
        menu();
    }

    public void mostrar() {
        int fila, columna;
        for (fila = 0; fila < 1; fila++) {
            for (columna = 0; columna < 6; columna++) {
                System.out.printf(titulos[fila][columna] + "\t");
            }
            System.out.println("");
        }
        for (fila = 0; fila < 6; fila++) {
            for (columna = 0; columna < 6; columna++) {
                System.out.print(notas[fila][columna] + "\t");
            }
            System.out.println("");
        }
        menu();
    }

    public void calcularPromedio() {
        int fila, columna;
        for (fila = 0; fila < 6; fila++) {
            for (columna = 1; columna < 5; columna++) {
                notas[fila][5] += notas[fila][columna];
            }
            notas[fila][5] = notas[fila][5] / 4;
        }
    }
}
