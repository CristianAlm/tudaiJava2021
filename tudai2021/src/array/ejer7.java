package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Hacer un programa que dado un arreglo ordenado creciente de enteros
	de tamaño 10 que se encuentra precargado, solicite al usuario un numero
	entero y lo inserte en el arreglo manteniendo su orden. Para ello tendrá
	que realizar un corrimiento a derecha (se pierde el último valor del arreglo)
	y colocar el numero en el arreglo en la posición indicada.
 * */

public class ejer7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,3,5,7,9,11,15,17,19,21};
		int usuario;
		System.out.println("Arreglo original");
		imprimirArray(arr);
		System.out.println();
		usuario = pedirValor();
		System.out.println("");
		insertarValor(usuario,arr);
		imprimirArray(arr);
	}
	
	
	private static void insertarValor(int usuario, int[] arr) {
		// TODO Auto-generated method stub
		corrimientoDerecha(arr);
		arr[0]=usuario;
		ordenar(arr);
		imprimirArray(arr);
		usuario = pedirValor();
		insertarValor(usuario,arr);
	}

	private static void ordenar(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length-1; i++) {
			if (arr[i] > arr[i+1]) {
				int aux = arr[i+1];
				arr[i+1] = arr[i];
				arr[i] = aux;
			}
		}
	}


	private static void corrimientoDerecha(int[] arr) {
		// TODO Auto-generated method stub
		int indice = arr.length -1;
		while (indice > 0){
			arr[indice] = arr[indice-1];
			indice--;
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
