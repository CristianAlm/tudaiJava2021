package disenioDescendente;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Escribir un programa que mientras que el usuario ingrese un caracter letra
	minúscula, pida ingresar un numero entero. Si el número ingresado está
	entre 1 y 5 inclusive deberá imprimir la tabla de multiplicar de dicho
	numero.
 * */

public class ejer8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char usuario = pedirCaracter();
		
		ejercicio(usuario);
		
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

	private static void ejercicio(char usuario) {
		// TODO Auto-generated method stub
		if (esMinuscula(usuario)) {
			int numUsuario = pedirValor();
			if(esNumValido(numUsuario)){
				imprimirTabla(numUsuario);
			}else{
				recursion(usuario);
			}
		}
		recursion(usuario);
	}

	private static void recursion(char usuario) {
		// TODO Auto-generated method stub
		usuario = pedirCaracter();
		ejercicio(usuario);
	}

	private static void imprimirTabla(int numUsuario) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 10; i++) {
			System.out.println(i*numUsuario + "| ");
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

	private static boolean esNumValido(int numUsuario) {
		// TODO Auto-generated method stub
		return numUsuario >=1 && numUsuario <=5;
	}

	private static boolean esMinuscula(char usuario) {
		// TODO Auto-generated method stub
		return usuario >= 'a' && usuario <= 'z';
	}

}
