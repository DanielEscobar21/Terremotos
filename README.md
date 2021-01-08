# TerremotosUSGS

_Desarrollo de una aplicación que muestre una lista de los terremotos más recientes en el
mundo desde la API de la organización USS Geological Survey (USGS)._

_En esta práctica vamos a ver sobre cómo crear una aplicación Swing que descargue infor-
mación de un servidor HTTP a través de una URL utilizando un SwingWorker y construye
un componente JTree con la información descargada, una lista de datos de los terremotos
ocurridos en una fecha o rango de fechas en particular. Los datos los vamos a descargar uti-
lizando la clase HttpURLConnection del paquete java.net para iniciar una conexión HTTP
con el servidor, abrir la secuencia de entrada de la conexión HTTP para leer los bytes trans-
feridos desde el servidor. Y se crea una secuencia de salida en el lado del cliente para recibir
la información en formato JSON._

## Introducción 

_Este programa toma de la mano los conocimientos adquiridos a lo largo del curso de Tópicos Avanzados 
de Programación, desde la creación de la GUI (Guia de Interfaz de Usuario) hasta la implementación de
hilos para la descarga de información._

_Para esto, utilizamos la API de la ["USGS:United States Geological Survey"](https://earthquake.usgs.gov/fdsnws/event/1/)_

### Características
_Las características que deberá tener el Software serán las siguientes:_
            
_a) Una interfaz para establecer los parámetros de la búsqueda de información:
            Las fechas deben de ser capturadas con un componente JDatePicker (Time: starttime, 
               endtime)
            Para limitar el numero de resultados,  debe ser capturado con un cuadro de texto (limit)
            Utilizar el componente JSlider para establecer los rangos de la magnitud (maxmagnitude, 
               minmagnitude; 0 significa no utilizar esta opción)
            Utilizar JRadioButton para seleccionar una opción para ordenar la información (orderby: time, 
                time-asc, magnitude, magnitude-asc y none para no ordenar)
            Añadir un botón para iniciar la búsqueda de información
                URL ejemplo de consulta para enviar una solicitud de datos:
 (https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02)
            Añadir un botón para cancelar la descarga de información._

_b) Utilizar un SwingWorker para descargar los datos de la consulta y no se bloquee nuestra interfaz._

_c) Una interfaz para mostrar los resultados:
            Los resultados se deben de mostrar en un componente JTree para que la visualización de 
               datos sea de forma jerárquica.
            La información se debe jerarquizar por fecha, magnitud  y titulo.
            Se deben de mostrar los siguientes datos de cada terremoto: place, magType, updated (fecha 
               de actualización, mostrar en formato de fecha) y url._

_d) Una interfaz para mostrar los nodos seleccionados en el JTree
            Siempre que se seleccione un nodo en el árbol, añade la ruta del nodo seleccionado en un
                componente JList._
 
_e) Usa un objeto JTabbedPane para organizar los componentes de la GUI en la ventana._



### Pre-requisitos 

_Para la ejecución de este programa es necesario las librerias "AbsoluteLayout.jar", "jcalendar-1.4.jar" y "json-20201115.jar". Que tambien se puede enontrar en la carpeta de "src/Lib/"_

Para compilar el programa con Libreria desde CMD utilizar este comando desues de estar en la carpeta de las clases y haber corrido la maquina virtual de Java en la terminal
```
javac -cp Lib/AbsoluteLayout.jar.;Lib/json-20201115.jar.;Lib/jcalendar-1.4.jar *.java
```
Para ejecutar el progrma 
```
java -cp .;Lib/AbsoluteLayout.jar.;Lib/json-20201115.jar.;Lib/jcalendar-1.4.jar exe
```

## Construido con 

* [SublimeText 3](https://www.sublimetext.com/) - Editor de Texto
* [NetBeans IDE](https://netbeans.org/projects/www/) - IDE
* [Adobe Illustrator](https://www.adobe.com/mx/products/illustrator.html) - Creador de Iconos


## Referencias
* [How to Send HTTP Request and Parse JSON Data Using Java](https://www.youtube.com/watch?v=qzRKa8I36Ww)
* [API Documentation](https://earthquake.usgs.gov/fdsnws/event/1/)
* [JTree basic tutorial and examples](https://www.codejava.net/java-se/swing/jtree-basic-tutorial-and-examples)


## Version
Version 2.0 Terremotos

## Autor 
* **Daniel Escobar Araujo** [DanielEscobar21](https://github.com/DanielEscobar21)

## Licencia 
Copyright (c) 2021-Daniel Escobar Araujo (DanielEscobar21)

Por la presente se concede permiso, sin cargo, a cualquier persona que obtenga una copia de este software y los archivos de documentación asociados (el "Software"), para utilizar el Software sin restricciones, incluidos, entre otros, los derechos de uso, copia, modificación, fusión , publicar, distribuir, sublicenciar y / o vender copias del Software, y permitir que las personas a las que se les proporcione el Software lo hagan, sujeto a las siguientes condiciones:

El aviso de copyright anterior y este aviso de permiso se incluirán en todas las copias o partes sustanciales del Software.

EL SOFTWARE SE PROPORCIONA "TAL CUAL", SIN GARANTÍA DE NINGÚN TIPO, EXPRESA O IMPLÍCITA, INCLUYENDO PERO NO LIMITADO A LAS GARANTÍAS DE COMERCIABILIDAD, ADECUACIÓN PARA UN PROPÓSITO PARTICULAR Y NO INFRACCIÓN. EN NINGÚN CASO LOS AUTORES O TITULARES DE LOS DERECHOS DE AUTOR SERÁN RESPONSABLES DE CUALQUIER RECLAMO, DAÑOS U OTRAS RESPONSABILIDADES, YA SEA EN UNA ACCIÓN DE CONTRATO, AGRAVIO O DE OTRO MODO, QUE SURJA DE, FUERA DE O EN RELACIÓN CON EL SOFTWARE O EL USO U OTRAS NEGOCIACIONES EN EL SOFTWA

## Datos 

* Este Proyecto se hizo en Base a la materia de Tópicos Avanzados de Programación.

