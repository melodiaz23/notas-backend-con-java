import java.util.Arrays;
import java.util.Scanner;

public class RegistroAlumnos {
  public static void main(String[] args) {
    System.out.println("\033\143"); // Limpia la consola

    try (Scanner scanner = new Scanner(System.in)) {

      boolean salir = false;
      String[] alumnos = { "Maria", "Jhon", "Andrea" };
      Double[] notas = { 3.0, 4.0, 5.0 };

      do {
        System.out.println("--------");
        System.out.println("MENÚ");
        System.out.println("1- Registrar Alumno");
        System.out.println("2- Mostrar todos los alumnos");
        System.out.println("3- Mostrar promedio de notas");
        System.out.println("4- Buscar alumno por nombre");
        System.out.println("5- Modificar nota por nombre");
        System.out.println("6- Eliminar alumno por nombre");
        System.out.println("7- Salir");
        System.out.println("--------");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (alumnos.length == 0 && opcion != 1) {
          System.out.println("No hay alumnos registrados");
          continue;
        }
        switch (opcion) {
          case 1 -> {
            String nombreAlumno = "";
            double notaAlumno;
            char agregarAlumno = ' ';
            while (agregarAlumno != 'n') {
              do {
                System.out.print("Ingrese nombre y apellido del alumno: ");
                nombreAlumno = scanner.nextLine();

                if (nombreAlumno.isEmpty())
                  System.out.println("El nombre del alumno no puede estar vacío.");

              } while (nombreAlumno.isEmpty());

              do {
                System.out.print("Ingrese la nota del alumno: ");
                notaAlumno = scanner.nextDouble();

                if (notaAlumno < 0.00 || notaAlumno > 10.0)
                  System.out.println("Nota no válida. Debe estar entre 0.0 y 10.0");

              } while (notaAlumno < 0.00 || notaAlumno > 10.0);
              scanner.nextLine();

              alumnos = Arrays.copyOf(alumnos, alumnos.length + 1);
              notas = Arrays.copyOf(notas, notas.length + 1);

              alumnos[alumnos.length - 1] = nombreAlumno;
              notas[notas.length - 1] = notaAlumno;

              do {
                System.out.print("Desea agregar otro alumno? (s/n): ");
                agregarAlumno = scanner.next().toUpperCase().charAt(0);

                if (agregarAlumno != 'S' && agregarAlumno != 'N')
                  System.out.println("Respuesta incorrecta. Debe elegir 's' (si) o 'n' (no).");

              } while (agregarAlumno != 'S' && agregarAlumno != 'N');
              scanner.nextLine();
            }
          }
          case 2 -> {
            System.out.println("Los alumnos son: ");
            for (int i = 0; i < alumnos.length; i++) {
              System.out.println(alumnos[i] + " | Nota: " + notas[i]);
            }

          }
          case 3 -> {
            double suma = 0;
            for (Double nota : notas) {
              suma += nota;
            }
            System.out.printf("El promedio es: %.2f \n", suma / notas.length);
          }
          case 4 -> {
            System.out.println("Ingrese el nombre que desea buscar");
            String nombreBusc = scanner.nextLine().toUpperCase();
            boolean nombreEsta = false;
            for (int i = 0; i < alumnos.length; i++) {
              if (alumnos[i].toUpperCase().contains(nombreBusc)) {
                System.out.println("El alumno es " + alumnos[i] + " y su nota es " + notas[i]);
                nombreEsta = true;
              }
            }
            if (!nombreEsta) {
              System.out.println("El alumno no existe");
            }
          }
          case 5 -> {
            System.out.println("Ingrese el nombre que desea buscar");
            String nombreBusc = scanner.nextLine().toUpperCase();
            boolean nombreEsta = false;
            for (int i = 0; i < alumnos.length; i++) {
              // Se usa contains en caso de que existan dos alumnos con el mismo nombre;
              if (alumnos[i].toUpperCase().contains(nombreBusc)) {
                nombreEsta = true;
                System.out.println("Deseas cambiar la nota para: " + alumnos[i] + "? s/n");
                char siNo = scanner.nextLine().toUpperCase().charAt(0);
                if (siNo == 'S') {
                  System.out.println("Indica la nueva nota: ");
                  notas[i] = scanner.nextDouble();
                }
              }
            }
            if (!nombreEsta) {
              System.out.println("El alumno no existe");
            } else {
              System.out.println("Listado con nuevas notas");
              for (int i = 0; i < alumnos.length; i++) {
                System.out.println(alumnos[i] + " | Nota: " + notas[i]);
              }
            }

          }
          case 6 -> {
            System.out.println("Ingrese el nombre que desea buscar");
            String nombreBusc = scanner.nextLine().toUpperCase();
            boolean nombreEsta = false;
            int elementoARemover = -1;
            for (int i = 0; i < alumnos.length; i++) {
              if (alumnos[i].toUpperCase().contains(nombreBusc)) {
                nombreEsta = true;
                System.out.println("Deseas eliminar a " + alumnos[i] + "? s/n");
                char siNo = scanner.nextLine().toUpperCase().charAt(0);
                if (siNo == 'S') {
                  elementoARemover = i;
                  break;
                }
              }
            }
            if (!nombreEsta) {
              System.out.println("El alumno no existe");
            } else if (elementoARemover != -1) {
              String[] nuevosAlumnos = new String[alumnos.length - 1];
              int j = 0;
              for (int i = 0; i < alumnos.length; i++) {
                if (i != elementoARemover) {
                  nuevosAlumnos[j] = alumnos[i];
                  j++;
                }
              }
              alumnos = nuevosAlumnos;
              System.out.println("El listado con los nuevos alumnos ");
              for (int i = 0; i < alumnos.length; i++) {
                System.out.println(alumnos[i] + " | Nota: " + notas[i]);
              }
            } else {
              System.out.println("No se ha eliminado ningún alumno");
            }

          }
          case 7 -> {
            salir = true;
          }
          default -> {
            System.out.println("Opción seleccionada es inválida, intenta nuevamente");
          }
        }
      } while (!salir);

    } catch (Exception e) {
      System.out.println(e);
    }

  }

}