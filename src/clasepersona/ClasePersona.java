package clasepersona;

import java.util.Scanner;

public class ClasePersona {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int personasConFecha = 0;

        Persona persona = null;
        String nombre, apellidos, fechaNacimiento, fechaProcesar;
        int cantidadFechas = 0;
        int edad = 0;

        personasConFecha = sc.nextInt();

        sc.nextLine();

        for (int i = 0; i < personasConFecha; i++) {
            nombre = sc.nextLine();
            apellidos = sc.nextLine();
            fechaNacimiento = sc.nextLine();
            try {
                persona = new Persona(nombre, apellidos, fechaNacimiento);
                
                cantidadFechas = sc.nextInt();
                sc.nextLine();
                for (int j = 0; j < cantidadFechas; j++) {

                    fechaProcesar = sc.nextLine();

                    try {
                        edad = persona.getEdadEnFecha(fechaProcesar);
                        if (edad == -1) {
                            System.out.println(persona.getNombre() + " " + persona.getApellidos() + " aun no ha nacido a fecha " + fechaProcesar);
                        } else {
                            System.out.println(persona.getNombre() + " " + persona.getApellidos() + " tendra " + edad + " anyos en fecha " + fechaProcesar);
                        }

                    } catch (IllegalArgumentException ex) {
                        System.out.println("ERROR. Procesando siguiente fecha");
                    }

                }

            } catch (IllegalArgumentException ex) {
                System.out.println("ERROR. Procesando siguiente persona");
            }
        }

    }

}
