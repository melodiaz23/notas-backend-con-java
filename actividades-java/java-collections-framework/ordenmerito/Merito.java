package ordenmerito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Merito {
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)){
			ArrayList<Integer> notas = new ArrayList<>();
			int nota;
			String opc;

			do {
				System.out.println("Ingresa la nota al sistema:");
				nota = scanner.nextInt();
				scanner.nextLine();
				if(nota >= 1 && nota <= 10){
					notas.add(nota);
				} else {
					System.out.println("La nota no es valida ");
				}
				System.out.println("Deseas ingresar otra nota más? S/N");
				opc = scanner.nextLine();
			} while (opc.equalsIgnoreCase("S"));

			notas.sort(Comparator.reverseOrder());
			System.out.println("Lista de notas orden descendente");
			System.out.println(notas);

			Collections.sort(notas);
			System.out.println("Lista de notas orden ascendente");
			System.out.println(notas);
		}
	}
}