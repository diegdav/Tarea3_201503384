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
public class Usuario {

    Scanner teclado = new Scanner(System.in);
    private final String[] nombre_usuario;      //Es la matriz para que se guarden los usuarios
    private int opcion, contador;

    public Usuario() {
        nombre_usuario = new String[5];
        contador = 1;
    }

    public void menu() {
        opcion = 0;

        /*El do while es para que cuando el usuario ingrese un valor fuera del rango, le indique que es una opcion
incorrecta, esto se define en el default. 
El try-catch se esta utilizando para que cuando el usuario ingrese algun caracter no numerico, le vuelva
a aparecer el menu. Dentro del catch se utiliza el InputMismatchException para indica que tipo de error se
puede capturar, en este caso es un valor no numerico.
         */
        do {
            try {
                System.out.println("\nIngrese a una opcion (1-4): \n1. Ingresar usuarios \n2. Mostrar usuarios ascendente \n3. Mostrar usuario"
                        + " descendente \n4. Menu Principal");
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        //el contador define la cantidad de elementos que hay dentro de la matriz
                        if (contador == 5) {
                            System.out.println("\nEspacio de usuarios lleno.");
                        } else {
                            ingresarUsuarios();
                        }
                        menu();
                        break;
                    case 2:
                        usuariosAscendente();
                        break;
                    case 3:
                        usuariosDescendente();
                        break;
                    case 4:
                        System.out.println("");
                        Menu menuPrincipal = new Menu();
                        menuPrincipal.principal();
                        break;
                    default:
                        System.out.println("Opcion incorrecta. Intente de nuevo.\n");
                }
            } catch (InputMismatchException e) {
                teclado.nextLine();
            }
        } while (opcion < 1 || opcion > 4);
    }

    public void ingresarUsuarios() {
        int i;

        String nombre_prueba;   //variable para que el usuario pueda ingresar el nombre del usuario

        System.out.print("\nIngrese el nombre del usuario: ");
        nombre_prueba = teclado.next();

        //si la posicion cero de la matriz esta vacia entonces guardara el valor ingresado
        if (nombre_usuario[0] == null) {
            nombre_usuario[0] = nombre_prueba;
        } else {
            //si la posicion cero ya tiene un valor entonces los demas valores ingresados se guardaran en las demas
            //posiciones de la matriz
            for (i = 0; i < contador; i++) {
                //se compara el nombre ingresado con los nombres ingresados en la matriz para verificar
                //si hay alguno repetido
                if (nombre_prueba.equalsIgnoreCase(nombre_usuario[i])) {
                    System.out.println("\nEste usuario ya ha sido ingresado");
                    break;      //se usa para que cuando se cumpla la condicion se salga del for
                    //y no recorra todas las posiciones
                } else {
                    //si no hay ningun nombre repetido, entonces guardara el nombre en la matriz en la
                    //posicion correspondiente 
                    nombre_usuario[contador] = nombre_prueba;
                    contador++;     //se indica que se almaceno un nombre en la matriz
                    break;      //se usa para que cuando se cumpla la condicion se salga del for
                    //y no recorra todas las posiciones
                }
            }
        }
        nombre_prueba = "";
    }

    public void usuariosAscendente() {
        int i;

        System.out.println("");
        //recorre la matriz donde se encuentran los nombres en orden contrario al que se ingresaron
        for (i = 4; i >= 0; i--) {
            if (nombre_usuario[i] == null) {        //por cada espacio vacio se imprimira un salto de linea
                System.out.println("");
            } else {
                System.out.println((i + 1) + ". " + nombre_usuario[i]);
            }
        }
        menu();
    }

    public void usuariosDescendente() {
        int i;

        System.out.println("");
        //recorre la matriz donde se encuentran los nombres
        for (i = 0; i <= 4; i++) {
            if (nombre_usuario[i] == null) {        //por cada espacio vacio se imprimira un salto de linea
                System.out.println("");
            } else {
                System.out.println((i + 1) + ". " + nombre_usuario[i]);
            }
        }
        menu();
    }
}
