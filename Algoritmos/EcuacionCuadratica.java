public class EcuacionCuadratica {
   public static void resolver(double a, double b, double c) {
        System.out.println("Ecuación: " + a + "x² + " + b + "x + " + c + " = 0");
        
        //verificar si es una ecuacion cuadratica
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("infinitas soluciones");
                } else {
                    System.out.println("ecuacion sin solucion");
                }
            } else {
                System.out.println("ecuación lineal");
            }
            return;
        }
        
        //discriminante
        double discriminante = b * b - 4 * a * c;
        System.out.println("Discriminante: " + discriminante);
        
        //Caso discriminante positivo dos soluciones
        if (discriminante > 0) {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("dos soluciones reales:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
        
        //Caso discriminante cero una solucion
        else if (discriminante == 0) {
            double x = -b / (2 * a);
            System.out.println("Una solución:");
            System.out.println("x = " + x);
        }
        
        //caso discriminante negativo
        else {
            double real = -b / (2 * a);
            double imaginaria = Math.sqrt(-discriminante) / (2 * a);
            System.out.println("Dos soluciones complejas:");
            System.out.println("x1 = " + real + " + " + imaginaria + "i");
            System.out.println("x2 = " + real + " - " + imaginaria + "i");
        }
    }
}