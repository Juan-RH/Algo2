package aed;

import javafx.beans.binding.StringBinding;

public class Agenda {

    private Fecha fechaActual;
    private ArregloRedimensionableDeRecordatorios recordatorios;


    public Agenda(Fecha fechaActual) {
        this.fechaActual = new Fecha(fechaActual);
        this.recordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this.recordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        StringBuffer recordatorioDeLaFecha = new StringBuffer();

        recordatorioDeLaFecha.append(this.fechaActual + "\n=====\n");

        Recordatorio recordatorio;
        for (int i = 0; i < this.recordatorios.longitud(); i++) {
            recordatorio = this.recordatorios.obtener(i);

            if(recordatorio.fecha().mes() == this.fechaActual.mes()
                && recordatorio.fecha().dia() == this.fechaActual.dia()){
                    recordatorioDeLaFecha.append(recordatorio + "\n" );
            }
        }
        return recordatorioDeLaFecha.toString();

    }

    public void incrementarDia() {
        this.fechaActual.incrementarDia();

    }

    public Fecha fechaActual() {
        return this.fechaActual;
    }

}
