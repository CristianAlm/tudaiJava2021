package array;

/*
 * Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
	precargado, invierta el orden del contenido (por ejemplo: el que está en 0 se intercambia con
	el que está en 9, el que está en 1 con el que está en 8...). Este intercambio no se debe realizar
	de manera explícita, hay que hacer un método que incluya una iteración de intercambio.
 * */

public class ejer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		
		imprimirArray(arr);
		System.out.println("");
		arr = intercambiar(arr);
		imprimirArray(arr);
	}

	private static int[] intercambiar(int[] arr) {
		// TODO Auto-generated method stub
		int arrayLocal[]=new int[arr.length];
		
		for(int i=0;i<arr.length;i++){
			arrayLocal[i]=arr[arr.length-1-i];
		}
		return arrayLocal;
	}

	private static void imprimirArray(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "| ");
		}
	}

}
