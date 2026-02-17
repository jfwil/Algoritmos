public class Factorial{
    public void factorial(int n){
    
    Scanner sc = new Scanner(System.in);

        int num;
        double factorial = 1;

        System.out.println("Ingrese un numero entero:");
        num = sc.nextInt();

        if (num < 0) {
            System.out.println("No existe factorial para numeros negativos.");
        } else {
            for (int i = 1; i <= num; i++) {
                factorial = factorial * i;
            }

            System.out.println("El factorial de " + num + " es: " + factorial);
        }

        sc.close();
    }
}