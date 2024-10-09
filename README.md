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

---

# Servicios Backend

Un programador backend es responsable de recibir, procesar y almacenar datos en una base de datos. También puede buscar y entregar esos datos en el formato solicitado por el cliente.

![backend](https://github.com/melodiaz23/notas-backend-con-java/blob/master/images/servicios_backend.png?raw=true)

# JAVA

Java es un lenguaje de programación que fue diseñado bajo el paradigma **orientado a objetos**, lo que permite:

- Modelar y representar objetos del mundo real de manera eficiente en código.
- Organizar y estructurar el código de manera lógica y comprensible.
- Reutilizar código de manera efectiva.

## Entorno Java

![entorno java](https://github.com/melodiaz23/notas-backend-con-java/blob/master/images/entorno-java.png?raw=true)

- **JDK (Java Development Kit):** Herramientas para desarrollar, compilar y depurar aplicaciones Java, incluyendo el compilador (Javac) y el JRE.
- **Javac:** Compilador de Java que convierte el código fuente en bytecode para ser ejecutado por la JVM.
- **JRE (Java Runtime Environment):** Entorno de ejecución que incluye la JVM y las bibliotecas necesarias para ejecutar aplicaciones Java.
- **Java SE (Java Standard Edition):** Conjunto de clases y APIs básicas para el desarrollo de aplicaciones Java.
- **JVM (Java Virtual Machine):** Máquina virtual que ejecuta el código Java, permitiendo un entorno independiente de la plataforma.
- **GC (Garbage Collector):** Gestor automático de memoria que elimina objetos no utilizados para evitar fugas de memoria y mejorar la eficiencia.

## Primeros pasos

- En Java para ejecutar código usamos un método especial que se llama `main`. Si no existe el método main, no se ejecuta nada.
- Para el nombre de la clase se usa `PascalCase`

```java
public class MiPrimerPrograma {
  public static void main(String[] args) {
    // Lo primero que se ejecuta es lo que está dentro de este bloque
    System.out.println("Hola Mundo");
  }
}
```

- `System.out.println();` -> Imprime en consola.
- `System` -> Es una clase que representa al sistema
- `out` -> Es otro objeto y es un atributo de la clase System que representa una salida del sistema.
- `println` -> Es un método, imprime en una nueva línea en la consola.
- `print` -> Imprime en la misma línea.

> [!NOTE]
> Al programar en Java, es crucial asignar y almacenar los datos en variables del tipo correcto para garantizar un funcionamiento adecuado.

Para declarar una variable en Java:

```Java
int miVariable = 10;
```

- `int` -> tipo de dato.
- `=` -> Operador de asignación.
- `;` -> Fin de la sentencia.

### Diferencia entre declarar e inicializar

Para **declarar** una variable en Java, primero se especifica el tipo de dato que va a contener y luego asignarle un nombre.

```Java
int numero1;
```

Para **inicializar** una variable se usa el operador de asignación y se proporciona un valor que sea compatible con el tipo de dato declarado.

```Java
numero1 = 17;
```

También es posible combinar la declaración e inicialización en una misma línea.

```Java
int numero1 = 17;
```

## Variables Vs. Constantes

- Una **constante** es un dato al que se le asigna un valor una sola vez y no puede ser modificado posteriormente.
- Una vez que una constante está inicializada, su valor es inalterable.
- Para declarar una constante en Java, se utiliza la palabra reservada final y se inicializa en la misma sentencia.

```Java
final int NUMERO_15 = 15;
```

- Al declarar una constante debemos _inicializarla de inmediato_.
- Las variables se escriben en `camelCase`.
- Las constantes se escriben en `UPPER_CASE.`.

## Tipos de datos

![tipos de datos](https://github.com/melodiaz23/notas-backend-con-java/blob/master/images/tipos_de_datos.png?raw=true)

### Datos primitivos

- Se caracterizan por poder almacenar un único valor.
- La mayor parte de los tipos estructurados o complejos son composiciones a partir de datos primitivos.
- Los datos primitivos (8), sirven para gestionar los tipos de información más básicos como números o booleanos.

#### Numéricos

6 de los datos primitivos, están destinados a facilitar el trabajo con números, se pueden agrupar en dos categorías:

- **Enteros (4):** Permiten operar exclusivamente con números enteros, sin parte decimal.
- **Numéricos en punto flotante (2):** Contempla números racionales o con parte decimal.

##### Tipos numéricos enteros

1. **byte:** Emplea un sólo byte
   _Tamaño:_ 1 byte (8 bits).
   _Rango:_ [-128, 127].

2. **short:** Usa el doble de almacenamiento que el anterior.
   _Tamaño:_ 2 bytes (16 bits).
   _Rango:_ [-32.768, 32.767].

3. **int:** Es el tipo de dato entero más empleado.
   _Tamaño:_ 4 bytes (32 bits).
   _Rango:_ [-2.147.483.648, 2.147.483.647] (o -2^31 a 2^31-1).

4. **long:** Tipo de entero de mayor tamaño.
   _Tamaño:_ 8 bytes (64 bits).
   _Rango:_ [-9.223.372.036.854.775.808, 9.223.372.036.854.775.807] (o -2^63 a 2^63-1).

##### Tipos numéricos decimales

Permiten representar números tanto muy grandes como muy pequeños, además de números decimales.

1. **float:** Conocido como tipo de precisión simple. Soporta hasta 7 números después de la coma.

   - _Tamaño:_ 4 bytes (32 bits).

2. **double:** Utiliza un esquema de almacenamiento similar al `float`, pero con mayor capacidad. Soporta 15 números después de la coma
   - _Tamaño:_ 8 bytes (64 bits).

> [!NOTE]
> Mientras que _float_ podría ser adecuado para representar datos con una precisión de hasta dos dígitos decimales, el tipo _double_ ofrece una mayor precisión y un rango de valores más amplio, lo que puede resultar beneficioso en aplicaciones comerciales donde la exactitud de los datos desempeña un papel crucial.

#### Booleanos y caracteres

##### `boolean`

Facilita el trabajo con valores "verdadero/falso". El tipo de datos `boolean` Sólo acepta true o false,

```Java
boolean booleana = true;
boolean booleana = false;
```

##### `char`

- Se utiliza para almacenar caracteres individuales.
- Aunque se considera un tipo numérico, su representación habitual es el carácter cuyo código almacena.
- Utiliza la codificación _UTF-16_ de Unicode.
- Debe estar rodeado de comillas simples

```Java
char caracter = 'a';
```

### Estructurados

- Después de los primitivos, todos los demás tipos de datos son objetos, también llamados tipos estructurados o _"Clases"_.
- Los objetos son instancias de las clases.
- Se denominan estructurados por que su mayor parte están destinados a contener múltiples valores.
- Pueden contener valores de tipo primitivo o de tipo objeto.

#### Cadenas de caracteres

Se declara como:

```Java
String nombreCurso = "Iniciación a Java";
```

- **Las cadenas en Java son un objeto** de la clase String, aunque se declaren de este modo.
- Las cadenas de caracteres se delimitan entre comillas dobles, en lugar de simples como los caracteres individuales.
- Las cadenas, son objetos que disponen de métodos que permiten operar sobre la información almacenada en dicha cadena.

#### Arrays

- Son colecciones de datos de un mismo tipo.
- Es una estructura de datos en la que a cada elemento le corresponde una posición identificada por uno o más índices numéricos enteros.
- Es habitual llamar vectores a los arrays de una dimensión y matrices a los arrays que trabajan con dos dimensiones.
- Los elementos de un array se empiezan a numerar en el 0.

#### Tipos definidos por el usuario

En Java, existen muchas clases estructuradas creadas por la plataforma o terceros que permiten realizar diversas operaciones. Además, los usuarios pueden crear sus propias clases para tareas específicas, lo que se conoce como **tipos estructurados definidos por el usuario**.

### Envoltorio (Wrapper)

- Java cuenta con tipos de datos **envoltorio** para cada tipo primitivo.
- Estos tipos añaden métodos y propiedades útiles a los primitivos.
- Facilitan el uso de datos por **referencia** en lugar de por valor.
- Los tipos envoltorio son:
  - `Byte`
  - `Short`
  - `Integer`
  - `Long`
  - `Float`
  - `Double`
  - `Boolean`
  - `Character`

## Clases

Una clase se puede visualizar como un plano o una plantilla que define las características y comportamientos de un objeto.

Al crear una **instancia** de una clase, se crea un objeto específico basado en esa plantilla.

Las clases `System` están en un paquete que se descarga por defecto.

### Clase Scanner

- La clase Scanner es utilizada en Java para obtener la entrada del usuario desde la consola.
- La clase Scanner nos permite solicitar datos al usuario y detener la ejecución del programa hasta que se ingrese la información requerida.

Para usar la clase `Scanner`, se debe:

```Java
// 1. Importarla
import java.util.Scanner;
// 2. Crear una instancia
Scanner miScanner = new Scanner(System.in);
```

`System.in` -> Permite la entrada de datos.

_Una vez que se tiene una instancia de Scanner, se pueden utilizar sus métodos para leer los datos ingresados por el usuario._ Algunos de ellos son:

- `nextBoolean()`: Lee un valor booleano (`true` o `false`) desde la entrada.
- `nextInt()`: Lee un número entero desde la entrada.
- `nextDouble()`: Lee un número de tipo `double` desde la entrada.
- `nextLine()`: Lee una línea completa de texto desde la entrada.
- `next()` : Lee hasta el primer espacio.

Ejemplo:

```Java
Scanner miScanner = new Scanner(System.in);
System.out.print("Ingresa un número entero: ");
int numero = miScanner.nextInt();
System.out.println("El número ingresado es: " + numero);
```

La clase `Scanner` puede aceptar varios tipos de argumentos dependiendo de la fuente de datos que se quiera leer:

1. **`System.in`**: Para leer desde la entrada estándar (teclado).

   ```java
   Scanner miScanner = new Scanner(System.in);
   ```

2. **`File`**: Para leer desde un archivo.

   ```java
   File file = new File("ruta/del/archivo.txt");
   Scanner miScanner = new Scanner(file);
   ```

3. **`String`**: Para leer desde una cadena de texto.
   ```java
   String data = "texto de ejemplo";
   Scanner miScanner = new Scanner(data);
   ```

> [!NOTE]
> Es importante tener en cuenta que al utilizar la clase Scanner, es una buena práctica cerrar el objeto Scanner una vez que ya no se necesita. Esto se hace mediante la llamada al método `close()` del objeto Scanner.
>
> En el ejemplo sería: `miScanner.close();`
>
> La llamada a `close()` asegura que los recursos asociados con el objeto Scanner sean liberados adecuadamente, lo que contribuye a un mejor manejo de recursos y previene problemas de rendimiento en el programa.

## Operadores en Java

Los operadores en Java son símbolos especiales que se utilizan para realizar operaciones en variables y valores.

### Operadores Aritméticos

Son símbolos especiales utilizados para realizar operaciones matemáticas en variables. Incluyen:

| Operador            | Descripción                         | Ejemplo |
| ------------------- | ----------------------------------- | ------- |
| Adición (+)         | Suma dos valores.                   | `a + b` |
| Sustracción (-)     | Resta un valor de otro.             | `a - b` |
| Multiplicación (\*) | Multiplica dos valores.             | `a * b` |
| División (/)        | Divide un valor por otro.           | `a / b` |
| Módulo (%)          | Obtiene el residuo de una división. | `a % b` |

### Operadores de Asignación

Se utilizan para asignar un valor a una variable, combinando la asignación con una operación aritmética o de bits. Los más comunes son:

| Operador                          | Descripción                               | Ejemplo  |
| --------------------------------- | ----------------------------------------- | -------- |
| Asignación (=)                    | Asigna un valor a una variable.           | `a = b`  |
| Suma y asignación (+=)            | Suma y luego asigna el valor.             | `a += b` |
| Resta y asignación (-=)           | Resta y luego asigna el valor.            | `a -= b` |
| Multiplicación y asignación (\*=) | Multiplica y luego asigna el valor.       | `a *= b` |
| División y asignación (/=)        | Divide y luego asigna el valor.           | `a /= b` |
| Módulo y asignación (%=)          | Aplica el módulo y luego asigna el valor. | `a %= b` |

Ejemplo:

```Java
// Asignación simple
a = b;
// Suma y asignación
a += b;      // a = a + b
// Resta y asignación
a -= b;      // a = a - b
// ...

```

### Operadores de Incremento y Decremento

Se utilizan para aumentar o disminuir el valor de una variable en una unidad.

| Operador | Descripción                             | Ejemplo       |
| -------- | --------------------------------------- | ------------- |
| `++`     | Aumenta el valor de una variable en 1   | `a++` o `++a` |
| `--`     | Disminuye el valor de una variable en 1 | `a--` o `--a` |

### Operadores Relacionales o de Comparación

Se utilizan para comparar dos valores y producir un resultado booleano que indica si la comparación es verdadera o falsa.

| Operador               | Descripción                                     | Ejemplo  |
| ---------------------- | ----------------------------------------------- | -------- |
| Igual a (==)           | Verifica si dos valores son iguales.            | `a == b` |
| No igual a (!=)        | Verifica si dos valores no son iguales.         | `a != b` |
| Mayor que (>)          | Verifica si un valor es mayor que otro.         | `a > b`  |
| Menor que (<)          | Verifica si un valor es menor que otro.         | `a < b`  |
| Mayor o igual que (>=) | Verifica si un valor es mayor o igual que otro. | `a >= b` |
| Menor o igual que (<=) | Verifica si un valor es menor o igual que otro. | `a <= b` |

### Operadores Lógicos

Se utilizan para combinar expresiones booleanas y producir un resultado booleano basado en ellas.

| Operador         | Descripción                                                        | Ejemplo |
| ---------------- | ------------------------------------------------------------------ | ------- |
| AND lógico (&&)  | Devuelve verdadero si ambos operandos son verdaderos.              | a && b  |
| OR lógico (\|\|) | Devuelve verdadero si al menos uno de los operadores es verdadero. | a\|\|b  |
| NOT lógico (!)   | Invierte el valor de verdad del operando.                          | !a      |

### Operador Condicional (Operador Ternario)

Es una expresión condicional que permite tomar decisiones basadas en una condición.

Es una forma concisa y eficiente de escribir expresiones condicionales simples en Java.

| Operador | Descripción                                                         | Ejemplo         |
| -------- | ------------------------------------------------------------------- | --------------- |
| `? :`    | `a > b ? a : b` (si a es mayor que b, devuelve a, sino devuelve b). | `a > b ? a : b` |

### Operadores de Bit

Son utilizados para realizar operaciones a nivel de bits en los valores enteros. Estos operadores manipulan los bits individuales de los operandos.

| Operador                                      | Descripción                                                                          | Ejemplo   |
| --------------------------------------------- | ------------------------------------------------------------------------------------ | --------- |
| AND binario (`&`)                             | Realiza una operación AND en cada par de bits.                                       | `a & b`   |
| OR binario (\|)                               | Realiza una operación OR en cada par de bits.                                        | a \| b    |
| OR binario (`^`)                              | Realiza una operación OR en cada par de bits.                                        | `a ^ b`   |
| Complemento binario (`~`)                     | Invierte todos los bits.                                                             | `~a`      |
| Desplazamiento a la izquierda (`<<`)          | Desplaza los bits a la izquierda, rellena con ceros a la derecha.                    | `a << 2`  |
| Desplazamiento a la derecha (`>>`)            | Desplaza los bits a la derecha, rellena con el bit más significativo a la izquierda. | `a >> 2`  |
| Desplazamiento a la derecha sin signo (`>>>`) | Desplaza los bits a la derecha, rellena con ceros a la izquierda.                    | `a >>> 2` |

## Definiciones claves

**IDE:** Integrated development environment. Es el entorno de desarrollo

**Compilación:** Es un proceso en el que el código fuente escrito en lenguaje Java se traduce a un lenguaje que la computadora pueda entender y ejecutar.

**Programa:** Es una serie de instrucciones escritas que una computadora puede ejecutar para procesar datos y producir un resultado.

**Sentencias:** Son unidades mínimas de ejecución en un programa y se componen de reglas gramaticales conocidas como sintaxis.

**Sintaxis:** define cómo se deben combinar las palabras, los símbolos y los elementos gramaticales para formar instrucciones y expresiones válidas.

**Clase:** Es una de las unidades básicas más importantes de JAVA como lenguaje de tipo orientado a objeto. Dentro de ella se colocan datos y código del programa que vamos a empezar a codificar.

**Paquetes:** Nos permite organizar los programas java y empaquetar muchos programas con un mismo fin.

## Estructuras de Control

Son mecanismos que permiten controlar
el flujo de ejecución de un programa.

También permiten manejar excepciones y controlar situaciones inesperadas durante la ejecución
del programa.

### `if`

El `if` es una estructura de control condicional que nos permite ejecutar un
bloque de código si se cumple una condición determinada.

```Java
public static void main(String[] args){
	// Sentencias que se ejecutan antes del if
	if (condicion){
	// Sentencias que se ejecutan si la condición es verdadera
	}
	// Sentencias que se ejecutan después del "if"
}
```

## `if`-`else`

Permite ejecutar un bloque de código si se cumple una condición determinada, y otro bloque  
código si la condición no se cumple.

```Java
public static void main(String[] args){
	// Sentencias que se ejecutan antes del if else
	if (condicion){
	// Sentencias que se ejecutan si la condición es verdadera
	} else {
	// Sentencias que se ejecutan si la condición es falsa.
	}

	// Sentencias que se ejecutan después del "if"
}
```

## `if`-`else`-`if`

permite ejecutar un bloque de código si se cumple una condición determinada y otro bloque de
código sólo si se cumple otra condición.

```Java
public static void main(String[] args){
	// Sentencias que se ejecutan antes del if else if
	if (condicion1){
	// Sentencias que se ejecutan si la condición es verdadera
	} else if (condicion2){
	// Sentencias que se ejecutan si la condición1 es falsa y la condicion2 es verdadera.
	}

	// Sentencias que se ejecutan después del "if"
}
```

> Después de la llave de cierre del bloque "else if (`condicion2`)", podemos agregar otro bloque "else" o "else if (`condicion`)" tantas veces como queramos.

## `switch`

Permite seleccionar uno de varios bloques de código para ejecutar, dependiendo del valor de una expresión o variable.

La expresión dentro del switch se evalúa y se compara con los casos definidos dentro de él. Cada caso representa una opción diferente, y se ejecutará el bloque de código correspondiente si el valor de la expresión coincide con el caso.

```java
public static void main(String[] args) {
//Sentencias que se ejecutan antes del "switch".
	switch (opcion) {
		case 1:
		case 2:
			//Sentencias que se ejecutan si "opción" tiene el "valor 1 o 2".
			System.out.println("Seleccionaste la opción 1 o 2");
			break;
		case 3:
			//Sentencias que se ejecutan si "opción" tiene el "valor 3".
			System.out.println("Seleccionaste la opción 3");
			break;
		default:
			//Sentencias que se ejecutan si "opción" no coincide con el
			valor de ningún "case".
			System.out.println("Opción inválida");
			break;
	}
//Sentencias que se ejecutan después del "switch".
}
```

> Sin el `break`, el código continua ejecutando los casos siguientes, incluso si no coinciden con el valor de la expresión.

### Jump statements

Java soporta tres sentencias de salto:

- **Break**:

  - Termina una secuencia en una declaración `switch`.
  - Sale de un bucle.

- **Continue**:

  - Fuerza una iteración anticipada de un bucle, saltando el resto del código y pasando a la siguiente.

- **Return**:
  - Termina explícitamente la ejecución de un método y, opcionalmente, devolviendo un valor.

### Switch expression

Otra forma mejorada de utilizar el switch introducida en Java 12. Permite evaluar diferentes tipos de datos, incluyendo
cadenas de texto (strings), y utilizar expresiones más complejas.

```java
public static void main(String[] args) {
    // Sentencias que se ejecutan antes del "switch".
    switch (opcion) {
      case 1 -> System.out.println("Seleccionaste la opción 1");
      case 2 -> System.out.println("Seleccionaste la opción 2");
      case 3 -> System.out.println("Seleccionaste la opción 3");
      default -> System.out.println("Opción inválida");
    }
    // Sentencias que se ejecutan después del "switch".
  }
```

> - Switch expressions no requieren el uso de la palabra `break`.
> - Si se requiere incluir varias líneas de código se utilizan llaves `{` `}`.

El switch como expresión es un nuevo enfoque que
permite que el switch funcione como una expresión.

Con el switch como expresión, podemos asignar directamente el resultado del switch a la variable, sin necesidad de declararla previamente:

```java
public static void main(String[] args) {
    String mes = "February";
    int numeroDeDias = switch (month) {
      case "February" -> 28;
      case "April", "June", "September", "November" -> 30;
      case "January", "March", "May", "July", "August", "October", "December" -> 31;
      default -> 0;
    };
    System.out.println(mes+" tiene "+numeroDeDias+" días.");
    }
```

#### `yield`

Al utilizar bloques de código en una expresión switch para manejar múltiples líneas de código, se emplea la palabra clave `yield` para indicar el valor de retorno del case.

```java
public static void main(String[] args) {
    String position = "director";
    boolean alcanzoObjetivos = true;
    double bonus = switch (position) {
      case "temporal" -> 50;
      case "empleado" -> 1000;
      case "director" -> {
        double bonusBase = 2000;
        double bonusPorRendimiento = alcanzoObjetivos ? 500 : 0;
        double bonusTotal = bonusBase + bonusPorRendimiento;
        yield bonusTotal;
        }
      default -> 0;
      };
      System.out.println("El bonus del "+position+" es $"+bonus);
    }
```

> [!NOTE]
> Si se conocen de antemano todos los valores que puede tomar una variable, es necesario tener un case correspondiente para cada uno de ellos. En caso de no conocer todos los posibles valores, es recomendable incluir una cláusula default para manejar cualquier valor no previsto.
