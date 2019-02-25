package hibernate;

import java.util.List;
import java.util.Scanner;

public class EntradaSalida {

	private static Scanner sc=new Scanner(System.in);
	public static int mostrarM(String[] l) {
		System.out.println();
		for (String string : l) {
			System.out.println(string);
		}
		int i=sc.nextInt();sc.nextLine();
		return i;
	}
	public static void imprimirRes(List<Persona> listaB) {
		for (Persona persona : listaB) {
			String nombre=persona.getNombre();
			System.out.println(nombre);//aki se sacan los datos del  persona
		}
		
	}
	public static String pedirNombreB() {
		System.out.println("introduce Nombre persona buscada:");
		String nombre=sc.nextLine();
		return nombre;
	}

}
