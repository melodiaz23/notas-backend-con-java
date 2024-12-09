package sistemadeturnos;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
	static ArrayList<String> turnos = new ArrayList<>();
	public static void main(String[] args) {

int opcion;
	try(Scanner scanner = new Scanner(System.in)){
			int num = 0;
			do {
				menu();
				opcion = scanner.nextInt();
				scanner.nextLine();
				switch (opcion){
					case 1 -> {
						System.out.println("Nuevo  turno generado");
		        num++;
						turnos.add("T-" + num);
						imprimirTurnos();
					}
					case 2 -> {
						try {
						System.out.println("Llamando turno: " + turnos.getFirst());
						turnos.removeFirst();
						imprimirTurnos();
						} catch (NoSuchElementException e) {
							System.out.println("No existen turnos en espera.");
						}
					}
					case 3 -> {
						System.out.println("Indica el turno que deseas atender");
						String turnoAAtender = scanner.nextLine().toUpperCase();
						System.out.println(turnos.remove(turnoAAtender) ? "Turno ha sido llamado." : "Turno no existe, por favor, verifica.");
						imprimirTurnos();
					}
					case 4 -> {}
					default -> System.out.println("Opción inválida");
				}
			} while (opcion!=4);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void menu(){
		System.out.println("MENÚ DE TURNOS");
		System.out.println("1- Nuevo Cliente");
		System.out.println("2- Llamar siguiente");
		System.out.println("3- Llamar específico");
		System.out.println("4- Salir");
	}

	public static void imprimirTurnos(){
		System.out.println("TURNOS ACTUALES");
		System.out.println(turnos);
	}

}
