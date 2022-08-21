package ar.edu.agustingomez1986.conversor;

import java.util.ArrayList;

public class Longitud extends Unidades{
//	*****  CONSTRUCTORES  ***** (la paridad es en realación al metro)
	public Longitud(String nombre, double paridad) {
		super(nombre, paridad);
	}
	public Longitud(String nombre) {
		super(nombre);
	}
	
	static String mensajePrimeraSeleccion = "Seleccione la unidad de medida";
	static String mensajeSegundaSeleccion = "Selecciona a qué unidad quieres pasar";

	//	*****  ARMO LISTA DE MONEDAS  *****
	static ArrayList<Longitud> listaLongitudes = new ArrayList<>();
	
	static Longitud metro = new Longitud("metros", 1);
	static Longitud kilometro = new Longitud("kilometros", 0.001);
	static Longitud milla = new Longitud("millas", 0.000621371);
	static Longitud yarda = new Longitud("yardas", 1.09361);
	static Longitud pulgada = new Longitud("pulgadas", 39.3701);
	static Longitud pie = new Longitud("pies", 3.28084);
	
	public void InicializoArray() {
		if (listaLongitudes.isEmpty()) {
			listaLongitudes.add(metro);
			listaLongitudes.add(kilometro);
			listaLongitudes.add(milla);
			listaLongitudes.add(yarda);
			listaLongitudes.add(pulgada);
			listaLongitudes.add(pie);	
		}
	}
	
	public static ArrayList<Longitud> ArrayLongitud(){
		return listaLongitudes;
	}
	
	//	*****  ARMO LISTA PARA EL MENU DESPLEGABLE  *****
	static ArrayList<Object> listaNombreLongitud = new ArrayList<>();
	
	public void InicializoDesplegable() {
		if (listaNombreLongitud.isEmpty()) {
			listaNombreLongitud.add(metro.nombre);
			listaNombreLongitud.add(kilometro.nombre);
			listaNombreLongitud.add(milla.nombre);
			listaNombreLongitud.add(yarda.nombre);
			listaNombreLongitud.add(pulgada.nombre);
			listaNombreLongitud.add(pie.nombre);	
		}
	}
	
	public static Object[] Desplegable() {
		return (Object[]) listaNombreLongitud.toArray();
	}
	
	//	*****  MÉTODO QUE DEVUELVE LA PARIDAD AL INGRESARLE UN NOMBRE DE MONEDA  *****
	public double BuscoParidad (String nombre) {
		Longitud nueva = new Longitud(nombre);
		for(int x=0; x < 6; x++) {//listaNombreMonedas.size(); x++) {
			if (listaNombreLongitud.get(x) == nombre) {
				nueva = listaLongitudes.get(x);
			}
		}
		return nueva.paridad;
	}
	
	//	*****  MÉTODO QUE CONVIERTE  *****
	public static double Convierto (String nombreLongitudInicial, String nombreLongitudFinal, double cantidad) {
		Longitud longitudInicial = new Longitud(nombreLongitudInicial);
		Longitud longitudFinal = new Longitud(nombreLongitudFinal);
		
		double paridadLongitudInicial = longitudInicial.BuscoParidad(nombreLongitudInicial);
		double paridadLongitudFinal = longitudFinal.BuscoParidad(nombreLongitudFinal);
		
		double cantidadConvertida = Math.round(paridadLongitudFinal / paridadLongitudInicial * cantidad *100.00)/100.00;
		return cantidadConvertida;
	}
}