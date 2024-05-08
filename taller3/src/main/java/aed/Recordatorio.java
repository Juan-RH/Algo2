package aed;

public class Recordatorio {

    private String mensaje;
    private Fecha fecha;
    private Horario horario;
    

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha   = new Fecha(fecha);
        this.horario = new Horario(horario);
        
    }

    public Horario horario() {
        return this.horario;
    }

    public Fecha fecha() {
        return new Fecha(this.fecha);
    }

    public String mensaje() {
        return this.mensaje;
    }

    @Override
    public String toString() {
        return this.mensaje + " @ " + this.fecha + " " + this.horario;
    }

    @Override
    public boolean equals(Object otro) {
        throw new UnsupportedOperationException("No implementada aun");
    }

}
