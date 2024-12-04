package listadeinvitados;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		RegistroDeInvitados invitados = new RegistroDeInvitados();
		int opcion;
		try(Scanner scanner = new Scanner(System.in)){
			do {
				menu();
				opcion = scanner.nextInt();
				scanner.nextLine();
				switch (opcion) {
					case 1 -> {
						System.out.println("¿Cual es el nombre del invitado a agregar?");
						String nombre = scanner.nextLine();
						invitados.agregarInvitado(nombre);
					}
					case 2 -> {
						System.out.println("Indica el nombre del invitado a remover");
						String nombre = scanner.nextLine();
						invitados.eliminarInvitado(nombre);
					}
					case 3 -> {
						invitados.mostrarInvitados();
					}
					case 4 -> {
					}
					default -> System.out.println("Opción inválida");
				}
			} while (opcion!=4);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void menu(){
		System.out.println("MENÚ INVITADOS");
		System.out.println("1- Agregar");
		System.out.println("2- Eliminar");
		System.out.println("3- Mostrar");
		System.out.println("4- Salir");
	}
}
