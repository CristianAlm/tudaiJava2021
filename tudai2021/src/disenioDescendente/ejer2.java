package disenioDescendente;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Escribir un diseño de programa que mientras que el usuario
	ingrese un caracter dígito o caracter letra minúscula,
	imprima dicho caracter, y si es caracter letra minúscula,
	imprima si es vocal o consonante.
 * */

public class ejer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char usuario = pedirCaracter();
		
		procesarEjercicio(usuario);
		
	}

	private static void procesarEjercicio(char usuario) {
		// TODO Auto-generated method stub
		if (esVocal(usuario)) {
			System.out.println(usuario);
			System.out.println("Es una vocal.");
			
		}else if (esDigito(usuario)) {
			System.out.println(usuario);
			System.out.println("Es un digito");
		}
		else {
			System.out.println(usuario);
			System.out.println("Es una consonante y minuscula.");
		}
	}

	private static boolean esDigito(char usuario) {
		// TODO Auto-generated method stub
		return usuario >= '0' && usuario <= '9';
	}

	private static boolean esVocal(char usuario) {
		// TODO Auto-generated method stub
		return usuario =='a' || usuario =='e' ||usuario =='i' ||usuario =='o' ||usuario =='u';
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
				}else if (esDigito(variableLocal)) {
					System.out.println("Vale para el ejer.");
					variableValida = true;
				}
				else if (esMayuscula(variableLocal)) {
					System.out.println("No vale");
				}
				
			} catch (Exception exc) {
				// TODO: handle exception
				System.out.println(exc);
			}
		}
		return variableLocal;
	}

	private static boolean esMayuscula(char variableLocal) {
		// TODO Auto-generated method stub
		return variableLocal >= 'A' && variableLocal <= 'Z';
	}

	private static boolean esMinuscula(char variableLocal) {
		// TODO Auto-generated method stub
		return variableLocal >= 'a' && variableLocal <= 'z';
	}

}
