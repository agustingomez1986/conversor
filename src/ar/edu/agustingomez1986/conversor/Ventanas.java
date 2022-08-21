package ar.edu.agustingomez1986.conversor;

import javax.swing.JOptionPane;

public class Ventanas {
	static Object[] desplegable = {};
	static String seleccionMenuPrincipal = "";
	static String seleccionPrimeraSeleccion = "";
	static String seleccionSegundaSeleccion = "";
	static String ventanaCantidad = "";
	static double metodoConversion = 0;
	static String mensajePrimeraSeleccion = "";
	static String mensajeSegundaSeleccion = "";
	
	public static void MenuPrincipal() {
		String[] desplegablePrincipal = {"Moneda", "Temperatura", "Longitud"};
		seleccionMenuPrincipal = (String) JOptionPane.showInputDialog(null, "Selecciona lo que quieres "
								+ "convertir", "Elegir", JOptionPane.QUESTION_MESSAGE, null, 
								desplegablePrincipal, desplegablePrincipal[0]);
		if (seleccionMenuPrincipal == null) {
			JOptionPane.showMessageDialog(null, "Programa finalizado");
			System.exit(0);
		}
		
		switch (seleccionMenuPrincipal) {
		case "Moneda":
			Moneda inicializacionArrayMoneda = new Moneda("array");
			inicializacionArrayMoneda.InicializoArray();
			Moneda inicializacionMonedas = new Moneda("desplegable");
			inicializacionMonedas.InicializoDesplegable();
			desplegable = Moneda.Desplegable();
			mensajePrimeraSeleccion = Moneda.mensajePrimeraSeleccion;
			mensajeSegundaSeleccion = Moneda.mensajeSegundaSeleccion;
			break;
		case "Temperatura":
			Temperatura inicializacionArrayTemperatura = new Temperatura("array");
			inicializacionArrayTemperatura.InicializoArray();
			Temperatura inicializacionTemperatura = new Temperatura("desplegable");
			inicializacionTemperatura.InicializoDesplegable();
			desplegable = Temperatura.DesplegableTemperatura();
			mensajePrimeraSeleccion = Temperatura.mensajePrimeraSeleccion;
			mensajeSegundaSeleccion = Temperatura.mensajeSegundaSeleccion;
			break;
		case "Longitud":
			Longitud inicializacionArrayLongitud = new Longitud("array");
			inicializacionArrayLongitud.InicializoArray();
			Longitud inicializacionLongitud = new Longitud("desplegable");
			inicializacionLongitud.InicializoDesplegable();
			desplegable = Longitud.Desplegable();
			mensajePrimeraSeleccion = Longitud.mensajePrimeraSeleccion;
			mensajeSegundaSeleccion = Longitud.mensajeSegundaSeleccion;
			break;
		}
		
		PrimeraSeleccion();
	}
	
	public static void PrimeraSeleccion() {		
		seleccionPrimeraSeleccion = (String) JOptionPane.showInputDialog(null,
				mensajePrimeraSeleccion, "Elegir",
				JOptionPane.QUESTION_MESSAGE, null, desplegable, desplegable[0]);
		
		if (seleccionPrimeraSeleccion == null) {
			MenuPrincipal();
			System.exit(0);
		}
		
		SegundaSeleccion();
	}
	
	public static void SegundaSeleccion() {
		seleccionSegundaSeleccion = (String) JOptionPane.showInputDialog(null,
				mensajeSegundaSeleccion, "Elegir",
				JOptionPane.QUESTION_MESSAGE, null, desplegable, desplegable[0]);
		
		if (seleccionSegundaSeleccion == null) {
			MenuPrincipal();
			System.exit(0);
			
		}
		
		CantidadSeleccion();
	}
	
	public static void CantidadSeleccion() {
		ventanaCantidad = JOptionPane.showInputDialog("Introduce la cantidad a convertir");
		if (ventanaCantidad == null) {
			MenuPrincipal();
			System.exit(0);
		}
		while(!Unidades.Valido(ventanaCantidad)) {
			JOptionPane.showMessageDialog(null, "El valor no es válido");
			ventanaCantidad = JOptionPane.showInputDialog("Introduce la cantidad a convertir");
		}
		
		switch (seleccionMenuPrincipal) {
		case "Moneda":
			metodoConversion = Moneda.Convierto(seleccionPrimeraSeleccion, seleccionSegundaSeleccion, new Double(ventanaCantidad));
			break;
		case "Temperatura":
			metodoConversion = Temperatura.Convierto(seleccionPrimeraSeleccion, seleccionSegundaSeleccion, new Double(ventanaCantidad));
			break;
		case "Longitud":
			metodoConversion = Longitud.Convierto(seleccionPrimeraSeleccion, seleccionSegundaSeleccion, new Double(ventanaCantidad));
			break;
		}
		
		double resultadoConversion = metodoConversion;
		
		JOptionPane.showMessageDialog(null, (Double.parseDouble(ventanaCantidad) + " " +seleccionPrimeraSeleccion +
				 "  son:  " + resultadoConversion + " " + seleccionSegundaSeleccion));
		
		PantallaFinal();
	}
	
	public static void PantallaFinal() {		
		int pantallaFinal = JOptionPane.showConfirmDialog(null, "¿Desea volver a realizar una conversión?");
		switch(pantallaFinal) {
			case 0:
				MenuPrincipal();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Programa finalizado");
		}
	}
}
