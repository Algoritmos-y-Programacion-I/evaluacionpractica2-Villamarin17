package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

    private Controller control;
    private Scanner sc;

    public Executable() {
        control = new Controller();
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Executable exe = new Executable();
        exe.menu();
    }

    /**
     * Descripcion: Despliega el menu principal de funcionalidades al usuario
     */
    public void menu() {
        boolean flag = true;

        do {
            System.out.println("\nBienvenido a Icesi Sostenible!");
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("----------------------");
            System.out.println("1) Registrar un Proyecto en un Pilar");
            System.out.println("2) Consultar Proyectos por Pilar");
            System.out.println("0) Salir");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    registerProject();
                    break;
                case 2:
                    showProjectsByPillar();
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestros servicios. ¡Adiós!");
                    flag = false;
                    break;
                default:
                    System.out.println("Opción inválida, intente nuevamente");
                    break;
            }
        } while (flag);
    }

    /**
     * Descripcion: Solicita al usuario la informacion necesaria para registrar un Project
     * en un Pilar en el sistema
     */
    public void registerProject() {
        System.out.println("Seleccione el Pilar: 1) Biodiversidad 2) Agua 3) Tratamiento de Basuras 4) Energía");
        int pillarType = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        System.out.println("Ingrese el ID del proyecto: ");
        String id = sc.nextLine();

        System.out.println("Ingrese el nombre del proyecto: ");
        String name = sc.nextLine();

        System.out.println("Ingrese la descripción del proyecto: ");
        String description = sc.nextLine();

        System.out.println("¿El proyecto está activo? (true/false): ");
        boolean status = sc.nextBoolean();

        boolean result = control.registerProjectInPillar(pillarType - 1, id, name, description, status);
        if (result) {
            System.out.println("El proyecto se ha registrado exitosamente.");
        } else {
            System.out.println("No fue posible registrar el proyecto.");
        }
    }

    /**
     * Descripcion: Muestra al usuario los Proyectos registrados en un Pilar
     */
    public void showProjectsByPillar() {
        System.out.println("Seleccione el Pilar: 1) Biodiversidad 2) Agua 3) Tratamiento de Basuras 4) Energía");
        int pillarType = sc.nextInt();

        String result = control.queryProjectsByPillar(pillarType - 1);
        System.out.println(result);
    }
}
