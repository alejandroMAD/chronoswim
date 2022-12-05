Chronoswim
===============
[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![en](https://img.shields.io/badge/lang-en-red.svg)](https://github.com/alejandroMAD/chronoswim/blob/master/README.md)
[![es](https://img.shields.io/badge/lang-es-yellow.svg)](https://github.com/alejandroMAD/chronoswim/blob/master/README.es.md)

Interfaz de usuario
----------
![Captura de pantalla](/screenshot.png)

Una aplicación de Java Swing para cronometrar los tiempos en carreras deportivas y administrar un fichero de base de datos
donde se guardan los resultados de las carreras y nombres de los medallistas, empleando un patrón de diseño MVC y practicando operaciones CRUD en un fichero CSV. Compilar con Java 1.8 o superior.

Características
-------------------
* Las carreras permiten registrar el nombre del evento, la fecha y hora del sistema y los nombres de 8 participantes.
* Una carrera puede celebrarse sin especificar un nombre (se utilizará "Default Race"), pero no sin inscribir a 8 atletas, existiendo reglas de validación del formulario para garantizarlo.
* El reloj de la carrera se muestra en un formato predefinido en la clase SportsTimeFormat: [minutos:segundos:fracción de segundos] de manera similar a las competiciones deportivas reales.
* El cronómetro de carrera permite registrar individualmente los tiempos de llegada a la meta de cada participante.
* Los resultados de las carreras pueden guardarse en un fichero CSV de texto plano, incluyendo los nombres y tiempos de los atletas que llegan a la meta en primera, segunda y tercera posición.
* Los resultados almacenados en la base de datos rellenan una tabla de tipo JTable en la Vista.
* Pueden practicarse las operaciones CRUD de gestión de bases de datos en los registros del fichero CSV, que además está dinámicamente indizado.
* Una colección de registros predefinidos de carreras auténticas de la natación olímpica puede utilizarse en la tabla y base de datos para fines de prueba y aprendizaje.
* La actualización de registros está restringida a modificar el nombre de la carrera para evitar la manipulación de los resultados de eventos deportivos.

El uso de un fichero sencillo de tipo CSV como "base de datos" no es una solución óptima, pero lo he elegido para este proyecto con fines educativos y en cumplimiento de los requisitos de un ejercicio del módulo de Acceso a Datos del CFGS de Desarrollo de Aplicaciones Multiplataforma.

Reconocimiento
-------------------

* Señal de Stop: [Iconos creados por Freepik - Flaticon](https://www.flaticon.es/iconos-gratis/detener)
* Iconos de medallas: [Iconos creados por Freepik - Flaticon](https://www.flaticon.com/free-icons/medal)
* Icono de cronómetro: [creado por Yogi Aprelliyanto - Flaticon](https://www.flaticon.com/free-icons/stopwatch)
* Imagen de fondo de piscina: [creado por Cmapm](https://commons.wikimedia.org/wiki/File:Swimming_pool_50m_2008.svg)

Licencia
--------
    Copyright (C) 2022  Alejandro M. González
    
    Licencia MIT: https://opensource.org/licenses/MIT
