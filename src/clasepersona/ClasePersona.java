package clasepersona;

import java.util.Scanner;

public class ClasePersona {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int personas = 0;

        Persona persona = null;
        Persona personaAnterior = null;
        String nombre, apellidos, fechaNacimiento;
        int edad = 0;

        personas = sc.nextInt();

        sc.nextLine();

        for (int i = 0; i < personas; i++) {
            nombre = sc.nextLine();
            apellidos = sc.nextLine();
            fechaNacimiento = sc.nextLine();
            try {
                persona = new Persona(nombre, apellidos, fechaNacimiento);

                if (i > 0 && personaAnterior != null) {
                    if (persona.equals(personaAnterior)) {
                        System.out.println(persona.toString() + " y "
                                + personaAnterior.toString() + " son la misma");
                    } else {
                        System.out.println(persona.toString() + " y "
                                + personaAnterior.toString() + " son distintas");
                    }
                }

                personaAnterior = new Persona(nombre, apellidos, fechaNacimiento);

            } catch (IllegalArgumentException ex) {
                System.out.println("ERROR. Procesando siguiente persona");
            }
        }

    }

}
