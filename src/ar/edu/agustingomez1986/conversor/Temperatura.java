package ar.edu.agustingomez1986.conversor;

import java.util.ArrayList;

public class Temperatura extends Unidades{
	static String mensajePrimeraSeleccion = "Seleccione la unidad de temperatura";
	static String mensajeSegundaSeleccion = "Selecciona a qué unidad quieres pasar";
	
	//	*****  CONSTRUCTORES  ***** (la paridad es en relacion al ºC)
	public Temperatura(String nombre, double paridad) {
		super(nombre, paridad);
	}
	public Temperatura(String nombre) {
		super(nombre);
	}
	
	//	*****  ARMO LISTA DE TEMPERATURAS  *****
	static ArrayList<Temperatura> listaTemperatura = new ArrayList<>();
	
	static Temperatura celsius = new Temperatura("ºC", 1);
	static Temperatura kelvin = new Temperatura("K", 1);
	static Temperatura fahrenheit = new Temperatura("ºF", 5/9);
	
	public void InicializoArray() {
		if(listaTemperatura.isEmpty()) {
			listaTemperatura.add(celsius);
			listaTemperatura.add(kelvin);
			listaTemperatura.add(fahrenheit);	
		}
	}
	
	public static ArrayList<Temperatura> ArrayTemperatura(){
		return listaTemperatura;
	}
	
	//	*****  ARMO LISTA PARA EL MENU DESPLEGABLE  *****
	static ArrayList<Object> listaNombreTemperatura = new ArrayList<>();
	
	@Override
	public void InicializoDesplegable() {
		if(listaNombreTemperatura.isEmpty()) {
			listaNombreTemperatura.add(celsius.nombre);
			listaNombreTemperatura.add(kelvin.nombre);
			listaNombreTemperatura.add(fahrenheit.nombre);	
		}
	}
	
	public static Object[] DesplegableTemperatura() {
		return (Object[]) listaNombreTemperatura.toArray();
	}
	
	//	*****  MÉTODO QUE CONVIERTE  *****
	public static double Convierto (String nombreTemperaturaInicial, String nombreTemperaturaFinal, double cantidad) {
		
		double cantidadInicial = cantidad;
		double cantidadFinal = 0;
		
		switch(nombreTemperaturaInicial) {
			case "K":
				cantidadInicial -= 273.15;
				break;
			case "ºF":
				cantidadInicial = (cantidadInicial - 32) * 5/9;
		}
		
		switch(nombreTemperaturaFinal) {
		case "ºC":
			cantidadFinal = cantidadInicial;
			break;
		case "K":
			cantidadFinal = cantidadInicial + 273.15;
			break;
		case "ºF":
			cantidadFinal = (cantidadInicial * 9/5) +32;
	}
		
		double cantidadConvertida = Math.round(cantidadFinal *100.0)/100.0;
		return cantidadConvertida;
	}
}
