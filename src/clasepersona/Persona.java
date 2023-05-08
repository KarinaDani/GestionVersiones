package clasepersona;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Persona {

    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String apellidos) {
        if (nombre.length() == 0 || apellidos.length() == 0) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
        }
    }

    public Persona(String nombre, String apellidos, String fechaNacimiento) throws IllegalArgumentException {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = generarFecha(fechaNacimiento);
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNacimiento() throws IllegalArgumentException {
        String fecha;
        if (this.fechaNacimiento == null) {
            fecha = null;
        } else {
            fecha = getFechaNacimiento('-');
        }
        return fecha;
    }

    public String getFechaNacimiento(char separador) {
        String fecha = null;

        if (separador != '-' && separador != '/') {
            throw new IllegalArgumentException();
        } else {
            if (this.fechaNacimiento != null) {
                fecha = String.format("%02d%c%02d%c%04d", this.fechaNacimiento.getDayOfMonth(), separador, this.fechaNacimiento.getMonthValue(), separador, this.fechaNacimiento.getYear());
            }
        }

        return fecha;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = generarFecha(fechaNacimiento);
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
            anyo = Integer.parseInt(fecha.substring(6));

            try {
                fechaCorrecta = LocalDate.of(anyo, mes, dia);
            } catch (DateTimeException ex) {
                throw new IllegalArgumentException();
            }
        }

        return fechaCorrecta;
    }

    public int getEdadEnFecha(String cadenaFecha) throws IllegalArgumentException {
        int edad = 0;

        if (this.fechaNacimiento == null || this.fechaNacimiento.isAfter(generarFecha(cadenaFecha))) {
            edad = -1;
        } else {
            edad = generarFecha(cadenaFecha).getYear() - this.fechaNacimiento.getYear();
            if (generarFecha(cadenaFecha).getMonthValue() < this.fechaNacimiento.getMonthValue()) {
                edad = edad - 1;
            }
            if (generarFecha(cadenaFecha).getMonthValue() == this.fechaNacimiento.getMonthValue()) {
                if (generarFecha(cadenaFecha).getDayOfMonth() < this.fechaNacimiento.getDayOfMonth()) {
                    edad = edad - 1;
                }
            }
        }

        return edad;
    }

    public int getEdad() {
        int edad = 0;
        if (this.fechaNacimiento == null || this.fechaNacimiento.isAfter(LocalDate.now())) {
            edad = -1;
        } else {
            edad = LocalDate.now().getYear() - this.fechaNacimiento.getYear();
            if (LocalDate.now().getMonthValue() < this.fechaNacimiento.getMonthValue()) {
                edad = edad - 1;
            }
            if (LocalDate.now().getMonthValue() == this.fechaNacimiento.getMonthValue()) {
                if (LocalDate.now().getDayOfMonth() < this.fechaNacimiento.getDayOfMonth()) {
                    edad = edad - 1;
                }
            }
        }
        return edad;
    }
}
