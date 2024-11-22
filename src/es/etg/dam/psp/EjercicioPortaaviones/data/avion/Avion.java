package es.etg.dam.psp.EjercicioPortaaviones.data.avion;

public class Avion {
    // Constantes de texto
    public static final String MSG_CAIDO = "Derribado";
    public static final String MSG_COMBATE = "En pie";
    public static final String PATRON = "\n\nEl piloto con ID %d ha hecho %d bajas";

    public static void main(String[] args) {
        // Parsear el ID pasado como argumento
        int id = Integer.parseInt(args[0]);
        int vivo = (int) (Math.random() * 2);
        int bajas = (int) (Math.random() * 100) + 1;

        // Construir el resultado
        String resultado = (vivo == 0) ? MSG_CAIDO : MSG_COMBATE;
        resultado += String.format(PATRON, id, bajas);
        System.out.println(resultado);
    }
}
