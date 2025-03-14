package ciudades;

import java.util.ArrayList;
import java.util.Scanner;

public class Ciudades {
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)){
			ArrayList<String> ciudades = new ArrayList<>();
			String ingresaCiudad;
			do {
			System.out.println("Indica el nombre de la ciudad:");
			String ciudad = scanner.nextLine();
			ciudades.add(ciudad);
				System.out.println("Desas ingresar otra ciudad? S/N");
				ingresaCiudad = scanner.nextLine();
			} while (ingresaCiudad.equalsIgnoreCase("S"));

			System.out.println("LISTADO DE CIUDADES");
			for (String ciudad: ciudades){
				System.out.println("- " + ciudad);
			}

		} catch (Exception e){
			System.out.println("Ocurrió un error" + e);
		}
	}
}
