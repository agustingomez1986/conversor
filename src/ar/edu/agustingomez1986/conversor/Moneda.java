package ar.edu.agustingomez1986.conversor;

import java.util.ArrayList;

public class Moneda extends Unidades{
	//	*****  CONSTRUCTORES  ***** (la paridad es en realación al dolasUSA)
	public Moneda(String nombre, double paridad) {
		super(nombre, paridad);
	}
	public Moneda(String nombre) {
		super(nombre);
	}
	
	static String mensajePrimeraSeleccion = "Seleccione la moneda";
	static String mensajeSegundaSeleccion = "Selecciona a qué moneda quieres pasar";

	//	*****  ARMO LISTA DE MONEDAS  *****
	static ArrayList<Moneda> listaMonedas = new ArrayList<>();
	
	static Moneda dolarUSA = new Moneda("USD", 1);
	static Moneda euro = new Moneda("EUR", 1.01);
	static Moneda pesoArgentino = new Moneda("ARS", 136.65);
	static Moneda libraEsterlina = new Moneda("GBP", 0.85);
	static Moneda yenJapones = new Moneda("JPY", 137.42);
	static Moneda wonSurCorea = new Moneda("KRW", 1342.16);
	
	public void InicializoArray() {
		if (listaMonedas.isEmpty()) {
			listaMonedas.add(dolarUSA);
			listaMonedas.add(euro);
			listaMonedas.add(pesoArgentino);
			listaMonedas.add(libraEsterlina);
			listaMonedas.add(yenJapones);
			listaMonedas.add(wonSurCorea);	
		}
	}
	
	public static ArrayList<Moneda> ArrayMoneda(){
		return listaMonedas;
	}
	
	//	*****  ARMO LISTA PARA EL MENU DESPLEGABLE  *****
	static ArrayList<Object> listaNombreMonedas = new ArrayList<>();
	
	public void InicializoDesplegable() {
		if (listaNombreMonedas.isEmpty()) {
			listaNombreMonedas.add(dolarUSA.nombre);
			listaNombreMonedas.add(euro.nombre);
			listaNombreMonedas.add(pesoArgentino.nombre);
			listaNombreMonedas.add(libraEsterlina.nombre);
			listaNombreMonedas.add(yenJapones.nombre);
			listaNombreMonedas.add(wonSurCorea.nombre);	
		}
	}
	
	public static Object[] Desplegable() {
		return (Object[]) listaNombreMonedas.toArray();
	}
	
	//	*****  MÉTODO QUE DEVUELVE LA PARIDAD AL INGRESARLE UN NOMBRE DE MONEDA  *****
	public double BuscoParidad (String nombre) {
		Moneda nueva = new Moneda(nombre);
		for(int x=0; x < 6; x++) {//listaNombreMonedas.size(); x++) {
			if (listaNombreMonedas.get(x) == nombre) {
				nueva = listaMonedas.get(x);
			}
		}
		return nueva.paridad;
	}
	
	//	*****  MÉTODO QUE CONVIERTE  *****
	public static double Convierto (String nombreMonedaInicial, String nombreMonedaFinal, double cantidad) {
		Moneda monedaInicial = new Moneda(nombreMonedaInicial);
		Moneda monedaFinal = new Moneda(nombreMonedaFinal);
		
		double paridadMonedaInicial = monedaInicial.BuscoParidad(nombreMonedaInicial);
		double paridadMonedaFinal = monedaFinal.BuscoParidad(nombreMonedaFinal);
		
		double cantidadConvertida = Math.round(paridadMonedaFinal / paridadMonedaInicial * cantidad *100.0)/100.0;
		return cantidadConvertida;
	}
}
