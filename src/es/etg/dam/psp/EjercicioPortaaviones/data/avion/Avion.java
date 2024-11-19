package es.etg.dam.psp.EjercicioPortaaviones.data.avion;

public class Avion {
    // Constantes de texto
    public static final String MSG_CAIDO = "Derribado";
    public static final String MSG_COMBATE = "En pie";
    public static final String PATRON = "\n\nEl piloto con ID %d ha hecho %d bajas";

    public static void main(String[] args) {
        // Parsear el ID pasado como argumento
        int id = Integer.parseInt(args[0]);

        // Generar estado del piloto (0 = caído, 1 = en combate)
        int vivo = (int) (Math.random() * 2);

        // Generar número de bajas (entre 1 y 100)
        int bajas = (int) (Math.random() * 100) + 1; // Genera de 1 a 100

        // Construir el resultado
        String resultado = (vivo == 0) ? MSG_CAIDO : MSG_COMBATE;
        resultado += String.format(PATRON, id, bajas);
        
        // Imprimir resultado
        System.out.println(resultado);
    }
}
