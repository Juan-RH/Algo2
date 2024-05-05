package aed;

public class Recordatorio {

    private String mensaje;
    private Fecha fecha;
    private Horario horario;
    private Fecha fecha_original;
    

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha   = fecha;
        this.horario = horario;
        this.fecha_original = new Fecha(fecha);
        
    }

    public Horario horario() {
        return this.horario;
    }

    public Fecha fecha() {
        return this.fecha_original;
    }

    public String mensaje() {
        return this.mensaje;
    }

    @Override
    public String toString() {
        return mensaje + " @ " + fecha + " " + horario;
    }

    @Override
    public boolean equals(Object otro) {
        throw new UnsupportedOperationException("No implementada aun");
    }

}
