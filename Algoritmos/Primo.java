package Algoritmos;
public class Primo {
    
    public static boolean esPrimo(int numero) {
        // si es menor o igual a 1 no es primo
        if (numero <= 1) {
            return false;
        }
        //si el número es 2 es primo
        if (numero == 2) {
            return true;
        }
        int raiz = (int) Math.round(Math.sqrt(numero));
        //ciclo desde la raíz entero hasta 1
        for (int divisor = raiz; divisor >= 1; divisor--) {
            //si la division da un numero exacto el numero es primo, este ciclo continua hasta llegar a 1
            if (divisor != 1 && numero % divisor == 0) {
                return false;
            }
        }
        
        //si se acaban los enteros para dividir el numero es primo
        return true;
    }
    
}