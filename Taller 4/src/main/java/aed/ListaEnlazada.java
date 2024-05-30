package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {

    private Nodo primero;
    private int indice;

    private class Nodo {
        T valor;
        Nodo siguiente;
        Nodo anterior;

        Nodo(T v){
            valor = v;
            siguiente = null;
            anterior = null;
        }

    }

    public ListaEnlazada() {
        primero = null;

    }

    public int longitud() {
        return this.indice;
        
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        if(primero == null){
            primero = new Nodo(nuevo.valor);
        }else{
             
            nuevo.siguiente = primero;
            primero.anterior = nuevo;
            primero = nuevo;            
            }
        this.indice++;



    }

    public void agregarAtras(T elem) {
        Nodo porAgregar = new Nodo(elem);
        
        if(primero == null){
            primero = porAgregar;
        }else{
            Nodo actual = primero;
            while(actual.siguiente != null){
                actual = actual.siguiente;
            }
            actual.siguiente = porAgregar;
            porAgregar.siguiente = null;
            porAgregar.anterior = actual;
        }
        indice++;
    }

    public T obtener(int i) {
        
        //recorramos el nodo con un for hasta el indice i
        Nodo actual = primero;
        for (int j = 0; j < i; j++) {
            actual = actual.siguiente;
        }
        return actual.valor;
            
        
    }

    public void eliminar(int i) {
        Nodo actual = primero;

        //elimino el primero
        if(i == 0){
            this.primero = actual.siguiente;

            // una vez en el indice, evalúo
        }else{
            for(int j = 0; j < i; j++){
                actual = actual.siguiente;
            }//si es el ultimo elemento
            if(i == indice-1){
                actual.anterior.siguiente = null;
            //cualquier caso intermedio
            }else{
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
            
            }
        }indice--;

    }


    

    public void modificarPosicion(int indice, T elem) {
        Nodo actual = primero;
        Nodo modificado = new Nodo(elem);

        for(int j=0; j < indice; j++){
            actual = actual.siguiente;
        }
        
        if(indice == 0){
            modificado.anterior = actual.anterior;
            modificado.siguiente = actual.siguiente;
            actual.siguiente.anterior=modificado;
        }else{
            if(indice == this.indice-1){
                modificado.anterior = actual.anterior;
                modificado.siguiente = actual.siguiente;
                actual.anterior.siguiente = modificado;
            }else{
                modificado.anterior = actual.anterior;
                modificado.siguiente = actual.siguiente;
                actual.anterior.siguiente = modificado;
                actual.siguiente.anterior=modificado;
            }
        }
        
        //[,99]
        //[(null,42,43),(42,43,44),(44),(45)]


    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> copia = new ListaEnlazada<>();
        Nodo actual = primero;

        
        while(actual != null){
            copia.agregarAtras(actual.valor);
            actual = actual.siguiente; 
        }

        return copia;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        //entra una objeto por parametro, de tipo lista enlazada
        //Copio en un nodo nuevo el valor del lista.primero
        this.primero = new Nodo(lista.primero.valor);
        this.indice = 1;

        Nodo actual = lista.primero;
        while (actual.siguiente != null){
            this.agregarAtras(actual.siguiente.valor);
            actual = actual.siguiente;
        }
        
        
    }
    
    @Override
    public String toString() {
        StringBuffer lista = new StringBuffer();
        lista.append("[");
        Nodo actual = primero;
        while(actual!= null){
            lista.append(actual.valor + ", ");
            actual = actual.siguiente;
        }
        lista.delete(lista.length()-2, lista.length());
        lista.append("]");
        return lista.toString();
        

    }

    private class ListaIterador implements Iterador<T> {
        //Utilizo dos nodos para ir pudiendo desplazarme sin perder información
        private Nodo actual = primero;
        private Nodo anterior = primero;

        //los test contemplan que avanzo y retrocedo, en este ultimo caso, 
        //anterior = actual.anterior == null y actual == primero

        public boolean haySiguiente() {
	        //Fuera de rango solo si actual y anterior son null.
            if( anterior == null){ //actual = primero deja anterior = null y sigo en rango
                if (actual == null) {
                    return false;   
                }else{ 
                    return true;
                }
            }else{
                //hay siguiente si (anterior.siguiente == actual) != null   
                if(actual != null){
                    return true;
                    
                }else{
                    return false;
                }
            }
        }
        //extremo derecho, si actual && anterior == null
        public boolean hayAnterior() {
	        if( actual == null){
                if (anterior == null) {
                    return false;   
                }else{
                    return true;
                }
            }else{
                if(actual.anterior != null){
                    return true;
                }else{
                return false;
                }
            }
        }

        public T siguiente() {
            anterior = actual;
            actual = actual.siguiente;
            return anterior.valor;
        }
        

        public T anterior() {
	        actual = anterior;
            anterior = anterior.anterior;
            
            return actual.valor;
        }
    }

    public Iterador<T> iterador() {
	    return new ListaIterador();
    }

}
