package es.etg.dam.psp.EjercicioPortaaviones.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ImpresionMarkdown extends Impresora {

    // Constantes de texto
    private static final String TITULO = "## ==Misión de aviación==";
    private static final String FICHERO = "src/es/etg/dam/psp/EjercicioPortaaviones/util/ficheros/Informe.md";
    private static final String PATRON = "%s\n\n%s";

    // Constructor de la clase
    public ImpresionMarkdown() {
        super();
    }

    @Override
    public void imprimir(String contenido) {
        File archivo = new File(FICHERO);

        try {
            // Verificar si el archivo existe
            if (!archivo.exists()) {

                // Crear los directorios si no existen
                archivo.getParentFile().mkdirs();

                // Crear el archivo
                archivo.createNewFile();
            }

            // Escribir en el archivo
            try (BufferedWriter writter = new BufferedWriter(new FileWriter(archivo, true))) {
                writter.write(String.format(PATRON, TITULO, contenido));
                writter.newLine();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
