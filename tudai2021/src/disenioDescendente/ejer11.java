package disenioDescendente;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Escribir un programa que mientras el usuario ingrese un número entero
	entre 1 y 10 realice:
	– Si el numero ingresado es múltiplo de 3 pida ingresar un caracter, y para el caracter
	ingresado imprima a que tipo de carácter esta asociado:
	• “letra minúscula” si el caracter es una letra del abecedario en minúscula;
	• “letra mayúscula” si el caracter es una letra del abecedario en mayúscula;
	• “dígito” si el caracter corresponde a un carácter número;
	• “otro” para los restantes casos de caracteres.
	– Si el numero ingresado es múltiplo de 5 imprima la tabla de multiplicar del numero
	ingresado.
 * */

public class ejer11 {

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
			if (primerValido(usuario)) {
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
			}else if (segundoValido(usuario)) {
				mostrarTabla(usuario);
			}else {
				reutilizar(usuario);
			}
		}else {
			reutilizar(usuario);
		}
	}

	private static void mostrarTabla(int usuario) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 10; i++) {
			System.out.println(i*usuario +"| ");
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

	private static boolean segundoValido(int usuario) {
		// TODO Auto-generated method stub
		return (usuario%5) == 0;
	}

	private static boolean primerValido(int usuario) {
		// TODO Auto-generated method stub
		return (usuario%3) == 0;
	}

	private static boolean esValido(int usuario) {
		// TODO Auto-generated method stub
		return usuario > 0 && usuario <= 10;
	}

}
