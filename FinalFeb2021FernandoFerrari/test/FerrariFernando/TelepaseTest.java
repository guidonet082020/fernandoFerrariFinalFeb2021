package FerrariFernando;

import org.junit.Test;

public class TelepaseTest {
	Integer cantCabinas = 4;
	EstacionDePeaje dellepiane = new EstacionDePeaje(cantCabinas);
	Tag tag = new Tag(1);
	
	
	
	@Test(expected = TagNoEncontradoException.class)
	public void queVerificaQueSeEncuentreElTagConIdUno () throws TagNoEncontradoException {
		//Para este test se debeinvocar al metodo public Boolean verifcarExiste(Tag tag)
		//el mismo no se puede modificar
		Telepase tele = (Telepase)dellepiane.getCabinas().get(0);
		tele.verifcarExiste(tag);
	}
	

	@Test(expected = SaldoInsuficienteError.class)
	public void queAlPasarAutobusconSaldoInsuficienteLanceUnaExcepcion () throws SaldoInsuficienteError, TagNoEncontradoException, VehiculoNoPermitidoException {
		Telepase tele = (Telepase)dellepiane.getCabinas().get(0);
		AutoBus bus = new AutoBus("11",tag);
		bus.getTag().setSaldo(100.0);
		tele.pagarAutomatico(bus);
	}
	
	@Test(expected = TagNoEncontradoException.class)
	public void queAlPasarUnAutobusconUnTagInvalidoLanceUnaExcepcion () throws SaldoInsuficienteError, TagNoEncontradoException, VehiculoNoPermitidoException {
		Telepase tele = (Telepase)dellepiane.getCabinas().get(0);
		Tag tag2 = new Tag(2);
		tag2.setSaldo(200.0);
		AutoBus bus2 = new AutoBus("11",tag2);		
		tele.pagarAutomatico(bus2);
	}
	
	

}
