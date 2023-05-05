package clasepersona;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Persona {

    private String nombre;
    private String apellidos;
    private LocalDate fechaDeNacimiento;

    public Persona(String nombre, String apellidos, String fechaNacimiento) throws IllegalArgumentException {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaDeNacimiento = generarFecha(fechaNacimiento);
    }

    public Persona(String nombre, String apellidos) {
        if (nombre.length() == 0 || apellidos.length() == 0) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNacimiento() throws IllegalArgumentException {
        String fecha;
        if (this.fechaDeNacimiento == null) {
            fecha = null;
        } else {
            fecha = getFechaNacimiento('-');
        }
        return fecha;
    }

    String getFechaNacimiento(char separador) {
        String fecha = null;

        if (separador != '-' && separador != '/') {
            throw new IllegalArgumentException();
        } else {
            if (this.fechaDeNacimiento != null) {
                fecha = String.format("%02d%c%02d%c%04d", this.fechaDeNacimiento.getDayOfMonth(), separador, this.fechaDeNacimiento.getMonth(), separador, this.fechaDeNacimiento.getYear());
            }
        }

        return fecha;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = generarFecha(fechaDeNacimiento);
    }

    private LocalDate generarFecha(String fecha) {
        LocalDate fechaCorrecta = null;
        int dia;
        int mes;
        int anyo;

        if (!fecha.matches("[0-9]{2}[-][0-9]{2}[-][0-9]{4}") && !fecha.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}")) {
            throw new IllegalArgumentException();
        } else {

            dia = Integer.parseInt(fecha.substring(0, 2));
            mes = Integer.parseInt(fecha.substring(3, 5));
            anyo = Integer.parseInt(fecha.substring(6, 10));

            try {
                fechaCorrecta = LocalDate.of(anyo, mes, dia);
            } catch (DateTimeException ex) {
                throw new IllegalArgumentException();
            }
        }

        return fechaCorrecta;
    }

}
