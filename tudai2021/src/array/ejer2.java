package array;

/*
 * Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
	precargado, obtenga la cantidad de números pares que tiene y la imprima.
 * */

public class ejer2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {2,2,4,4,5,6,6,8,9,10};
		imprimirArray(arr);
		System.out.println("");
		int counting = contarPar(arr);
		System.out.println("La cantidad de pares son: " + counting);
	}

	private static int contarPar(int[] arr) {
		// TODO Auto-generated method stub
		int countingLocal = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(esPar(arr[i])){
				countingLocal++;
			}
		}
		return countingLocal;
	}

	

	private static boolean esPar(int i) {
		// TODO Auto-generated method stub
		return i%2==0;
	}

	private static void imprimirArray(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "| ");
		}
	}

}
