# RETO AUTOMATIZACION T-EVOLVERS

### API AUTOMATION TESTING:
El reto consistirá en automatizar un api para los siguientes end points o paths:
1. CreateBooking.
2. GetBooking.
3. UpdateBooking.

Condiciones de entrega:
• Se deben entregar el proyecto en un repositorio público de github.
• Por favor solo versionar los archivos necesarios.
• Indicar el stack tecnológico utilizado. Generar un readme con la explicación de como ejecutar
los proyectos.
Se utilizará el siguiente api:
• URL: https://restful-booker.herokuapp.com/apidoc/index.html

Para el tercer escenario es necesario automatizar el Auth – Create Token ya que es requerido en
un header llamado Cookie donde se debe concatenar el valor a la palabra “token=” con el
response del endpoint CreateToken.

Realizar los escenarios y validaciones que considere relevantes.

### WEB AUTOMATION TESTING:
El reto consistirá en automatizar la búsqueda y agregado de productos de una tienda virtual.
Seleccionar varios productos y comprarlos. Nota: No es necesario agregar el registro del
usuario en la automatización.
Se utilizará la siguiente url:
• URL: https://www.demoblaze.com/
Realizar los escenarios y validaciones que considere, sin embargo, se debe validar que la
suma total de los productos escogidos sea correcta.

### Condiciones de entrega:
• Se deben entregar el proyecto en un repositorio público de github.
• Por favor solo versionar los archivos necesarios.
• Indicar el stack tecnológico utilizado. Generar un readme con la explicación de como ejecutar
los proyectos.

### Tabla de contenido

