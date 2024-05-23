package aed;

class Funciones {
    int cuadrado(int x) {
        return x*x;
    }

    double distancia(double x, double y) {
        return Math.sqrt( (x*x) + (y*y) );
    }

    boolean esPar(int n) {
        return(n%2 == 0);
    }

    boolean esBisiesto(int n) {
        boolean res = false;

        if( (n%400 == 0) || ((n%4 == 0) && (n%100 != 0))){
            res = true;
        }
        return res;
    }

    int factorialIterativo(int n) {
        int res = 1;

        if(n<=1){
            res  = 1; 
        }
        else if(n>1){
            for(int i = n; i > 1; i--){
                res *= i;
            }
        }
        return res;
    }

    int factorialRecursivo(int n) {
        int res = 0;

        if(n<=1){
            res  = 1; 
        }else if(n > 1){
            res = n * factorialRecursivo(n-1);
        }
        return res;
    }

    boolean esPrimo(int n) {
        boolean res = true;
        
        //caso base
        if(n <= 1){
            return false;
        }
        
        for(int i = 2; i < n; i++){
            if(n%i == 0){
                res = false;
            }
        }
        return res;
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        
        for(int i = 0; i < numeros.length; i++){
            res += numeros[i];
        }

        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int res = 0;   

        for(int i = 0; i < numeros.length; i++){
            if(buscado == numeros[i]){
                res = i;
            }
        }
        return res;
    }

    boolean tienePrimo(int[] numeros) {
        
        for(int i = 0; i < numeros.length; i++){
            if(esPrimo(numeros[i])){
                return true;
            }
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        
        for(int i = 0; i < numeros.length; i++){
            if(!esPar(numeros[i])){
                return false;
            }
        }

        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        
        if (s1.length() > s2.length()){
            return false;
        } 
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                return false;
            } 
        }
        
        return true;
    }

    boolean esSufijo(String s1, String s2) {
        String str_invertido1 = invertirString(s1);
        String str_invertido2 = invertirString(s2);

        if (s1.length() > s2.length()){
            return false;
        } 
        if(esPrefijo(str_invertido1, str_invertido2)){
            return true;
        }else{
            return false;
        }
        
        
    }
    String invertirString(String s1){
        String str_invertido = "";
    
        for(int i = s1.length() - 1; i >= 0; i--){
            str_invertido += s1.charAt(i);
        }
        return str_invertido;
    }
    
}
