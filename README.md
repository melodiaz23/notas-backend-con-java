# ¿Que es la programación?

Es dar instrucciones precisas y ordenadas para realizar una tarea específica. En el contexto de la informática, la programación se centra en la creación de programas mediante la elaboración de algoritmos, que son secuencias de pasos definidos para que una máquina ejecute las acciones deseadas.

Los componentes fundamentales de un programa son el _lenguaje de programación_ y los _algoritmos_.

## Lenguaje de programación

Un lenguaje de programación es un sistema formal que permite a los programadores **escribir una serie de instrucciones, acciones consecutivas, datos y algoritmos para resolver problemas**.

Existen diferentes tipos de lenguajes de programación:

- **Lenguaje máquina:** Compuesto por una secuencia de dígitos binarios (0 y 1).
- **Lenguajes de alto nivel:** Permiten escribir código utilizando estructuras similares a los idiomas humanos. Para que estos códigos sean ejecutables, se traducen mediante traductores o compiladores. Por ejemplo: Java, Python, Ruby, C++, JavaScript, entre otros.

## ¿Que es un algoritmo?

Los algoritmos son una **serie de pasos organizados lógicamente** que se utilizan para dar instrucciones a un programa y resolver problemas específicos.

El algoritmo se ejecuta de manera "**secuencial**", lo que significa que cada línea se ejecuta en orden, desde la declaración inicial hasta la palabra "**fin**".

# PSInt

> [!NOTE]
> Todos los programas toman una **entrada de información**, lo procesan y luego dan una **salida**.

Palabras reservadas propias del lenguaje que sirven para un uso específico:

- `Algoritmo` -> Inicio del código del programa.
- `FinAlgoritmo` -> Última línea del programa.
- `Definir` -> Declarar una variable.
- `Como` -> Tipo de dato.

---

En PSeInt, los tipos de datos que podemos utilizar incluyen: entero, real, caracter, cadena y lógico:

- **Entero** -> Permite guardar valores numéricos, sin decimales.
- **Real** -> Permite guardar valores numéricos, con decimales.
- **Caracter** -> Permite guardar letras, palabras, texto. También conocido como cadena de caracteres.
- **Logico** -> Permite guardar datos con valor de verdad (verdadero o falso).

---

- `Escribir` -> Nos permite mostrar información por la salida del programa (función de salida).

```c
Escribir "expresión o constante a imprimir separadas por comas"
```

Ejemplo:

```c
Escribir "Hola mundo! Soy", mi_nombre ,"y este es mi primer programa".
```

- `Leer` -> Función de entrada. Lee por teclado un valor que le he pedido al usuario para procesarlo dentro del programa.

```
Leer <variable donde quiero que se cargue el valor leído>
```

- `//`-> Comentarios
- `///` -> Se usará para identificar decisiones genéricas que nos expliquen como utilizar funciones del lenguaje.

## Estructuras Selectivas

Son usadas cuando nos enfrentamos a múltiples opciones que están condicionadas por una evaluación específica.

Existen tres tipos principales de estructuras selectivas/alternativas:

- **Simples**: utiliza la instrucción "Si" (1 alternativa)

```c
Si "expresión_logica" Entonces
	"acciones_por_verdadero"
Fin Si
```

- **Dobles**: Emplea las instrucciones "Si" y "Sino". (2 alternativas).

```c
Si "expresión_logica" Entonces
	"acciones_por_verdadero"
SiNo
	"acciones_por_falso"
Fin Si
```

- **Múltiples**: se desarrolla mediante instrucciones "Según" o "Si" anidado (n alternativas)

```c
Segun `variable_numerica` Hacer
	`opcion_1`:
		`secuencia_de_acciones_1`
	`opcion_2`:
		`secuencia_de_acciones_2`
	`opcion_3`:
		`secuencia_de_acciones_3`
	De Otro Modo:
		`secuencia_de_acciones_dom`
Fin Segun
```

> [!NOTE]
> Los condicionales múltiples permiten tener distintas alternativas a partir de seleccionar un valor posible que tiene una expresión.

**Los condicionales múltiples NO utilizan una condición lógica para resolver un problema.** Usan una variable y un conjunto de valores posibles que pueden tomar esa variable.

## Estructuras Repetitivas

- **Mientras**:  primero se evalúa una condición (una expresión lógica). Si esta condición se evalúa como falsa, no se realiza ninguna acción y el programa continúa con la siguiente instrucción.

