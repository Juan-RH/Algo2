package aed;

public class Recordatorio {

    private String mensaje;
    private Fecha fecha;
    private Horario horario;
    private Fecha oldFecha;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha   = fecha;
        this.horario = horario;
        this.oldFecha = fecha;
    }

    public Horario horario() {
        return this.horario;
    }

    public Fecha fecha() {
        return this.oldFecha;
    }

    public String mensaje() {
        return this.mensaje;
    }

    @Override
    public String toString() {
        return mensaje + "@" + fecha + "" + horario;
    }

    @Override
    public boolean equals(Object otro) {
        throw new UnsupportedOperationException("No implementada aun");
    }

}
