import algoritmos.Fibonacci;
import javax.swing.JOptionPane;
    
public class MenuPrincipal {

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        // arreglo de botones para escalabilidad
        String[] botones = {
            "Digito Fibonacci",
            "Numero Primo",
            "Ecuación Cuadratica",
            "Numero Factorial"
        };

        while (true) {
            int opcion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opcion:",
                    "Menu Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    botones,
                    botones[0]
            );

            switch (opcion) {
                case 0:
                    calcularFibonacci();
                    break;

                case JOptionPane.CLOSED_OPTION:
                    int confirmar = JOptionPane.showConfirmDialog(
                            null,
                            "¿Desea salir del programa?",
                            "Confirmar",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (confirmar == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Programa finalizado.",
                                "Salir",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        return;
                    }
                    break;

                case 1:
                    calcularPrimo();
                    break;

                case 2:
                    calcularEcuacionCuadratica();
                    break;
                case 3:
                    calcularFactorial();
                    break;
                    
                default:

                    break;
            }
        }
    }

    private static void calcularFibonacci() {
        while (true) {
            String input = JOptionPane.showInputDialog(
                    null,
                    "Ingrese la posicion n:",
                    "Digito Fibonacci",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (input == null) {
                return;
            }

            if (input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Por favor ingrese un numero.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                continue;
            }

            try {
                int n = Integer.parseInt(input.trim());

                if (n < 0) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Ingrese un numero mayor o igual a 0.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    continue;
                }

                long resultado = Fibonacci.fibonacci(n);

                JOptionPane.showMessageDialog(
                        null,
                        "Fibonacci(" + n + ") = " + resultado,
                        "Resultado",
                        JOptionPane.INFORMATION_MESSAGE
                );

                int continuar = JOptionPane.showConfirmDialog(
                        null,
                        "Calcular otro numero?",
                        "Continuar",
                        JOptionPane.YES_NO_OPTION
                );

                if (continuar != JOptionPane.YES_OPTION) {
                    return;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Error: Ingrese un numero valido.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    private static void calcularPrimo() {
        while (true) {
            String input = JOptionPane.showInputDialog(
                    null,
                    "Ingrese numero entero positivo:",
                    "Numero Primo",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (input == null) {
                return;
            }

            if (input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Por favor ingrese un numero.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                continue;
            }

            try {
                int n = Integer.parseInt(input.trim());

                if (n < 0) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Ingrese un numero mayor o igual a 0.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    continue;
                }

                boolean resultado = Primo.esPrimo(n);

                String mensaje;
                if (resultado) {
                    mensaje = n + " es un numero primo.";
                } else {
                    mensaje = n + " NO es un numero primo.";
                }

                JOptionPane.showMessageDialog(
                        null,
                        mensaje,
                        "Resultado",
                        JOptionPane.INFORMATION_MESSAGE
                );

                int continuar = JOptionPane.showConfirmDialog(
                        null,
                        "Verificar otro numero?",
                        "Continuar",
                        JOptionPane.YES_NO_OPTION
                );

                if (continuar != JOptionPane.YES_OPTION) {
                    return;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Error: Ingrese un numero valido.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    private static void calcularEcuacionCuadratica() {
        while (true) {
            //ingresar coeficiente a
            String inputA = JOptionPane.showInputDialog(
                    null,
                    "Ingrese el coeficiente a (x²):",
                    "Ecuacion Cuadratica",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (inputA == null) {
                return;
            }

            //ingresa coeficiente b
            String inputB = JOptionPane.showInputDialog(
                    null,
                    "Ingrese el coeficiente b (x):",
                    "Ecuacion Cuadratica",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (inputB == null) {
                return;
            }

            //ingresa coeficiente c
            String inputC = JOptionPane.showInputDialog(
                    null,
                    "Ingrese el coeficiente c (termino independiente):",
                    "Ecuacion Cuadratica",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (inputC == null) {
                return;
            }

            //campos vacios
            if (inputA.trim().isEmpty() || inputB.trim().isEmpty() || inputC.trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Por favor complete todos los campos.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                continue;
            }

            try {
                double a = Double.parseDouble(inputA.trim());
                double b = Double.parseDouble(inputB.trim());
                double c = Double.parseDouble(inputC.trim());

                //resultado
                String resultado = "Ecuación: " + a + "x² + " + b + "x + " + c + " = 0\n\n";

                //verificar si es cuadratica
                if (a == 0) {
                    if (b == 0) {
                        if (c == 0) {
                            resultado += "Infinitas soluciones";
                        } else {
                            resultado += "Ecuacion sin solucion";
                        }
                    } else {
                        double x = -c / b;
                        resultado += "Ecuacion lineal\nSolucion: x = " + x;
                    }
                } else {
                    //calculo del discriminante
                    double discriminante = b * b - 4 * a * c;
                    resultado += "Discriminante: " + discriminante + "\n\n";

                    //caso discriminante positivo
                    if (discriminante > 0) {
                        double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                        double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                        resultado += "Dos soluciones reales:\n";
                        resultado += "x1 = " + x1 + "\n";
                        resultado += "x2 = " + x2;
                    } //caso discriminante cero
                    else if (discriminante == 0) {
                        double x = -b / (2 * a);
                        resultado += "Una solucion:\n";
                        resultado += "x = " + x;
                    } // Caso discriminante negativo
                    else {
                        double real = -b / (2 * a);
                        double imaginaria = Math.sqrt(-discriminante) / (2 * a);
                        resultado += "Dos soluciones complejas:\n";
                        resultado += "x1 = " + real + " + " + imaginaria + "i\n";
                        resultado += "x2 = " + real + " - " + imaginaria + "i";
                    }
                }
                JOptionPane.showMessageDialog(
                        null,
                        resultado,
                        "Resultado",
                        JOptionPane.INFORMATION_MESSAGE
                );
                int continuar = JOptionPane.showConfirmDialog(
                        null,
                        "Resolver otra ecuacion?",
                        "Continuar",
                        JOptionPane.YES_NO_OPTION
                );

                if (continuar != JOptionPane.YES_OPTION) {
                    return;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Error: Ingrese numeros validos.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
    
    private static void calcularFactorial() {
        while (true) {
            String input = JOptionPane.showInputDialog(
                    null,
                    "Ingrese un numero entero:",
                    "Numero Factorial",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (input == null) {
                return;
            }

            if (input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Por favor ingrese un numero.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                continue;
            }

            try {
                int num = Integer.parseInt(input.trim());
                double factorial = 1;

                if (num < 0) {
                    JOptionPane.showMessageDialog(
                            null,
                            "No existe factorial para numeros negativos.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    continue;
                } else {
                    for (int i = 1; i <= num; i++) {
                        factorial = factorial * i;
                    }

                    JOptionPane.showMessageDialog(
                            null,
                            "El factorial de " + num + " es: " + factorial,
                            "Resultado",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }

                int continuar = JOptionPane.showConfirmDialog(
                        null,
                        "¿Calcular otro factorial?",
                        "Continuar",
                        JOptionPane.YES_NO_OPTION
                );

                if (continuar != JOptionPane.YES_OPTION) {
                    return;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Error: Ingrese un numero valido.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

}