```c
Mientras `expresion_logica` Hacer
	`secuencia_de_acciones`
Fin Mientras
```

- **Hacer/Repetir - Mientras Que**: El contenido del bucle se ejecuta al menos una vez.

```c
Hacer/Repetir
	`secuencia_de_acciones`
Mientras Que `expresion_logica`
```

- **Bucle Para**: Permite ejecutar un conjunto de acciones para cada paso de un conjunto de elementos.

```c
Para `variable_numérica` = `valor-inicial` Hasta `valor_final` Con Paso `paso` Hacer
	`secuencia_de_acciones`
Fin Para
```

> - `variable_numérica` es una variable de tipo contador
> - `Paso` es opcional y no es necesaria incluirla en el bucle. Por defecto la variación es de 1 en 1.

> [!NOTE]
> Con el bucle para podemos predecir cuantas vueltas va a dar el bucle porque sabemos el valor inicial, el final y el paso.
> **Bucle para** es útil cuando podamos predecir la cantidad de vueltas que vamos a utilizar. Cuando no hay forma de saberlo, usamos el **bucle mientras** o el **bucle hacer mientras**

## Estructuras anidadas

Es una característica que nos permiten los lenguajes de programación para que una estructura pueda estar dentro de otra estructura.

## Definiciones Claves

**Variables**: Permiten guardar cierto tipo de información en la memoria de la computadora y luego poder trabajar con esos valores.
A las variables hay que

1. **Identificarlas**.
2. Identificar el **tipo de dato**.
3. **Inicializarla**.
   **Variable no definida**: No se ha dado la instrucción para que la computadora reserve el lugar en la memoria para guardar la información.
   **Variable no inicializada**: La computadora ya reservó la memoria pero aún no tiene ningún valor.

**Valor nulo**: No hay valor/valor desconocido.
**Valor vacío**: En **datos** numéricos el valor vacío es el 0. `""` también es un valor vacío.

> [!note]  
> No utilizar **palabras reservadas** para los nombres de las variables.

**Datos**: Son la forma en la que la computadora entiende la representación de la información. - Numéricos: Enteros y reales. - Caracter - Lógico: Valor de verdad.

**Expresión**: combinación de operadores con variables, con constantes, con paréntesis, etc. Es una combinación de cualquier elemento que soporte el lenguaje de programación con el objetivo de obtener un resultado.

**Operaciones**:

- Matemáticas: Realizan cálculos.
- Relacionales: Comparan valores. Permiten operar con casi todos los tipos de datos y entregan un valor de tipo lógico.
- Lógicas: Evaluar decisiones en función de valores de verdad.

**Precedencia de operadores**: Conjunto de reglas que determina el orden en que se ejecutan las operaciones cuando hay paréntesis.

# Subprogramas

Un sub-programa se refiere a una porción de código dentro de un programa más grande que realiza una tarea específica.

En PSEINT, existen dos formas de implementar esta técnica:

- Las funciones: Devuelven un valor
- Los procedimientos(sub-procesos).

**la diferencia entre un procedimiento y una función radica principalmente en si devuelven o no un único valor como resultado**.

## Funciones

- **Las funciones son un tipo de sub-programa.** Son bloques de código que se pueden invocar múltiples veces.
- **Una función debe devolver siempre un resultado**, el cual puede ser de cualquier tipo de dato, pero siempre debe retornar un valor que será almacenado en la variable de retorno.

Formato general de una función:

```c
Funcion <variable_de_retorno> <- <Nombre> ( Argumentos )
	Defininr <variable_de_retorno> Como <tipo_de_dato>
// < sentencias >
Fin Funcion
```

- Variable retorno: Donde la función almacena el resultado. Debe ser definida.
- Nombre de la función: Nombre que utilizaremos para invocar la función
- Conjunto de Parámetros (opcional): Puede tener una cantidad variable de parámetros, que permiten que el programa se comunique, enviando información a través de ellos.

> [!NOTE]
>
> - Se pueden implementar diversas acciones dentro del bloque de código, pero solo se retorna el último valor almacenado en la variable creada para dicho fin.
> - Los **parámetros** son variables en la definición de una función, mientras que los **argumentos** son los valores reales que se pasan a la función cuando se la invoca. La cantidad, tipo y orden de los argumentos enviados al invocar la función deben ser coherentes con los declarados en la misma.

