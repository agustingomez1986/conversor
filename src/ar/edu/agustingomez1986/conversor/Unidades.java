package ar.edu.agustingomez1986.conversor;

public abstract class Unidades {
	public String nombre;
	public double paridad = 0;
	//public String clase;
	
	public Unidades(String nombre, double paridad){
		this.nombre = nombre;
		this.paridad = paridad;
	}
	public Unidades(String nombre) {
		this.nombre = nombre;
	}
	
	public void InicializoDesplegable() {}
	public void InicializoArray() {}
	
//	*****  MÉTODO PARA VALIDAR QUE LA CANTIDAD INGRESADA SEA UN NUMERO  *****
	public static boolean Valido(String valorIngresado) {
		try {
			valorIngresado = valorIngresado.replaceAll(",", ".");
			if(!valorIngresado.matches("[\\d]+([.]?[\\d]+)?")) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}
}
