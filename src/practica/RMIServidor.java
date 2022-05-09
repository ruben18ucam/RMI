package practica;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;



public class RMIServidor {

	public RMIServidor() {
		try {
			LocateRegistry.createRegistry(1099);
			
			MiInterfaz c = new Metodos();
			
			//Permite al cliente ligar un stub local que le de acceso al objeto remoto contenido en la aplicación servidor
			Naming.rebind("rmi://localhost:1099/ServicioVacunacion", c);
			
			
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}

	public static void main(String args[]) {
		new RMIServidor();
	}

}
