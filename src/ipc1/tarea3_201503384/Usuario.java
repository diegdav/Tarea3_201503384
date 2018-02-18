/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.tarea3_201503384;

import java.util.Scanner;

/**
 *
 * @author diego
 */
public class Usuario {

    Scanner teclado = new Scanner(System.in);
    private final String[] nombre_usuario;
    
    public Usuario() {
        nombre_usuario = new String[5];
    }

    public void menu() {
        int opcion;

        do {
            System.out.println("\n1. Ingresar usuarios \n2. Mostrar usuarios ascendente \n3. Mostrar usuario"
                    + " descendente \n4. Menu Principal");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("");
                    ingresarUsuarios();
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
        } while (opcion < 1 || opcion > 4);
    }

    public void ingresarUsuarios() {
        int i;

        for (i = 0; i < 5; i++) {
            System.out.print("Ingrese el nombre de usuario: ");
            nombre_usuario[i] = teclado.next();
        }
        menu();
    }

    public void usuariosAscendente() {
        int i;
        for (i = 4; i >= 0; i--) {
            System.out.println(nombre_usuario[i]);
        }
        menu();
    }
    
    public void usuariosDescendente() {
        for(String recorrido: nombre_usuario){
            System.out.println(recorrido);
        }
        menu();
    }
}
