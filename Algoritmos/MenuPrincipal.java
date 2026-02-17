package algoritmos;

/**
 *
 * @author asfak
 */
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
                        return; // Sale del metodo mostrarMenu()
                    }
                    break;
                    
                case 1:
                    calcularPrimo();
                    break;
                    
                default:
                    // Opcion no reconocida (por si acaso)
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
                        "¿Calcular otro numero?",
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
                        "Ingrese un numero.",
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
                            "ingrese un numero mayor o igual a 0.",
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
                        "¿Verificar otro numero?",
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