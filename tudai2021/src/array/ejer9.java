package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Hacer un programa que dado un arreglo de enteros de tamaño 10 que se
	encuentra precargado, solicite al usuario el ingreso de dos números
	enteros (posiciones del arreglo) y ordene de forma creciente el arreglo
	entre dos posiciones correspondientes a los números ingresados.
 * */

public class ejer9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {21,19,17,15,11,9,7,5,3,1};
		int pos1, pos2;
		System.out.println("Arreglo original");
		imprimirArray(arr);
		System.out.println();
		pos1 = pedirValor();
		pos2 = pedirValor();
		ordenarSecuencia(pos1,pos2,arr);
		System.out.println();
		imprimirArray(arr);
	}
	private static void ordenarSecuencia(int pos1, int pos2, int[] arr) {
		// TODO Auto-generated method stub
		System.out.println("pos 1 " + pos1 + " y pos 2 es " + pos2);
		
		if(pos1 < pos2){
			burbujeo(pos1,pos2,arr);
		}
		
	}
	
	private static void burbujeo(int pos1, int pos2, int[] arr) {
		// TODO Auto-generated method stub
		int temp;
		for(int i = pos1;i <=pos2;i++){
			for (int j = pos1 ; j <= pos2 - 1; j++){
				if (arr[j] > arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
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
