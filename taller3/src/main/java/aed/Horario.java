package aed;

public class Horario {

    private int hora;
    private int minutos;

    public Horario(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    public int hora() {
        return this.hora;
    }

    public int minutos() {
        return this.minutos;
    }

    @Override
    public String toString() {
        return hora + ":" + minutos;
    }

    @Override
    public boolean equals(Object otro) {
        if(this == otro){
            return true;
        }else if(getClass() != otro.getClass()){
            return false;
        }
        Horario horarioOtro = (Horario) otro;
        return this.hora == horarioOtro.hora && this.minutos == horarioOtro.minutos;
    }

}
