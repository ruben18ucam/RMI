package practica;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;



public class Metodos extends UnicastRemoteObject implements MiInterfaz{
	
	ArrayList<Vacuna> lista = new ArrayList<Vacuna>();
	ArrayList<Laboratorio> lista2 = new ArrayList<Laboratorio>();
	
	
	public Metodos() throws RemoteException 
	{ super(); }

	@Override
	public void addVacuna(String id, String descripcion) throws RemoteException {
		Vacuna v = new Vacuna(id,descripcion);
		lista.add(v);
		
		
	}

	@Override
	public boolean eliminarVacuna(String clave) throws RemoteException {
		//devolveremos un true en el caso de que podamos eliminar la vacuan correctamente
		//un false en el caso de que no podamos eliminar la vacuna
		boolean aux=false;
		for(Vacuna v: lista) {
			if(v.getId().equals(clave)) {
				lista.remove(v);
				aux=true;
				break;
			}
			
		}
		return aux;
	
	}
		

	@Override
	public Vacuna getVacuna(String clave) throws RemoteException {
		
		Vacuna aux=null;
		for(Vacuna v: lista) {
			if(v.getId().equals(clave)) {
				aux=v;
			
			}
		}
		return aux;
	}

	@Override
	public boolean updateVacuna(String id, String descripcion) throws RemoteException {
		//devolveremos un true en el caso de que podamos actualizar la vacuan correctamente
		//un false en el caso de que no podamos actualizar la vacuna
		boolean aux=false;
		for(Vacuna v: lista) {
			if(v.getId().equals(id)) {
				v.setDescripcion(descripcion);
				aux=true;
				break;
			}
		}
		return aux;
		
	}

	@Override
	public int contarVacuna() throws RemoteException {
		int contador=0;
		for(Vacuna v: lista) {
			contador++;
		}
		return contador;
	}

	@Override
	public void addLaboratorio(String id, String nombre) throws RemoteException {
	    Laboratorio lab = new Laboratorio(id,nombre);
        lista2.add(lab);
	}

	@Override
	public Laboratorio getLaboratorio(String clave) throws RemoteException {
		Laboratorio aux=null;
		for(Laboratorio v: lista2) {
			if(v.getIdLab().equals(clave)) {
				aux=v;
				
			}
		}
		return aux;
	}

	@Override
	public boolean eliminarLaboratorio(String clave) throws RemoteException {
		boolean aux=false;
		for(Laboratorio v: lista2) {
			if(v.getIdLab().equals(clave)) {
				lista2.remove(v);
				aux=true;
				break;
			}
			
		}
		return aux;
		
	}

	@Override
	public Vacuna[] listarVacunas() throws RemoteException {
		Vacuna aux[]= new Vacuna[this.contarVacuna()];
		int contador=0;
		for(Vacuna v: lista) {
			aux[contador]=v;
			contador++;
		}
		return aux;
	}

	@Override
	public int contarLaboratorios() throws RemoteException {
		int contador=0;
		for(Laboratorio v: lista2) {
			contador++;
		}
		return contador;
	}

	@Override
	public Laboratorio[] listarLaboratorios() throws RemoteException {
		Laboratorio aux[]= new Laboratorio[this.contarLaboratorios()];
		int contador=0;
		for(Laboratorio v: lista2) {
			aux[contador]=v;
			contador++;
		}
		return aux;
	}
	
	


}