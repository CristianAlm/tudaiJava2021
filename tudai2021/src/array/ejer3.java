package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
	precargado, solicite al usuario una posición y realice un corrimiento a izquierda o hacia la
	menor posición del arreglo.
 * */

public class ejer3 {

	public static int MAX = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		int usuario;
		System.out.println("Arreglo original");
		imprimirArray(arr);
		usuario = pedirValor();
		System.out.println("");
		solucion(usuario,arr);
		
	}

	private static void solucion(int usuario, int[] arr) {
		// TODO Auto-generated method stub
		arr = corrimiento(usuario, arr);
		imprimirArray(arr);
		usuario = pedirValor();
		solucion(usuario,arr);
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
		boolean variableValida = false;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			try {
				System.out.println("Ingrese el valor de 0 a 9: ");
				variableLocal=Integer.valueOf(entrada.readLine());
				
				if (esValida(variableLocal)) {
					variableValida=true;
				}
				
			} catch (Exception exc) {
				// TODO: handle exception
				System.out.println(exc);
			}			
		} while (!variableValida);
		
		
		return variableLocal;
	}

	private static boolean esValida(int variableLocal) {
		// TODO Auto-generated method stub
		return variableLocal < MAX;
	}

	private static int[] corrimiento(int pos, int[] arr) {
		// TODO Auto-generated method stub
		int indice = 0;
		while (indice < pos) {
			arr[indice]=arr[indice+1];
			indice++;
		}
		return arr;
	}

}
