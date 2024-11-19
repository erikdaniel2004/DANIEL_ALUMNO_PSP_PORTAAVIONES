package es.etg.dam.psp.EjercicioPortaaviones.util;

public class FabricaImpresion {

    // Constantes de texto
    private static final String ERROR_IMPRESION = "Tipo de impresión no soportado: ";
    
    public static Impresora crearImpresora(TipoImpresion tipoImpresion) {
        switch (tipoImpresion) {
            case CONSOLA:
                return new ImpresionConsola();
            case MARKDOWN:
                return new ImpresionMarkdown();
            default:
                throw new IllegalArgumentException(ERROR_IMPRESION + tipoImpresion);
        }
    }
}
