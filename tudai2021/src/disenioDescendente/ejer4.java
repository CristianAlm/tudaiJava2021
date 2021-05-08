package disenioDescendente;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Escribir un programa que mientras el usuario cargue desde
	teclado un numero entero distinto de 0, imprima por
	pantalla la suma que se obtiene de invocar un método
	que calcula la sumatoria de los primeros 200 números
	naturales (son números enteros en 1 y 200).
 * */

public class ejer4 {
	
	public static final int SUMATORIA = 200;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int usuario = pedirValor();
		
		imprimirSumatoria(SUMATORIA);

	}
	private static int pedirValor() {
		// TODO Auto-generated method stub
		int variableLocal=0;
		boolean variableValida = false;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		while (!variableValida) {
			try {
				System.out.println("Ingrese el valor: ");
				variableLocal=Integer.valueOf(entrada.readLine());
				
				if (esDigito(variableLocal)) {
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
	private static boolean esDigito(int usuario) {
		// TODO Auto-generated method stub
		return usuario >= 0 && usuario <= 9;
	}
	private static void imprimirSumatoria(int sumatoria2) {
		// TODO Auto-generated method stub
		int variableLocal = 0;
		
		for (int i = 1; i <= SUMATORIA; i++) {
			variableLocal += i;
		}
		
		System.out.println(variableLocal);
	}

}
