package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Hacer un programa que dado un arreglo de enteros de tama�o 10 que se encuentra
	precargado, solicite al usuario un numero entero y lo agregue al principio del arreglo (posici�n
	0). Para ello tendr� que realizar un corrimiento a derecha (se pierde el �ltimo valor del arreglo) y
	colocar el numero en el arreglo en la posici�n indicada.
 * */

public class ejer4 {

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
		corrimientoDerecha(arr);
		insertarValor(arr, usuario);
		
	}

	private static void insertarValor(int[] arr, int usuario) {
		// TODO Auto-generated method stub
		arr[0]= usuario;
	}

	private static void corrimientoDerecha(int[] arr) {
		// TODO Auto-generated method stub
		int indice = arr.length-1;
		while (indice > 0) {
			arr[indice] = arr[indice-1];
			indice--;
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

	private static void imprimirArray(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "| ");
		}
	}

}
