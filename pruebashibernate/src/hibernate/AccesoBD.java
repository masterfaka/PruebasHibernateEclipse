package hibernate;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;




public class AccesoBD {

	private static SessionFactory sessionFactory;

	
	public static void setUp() throws Exception {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			System.out.println(e.getMessage());
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}
	public static void insertarPersona(Persona p)
	{
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(p);
		s.getTransaction().commit();
	}
	public static ArrayList<Persona> recuperarPersonas()
	{
		Session s=sessionFactory.openSession();
		s.beginTransaction();//fundamental
		ArrayList<Persona> result = (ArrayList<Persona>)s.createSQLQuery("SELECT * from persona").list();
		s.getTransaction().commit();
		System.out.println(result.get(0).toString());
    /*  for (Persona e : result) {
            System.out.println("Leido: "+e.toString());
        }*/
        return result;
		//s.createSQLQuery("SELECT * from persona ");
		//s.beginTransaction();
		//s.save(p);
		//s.getTransaction().commit();
	}
	//metodo de luis
	/*OPCIOON WENAAAA*/
	//hay ke importar LIsta de java utils!! el otro es otra vaina de esto
	//las querys HQl se configuran con los names del fichero de confi
	public static List<Persona> recuperarPersonasL()
	{
		Session s=sessionFactory.openSession();
		s.beginTransaction();//fundamental
		//Query consulta=s.createQuery("FROM Persona");
		List<Persona> result = (List<Persona>) s.createQuery("FROM Persona").list();
		s.getTransaction().commit();
      for (Persona e : result) {
            System.out.println("Leido: "+e.getNombre()+e.getEmail()+e);
        }
        return result;
		//s.createSQLQuery("SELECT * from persona ");
		//s.beginTransaction();
		//s.save(p);
		//s.getTransaction().commit();
	}
	public static List<Persona> buscarPersonasL(String n)
	{
		Session s=sessionFactory.openSession();
		s.beginTransaction();//fundamental
		//Query consulta=s.createQuery("FROM Persona");
		Query qry = s.createQuery("From Persona persona where persona.nombre  like '%"+n+"%'");
		//qry.setString(0, "%"+n+"%");
		List<Persona> result=qry.list();
		//List<Persona> result = (List<Persona>) s.createQuery("FROM Persona WHERE nombre LIKE ").list();
		s.getTransaction().commit();
      for (Persona e : result) {
            System.out.println("Buscado: "+e.getNombre()+e.getEmail()+e);
        }
        return result;
		//s.createSQLQuery("SELECT * from persona ");
		//s.beginTransaction();
		//s.save(p);
		//s.getTransaction().commit();
	}
}

