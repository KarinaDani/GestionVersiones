package clasepersona;

import java.util.Scanner;

public class ClasePersona {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int personasConFecha = 0;
        int personasSinFecha = 0;
        Persona persona = null;
        String nombre, apellidos, fechaNacimiento;
        boolean fechaCorrecta = false;

        personasConFecha = sc.nextInt();
        personasSinFecha = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < personasConFecha; i++) {
            nombre = sc.nextLine();
            apellidos = sc.nextLine();
            fechaNacimiento = sc.nextLine();
            try {
                persona = new Persona(nombre, apellidos, fechaNacimiento);

                System.out.println("Procesado: " + persona.getNombre() + " " + persona.getApellidos() + ", nacido el "
                        + persona.getFechaNacimiento().substring(0, 2) + " del "
                        + persona.getFechaNacimiento().substring(3, 5) + " de "
                        + persona.getFechaNacimiento().substring(6));
            } catch (IllegalArgumentException ex) {
                System.out.println("ERROR. Procesando siguiente persona");
            }
        }

        for (int i = 0; i < personasSinFecha; i++) {
            nombre = sc.nextLine();
            apellidos = sc.nextLine();
            persona = new Persona(nombre, apellidos);
            fechaNacimiento = persona.getFechaNacimiento();

            System.out.println("Procesado: " + persona.getNombre() + " " + persona.getApellidos() + ", nacido el " + fechaNacimiento);

            if (i == personasSinFecha - 1) {
                fechaCorrecta = false;
                fechaNacimiento = sc.nextLine();
                while (!fechaCorrecta) {
                    try {
                        persona.setFechaNacimiento(fechaNacimiento);
                        fechaNacimiento = persona.getFechaNacimiento();
                        fechaCorrecta = true;

                        System.out.println("Procesado: " + persona.getNombre() + " " + persona.getApellidos() + ", nacido el "
                                + persona.getFechaNacimiento().substring(0, 2) + " del "
                                + persona.getFechaNacimiento().substring(3, 5) + " de "
                                + persona.getFechaNacimiento().substring(6));
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Fecha Incorrecta");
                        fechaNacimiento = sc.nextLine();
                    }
                }
            }
        }

    }

}
