package clase2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 	Escribir un programa que solicite los siguientes datos de una persona (nombre,
	apellido, edad, altura, ocupación, dirección) y los imprima por pantalla.
 * */

public class pedirDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nombre, apellido, ocupacion, direccion;
		int edad, altura;
		
		System.out.println("Ingrese el nombre");
		nombre = pedirDato();
		System.out.println("Ingrese el apellido");
		apellido = pedirDato();
		System.out.println("Ingrese la ocupacion");
		ocupacion = pedirDato();
		System.out.println("Ingrese la direccion");
		direccion = pedirDato();
		System.out.println("Ingrese su edad");
		edad = pedirDatoNumerico();
		System.out.println("Ingrese su altura");
		altura = pedirDatoNumerico();
		
		imprimirDatos(nombre, apellido, ocupacion, direccion, edad, altura);

	}
	
	private static void imprimirDatos(String nombre, String apellido,
			String ocupacion, String direccion, int edad, int altura) {
		// TODO Auto-generated method stub
		
		System.out.println("El nombre es: " + nombre + " y el apellido es: " + apellido + "\n" + 
				"De ocupacion: " +ocupacion + "\n"
				+ "Direccion : " + direccion + "\n"
				+ "Edad: " +edad + " y altura : "+ altura);
		
	}

	private static int pedirDatoNumerico() {
		// TODO Auto-generated method stub
		int variableLocal=0;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			variableLocal=Integer.valueOf(entrada.readLine());
		} catch (Exception exc) {
			// TODO: handle exception
			System.out.println(exc);
		}
		
		return variableLocal;
	}

	private static String pedirDato() {
		// TODO Auto-generated method stub
		String variableLocal = null;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			variableLocal=entrada.readLine();
		} catch (Exception exc) {
			// TODO: handle exception
			System.out.println(exc);
		}
		
		return variableLocal;
	}

}
