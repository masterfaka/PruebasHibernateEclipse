package hibernate;


import java.util.List;

public class principal {
	//Aki  acemos el grub con hibernate

	public static void main(String[] args) {
		
		try {
			AccesoBD.setUp();
			Persona p=new Persona("Luis", "Sanz", "luis@mail.com");
			Persona p1=new Persona("prueba3", "asssss", "luis@mail.com");
			
			
			String[] lista= {"1-Insertar producto","2-Listar","3-buscarProducto","4-Salir"};
			int opcion=EntradaSalida.mostrarM(lista);
			while(opcion != 4) {
				switch (opcion) {
				case 1://inseert
					//habria ke pedi persona
					AccesoBD.insertarPersona(p);
					AccesoBD.insertarPersona(p1);
					break;
				case 2://listar
					List<Persona> listaP=AccesoBD.recuperarPersonasL();
					//esto muestra unke no deberia.... deberia aber una func en E/S
					
	
				
					break;
				case 3://buscar
					
					//introducir panombre a buscar por siacaso tratar como lista
					String  nom=EntradaSalida.pedirNombreB();
					List<Persona> listaB=AccesoBD.buscarPersonasL(nom);
					//E/S imprimir lista
					EntradaSalida.imprimirRes(listaB);
					break;
				default:
					break;
				}			
				opcion=EntradaSalida.mostrarM(lista);
			}
			//List<Persona> lista=AccesoBD.recuperarPersonasL();
			//List<Persona> lista=AccesoBD.buscarPersonasL("Luis");
				//necesitamos  insertar buscar y listar
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}
}

