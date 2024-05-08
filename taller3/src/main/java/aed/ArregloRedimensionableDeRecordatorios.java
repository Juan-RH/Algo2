package aed;

import javax.sound.midi.Sequence;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {
    
    private ArregloRedimensionableDeRecordatorios original;

    public ArregloRedimensionableDeRecordatorios() {
        this.original = new ArregloRedimensionableDeRecordatorios();
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        throw new UnsupportedOperationException("No implementada aun");

    }

    public int longitud() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void agregarAtras(Recordatorio i) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public Recordatorio obtener(int i) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void quitarAtras() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        throw new UnsupportedOperationException("No implementada aun");

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        return new ArregloRedimensionableDeRecordatorios(this.original);

    }

}
