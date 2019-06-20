package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Usuario {
	private String nombre;
	private String apellido;
	private int dni;
	protected Aerolinea aerolinea;
	protected double dineroTotalGastado;
	
	private ArrayList<ArrayList<String>> historicoBusquedas = new ArrayList<ArrayList<String>>();
	protected List<Asiento> compras = new ArrayList<Asiento>();


	protected List<Asiento> reservas = new ArrayList<Asiento>();
	
	public Usuario(String nombre, String apellido, int dni, Aerolinea aerolinea) {
		this.setNombre(nombre);
		this.apellido = apellido;
		this.setDni(dni);
		this.aerolinea = aerolinea;
	}
	
	public String getApellido() {
		return apellido;
	}

	private void setDni(int _dni) {
		this.dni = _dni;
	}
	
	private int getDni(){
		return dni;
	}

	private void setNombre(String _nombre) {
		this.nombre = _nombre;
	}

	public ArrayList<ArrayList<Asiento>> realizarBusqueda 
			(String origen, String fechaSalida, String horaSalida,
			String destino, String fechaLlegada, String horaLlegada) {
		
		ArrayList<String> criterios = new ArrayList<>(
				Arrays.asList(origen, fechaSalida, horaSalida, destino, fechaLlegada, horaLlegada));
		this.historicoBusquedas.add(criterios);
			return aerolinea.asientosDisponibles(origen, fechaSalida, horaSalida,
					destino, fechaLlegada, horaLlegada);
		
	}
	
	public void comprar(String CodAsiento){
		try{
			Asiento asientoComprado = aerolinea.comprar(CodAsiento);
			this.compras.add(asientoComprado);
			
		}
		catch (Exception ex){
			throw ex;
		}
	}
	
	public boolean suscripto() {
		return false;
	}

	public ArrayList<ArrayList<String>> getHistoricoBusquedas() {
		return historicoBusquedas;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Asiento> getCompras() {
		return compras;
	}

	public List<Asiento> getReservas() {
		return reservas;
	}
}
