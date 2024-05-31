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
        Nodo Father;
        Nodo L_Son;
        Nodo R_Son;
        T value;
        

        // Crear Construcftor del nodo
        public Nodo(T value) {
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

        return minimoRecursivo(Raiz);
    }

    public T minimoRecursivo(Nodo n){
        if(n.L_Son == null){
            return n.value;
        }else{
            return minimoRecursivo(n.L_Son);
        }
    }

    public T maximo(){
        return maximoRecursivo(Raiz);
    }
    public T maximoRecursivo(Nodo n){
        if(n.R_Son == null){
            return n.value;
        }else{
            return maximoRecursivo(n.R_Son);
        }
    }
    public void insertar(T elem) {
        Nodo nuevoNodo = new Nodo(elem);
        if (pertenece(elem)) {
            return;
        }
        // Si está vacío lo asigno como nueva raiz
        if (Raiz == null) {
            Raiz = nuevoNodo;
            CantidadNodos += 1;
            return;
        }
        insertarRecursivo(nuevoNodo, Raiz);
    }
    
    public void insertarRecursivo(Nodo nuevoNodo, Nodo actual) {
        // Si nodo nuevo > actual
        if (nuevoNodo.value.compareTo(actual.value) > 0) {
            // Si el valor del nuevo nodo es mayor, inserto a la derecha
            if (actual.R_Son == null) {
                actual.R_Son = nuevoNodo;  // Asigno el nuevo como hijo derecho
                nuevoNodo.Father = actual; 
                CantidadNodos += 1; 
            } else {
                // sigo buscando recursivamente a la derecha
                insertarRecursivo(nuevoNodo, actual.R_Son);
            }
        } else {
            // Si el valor del nuevo nodo es menor o igual, inserto a la izquierda
            if (actual.L_Son == null) {
                actual.L_Son = nuevoNodo;  // Asigno el nuevo como hijo izquierdo
                nuevoNodo.Father = actual; 
                CantidadNodos += 1; 
            } else {
                insertarRecursivo(nuevoNodo, actual.L_Son);
            }
        }
    }
      

    public void eliminar(T elem) {
        Nodo actual = this.Raiz;
        Nodo padre = null;
    
        // Caso base: si el nodo actual es nulo, termina la recursión
        if (actual == null) {
            return;
        }
    
        eliminarRecursivo(elem, padre, actual);
    }
    
    private void eliminarRecursivo(T elem, Nodo padre, Nodo actual) {
        // Caso base: si el nodo actual es nulo, termina la recursión
        if (actual == null) {
            return;
        }
    
        // Desplazo hasta el nodo a eliminar
        if (elem.compareTo(actual.value) > 0) {
            eliminarRecursivo(elem, actual, actual.R_Son);
        } else if (elem.compareTo(actual.value) < 0) {
            eliminarRecursivo(elem, actual, actual.L_Son);
        } else {
            
            Nodo hijo;
            if (actual.L_Son != null) {
                hijo = actual.L_Son;
            } else {
                hijo = actual.R_Son;
            }
    
            if (actual.R_Son == null || actual.L_Son == null) {
                // Si no tiene padre, hablamos de la raiz
                if (padre == null) {
                    this.Raiz = hijo;
                } else if (padre.L_Son == actual) {
                    padre.L_Son = hijo;
                } else {
                    padre.R_Son = hijo;
                }
                this.CantidadNodos--;
            } else {
                // Busca el predecesor inmediato (el mayor de los hijos izquierdos)
                Nodo nodoProximo = actual;
                Nodo Pre_inmediato = nodoProximo.L_Son;
    
                while (Pre_inmediato.R_Son != null) {
                    nodoProximo = Pre_inmediato;
                    Pre_inmediato = Pre_inmediato.R_Son;
                }
    
               
                actual.value = Pre_inmediato.value;
                
                
                if (nodoProximo != actual) {
                    nodoProximo.R_Son = Pre_inmediato.L_Son; 
                } else {
                    nodoProximo.L_Son = Pre_inmediato.L_Son;
                }
    
                this.CantidadNodos--;
            }
        }
    }
    

    public boolean pertenece(T elem){
        Nodo nodo = this.Raiz;
        
        return perteneceRecursivo(elem, nodo); 
         
    }

    public boolean perteneceRecursivo(T elem, Nodo n){
        if(n == null) {
            return false;
        } 
        if(elem.compareTo(n.value)==0) {
            return true; 
        }
        else if(elem.compareTo(n.value)<0) {
            return perteneceRecursivo(elem, n.L_Son);
        }
        else {
            return perteneceRecursivo(elem, n.R_Son);
        }
    }

        /*while (actual != null) {
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

    } */ 

    public String toString(){
        Iterador<T> iterador = new ABB_Iterador();
        StringBuffer cadena = new StringBuffer("{");
        

        
        while(iterador.haySiguiente()){
            cadena.append(iterador.siguiente() + ",");
            
        }
        cadena.deleteCharAt(cadena.length()-1);
        cadena.append("}");
        return cadena.toString();
    }



    public Nodo hallarNodoSiguiente(Nodo n) {
        if (n == null) {return null;}
        if (n.R_Son != null) {return hallarNodoConMinimo(n.R_Son);}
        return hallarSiguienteNodoPadre(n);
    }

    public Nodo hallarSiguienteNodoPadre(Nodo n) {
        Nodo nodoPadre = n.Father;
        if (n == null || nodoPadre == null || n == nodoPadre.L_Son) {return nodoPadre;}
        return hallarSiguienteNodoPadre(nodoPadre);
    
    }

    public Nodo hallarNodoConMinimo(Nodo n){
        if(n.L_Son == null) {
            return n; 
        }
        else {
            return hallarNodoConMinimo(n.L_Son);
        }
    }


    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;
        private int nodosRecorridos = 0;
        
        public ABB_Iterador() {
            this._actual= hallarNodoConMinimo(Raiz);
        
        }

        public boolean haySiguiente() {            
            if(_actual != null){
                return true;
            }else{
                return false;
            }
        }
    
        public T siguiente() {
            Nodo _anterior = _actual;
            
            _actual = hallarNodoSiguiente(_actual);
            return _anterior.value;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }
}
