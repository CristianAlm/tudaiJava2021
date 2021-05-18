package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Hacer un programa que dado un arreglo ordenado creciente de enteros
	de tamaño 10 que se encuentra precargado, solicite al usuario un numero
	entero y elimine la primer ocurrencia de numero (un número igual) en el
	arreglo si existe.
 * */

public class ejer8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,3,5,7,9,11,15,17,19,21};
		int usuario;
		System.out.println("Arreglo original");
		imprimirArray(arr);
		System.out.println();
		usuario = pedirValor();
		System.out.println();
		eliminarSecuencia(arr, usuario);
		imprimirArray(arr);
	}
	private static void eliminarSecuencia(int[] arr, int usuario) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==usuario){
				corrimientoIzquierda(i, arr);//Si va "i" le paso la posicion y si va "arr[i]" le paso el valor en esa posicion.				
			}
		}
		imprimirArray(arr);
		usuario = pedirValor();
		System.out.println();
		eliminarSecuencia(arr, usuario);
	}
	private static void corrimientoIzquierda(int indice, int[] arr) {
		// TODO Auto-generated method stub
		while (indice < arr.length-1) {
			arr[indice]=arr[indice+1];
			indice++;
		}
	}
	private static void imprimirArray(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "| ");
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
