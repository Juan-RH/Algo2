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
        Nodo actual = Raiz;
        Nodo anterior = actual;

        if(pertenece(elem) && CantidadNodos > 1){
            // Avanzo hasta actual == elem
            while (actual.value != elem) {
                // Desplazo izquierda o derecha
                if(actual.value.compareTo(elem) > 0){
                    anterior = actual;
                    actual = actual.L_Son;
                }else if(actual.value.compareTo(elem) < 0){
                    anterior = actual;
                    actual = actual.R_Son;
                }
            }
            //Tendremos dos casos, si actual tiene 2 hijos
            if(actual.L_Son != null && actual.R_Son != null){// Cuando actual tiene los dos hijos
                
                    //filtremos primero el nodo que tengo que reemplazar en lugar del actual
                    //nodoProximo es el min() del subárbol desde el nodo actual.
                    Nodo nodoProximo = actual.R_Son;
                    Nodo padreProximo = nodoProximo;
                    while (nodoProximo.L_Son != null) {
                        padreProximo = nodoProximo;
                        nodoProximo = nodoProximo.L_Son;
                    }
                    actual.value = nodoProximo.value; // reemplazo el value del proximo en actual
                    
                    //y ahora podemos desvincular nodoProximo del arbol
                    if(nodoProximo.R_Son != null){//Hay un caso más, donde si el nodo proximo tiene hijos izquierdos, tengo que enlazarlos como hijos derechos de padreProximo
                        padreProximo.L_Son = nodoProximo.R_Son;
                    }else{
                        padreProximo.L_Son = null;
                    }
            }

            //Y si actual tiene menos de 2 hijos
            // Dependiendo cual hijo sea actual, para reemplazar correctamente los valores del nodo padre de actual
            
            if(anterior.L_Son == actual){
                
                if(actual.L_Son == null && actual.R_Son == null){
                    anterior.L_Son = null;
                }else if(actual.R_Son == null){
                    anterior.L_Son = actual.L_Son;
                }else if(actual.L_Son == null){
                    anterior.L_Son = actual.R_Son;
                }else{ 
                }


            }else{
                if(actual.L_Son == null && actual.R_Son == null){
                    anterior.R_Son = null;
                }else if(actual.R_Son == null){
                    anterior.R_Son = actual.L_Son;
                }else if(actual.L_Son == null){
                    anterior.R_Son = actual.R_Son;
                }else{
                }
            }
            CantidadNodos--;
        }else{
            ;
        }
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
