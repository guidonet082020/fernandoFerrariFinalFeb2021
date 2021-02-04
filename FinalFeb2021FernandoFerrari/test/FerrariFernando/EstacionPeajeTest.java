package FerrariFernando;

import org.junit.Assert;
import org.junit.Test;

public class EstacionPeajeTest {
	Integer cantCabinas = 4;
	EstacionDePeaje dellepiane = new EstacionDePeaje(cantCabinas);
	
	@Test
	public void queVericaQueSeCreanTodasCabinasEnUnaEstacionDePeaje() {
		Integer nroDeCabinasActual = dellepiane.getCabinas().size();
		Assert.assertEquals(cantCabinas, nroDeCabinasActual);
	}
	
	
	
	
	@Test
	public void queQueObtieneListaDeCabinasOrdenaPorImporteDescendente () {
		
	}
	
	
	
	
	
}
