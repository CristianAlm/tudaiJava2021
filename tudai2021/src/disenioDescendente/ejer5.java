package disenioDescendente;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Escribir un programa que mientras el usuario ingresa un caracter distinto
	del caracter ‘*’, invoque a un método que imprima si es caracter dígito o
	caracter letra minúscula, y si es letra minúscula imprimir si es vocal o
	consonante.
 * */

public class ejer5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char usuario = pedirCaracter();
		
		realizar(usuario);
		
	}

	private static void realizar(char usuario) {
		// TODO Auto-generated method stub
		while (usuario != '*') {
			verifyCaracter(usuario);
			usuario = pedirCaracter();
		}
		while (usuario =='*') {
			usuario = pedirCaracter();
			realizar(usuario);
		}
	}

	private static char pedirCaracter() {
		// TODO Auto-generated method stub
		char variableLocal = 0;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Ingrese un caracter: ");
			variableLocal=entrada.readLine().charAt(0);
			
		} catch (Exception exc) {
			// TODO: handle exception
			System.out.println(exc);
		}
		return variableLocal;
	}

	private static void verifyCaracter(char usuario) {
		// TODO Auto-generated method stub
		if(esDigito(usuario)){
			System.out.println("Es digito");
		}else if (esMinuscula(usuario)) {
			System.out.println("Es minuscula");
			
			if(esVocal(usuario)){
				System.out.println("Es vocal");
			}else{
				System.out.println("Es consonante");
			}
		}else {
			System.out.println("Ninguna de las anteriores");
		}
	}

	private static boolean esVocal(char usuario) {
		// TODO Auto-generated method stub
		return usuario =='a' || usuario =='e' ||usuario =='i' ||usuario =='o' ||usuario =='u';
	}

	private static boolean esMinuscula(char variableLocal) {
		// TODO Auto-generated method stub
		return variableLocal >= 'a' && variableLocal <= 'z';
	}

	private static boolean esDigito(char usuario) {
		// TODO Auto-generated method stub
		return usuario >= '0' && usuario <= '9';
	}

}
