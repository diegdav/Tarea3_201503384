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
    private final String[][] titulos = {{"ID", "Nota 1", "Nota 2", "Nota 3", "Nota 4", "Promedio"}};    //encabezado de cada columna
    private final int[][] notas;                                                                        //matriz para que el usuario ingrese las notas

    public Promedio() {
        notas = new int[6][6];                                                  //se define el tamaño de la matriz
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
                        if (notas[0][0] == 0) {
                            System.out.println("\nDebe de ingresar de primero las notas");
                            menu();
                        } else {
                            mostrar();
                        }
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
        contador = 1;                                               //es para mostrar el numero de nota que se vaya a ingresar
        
        for (i = 0; i < 6; i++) {
            System.out.print("\nIngrese el id del estudiante: ");
            notas[i][0] = teclado.nextInt();                        //guarda el id en la matriz en la columna 0 y en cada fila correspondiente
            for (j = 1; j < 5; j++) {                               //inicia desde 1 ya que el espacio 0 corresponde al id
                do {
                    System.out.print("Ingrese la nota " + contador + " del estudiante " + notas[i][0] + ": ");
                    nota = teclado.nextInt();
                    if (nota < 0 || nota > 100) {
                        System.out.println("\nDebe de ingresar una nota menor a 100 y mayor a 0");
                    }
                } while (nota < 0 || nota > 100);
                notas[i][j] = nota;                                 //la nota ingresada se guardara en la fila y columna correspondiente
                contador++;                                         //el contador lleva el control de cada nota ingresada
                if (contador == 5) {                                //al momento de ingresar la nota 4 aumentara en 5 
                    contador = 1;                                   //por lo tanto tiene que volver a iniciar desde 1
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
                System.out.printf(titulos[fila][columna] + "\t");               //\t es para que haga tabulacion al momento de ingresar cada columna
            }                                                                   //al recorrer el for, se muestra el contenido de la matriz titulos.
            System.out.println("");
        }
        for (fila = 0; fila < 6; fila++) {                                      
            for (columna = 0; columna < 6; columna++) {
                System.out.print(notas[fila][columna] + "\t");                  //recorre la matriz notas y las muestra, dejando tabulacion por cada 
            }                                                                   //columna, esto para que no quueden juntos los valores de cada columna
            System.out.println("");
        }
        menu();
    }

    public void calcularPromedio() {
        int fila, columna;
        for (fila = 0; fila < 6; fila++) {
            for (columna = 1; columna < 5; columna++) {                         //recorre de 2 a 4 ya que en la posicion 1 se encuentra el id y en el 5 el promedio
                notas[fila][5] += notas[fila][columna];                         //guarda en la ultima columna de cada fila la suma de cada nota recorrida
            }
            notas[fila][5] = notas[fila][5] / 4;                                //al terminar de sumar cada nota la divide dentro de 4 para obtener el promedio
        }
    }
}
