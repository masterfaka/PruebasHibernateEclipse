package hibernate;


import java.util.List;

public class principal {

	public static void main(String[] args) {
		
		try {
			AccesoBD.setUp();
			Persona p=new Persona("Luis", "Sanz", "luis@mail.com");
			Persona p1=new Persona("prueba3", "asssss", "luis@mail.com");
			
			AccesoBD.insertarPersona(p);
			AccesoBD.insertarPersona(p1);
			//List<Persona> lista=AccesoBD.recuperarPersonasL();
			List<Persona> lista=AccesoBD.buscarPersonasL("Luis");
			//AccesoBD.insertarPersona(p1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}
}
