package FerrariFernando;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EstacionDePeaje {

	private List<Cabina> cabinas;

	private Integer cantidadDeCabinas;

	/*
	 * Al momento de la creacion de la estacion de peajes se deben crear todas las cabianas
	 * donde en la posicion 0 hay una cabina de Telepase y el resto de las cabinas son comunes 
	 */
	public EstacionDePeaje(Integer cantidadDeCabinas) {
		this.cantidadDeCabinas = cantidadDeCabinas;
		cabinas = new ArrayList<Cabina>(cantidadDeCabinas);
		for(int i=0;i<cantidadDeCabinas;i++) 
		{
			Cabina newCab = null;
			if(i == 0) 
			{
				newCab = new Telepase(i);				
			}
			else 
			{
				newCab = new Cabina(i);	
			}
			agregarCabinas(newCab);
		}
	}

	//Metodo que agrega todas las cabinas (No Obligatorio)
	private void agregarCabinas(Cabina cabina) {
		cabinas.add(cabina);
	}

	/*
	 * obtiene todas un listado de cabinas ordenas por importe recaudado en forma descendete
	 */
	public Set<Cabina> otenerCabinasOrdenadaImporteDescendente(Orden orden) {
		return null;
		
	}
	
	
	public List<Cabina>getCabinas(){
		return this.cabinas;
	}

}
