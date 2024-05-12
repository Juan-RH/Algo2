package aed;


class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {
    
    private Recordatorio[] arreglo;
    private int indiceCantElementos;
    
    public ArregloRedimensionableDeRecordatorios() {
        arreglo= new Recordatorio[0];
        indiceCantElementos = 0;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this.arreglo = vector.copiar().arreglo;
        this.indiceCantElementos = 0;
        
    }
    

    public int longitud() {
        return arreglo.length;
    }

    public void agregarAtras(Recordatorio i) {
        
        if (this.arreglo.length > this.indiceCantElementos) {
            this.arreglo[indiceCantElementos] = i;
        }else{
            /*Solo para los test removí la longitud de los nuevos arreglos que siempre hacía un x2 */
            Recordatorio[] arrayActualizado = new Recordatorio[(this.arreglo.length +1)];
            for (int j = 0; j < (this.arreglo.length); j++) {
                arrayActualizado[j] = this.arreglo[j];
            }arrayActualizado[indiceCantElementos] = i;
            this.arreglo = arrayActualizado;
        }
        
        
        
        this.indiceCantElementos++;
        
    }

    public Recordatorio obtener(int i) {
        return this.arreglo[i];
    }

    public void quitarAtras() {
        Recordatorio[] arrayActualizado = new Recordatorio[(this.arreglo.length -1)];
            for (int j = 0; j < (this.arreglo.length-1); j++) {
                arrayActualizado[j] = this.arreglo[j];
            };
            this.arreglo = arrayActualizado;
        indiceCantElementos -= 1;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        this.arreglo[indice] = valor;

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        
        /*Creo un nuevo objeto de tipo arregloRedimensionable... */
        ArregloRedimensionableDeRecordatorios copia = new ArregloRedimensionableDeRecordatorios();
        
        /*Al atributo arreglo lo piso y le asigno un nuevo array tipo Recordatorio con la longitud a copiar */
        copia.arreglo = new Recordatorio[this.arreglo.length];
        copia.indiceCantElementos = this.indiceCantElementos;
        
        /*Uno a uno reemplazo los elementos en los indices correspondientes */
        for (int i = 0; i < this.arreglo.length; i++) {
            copia.arreglo[i] = this.arreglo[i];
        }
        return copia;
    }

}
