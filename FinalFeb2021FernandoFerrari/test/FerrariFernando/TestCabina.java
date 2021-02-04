package FerrariFernando;

import org.junit.Assert;
import org.junit.Test;

public class TestCabina {

	Integer cantCabinas = 4;
	EstacionDePeaje dellepiane = new EstacionDePeaje(cantCabinas);
		
	Coche auto = new Coche("ee");
	Coche auto2 = new Coche("ees");
	Moto moto = new Moto("eeee");
	
	@Test
	public void queVerificaQueCuenteCorrectamenteLaCantidadDeVehiculosQuePaSanPorUnacabina() {
		Cabina cab1 = (Cabina)dellepiane.getCabinas().get(1);
		cab1.pagar(auto);
		cab1.pagar(auto2);
		cab1.pagar(moto);
		
		Integer cantAutos = 2;
		Assert.assertEquals(cantAutos, cab1.getCantVehiculos(auto));
	}


	@Test
	public void queVerificaQueSeRecaudeCorrectaMenteElPagoDeUnVehiculo() {
		Cabina cab1 = (Cabina)dellepiane.getCabinas().get(1);
		cab1.pagar(auto);
		cab1.pagar(auto2);
		
		Double recaudacion = 200.0;
		
		Assert.assertEquals(recaudacion, cab1.getRecaudacion());
	}

	
}
