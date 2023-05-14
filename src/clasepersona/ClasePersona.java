package clasepersona;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ClasePersona {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int personas = 0;

        Persona persona = null;
        String nombre, apellidos, fechaNacimiento, fecha;
        ArrayList<Persona> lista = new ArrayList<>();
        Iterator<Persona> iterator;
        int consultas = 0;
        int edadMaxima = 0;

        personas = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < personas; i++) {
            nombre = sc.nextLine();
            apellidos = sc.nextLine();
            fechaNacimiento = sc.nextLine();
            try {
                persona = new Persona(nombre, apellidos, fechaNacimiento);

                lista.add(persona);

            } catch (IllegalArgumentException ex) {
                System.out.println("ERROR procesando alumno " + nombre + ". Procesando siguiente alumno");
            }
        }

        consultas = sc.nextInt();
        for (int j = 1; j <= consultas; j++) {
            sc.nextLine();
            System.out.println("CASO " + j);
            System.out.println("----------");

            iterator = lista.iterator();
            fecha = sc.nextLine();
            edadMaxima = sc.nextInt();

            while (iterator.hasNext()) {
                Persona p = iterator.next();
                if (p.getEdadEnFecha(fecha) < edadMaxima) {
                    System.out.println(p.toString());
                }
            }

        }
        lista.clear();
    }
}
