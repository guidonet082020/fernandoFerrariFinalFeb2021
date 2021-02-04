package FerrariFernando;

import java.util.HashMap;

import java.util.Map;

public class Cabina {
	
	/*
	 * Fornato del Contador de vehiculo ejemplo
	 * Clave valor
	 * Moto    6
	 * AutoBus 3
	 * Moto    2
	 *  
	 */
	private Map <String, Integer> contadorDeVehiculos;
	private Integer numero;
	
	/*
	 * 
	 */
	private Double tarifaCoche;
	private Double tarifaMoto;
	private Double tarifaAutoBus;


	/* recaudacion total de todos los vehiculos que pasaron por dicha cabina*/
	private Double recaudacion;
	
	public Cabina(Integer numero) {
		this.numero=numero;
		this.recaudacion=0.0;
		this.tarifaAutoBus=200.0;
		this.tarifaCoche=100.0;
		this.tarifaMoto=50.0;
		contadorDeVehiculos = new HashMap<String, Integer>();
	
		//Completar la inicializacion de los atributos restantes
		contadorDeVehiculos.put("Moto", 0);
		contadorDeVehiculos.put("AutoBus", 0);
		contadorDeVehiculos.put("Coche", 0);
	}

	
	
	/*
	 * Este metodo realiza el cobro y acumula la recaudacion de la cabina en funcion al tipo de auto
	 * Tambien contabiliza la cantidad de vehiculo ejemplo si es moto aumenta en uno el contador de moto
	 */
	public void pagar (Vehiculo vehiculo)  {
		switch(vehiculo.getTipo()) {
		  case "Coche":
			  recaudacion += tarifaCoche;
			  contarVehiculo(vehiculo);
		    break;
		  case "Moto":
			  recaudacion += tarifaMoto;
			  contarVehiculo(vehiculo);
		    break;
		  case "AutoBus":
			  recaudacion += tarifaAutoBus;
			  contarVehiculo(vehiculo);
			    break;
		}
	}		
	
	public Integer getCantVehiculos(Vehiculo vehiculo) {
		Integer retorno = 0;
		switch(vehiculo.getTipo()) {
		  case "Coche":
			  retorno = contadorDeVehiculos.get("Coche");	
			  break;
		  case "Moto":
			  retorno = contadorDeVehiculos.get("Moto");	
			  break;
		  case "AutoBus":
			  retorno = contadorDeVehiculos.get("AutoBus");
			  break;
		}
		return retorno;
	}
	
	/*
	 * incrementa el contadorDeVehiculo 
	 */
	private  void  contarVehiculo (Vehiculo vehiculo) {	
		Integer value = 0;
		switch(vehiculo.getTipo()) {
		  case "Coche":
			  value = contadorDeVehiculos.get("Coche");
			  contadorDeVehiculos.put("Coche", value +1);
		    break;
		  case "Moto":
			  value = contadorDeVehiculos.get("Moto");
			  contadorDeVehiculos.put("Moto", value +1);
		    break;
		  case "AutoBus":
			  value = contadorDeVehiculos.get("AutoBus");
			  contadorDeVehiculos.put("AutoBus", value +1);
			    break;
		}
	}
	
	public Double getTarifaVehiculo(Vehiculo vehiculo) {
		Double retorno = 0.0;
		switch(vehiculo.getTipo()) {
		  case "Coche":
			  retorno = tarifaCoche;
			  break;
		  case "Moto":
			  retorno = tarifaMoto;		  
			  break;
		  case "AutoBus":
			  retorno = tarifaAutoBus;
			  break;
		}
		return retorno;
	}
	
	public Double getRecaudacion() {
		
		return recaudacion;
	}
}
