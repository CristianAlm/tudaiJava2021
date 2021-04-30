package clase3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 	Escribir un programa que permita el ingreso de un número entero
	por teclado e imprima el cociente de la división de dicho número
	con 2, 3, y 4.
 * */

public class entero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int entero = pedirValor();
		
		System.out.println("El cociente entre 2 es " + (entero/2));
		System.out.println("El cociente entre 3 es " + (entero/3));
		System.out.println("El cociente entre 4 es " + (entero/4));

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