* [Pre-requisitos](#pre-requisitos)
* [Instalación](#instalación)
* [Arquitectura del proyecto](#arquitectura-del-proyecto)
* [Ejecutando las pruebas](#ejecutando-las-pruebas)
* [Buenas Practicas](#buenas-practicas)
* [Construido con️](#construido-con)
* [Autores](#autores)


## Pre-requisitos

Antes de realizar la descarga o cloncacion del proyecto es importante:

```
- Tener instalado un IDE ya sea Eclipse o Intellij.
- Tener instalado en los pluging para el IDE Cucumber para java, Gherkin.
- Tener instalado en el equipo el JDK de java.
- Preferible tener intalado en el equipo Gradle con su respectiva variable de entorno.
```

## Instalación

Para realizar la clonación del proyecto es importante considerar los siguientes pasos:

```
- Crear una carpeta donde quieras almacenar el proyecto.
- Abrir la consola Git Bash y ejecutar el siguiente comando: "git clone https://github.com/desarrollojesusdorado/RetoAutomatizacionTEvolvers.git"
- Abrir el IDE ya sea Intellij ó Eclipse y realizar la importación del proyecto.
```
## Arquitectura del proyecto

La arquitectura principal del proyecto es con el framework screenplay y consta de las siguientes capas:

`![texto cualquiera por si no carga la imagen](https://miro.medium.com/max/2400/1*FKa85Y68iyd-mYSY4bYsPA.png)`

### Capas Principales

**Features:** En esta capa se escriben los archivos .feature, estos describen las características y escenarios a probar haciendo uso del lenguaje Gherkin.

**Runners:** Contiene los archivos runner encargados de ejecutar los escenarios de la feature. Se usan las anotaciones @RunWhit() @CucumberOptions() para especificar qué ejecutar y cómo hacerlo.

**Step Definitions:** Gestiona los code snippets de los steps definidos con las palabras Given, When, Then en los escenarios de los archivos .feature

**Tasks:** Esta clase contiene las clases que son el corazón del patrón de screenplay=Las tareas. Las tareas son acciones de alto nivel que definen un conjunto de interacciones en el lenguaje de negocio.

**Interactions:** Se encargan de las interacciones con la interfaz de usuario.Muchas interacciones ya fueron desarrolladas y se encuentran disponibles gracias a las librerías de screenplay y de serenity BDD. Ejemplo: Open, Click, Enter, Hit, SelectFromOptions.

**Questions:** Esta capa gestiona los Asserts o verificaciones de las pruebas las cuales son el fin ultimo de las mismas, ya que con estas capturamos la información de la interfaz que puede ser usada. Text,Value, Visibility.


### Capas Transversales

**Utils:** Contiene clases con los métodos unitarios que pueden ser utilizados libremente por otras clases del proyecto como: Conversores, Waits, verificadores.

**Exceptions:** Esta es una capa muy importante que tiene como objetivo dar manejo a los errores que pueden presentarse en la aplicación. Es una capa sensible al negocio y particular a cada proyecto.

## Ejecutando las pruebas

Para la ejecucion de los test automatizados es necesario identificar lo siguiente:

- Buscar en la ruta src/test/resources/features el .feature que deseemos ejecutar e identificar el runners asociado donde se encuetra configurado el .feature para su ejecución.

Para la ejecución de los runners podemos utilizar el siguiente comando:

```
gradle clean test --tests *ClaseRunners* aggregate --info
```

### Reporte de serenity:

Despues de ejecutado el comando anterior desde la consola ubicar el archivo index.html en la ruta target\site\serenity y abrirlo con el navegador de tu preferencia para mirar el detalle del test ejecutado.

### **Nota:**

Tambien puedes realizar la ejecución del runners desde el IDE ya sea Intellij o Eclipse, pero no vas a tener un reporte de serenity completo, por eso te recomiendo ejecutarlo desde la consola ya sea del IDE o del CMD para tener un reporte mas completo y donde puedas encontrar el index.html.

## Buenas Practicas

Al momento de codificar para el nombramiento de clases, metodos, variables y constantes se recomienda:

**Clases:**

Para el nombramiento de las clases se debera seguir la convención CamelCase por ejemplo:

```
public class VerificarTarifas {
}
```

**Metodos:**

Los métodos deben ser verbos, en mayúsculas y minúsculas, con la primera letra de cada palabra interna (a partir de la segunda) en mayúscula:

```
   public void queJesusIngresaALaPaginaDeDxHotels() {
}
```
**Variables:**

Los nombres de las variables deben ser cortos pero significativos.

- No debería comenzar con un guión bajo (‘_’) o caracteres, como por ejemplo, un signo de dólar ‘$’.
- Debe ser mnemotécnico, es decir, diseñado para indicar al observador casual la intención de su uso.
- Se deben evitar los nombres de variable de un carácter, excepto para variables temporales.
- Los nombres comunes para las variables temporales son: i, j, k, m y n para enteros; c, d y e para los caracteres.

```
    private String fechaIngreso;
    private String fechaSalida;
    private String numHabitaciones;
```
**Variables constantes en java:**

Debería estar todo en mayúsculas con palabras separadas por guiones bajos (“_”).

```
public static final String URL_PAGINA  = "https://js.devexpress.com/Demos/DXHotels/#home";
```

## Construido con

_Las tecnologias o herramientas usadas para la construccion del proyecto son:_

* [Screenplay](https://serenity-bdd.github.io/docs/screenplay/screenplay_webdriver) - El framework usado.
* [Gradle](https://docs.gradle.org/current/userguide/userguide.html) - Manejador de dependencias.
* [Serenity BDD](https://serenity-bdd.github.io/docs/reporting/the_serenity_reports) - Usado para generación de reportes para ver informes y detalle de las pruebas.
* [Gherkin](https://cucumber.io/docs/gherkin/reference/) - Redaccion de pasos para la ejecucion de nuestras pruebas.
* [Cucumber](https://cucumber.io/docs/installation/java/) - Metodos construidos en java que vincula a uno o mas pasos de Gherkin.
* [Junit](https://cucumber.io/docs/cucumber/api/#running-cucumber) - Usamos Junit para ejecutar nuestros escenarios en gherkin.
* [Git](https://git-scm.com/docs/gittutorial) - Esta es nuestra herramienta de versionamiento para el codigo generado.
* [Serenity Screenplay Rest](https://serenity-bdd.github.io/docs/screenplay/screenplay_rest) - Esta es nuestra herramienta para la automatización de nuestros servicios.

## Autores

_En construcción_
