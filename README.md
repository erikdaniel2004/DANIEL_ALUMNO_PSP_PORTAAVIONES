# Ejercicio Portaaviones

## Análisis

### Enunciado

Eres un ingeniero militar encargado de simular las operaciones de un portaaviones. Eres el encargado de dar la orden de **lanzar** la cantidad de cazas que creas necesario para sus misiones correspondientes de manera **INDEPENDIENTE**. Cada avión lanzado se espera un tiempo de entre **3 y 5 segundos** antes de poder dar paso al siguiente y al final lo que tienen que devolver es la caja negra con los siguientes datos:

**`Estado`**: "En pie" si el avión completó su misión o "Derribado" si falló.
**`Bajas enemigas`**: Un número aleatorio entre 1 y 100.
Al final es el **Portaaviones el que recupera las cajas negras** de los aviones y se almacenan los datos en la central del sistema. 

Se entregará un fichero zip, no importa el nombre:

Análisis y Diseño en Markdown (si se requieren imágenes se puede hacer referencia a ellas sin insertarlas en el documento). La extensión de este fichero debe ser .md y su pdf de exportación (si se hace con una herramienta distinta a md se subirá el pdf)
Imágenes utilizadas para el análisis y/o diseño
Código/Pruebas implementadas (se valorará la calidad/claridad/legibilidad del código)
Fichero pdf con el contenido del fichero Markdown.

## Diseño

```plantuml
package ".vscode" {
}

package "bin" {
}

package "lib" {
}

package "src.es.etg.dam.psp.EjercicioPortaaviones" {
    package "data" {
        package "app" {
            class App {
                +main(String[]args)
            }
        }

        package "portaaviones" {
            class Portaaviones {
                -MSG_ERROR : String
                -COMANDO : String
                -PATRONES : String
                +main(String[]args)
                -crearComando(int id) : String[]
            }
        }

        package "avion" {
            class Avion {
                -MSG_CAIDO : String
                -MSG_COMBATE : String
                -PATRON : String
                -main(String[]args)
            }
        }
    }

    package "util" {
        package "ficheros" {
            file Informe.md
        }

        interface Imprimible {
            #void Imprimir(String contenido)
        }

        abstract class Impresora {
            # Titulo : String
            # Contenido : String
            + Impresora(String titulo, String contenido)
            +getTitulo() : String titulo
            +getContenido() : String contenido
            +setTitulo(String titulo)
            +setContenido(String titulo)
            +abstract void imprimir(String contenido)
        }

        class FabricaImpresion {
            +crearImpresora(TipoImpresion impresion) : Impresora impresora
        }

        class ImpresionConsola {
            -Titulo : String
            +void imprimir(String contenido)
        }

        enum TipoImpresion {
            CONSOLA
            MARKDOWN
        }
    }
}
```