Los parámetros son una forma de comunicación entre los programas y los subprogramas.

El resultado que devuelven las funciones se pueden utilizar:

- Directamente en cualquier expresión
- Invocarla
- Utilizarla dentro de otras funciones.

### Función recursiva

**Una función es recursiva** cuando se invoca a sí misma para resolver el problema que tiene que solucionar.

Es esencial que  la función recursiva tenga una condición específica que permita que la recursión se detenga, conocida como **"condición de base"**.

Es esencial considerar que los programas recursivos tienden a consumir más recursos, ya que requieren mantener una pila de llamadas. Por ende, se sugiere emplear la recursividad de manera moderada

> [!NOTE]
> La función recursión tiene que tener alguna condición en donde la recursión se detenga, para que no se siga invocando infinitamente a sí misma (condición de base).

- Como **pros**, tenemos que los programas recursivos son fáciles de leer y mantener porque son cortos y a veces la técnica de recursividad es la mejor solución.
- Como **contra**, está que la recursión gasta más recursos porque hay que mantener la pila de llamada.

_Todo programa que se escribe de forma recursiva, se puede escribir de forma no recursiva_

Ejemplo:

```c
Algoritmo FactorialRecursivo
    Definir num Como Entero

    Escribir "Ingrese un número:"
    Leer num

    Escribir "El factorial de ", num, " es ", funcionFactorial(num)
FinAlgoritmo

Funcion f <-funcionFactorial(n)
	Definir f Como Entero
    Si n = 0 O n = 1 Entonces
        f=1	// funcion base que detiene la recursion
    Sino
		f= n * funcionFactorial(n - 1) // invocacion recursiva
    FinSi
FinFuncion

```

## Procedimientos

A diferencia de las funciones, los procedimientos no están obligados a retornar un valor.

```c
SubProceso  <nombre_procecimiento> ( Argumentos por Valor/Referencia )
	<sentencias>
FinSubProceso
```

- No es necesario tener una variable de retorno.
- Hay dos formas de pasar los parámetros a nuestro sub-programa: Por valor y por referencia.
  - Por referencia: Tanto el programa que invocó como el programa invocado comparten una referencia en memoria.
  - Por valor: Es la manera por defecto. Se realiza una copia por valor. En memoria son dos espacios distintos.

Con el paso del parámetro **por referencia** siempre tengo que definir una variable donde el sub-programa va a devolver el resultado.

## Definiciones Claves

- **Referencia en memoria**: Si dentro de un sub-programa modifico el valor del parámetro, también se modifica en memoria la misma posición del programa que invocó (Se comporta como u parámetro de entrada/salida)
- **Ámbito/Scope**: Lugar donde una variable habita y puede ser utilizada.
- **Pila de llamada**: Es la apilación de llamadas/invocaciones

# Arreglos

> Estructura que nos permite asociarle a una variable un conjunto de valores finitos que son siempre del mismo tipo.

Un array o arreglo es un conjunto finito y ordenado de elementos homogéneos.

Un arreglo es una estructura que permite guardar múltiples valores de un mismo tipo.

Los arreglos pueden tener múltiples dimensiones, aunque en la práctica se utilizan comúnmente en una o dos dimensiones. En este contexto, se les denomina **vectores o matrices**, según corresponda.

> [!NOTE]
> Los arreglos, una vez se define el tamaño que va a tener el vector no se puede redimensionar (son estáticos). Y todos los valores son del mismo tipo.

## Vectores

> Se representa gráficamente como una única fila con N columnas.

Consiste en una secuencia de elementos, dispuestos uno detrás del otro, y posee las siguientes características:

- Se identifica por un único nombre de variable.
- Sus elementos se almacenan en posiciones dentro del vector, cada una asociada a un subíndice.
- Se puede acceder a cada uno de sus elementos mediante su subíndice, ya sea de manera ordenada o aleatoria.
- Su tamaño es finito, lo que implica que una vez que se define, no puede cambiar.

