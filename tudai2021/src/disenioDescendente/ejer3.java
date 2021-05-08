package disenioDescendente;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Escribir un programa que mientras el usuario cargue desde
	teclado un caracter letra minúscula, llame a un método
	que imprime por pantalla la tabla de multiplicar de 9.
 * */

public class ejer3 {
	
	public static final int TABLA = 9;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char usuario = pedirCaracter();
		
		imprimirTabla(TABLA);

	}

	private static void imprimirTabla(int tabla2) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= TABLA; i++) {
			System.out.print(i*TABLA + "|");
		}
	}

	private static char pedirCaracter() {
		// TODO Auto-generated method stub
		char variableLocal = 0;
		boolean variableValida = false;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
		while(!variableValida){
			try {
				System.out.println("Ingrese un caracter: ");
				variableLocal=entrada.readLine().charAt(0);
				
				if(esMinuscula(variableLocal)){
					System.out.println("Vale para el ejer.");
					variableValida = true;
				}
				
			} catch (Exception exc) {
				// TODO: handle exception
				System.out.println(exc);
			}
		}
		return variableLocal;
	}

	private static boolean esMinuscula(char variableLocal) {
		// TODO Auto-generated method stub
		return variableLocal >= 'a' && variableLocal <= 'z';
	}

}
