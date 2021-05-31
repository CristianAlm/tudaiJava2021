package matriz;

/*
 * Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
	precargada, obtenga la cantidad de números pares que tiene y la imprima.
 * */

public class ejer2 {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] matint ={{0,1,2,3,4,5,6,7,8,9},
				{10,11,12,13,14,15,16,17,18,19},
				{20,21,22,23,24,25,26,27,28,29},
				{30,31,32,33,34,35,36,37,38,39},
				{40,41,42,43,44,45,46,47,48,49}
				};
		System.out.println("Matriz original");
		imprimir_matriz_int(matint);
		
		int counting = contarPar(matint);
		System.out.println("La cantidad de pares es " + counting);

	}
	private static int contarPar(int[][] matint) {
		// TODO Auto-generated method stub
		int contadorLocal=0;
		for (int i = 0; i < MAXFILA; i++) {
			contadorLocal=contarEnFila(matint[i],contadorLocal);
		}
		
		return contadorLocal;
	}
	private static int contarEnFila(int[] arr, int contadorLocal) {
		for (int i = 0; i < arr.length; i++) {
			if(esPar(arr[i])){
				contadorLocal++;
			}
		}
		return contadorLocal;
	}
	private static boolean esPar(int i) {
		// TODO Auto-generated method stub
		return i%2==0;
	}
	public static void imprimir_matriz_int(int [][] mat){
		for (int fila = 0; fila < MAXFILA; fila++){
			System.out.print("|");
			for (int columna = 0; columna < MAXCOLUMNA; columna++){
				System.out.print(mat[fila][columna]+"|");
			}
			System.out.println("");
		}
	}
}