![arreglo](https://github.com/melodiaz23/notas-backend-con-java/blob/master/images/20240910124048.png?raw=true)

> **Elemento**: Cada uno de los vectores que puede guardar un vector.
> **Índice/Subíndice**: Permite leer cada uno de los elementos del vector.

Un vector se representa como una única fila por N columnas. Donde N es el tamaño del vector.

Para declarar un vector en PSInt:

```c
Dimension nombre_variable(tamaño)
Definir nombre_variable tipo
```

## Matrices

Tenemos un índice para identificar las filas y un indice para identificar las columnas.

Una matriz puede concebirse como **una colección de vectores organizados en filas y columnas**. Está compuesta por elementos del mismo tipo, donde el orden de dichos elementos es crucial y se requiere la especificación de dos subíndices para identificar cada elemento en la estructura.

Matriz unidimensional = Se compone una sola columna de datos.
Matriz bidimensional = Se compone de filas y columnas.

![matriz](https://github.com/melodiaz23/notas-backend-con-java/blob/master/images/20240912092725.png?raw=true)

> En la notación estándar, generalmente el primer subíndice indica la fila del arreglo, mientras que el segundo subíndice denota la columna.

![sintaxis-matriz](https://github.com/melodiaz23/notas-backend-con-java/blob/master/images/20240912092759.png?raw=true)

---

En los arreglos multidimensionales el **tamaño** se calcula multiplicando la cardinalidad de cada dimensión.

**Cardinalidad**: Indica el largo de los índices/dimensiones del arreglo (cantidad de filas y columnas).

Ejemplo:

X[2,3] -> La primer dimensión tiene una **cardinalidad** 2 y la segunda tiene una cardinalidad de 3.

Tamaño = 2 x 3 = **6**

En este caso la matriz puede almacenar 6 elementos.

---

Para recorrer los elementos de una matriz se necesitará un bucle por cada dimensión, lo que permitirá recorrer todos los elementos.

![actividad-psint](https://github.com/melodiaz23/notas-backend-con-java/blob/master/images/20240912130110.png?raw=true)

> [!NOTE]
> La **dimensión** de un arreglo se puede determinar por la cantidad de índices necesarios para acceder a un elemento del arreglo.

# Métodos de ordenamiento

## Ordenamiento de Burbuja

Funciona revisando cada elemento de la lista que va a ser ordenada con el siguiente, intercambiándolos de posición si están en el orden equivocado. Es necesario revisar varias veces toda la lista hasta que no se necesiten más intercambios, lo cual significa que la lista está ordenada

```c
Proceso burbuja
	Dimension vector[20];
	Definir vector Como Entero;
	Definir i,j,k,aux Como Entero;
	Escribir "ordenar los numeros de un vector de forma ascendente.";
	Para i<-0 Hasta 19 Con Paso 1 Hacer
		Escribir "ingrese el siguiente numero: ";
		Leer vector[i];
	FinPara
	Para j<-1 Hasta 19 Hacer
		Para k<-0 Hasta 19-j Hacer
			Si vector[k] > vector[k+1] Entonces
				aux <- vector[k];
				vector[k]<-vector[k+1];
				vector[k+1]<-aux;
			FinSi
		FinPara
	FinPara
	Para i<-0 hasta 19 Hacer
		Escribir "posicion ",i," es: ",vector[i];
	FinPara
FinProceso

```

## Método de selección

El algoritmo de ordenación por selección procede encontrando el mayor elemento del vector e intercambiando su posición con el último elemento.

```c
Proceso seleccion2
	Dimension vector[10];
	Definir vector Como Entero;
	Definir i, c, aux, min Como Entero;

	Escribir "Ordenar los números de un vector.";
	Para i <- 0 Hasta 9 Hacer
		Escribir "Ingrese el siguiente número: ";
		Leer vector[i];
	FinPara

	// Comparaciones posibles son n-1, que serían 9. Por lo que se itera desde la posición 0 hasta la 8.
	Para i <- 0 Hasta 8 Hacer
		min <- i;
		Para c <- i+1 Hasta 9 Hacer
			Si vector[min] > vector[c] Entonces
				min <- c; // Se le asigna la posición de C, que sería la posición del número más pequeño, hasta ese momento.
			FinSi
		FinPara
		aux <- vector[i];
		vector[i] <- vector[min];
		vector[min] <- aux;
	FinPara

	Para i <- 0 Hasta 9 Hacer
		Escribir "Posición ", i, " es: ", vector[i];
	FinPara
FinProceso

```

## Ordenamiento por inserción

Inicialmente se tiene un solo elemento, que obviamente es un conjunto ordenado. Después, cuando hay k elementos ordenados de menor a mayor, se toma el elemento k+1 y se compara con todos los elementos ya ordenados, deteniéndose cuando se encuentra un elemento menor.

```c
Proceso porInsercion
	Dimension vector[10];
	Definir vector Como Entero;
	Definir i, j, aux Como Enteros;

	Escribir "Ordenar los números de un vector.";

	Para i <- 0 Hasta 9 Con Paso 1 Hacer
		Escribir "Ingrese el siguiente número: ";
		Leer vector[i];
	FinPara

	// Ordenamiento por inserción
	Para i <- 0 Hasta 9 Con Paso 1 Hacer
		aux <- vector[i]; // El valor del elemento actual.
		j <- i - 1; // j es el índice del elemento inmediatamente anterior a i.
		Mientras (j >= 0) Y (vector[j] > aux) Hacer
			vector[j + 1] <- vector[j];
			j <- j - 1;
		FinMientras

		vector[j + 1] <- aux;
	FinPara

	Para i <- 0 Hasta 9 Hacer
		Escribir "Posición ", i, " es: ", vector[i];
	FinPara
FinProceso
```

# Control de versiones: GIT

Git es un **sistema de control de versiones** que permite realizar un seguimiento
de los cambios en el código fuente u otros archivos de texto.

El sistema de control de Git está estructurado en tres áreas clave:

- Working Directory (Directorio de trabajo),
- Staging Area (Área de Preparación)
- “Local” Repository (Repositorio local).

![git areas](https://github.com/melodiaz23/notas-backend-con-java/blob/master/images/git-areas.png?raw=true)

## Git workflow

Es un conjunto de prácticas recomendadas para trabajar de manera eficiente y productiva. Este flujo define cómo añadir, probar y fusionar nuevas funcionalidades de forma que se eviten
conflictos y problemas.

Un buen flujo de trabajo ofrece:

- Facilidad para deshacer cambios y corregir errores.
- Escalabilidad, adaptándose tanto a equipos pequeños como grandes.
- Claridad y simplicidad, permitiendo que todo el equipo trabaje de manera coherente.

![git workflow](https://github.com/melodiaz23/notas-backend-con-java/blob/master/images/ramas_de_trabajo_git.png?raw=true)

## ¿Que es GitHub?

GitHub es una plataforma en línea donde se pueden guardar y manejar los proyectos de software.

GitHub proporciona una serie de herramientas y características adicionales que mejoran el flujo de trabajo, tales como:

- Reportar y seguir problemas.
- Revisar cambios.
- Automatizar tareas.
- Wiki y Páginas de GitHub.

Las características más relevantes son:

- Creación de repositorios
- Utiliza Git para el control de versiones.
- Facilita la colaboración en proyectos.
- Se pueden hacer `pull requests` (PR) para sugerir cambios a un repositorio.
- Los colaboradores de un proyecto pueden revisar los cambios de la PR.
- Proporciona herramientas para el seguimiento de problemas y tareas.
- Es conocido por ser un centro para proyectos de código abierto.

## ¿Qué es una pull request?

Es una solicitud para integrar cambios (commits) de una rama de desarrollo a otra, comúnmente de una rama de un fork o de una rama secundaria a la rama principal o main.

### Proceso para subir cambios de una rama

1. Crear una nueva rama
2. Realizar cambios y commits en la rama
3. Asegurarse de que la rama local esté actualizada con la rama principal.
4. Subir los cambios a Github
5. Crear una PR hacia el repositorio o rama objetiva.
6. Revisión por el equipo
7. Hacer merge en la rama principal o de desarrollo.

IDEA ejercicio.

1. Crear un proyecto.
2. Cada uno le hace fork
3. Cada uno crea una rama
4. Hace cambios y los sube
5. Hacer PR al repositorio principal.

## Definiciones Claves

**Repositorio:** Es un espacio centralizado donde se almacena, organiza y mantiene la información.

**Commit:** Capturas instantáneas de los archivos en momentos específicos.

**Markdown:** Es un lenguaje de marcado ligero diseñado para facilitar la lectura y escritura.

**README.md:** Es la primera página de documentación del proyecto. Sirve para:

- Describir el proyecto.
- Instrucciones de instalación.
- Uso y ejemplos.
- Enlaces a documentación adicional.
- Información para contribuyentes.
- Licencia.
- Contacto y reconocimientos.
- Badges

**HEAD:** Commit más reciente en la rama activa

**Ramas:** Permiten crear "caminos paralelos" para experimentar, desarrollar nuevas características o solucionar errores sin alterar la rama principal.

**origin:** Es un alias que apunta a la URL del repositorio remoto donde está almacenado el proyecto.

## Comandos

`git init` -> Inicializa un nuevo repositorio (proyecto) y si ya existe, se reinicia.

`git status` -> Muestra los archivos que han cambiado desde el último commit y los cambios preparados para el próximo commit.

`git add .` -> Mueve todos los archivos del working area al staging area.

`git add [nombre_del_archivo]` -> Agrega un archivo específico

`git commit -m [mensaje_descriptivo]` -> Toma los cambios del staging area y los añade al local repository

`git log` -> Permite ver el historial de commits.

`git log --oneline` -> Lista condensada con cada commit en una sola línea.

`git log --graph` -> Representación de las ramificaciones y fusiones en el historial de commits.

`touch <nombre_del_archivo>` -> Crea un nuevo archivo con el nombre especificado.

### Para configurar GIT

La configuración inicial consiste en establecer nombre de usuario y dirección de correo:

```bash
git config --global user.name [user]
git config --global user.email [user@mail.com]
```

Para verificar el nombre de usuario y el correo configurado:

```bash
git config --global user.name
git config --global user.email
```

Marco de colores para los comandos:

```shell
git config --global color.ui true
```

### Iniciando repositorio

Inicializa un nuevo repositorio (proyecto) y si ya existe, se reinicia.

```Shell
git init
```

Clona el repositorio de GitHub o BitBucket

```sh
git clone <url>
```

#### `git add`

Mueve todos los archivos del working area al staging area:

```sh
git add .
```

Agrega un archivo específico:

```sh
git add <nombre_del_archivo>
```

Añade todos los archivos nuevos, modificados y **eliminados**

```sh
git add --all
```

Añade todos los archivos con una extensión específica:

```sh
git add *.txt
```

Añade todos los archivos dentro de un directorio:

```sh
git add docs/
```

Añade todos los archivos de una extensión específica dentro de un directorio:

```sh
git add docs/*.txt
```

#### `git rm`

Borra un archivo del repositorio y lo prepara para el próximo commit:

```sh
git rm <archivo>
```

> Para este caso no se usaría `git add`

#### `git commit`

Toma los cambios del staging area y los añade al local repository:

```sh
git commit -m "[mensaje_descriptivo]"
```

Agrega y carga en el HEAD los cambios realizados, en lugar de hacer `git add <archivo>` y luego `git commit`:

```sh
git commit -a -m "[mensaje_descriptivo]"
```

> `-a`: Indica que Git debe incluir todos los archivos que han sido modificados y rastreados (No incluye archivos nuevos que no han sido rastreados).

Modifica el último commit:

```sh
git commit --amend -m "[mensaje_descriptivo]"
```

> Remplaza el último commit con un nuevo commit que incluye todos los cambios que ya estaban en el commit original, más cualquier cambio adicional que se haya añadido

Quita del HEAD un archivo y le pone el estado `untracked`:

```sh
git checkout -- <file>
# También se puede usar:
# git restore --staged <file>
```

#### `git log`

Permite ver el historial de commits:

```sh
git log
```

Lista condensada con cada commit en una sola línea.

```sh
git log --oneline
```

Representación de las ramificaciones y fusiones en el historial de commits.

```sh
git log --oneline --graph
```

### Para trabajar con ramas

Lista todas las ramas locales del repositorio local actual:

```Sh
git branch
```

Crear una nueva rama local:

```sh
git branch <nombre_de_la_rama>
```

Elimina localmente la rama indicada **solo** si ha sido fusionada con la rama actual:

```sh
git branch -d <nombre_de_la_rama>
```

Elimina localmente la rama sin verificar si ha sido fusionada con la rama actual:

```sh
git branch -D <nombre_de_la_rama>
```

Cambia de rama:

```sh
git checkout <nombre_de_la_rama>
# Más reciente:
git switch <nombre_de_la_rama>
```

Crea una nueva rama y cambia a ella inmediatamente:

```sh
git checkout -b <nombre_de_la_rama>
```

Crea un rama en base a una branch del repositorio remoto:

```sh
git switch -c <nuevo_nombre_de_la_rama> origin/branch-name
# Antes git checkout -b
```

### Para trabajar con el repositorio remoto

Clona un repositorio desde GitHub u otro servicio de alojamiento de Git:

```sh
git clone <url>
```

Clona un repositorio y le da un nombre específico al directorio clonado:

```sh
git clone <url> git-demo
```

Vincula un repositorio local con un repositorio remoto:

```Shell
git remote add origin <url>:
```

> `origin` es un nombre convencional que se da al repositorio remoto principal.

#### `git push`

Envía los cambios locales de la rama al repositorio remoto en la rama especificada:

```Sh
git push origin <nombre_de_la_rama>
```

> Si la rama remota no existe, el comando **creará** una nueva rama remota con el nombre especificado.

Sube los cambios al repositorio remoto y establece una rama de seguimiento upstream para la rama local actual:

```Sh
git push -u origin <nombre_de_la_rama>
```

> De este modo no se necesitará especificar el nombre del repositorio remoto y la rama, ya que quedará por defecto.

#### `git fetch`

Descarga los cambios del repositorio remoto pero no los fusiona en la rama.

```Sh
git fetch
```

> Se puede revisar los cambios antes de decidir integrarlos en la rama de trabajo local.

#### `git merge`

Une el branch actual con el especificado:

```sh
git merge <nombre_de_la_rama>
```

> Si no hay conflictos, Git realiza la fusión automáticamente. Si hay conflictos, se debe resolver manualmente para completar la fusión.

#### `git pull`

Trae los cambios de otra rama, y los fusiona con la rama actual:

```Sh
git pull origin <nombre_de_la_rama>
# Para asegurar que los cambios estén sincronizados con los últimos cambios en main:
git pull origin main
```

> [!NOTE]
> **En Visual Studio Code:**
>
> - Accept Current Change: para aceptar la versión del repositorio local como la versión correcta y más actual.
> - Accept Incoming Change: para aceptar la versión que viene del repositorio remoto como la versión correcta y más actual.
> - Accept Both Changes: para aceptar ambos cambios.
> - Compare Changes: para comparar los campos.

---

Cuando deseamos **integrar una rama con otra** podemos hacer pull desde la rama que vamos a integrar. Por ejemplo si vamos a hacer pull de "languages", hacia develop debemos:

```Sh
# 1.Cambiar a la rama de comparación
git checkout languages
# 2. Traer los cambios desde el repositorio remoto de la rama a la que le vamos a hacer PR
git pull origin develop
# 3. Resolver conflictos
# 4. Adicionar los cambios
git add <nombre_del_archivo>
# 5. Hacer commit
git commit -m [mensaje]
# 6. Enviar los cambios al repositorio remoto
git push origin languages
# 7. Desde GitHub hacer PR e integrar los cambios
# 8. Moverse a la rama develop y hacer pull para traer los cambios al repositorio local
git pull origin develop

```

#### `git remote`

Muestra la lista de los repositorios remotos a los que se le está haciendo fetch y push:

```sh
git remote -v
```

Cambia la URL del repositorio remoto asociado al nombre `origin`:

```sh
git remote set-url origin <url>
```

### Otros Comandos

#### `git reset`

Saca un archivo del commit:

```sh
git reset HEAD <archivo>
```

> El archivo queda en estado unstaged.

Devuelve el último commit que se hizo y pone los cambios en staging:

```sh
git reset --soft HEAD^
```

Devuelve el último commit, restableciendo los archivos al estado de ese commit anterior:

```sh
git reset --hard HEAD^
```

Devuelve los 2 últimos commits y todos los cambios al estado del commit anterior:

```sh
git reset --hard HEAD^^
```

Restablece el estado del repositorio al commit especificado:

```sh
git log
git reset --hard <commit_sha>
```

> Todos los cambios que se hicieron en los commits posteriores al commit seleccionado se eliminarán.

#### `git rebase`

Une el branch actual con el master:

```sh
git rebase
```

> `git rebase` altera el historial de commits.

Continúa la secuencia del rebase donde se pausó (si hay conflicto):

```sh
git rebase --continue
```

Omite el conflicto y sigue adelante:

```sh
git rebase --skip
```

Devuelve todo al principio del rebase:

```sh
git rebase --abort
```

Hace un rebase a un branch específico:

```sh
git rebase <nameBranch>
```
