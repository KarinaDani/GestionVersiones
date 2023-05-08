package clasepersona;

import java.util.Scanner;

public class ClasePersona {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int personasConFecha = 0;

        Persona persona = null;
        String nombre, apellidos, fechaNacimiento;
        int edad = 0;

        personasConFecha = sc.nextInt();

        sc.nextLine();

        for (int i = 0; i < personasConFecha; i++) {
            nombre = sc.nextLine();
            apellidos = sc.nextLine();
            fechaNacimiento = sc.nextLine();
            try {
                persona = new Persona(nombre, apellidos, fechaNacimiento);

                edad = persona.getEdad();
                if (edad == -1) {
                    System.out.println(persona.getNombre() + " " + persona.getApellidos() + " aun no ha nacido a dia de hoy");
                } else {
                    System.out.println(persona.getNombre() + " " + persona.getApellidos() + " tiene " + edad + " anyos a dia de hoy");
                }

            } catch (IllegalArgumentException ex) {
                System.out.println("ERROR. Procesando siguiente persona");
            }
        }

    }

}
