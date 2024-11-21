package es.etg.dam.psp.EjercicioPortaaviones.util;

public class ImpresionConsola extends Impresora{

    // Constantes de texto
    private static final String TITULO = "==Misión de aviación==";

    // Constructor de la clase
    public ImpresionConsola(){
        super();
    }
    
    @Override
    public void imprimir(String contenido) {
        System.out.println(titulo + "\n\n" + contenido);
    }
}
