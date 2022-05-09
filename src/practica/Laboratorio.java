package practica;

import java.io.Serializable;
import java.util.ArrayList;

public class Laboratorio  implements Serializable{

	private String id;
	private String nombre;
	private ArrayList<Vacuna>vacunas= new ArrayList<Vacuna>();
	private static int contador=0;
	
	public Laboratorio(String id, String nombre) {
		this.id=id;
		this.nombre=nombre;
	}
	public void addVacunaLaboratorio(Vacuna vacuna) {
		vacunas.add(vacuna);
	}
	
	public String getIdLab() {
		return id;
	}
	public String getNombreLab() {
		return nombre;
	}
	
	public void eliminarVacunaLaboratorio(Vacuna vacuna) {
		try {
		vacunas.remove(vacuna);
		}catch(Exception e) {
			System.out.println("Error");
		}
	}

}
