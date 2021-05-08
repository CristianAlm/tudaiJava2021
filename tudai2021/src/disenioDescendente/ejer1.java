package disenioDescendente;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Escribir un diseño de programa que mientras que el usuario
	ingrese un número distinto de 0, pida ingresar otro numero y
	lo imprima.
 * */

public class ejer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = pedirValor();
		int numImprimir = 0;
		
		realizarEjercicio(num, numImprimir);
		

	}

	private static void realizarEjercicio(int num, int numImprimir) {
		// TODO Auto-generated method stub
		
		while (num != 0) {
			numImprimir = pedirValor();
			System.out.println("El numero a imprimir es: " + numImprimir);
			num = pedirValor();
		}
	}

	private static int pedirValor() {
		// TODO Auto-generated method stub
		int variableLocal=0;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Ingrese el valor: ");
			variableLocal=Integer.valueOf(entrada.readLine());
		} catch (Exception exc) {
			// TODO: handle exception
			System.out.println(exc);
		}
		
		return variableLocal;
	}

}
