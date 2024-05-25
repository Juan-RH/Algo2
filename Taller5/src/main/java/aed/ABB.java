package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private Nodo Raiz;
    private int CantidadNodos;

    private class Nodo {
        // Agregar atributos privados del Nodo
        private Nodo Father;
        private Nodo L_Son;
        private Nodo R_Son;
        private T value;
        

        // Crear Construcftor del nodo
        public Nodo(T value) {
            this.Father = null;
            this.L_Son = null;
            this.R_Son = null;
            this.value = value;

        }
    }

    public ABB() {
        this.Raiz = null;
    }

    public int cardinal() {
        return CantidadNodos;

    }

    public T minimo(){
        Nodo actual = Raiz;

        while(actual.L_Son != null){
            actual = actual.L_Son;
        }return actual.value;

    }

    public T maximo(){
        Nodo actual = Raiz;

        while(actual.R_Son != null){
            actual = actual.R_Son;
        }return actual.value;
    }

    public void insertar(T elem){
        if(pertenece(elem)){
            ;
        }else{
        
            Nodo ingresante = new Nodo(elem);
            Nodo actual = Raiz;
            Nodo anterior= actual;
            
        
            //si el Nodo Raiz es null, le asigno el ingresante. 
            if(Raiz == null){
                Raiz = ingresante;
                CantidadNodos++;
                return;
            }else{
            //Sino, se desplaza comparando actual con elem y desplazando al nodo hijo que corresponde
                while(actual != null){
                    if(actual.value.compareTo(elem) > 0){
                        anterior = actual;
                        actual = actual.L_Son;
                    }else if(actual.value.compareTo(elem) < 0){
                        anterior = actual;
                        actual = actual.R_Son;
                    }else{

                    }
                }
            
            // Asigno el nuevo nodo en la posición de actual correspondiente
            ingresante.Father = anterior;
            // Para asignar cual valor de hijo corresponde, comparo elem con con el padre
            if(anterior.value.compareTo(elem) > 0){
                anterior.L_Son = ingresante;
            }else{
                anterior.R_Son = ingresante;
            }
            actual = ingresante;
            CantidadNodos++;
            }
        }
    }

    public boolean pertenece(T elem){
        Nodo actual = Raiz;
        boolean esta = false;

        while (actual != null) {
            if(actual.value.compareTo(elem) == 0){
                esta = true;
                break;
            }
            else if(actual.value.compareTo(elem) > 0){
                actual = actual.L_Son;
            }else{
                actual = actual.R_Son;
            }
        }
        return esta;

    }

    public void eliminar(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
