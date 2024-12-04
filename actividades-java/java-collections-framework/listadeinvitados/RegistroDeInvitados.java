package listadeinvitados;

import java.util.HashSet;

public class RegistroDeInvitados {
	private final HashSet<String> nombreInvitados = new HashSet<>();

	public void agregarInvitado(String nombre){
		System.out.println(nombreInvitados.add(nombre.toUpperCase()) ?
						"Nombre fue adicionado" :
						"Nombre ya existe");
	}

	public void eliminarInvitado(String nombre){
		System.out.println(nombreInvitados.remove(nombre.toUpperCase()) ?
						"Nombre fue eliminado":
						"Nombre no existe");
	}

	public void mostrarInvitados(){
		System.out.println(nombreInvitados);
	}


}
