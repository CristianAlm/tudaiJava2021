package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
	precargado, solicite al usuario un numero entero y elimine la primer ocurrencia de numero (un
	número igual) en el arreglo si existe. Para ello tendrá que buscar la posición y si está, realizar un
	corrimiento a izquierda (queda una copia de la última posición del arreglo en la anteúltima
	posición).
 * */

public class ejer5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		int usuario;
		System.out.println("Arreglo original");
		imprimirArray(arr);
		System.out.println();
		usuario = pedirValor();
		System.out.println("");
		solucion(usuario,arr);
		imprimirArray(arr);
	}

	private static void solucion(int usuario, int[] arr) {
		// TODO Auto-generated method stub
		for (int indice = 0; indice < arr.length; indice++) {
			if (arr[indice]==usuario) {
				corrimientoIzquierda(arr, indice);
			}
		}
	}

	private static void corrimientoIzquierda(int[] arr, int indice) {
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
