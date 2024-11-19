package es.etg.dam.psp.EjercicioPortaaviones.util;

public abstract class Impresora implements Imprimible{

    // Atributos
    protected String titulo;
    protected String contenido;

    // Constructor padre
    public Impresora(){
    }

    // Constructor
    public Impresora(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    // Métodos abstractos de funcionamiento de construcción de datos
    public abstract void imprimir(String contenido);
}
