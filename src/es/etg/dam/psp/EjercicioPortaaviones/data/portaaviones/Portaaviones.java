package es.etg.dam.psp.EjercicioPortaaviones.data.portaaviones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import es.etg.dam.psp.EjercicioPortaaviones.util.FabricaImpresion;
import es.etg.dam.psp.EjercicioPortaaviones.util.Impresora;
import es.etg.dam.psp.EjercicioPortaaviones.util.TipoImpresion;

public class Portaaviones {

    // Constantes de texto
    private static final String MSG_ERROR = "Error al ejecutar el avión";
    private static final String MSG_ERROR_AVIONES = "Debe especificar el número de aviones como argumento.";
    private static final String MSG_ERROR_ARGUMENTO = "El argumento proporcionado no es un número válido.";
    private static final String PATH = "bin";
    private static final String[] COMANDO_BASE = { "java", "-cp", PATH, "es.etg.dam.psp.EjercicioPortaaviones.data.avion.Avion" };
    private static final String PATRON_AVION = "%s en el avión ID: %d";
    private static final String PATRON_ERROR = "%s: %s";

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(MSG_ERROR_AVIONES);
            return;
        }

        try {
            // Número de aviones a lanzar
            int numAviones = Integer.parseInt(args[0]);

            for (int i = 0; i < numAviones; i++) {
                try {
                    // Construcción del comando dinámico agregando el ID
                    String[] comando = crearComando(i);

                    // Ejecución del proceso
                    Process process = Runtime.getRuntime().exec(comando);
                    StringBuilder output = new StringBuilder();

                    // Lectura del output del proceso
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        output.append(line).append("\n");
                    }

                    // Esperar a que termine el proceso y comprobar el código de salida
                    int exitVal = process.waitFor();
                    if (exitVal == 0) {
                        // Impresión del resultado en consola
                        Impresora impresora = FabricaImpresion.crearImpresora(TipoImpresion.CONSOLA);
                        impresora.imprimir(output.toString());

                        // Impresión del resultado en formato Markdown
                        impresora = FabricaImpresion.crearImpresora(TipoImpresion.MARKDOWN);
                        impresora.imprimir(output.toString());
                    } else {
                        System.out.println(String.format(PATRON_AVION, MSG_ERROR, i));
                    }

                    // Establece el tiempo de espera antes de lanzar el siguiente avión
                    try {
                        Thread.sleep((int) (Math.random() * 3000) + 2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } catch (IOException | InterruptedException ex) {
                    ex.printStackTrace();
                    System.out.println(String.format(PATRON_ERROR, MSG_ERROR, ex.getMessage()));
                }
            }

        } catch (NumberFormatException ex) {
            System.out.println(MSG_ERROR_ARGUMENTO);
        }
    }

    private static String[] crearComando(int id) {
        // Clona el comando base y agrega el ID al final
        String[] comando = new String[COMANDO_BASE.length + 1];
        System.arraycopy(COMANDO_BASE, 0, comando, 0, COMANDO_BASE.length);
        comando[COMANDO_BASE.length] = String.valueOf(id); // Agrega el ID como argumento
        return comando;
    }
}
