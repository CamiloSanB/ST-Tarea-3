# ST-Tarea-3
Contiene código fuente hechos en JAVA para la Tarea 3 de "Pruebas de Software", así como los tests hechos con JUnit para las clases hechas. Además presenta el reporte exportado de la cobertura de las clases hechas en el package "biblioteca".

El programa consiste en un programa de consola en el cual se pueden registrar libros e interactuar con ellos: Buscar, editar, eliminar.

# Autor
  Camilo Sánchez Bravo

# Descripción
  Se presenta a continuación la descripción de cada directorio principal.

  - ## Tarea3
    Código fuente escrito en JAVA (en subdirectorio src). El package (o directorio) "biblioteca" contiene el código fuente usados de las clases como de sus tests. Package "demo" contiene código fuente de la demo implementada, la cual viene cargada con dos registros de libros.
    
    Los tests están nombrados como Test<nombre_clase>.java (e.g. Clase Libro.java, TestLibro.java contiene sus tests). Estos fueron hechos con JUnit5.
    
    - ### Instalación
      Para poder ejecutar la demo, el archivo "Aplicacion.java" del package "demo" debe ser compilado, teniendo en cuenta que utiliza el package "biblioteca".
      
      Para los tests, se debe incluir la libreria JUnit5.
    - ### Cómo usar
      Ejecutar archivo generado de la compilación (e.g. En consola: >>java -jar Aplicacion.jar) e interactuar por consola según las opciones e instrucciones.
      
      Para los tests, ejecutar pruebas de cobertura.
  - ## coverage_classes
    Reporte de cobertura del packag "biblioteca" en HTML. Obtenido mediante la exportación de este.
    - ### Instalación
      No necesita instalación.
    - ### Cómo usar
      Abrir archivo "index.html" para comenzar a navegar a través del reporte generado. Importante notar aquí que el reporte incluido solo contiene la cobertura del package "biblioteca", por lo que si se genera un nuevo reporte incluyendo "demo", la cobertura será menor.

# ¿Cómo contribuir?
  No se aceptan contribuciones sobre nuevas funcionalidades y/o extensiones de los programas. Dado por la naturaleza del repositorio, sí se aceptan fallas y errores encontrandos en el funcionamiento de los programas, así como mejoras en el código.

# Licencia
  MIT License
