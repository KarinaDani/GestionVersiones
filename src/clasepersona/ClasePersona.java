package clasepersona;

import java.util.Scanner;

public class ClasePersona {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numPersonasTodosDatos = 0;
        int numPersonasNoTodos = 0;
        Persona persona = null;
        String nombre, apellidos, fechaNacimiento;
        boolean fechaCorrecta = false;

        numPersonasTodosDatos = sc.nextInt();
        numPersonasNoTodos = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numPersonasTodosDatos; i++) {
            nombre = sc.nextLine();
            apellidos = sc.nextLine();
            fechaNacimiento = sc.nextLine();
            try {
                persona = new Persona(nombre, apellidos, fechaNacimiento);
               
                
                
                //error
                //error
                System.out.println("Procesado: " + persona.getNombre() + " " + persona.getApellidos() + "  nacido el " + persona.getFechaNacimiento());
            } catch (IllegalArgumentException ex) {
                System.out.println("ERROR. Procesando siguiente persona");
            }

        }

        for (int i = 0; i < numPersonasNoTodos; i++) {
            nombre = sc.nextLine();
            apellidos = sc.nextLine();
            persona = new Persona(nombre, apellidos);
            fechaNacimiento = persona.getFechaNacimiento();

            System.out.println("Procesado: " + persona.getNombre() + " " + persona.getApellidos() + ", nacido el " + fechaNacimiento);

            if (i == numPersonasNoTodos - 1) {
                fechaCorrecta = false;
                fechaNacimiento = sc.nextLine();
                while (!fechaCorrecta) {
                    try {
                        persona.setFechaDeNacimiento(fechaNacimiento);
                        fechaNacimiento = persona.getFechaNacimiento();
                        fechaCorrecta = true;
                        
                        System.out.println("Procesado");
                        
                        
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Fecha Incorrecta");
                        fechaNacimiento = sc.nextLine();
                    }
                }
            }
        }

    }

}
