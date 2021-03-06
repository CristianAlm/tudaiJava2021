package disenioDescendente;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Escribir un programa que mientras el usuario ingrese un n?mero entero
	entre 1 y 10, pida ingresar un caracter, y por cada caracter ingresado
	imprima:
? ?letra min?scula? si el caracter es una letra del abecedario en min?scula;
? ?letra may?scula? si el caracter es una letra del abecedario en may?scula;
? ?d?gito? si el caracter corresponde a un car?cter n?mero;
? ?otro? para los restantes casos de caracteres.
 * */

public class ejer10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int usuario = pedirValor();
		
		utilizarValor(usuario);
		
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

	private static void utilizarValor(int usuario) {
		// TODO Auto-generated method stub
		if (esValido(usuario)) {
			char caracter = pedirCaracter();
			if (esMinuscula(caracter)) {
				System.out.println("Es minuscula");
				reutilizar(usuario);
			}else if (esMayuscula(caracter)) {
				System.out.println("Es mayuscula");
				reutilizar(usuario);
			}else if (esDigito(caracter)) {
				System.out.println("Es un digito");
				reutilizar(usuario);
			}else {
				System.out.println("Es otro caracter");
				reutilizar(usuario);
			}
		}else {
			reutilizar(usuario);
		}
	}

	private static boolean esDigito(char caracter) {
		// TODO Auto-generated method stub
		return caracter >= '0' && caracter <= '9';
	}

	private static boolean esMayuscula(char caracter) {
		// TODO Auto-generated method stub
		return caracter >= 'A' && caracter <= 'Z';
	}

	private static boolean esMinuscula(char caracter) {
		// TODO Auto-generated method stub
		return caracter >= 'a' && caracter <= 'z';
	}

	private static boolean esValido(int usuario) {
		// TODO Auto-generated method stub
		return usuario > 0 && usuario <= 10;
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

	private static void reutilizar(int usuario) {
		// TODO Auto-generated method stub
		usuario = pedirValor();
		utilizarValor(usuario);
	}

}
