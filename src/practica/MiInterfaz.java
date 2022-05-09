package practica;

public interface MiInterfaz extends java.rmi.Remote {
	
	
	public void addVacuna(String id,String descripcion)
			throws java.rmi.RemoteException;

		public boolean eliminarVacuna(String clave)
			throws java.rmi.RemoteException;

		public Vacuna getVacuna(String clave)
			throws java.rmi.RemoteException;

		public boolean updateVacuna(String id, String descripcion)
			throws java.rmi.RemoteException;
		
		public int contarVacuna()
				throws java.rmi.RemoteException;
		public int contarLaboratorios()
				throws java.rmi.RemoteException;
		
		public Vacuna[] listarVacunas()
				throws java.rmi.RemoteException;
		
		public void addLaboratorio(String id,String nombre)
				throws java.rmi.RemoteException;
		
		public Laboratorio getLaboratorio(String clave)
				throws java.rmi.RemoteException;
		
		public boolean eliminarLaboratorio(String clave)
				throws java.rmi.RemoteException;
		
		public Laboratorio[] listarLaboratorios()
				throws java.rmi.RemoteException;
		
		
	}