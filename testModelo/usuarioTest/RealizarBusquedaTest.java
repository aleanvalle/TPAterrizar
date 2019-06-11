package usuarioTest;

import org.junit.Assert;
import org.junit.Test;

import modelo.*;

public class RealizarBusquedaTest {

	@Test
	public void realizarBusqueda_usuarioEstandarRealizaUnaBusqueda() {
		String codDeVuelo1 = "EC0344";
		Aerolinea aero = new Aerolinea();
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20121010", "2010111", "20:10", "14:20");
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		aero.agregarVuelo(vuelo1);
		String lugarOrigen = "BUE";
		String lugarDestino = "LA";
		String fechaSalida = "20121010";
		String fechaLlegada = null;
		String horaSalida = null;
		String horaLlegada = null;
		Assert.assertEquals("El usuario no realizo la busqueda.", 
				usuario.realizarBusqueda(lugarOrigen, fechaSalida, horaSalida, lugarDestino, fechaLlegada, horaLlegada),
				aero.asientosDisponibles(lugarOrigen, fechaSalida, horaSalida, lugarDestino, fechaLlegada, horaLlegada));
		
	}
	

	@Test
	public void realizarBusqueda_usuarioEstandarNoRealizaBusquedaEHistoricoEstaVacio() {
		Aerolinea aero = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		Assert.assertEquals("El usuario no guardo la busqueda.", 0,usuario.getHistoricoBusquedas().size());
		
	}
	
	@Test
	public void realizarBusqueda_usuarioEstandarRealizaUnaBusquedaYQuedaEnElHistorico() {
		String codDeVuelo1 = "EC0344";
		Aerolinea aero = new Aerolinea();
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20121010", "2010111", "20:10", "14:20");
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		aero.agregarVuelo(vuelo1);
		String lugarOrigen = "BUE";
		String lugarDestino = "LA";
		String fechaSalida = "20121010";
		String fechaLlegada = null;
		String horaSalida = null;
		String horaLlegada = null;
		usuario.realizarBusqueda(lugarOrigen, fechaSalida, horaSalida, lugarDestino, fechaLlegada, horaLlegada);
		Assert.assertEquals("El usuario no guardo la busqueda.", 1,usuario.getHistoricoBusquedas().size());
		
	}
	
}
