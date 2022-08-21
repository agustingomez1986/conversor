package ar.edu.agustingomez1986.conversor;

import java.util.ArrayList;

public class Temperatura extends Unidades{
	static String mensajePrimeraSeleccion = "Seleccione la unidad de temperatura";
	static String mensajeSegundaSeleccion = "Selecciona a qu� unidad quieres pasar";
	
	//	*****  CONSTRUCTORES  ***** (la paridad es en relacion al �C)
	public Temperatura(String nombre, double paridad) {
		super(nombre, paridad);
	}
	public Temperatura(String nombre) {
		super(nombre);
	}
	
	//	*****  ARMO LISTA DE TEMPERATURAS  *****
	static ArrayList<Temperatura> listaTemperatura = new ArrayList<>();
	
	static Temperatura celsius = new Temperatura("�C", 1);
	static Temperatura kelvin = new Temperatura("K", 1);
	static Temperatura fahrenheit = new Temperatura("�F", 5/9);
	
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
	
	//	*****  M�TODO QUE CONVIERTE  *****
	public static double Convierto (String nombreTemperaturaInicial, String nombreTemperaturaFinal, double cantidad) {
		
		double cantidadInicial = cantidad;
		double cantidadFinal = 0;
		
		switch(nombreTemperaturaInicial) {
			case "K":
				cantidadInicial -= 273.15;
				break;
			case "�F":
				cantidadInicial = (cantidadInicial - 32) * 5/9;
		}
		
		switch(nombreTemperaturaFinal) {
		case "�C":
			cantidadFinal = cantidadInicial;
			break;
		case "K":
			cantidadFinal = cantidadInicial + 273.15;
			break;
		case "�F":
			cantidadFinal = (cantidadInicial * 9/5) +32;
	}
		
		double cantidadConvertida = Math.round(cantidadFinal *100.0)/100.0;
		return cantidadConvertida;
	}
}
