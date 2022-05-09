package practica;

import java.rmi.Naming;
import java.util.Scanner;



public class RMICliente {
	 public static void main(String[] args) {
		 String opcion=" ";
		 String id;
		 String descripcion;
		 Vacuna vacuna= null;
		 boolean aux;
		 Scanner teclado = new Scanner(System.in);
		 Laboratorio laboratorio;
		 
		 
		   try {
			   //se registra el objeto, al que vamos a poder acceder remotamente
			   
			   MiInterfaz c = (MiInterfaz)Naming.lookup("rmi://localhost:1099/ServicioVacunacion");
			
			 do {
			    	System.out.println("1.- ADD VACUNA");
					System.out.println("2.- GET VACUNA");
					System.out.println("3.- REMOVE VACUNA");
					System.out.println("4.- COUNT VACUNA");
					System.out.println("5.- UPDATE VACUNA");
					System.out.println("6.- LIST");
					System.out.println("7.- ADD LABORATORIO");
					System.out.println("8.- GET LABORATORIO");
					System.out.println("9.- REMOVE LABORATORIO");
					System.out.println("10.-LIST LABORATORIOS");
					System.out.println("11.- ADD LABORATORIOS");
					System.out.println("12.- REMOVE LABORATORIOS");
					System.out.println("13.- SALIR");
					System.out.print("¿Opcion? ");
					 opcion = teclado.nextLine();
					
					 switch(opcion) {
					 case "1":
						 System.out.println("Dime el id de la vacuna");
						 id=teclado.nextLine();
						 System.out.println("Dime la descripcion de la vacuna");
						 descripcion=teclado.nextLine();
						 //envio la id y la descripcion
						 //para crear un nuevo objeto en el servidor a traves de una nueva instancia
						 c.addVacuna(id, descripcion);
 
						 break;
					 
					 case "2":
						 System.out.println("Dime el id de la vacuna");
						 id=teclado.nextLine();
						 vacuna = c.getVacuna(id);
						 
						 if(vacuna!=null) {
							 System.out.println(vacuna.getId() +" "+ vacuna.getDescripcion());
						 }
						 else {
							 //si la vacuna=null significa que no la hemos encontrado
							 System.out.println("No hemos encontrado la vacuna");
						 }
						 
						 break;
						 
					 case "3":
						 System.out.println("Dime el id de la vacuna");
						 id=teclado.nextLine();
						 //el metodo eliminarVacuna nos devuelve un boolean dependiendo si ha podidido o no eliminar la vacuna
						 aux=c.eliminarVacuna(id);
						 
						 if(aux==true) {
							System.out.println("Eliminada correctamente"); 
						 }
						 else {
							 System.out.println("No hemos podido eliminarla");
						 }
						 
						 break;
						 
					 case "4":
						 //este metodo cueenta las vacunas
						 System.out.println("Hay "+c.contarVacuna()+" vacunas");
						 break;
						 
					 case"5":
						 System.out.println("Dime el id de la vacuna");
						 id=teclado.nextLine();
						 System.out.println("Dime la descripcion de la vacuna");
						 descripcion=teclado.nextLine();
						 aux= c.updateVacuna(id, descripcion);		
						 
						 if(aux==true) {
							 System.out.println("Actualizada correctamente");
						 }
						 else {
							 System.out.println("No hemos podido actualizarla");
						 }
						 
						 break;
						 
					 case "6":
						 Vacuna vacArray[]= new Vacuna[c.contarVacuna()];
						 vacArray = c.listarVacunas();
						
						 if(c.contarVacuna()==0) {
							 System.out.println("No hay ninguna vacuna");
						 }
						 else {						 
						 for(int i=0;i<c.contarVacuna();i++) {
							 System.out.println(vacArray[i].getId()+" "+vacArray[i].getDescripcion()); 
						 }
						 }
						 break;
						 
					 case"7":
						 System.out.println("Dime el id del laboratorio");
						 id=teclado.nextLine();
						 System.out.println("Dime el nombre del laboratorio");
						 descripcion=teclado.nextLine();						
						 c.addLaboratorio(id,descripcion);
						 
						 break;
						 
					 case"8":
						 System.out.println("Dime el id del laboratorio");
						 id=teclado.nextLine();
						 laboratorio = c.getLaboratorio(id);
						 
						 if(laboratorio!=null) {
							 System.out.println(laboratorio.getIdLab() +" "+ laboratorio.getNombreLab());
						 }
						 else {
							 System.out.println("No hemos encontrado el laboratorio");
						 }
						 break;
						 
					 case "9":
						 System.out.println("Dime el id del laboratorio");
						 id=teclado.nextLine();
						 aux= c.eliminarLaboratorio(id);
						 if(aux==true) {
								System.out.println("Eliminado correctamente"); 
							 }
							 else {
								 System.out.println("No hemos podido eliminarlo");
							 }
						 break;
					
					 case "10":
						 Laboratorio labArray[]= new Laboratorio[c.contarLaboratorios()];
						 labArray = c.listarLaboratorios();
						 if(c.contarLaboratorios()==0) {
							 System.out.println("No hay ningun laboratorio");
						 }
						 for(int i=0;i<c.contarLaboratorios();i++) {
							 System.out.println(labArray[i].getIdLab()+" "+labArray[i].getNombreLab()); 
						 }
						 
						 break;
					
					 case"11":
						 System.out.println("Dime el id de la vacuna");
						 id=teclado.nextLine();
						 System.out.println("Dime el id del laboratorio");
						 descripcion=teclado.nextLine();
						 vacuna = c.getVacuna(id);
						 laboratorio = c.getLaboratorio(descripcion);

                         if(vacuna!=null && laboratorio!=null) {
                        	 // si existe la vacuna y el laboratorio entonces podremos añadir la vacuna al laboratorio
                        	 laboratorio.addVacunaLaboratorio(vacuna);
                        	 System.out.println("Vacuna anadida correctamente");
                         }
                         else {
                        	 System.out.println("Error");
                         }

						 break;
					 case"12":
						 System.out.println("Dime el id de la vacuna");
						 id=teclado.nextLine();
						 System.out.println("Dime el id del laboratorio");
						 descripcion=teclado.nextLine();
						 vacuna = c.getVacuna(id);
						 laboratorio = c.getLaboratorio(descripcion);
						 
						 if(vacuna!=null && laboratorio!=null) {
							// si existe la vacuna y el laboratorio entonces podremos eliminar la vacuna del laboratorio
                        	 laboratorio.eliminarVacunaLaboratorio(vacuna);
                        	 System.out.println("Vacuna eliminada correctamente");
                         }
                         else {
                        	 System.out.println("Error");
                         }

						 
						 break;
						 
						 
					 }
				
				 
				 
			 }while(!opcion.equals("13"));
			
			
		}catch (Exception e) {
			e.printStackTrace();
			} 	
	}
}
