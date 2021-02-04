package FerrariFernando;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Telepase extends Cabina {

/*
 * Atributo donde se almacenan todos los tags habilitados para el telepase
 * No se permiten tags duplicados ( 2 tags son iguales cuando tienen el mismo id)
 */
	private Set<Tag> tags;

	public Telepase(Integer numero) {
		super(numero);
		tags = new HashSet<Tag>();
		//siempre al momento de crear un telepase se crea el tag 1 con 200 pesos de carga 
		Tag tagInicial = new Tag (1);
		tagInicial.setSaldo(200.0);
		this.cargarTag(tagInicial);
	}

	public Boolean cargarTag(Tag tag){
			return tags.add(tag);		
		
	}

	
	/*
	 * Este metodo es pago automatico y en estas cabinas solamente estan habilitados los autobuses
	 * Al momento de pasar un autobus se descuenta el importe del tag asociado al autobus y se incrementa la recaudacion de la cabina 
	 * y tambien se tiene que incrementar el contador de AutoBus 
	 * 
	 * Validaciones
	 * 1) en caso que el tag no este registrado lanza una TagNoEncontradoException
	 * 2) en caso que el vehiculo que ingreso al telepase no es un AutoBus lanza una  VehiculoNoPermitidoExceptions
	 * 3) en caso que el importe que tiene el tag no alcanza para pagar el peaje laza una SaldoInsuficienteError
	 * 
	 */
	public void pagarAutomatico(Vehiculo vehiculo)throws SaldoInsuficienteError, TagNoEncontradoException,VehiculoNoPermitidoException	{
		pagarConTelePase(vehiculo);
	}


	//Metodo no obligatorio
	private void pagarConTelePase(Vehiculo vehiculo) throws SaldoInsuficienteError, TagNoEncontradoException,VehiculoNoPermitidoException {
		if(verifcarVehiculoPermitido(vehiculo)) {			
			Tag tag = ((AutoBus) vehiculo).getTag();
			if(verifcarExiste(tag)) {
				Double tarifa = getTarifaVehiculo(vehiculo);
				Double saldo = ((AutoBus) vehiculo).getTag().getSaldo();
				if(verificarTieneSaldoSuficiente(saldo,tarifa)) {
					((AutoBus) vehiculo).getTag().setSaldo(saldo - tarifa);
					pagar(vehiculo);
				}				
			}
		}		
	}
//Verifica que si existe el tag
	public Boolean verifcarExiste(Tag tag) throws TagNoEncontradoException {
		// No Se Puede modificar el comportamiento de  este metodo
		//Los tags son iguales cuando tiene el mismo id 
		
		for (Tag tagLeido : tags) {
			if (tagLeido.equals(tag))
				return Boolean.TRUE;
		}

		throw new TagNoEncontradoException("No se encontro el Tag");
	}
	
	public Boolean verifcarVehiculoPermitido(Vehiculo vehiculo) throws VehiculoNoPermitidoException {
		
		if(vehiculo instanceof AutoBus) {
			return Boolean.TRUE;
		}	
		

		throw new VehiculoNoPermitidoException("El vehiculo no es permitido");
	}
	
	public Boolean verificarTieneSaldoSuficiente(Double saldo, Double importeAdescontar)throws SaldoInsuficienteError {
		if(saldo >= importeAdescontar) {
			return Boolean.TRUE;
		}	
		

		throw new SaldoInsuficienteError("No tiene saldo suficiente");
	}
}
