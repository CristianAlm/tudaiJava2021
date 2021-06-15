package matriz;
/*
 * Se tiene una matriz MAT de caracteres letras minúsculas precargada, se pide:
	– cargar un arreglo ARR_CANT_VOCALES_FILAS_ORD los índices de las filas de MAT y
	ordenarlo de forma tal que permita mantener un orden decreciente de MAT por la
	cantidad de vocales de sus filas.
	– dada una fila ingresada por el usuario desde teclado, eliminar la fila de la matriz MAT
	y actualizar el arreglo ARR_CANT_VOCALES_FILAS_ORD (no hay que aplicar método
	de ordenamiento).
 * */

import java.util.Random;

public class ejer18 {

	public static int MAX_FILA = 10;
	public static int MAX_COLUMNA = 10;

	public static void imprimir_arreglo_int(char[] arr) {
		for (int pos = 0; pos < MAX_COLUMNA; pos++) {
			System.out.print(arr[pos] + " | ");
		}
	}

	public static void imprimir_matriz_int(char[][] matriz) {
		System.out.println("Matriz");
		for (int fila = 0; fila < MAX_FILA; fila++) {
			imprimir_arreglo_int(matriz[fila]);
			System.out.println();
		}
	}

	public static void cargar_matriz_aleatorio_char(char[][] mat) {
		Random r = new Random();
		for (int fila = 0; fila < MAX_FILA; fila++)
			for (int col = 0; col < MAX_COLUMNA; col++) {
				mat[fila][col] = (char) (r.nextInt(26) + 'a');
			}
	}

	public static void imprimir_arreglo_char(char[] arr) {
		for (int pos = 0; pos < MAX_COLUMNA; pos++) {
			System.out.print(arr[pos] + " | ");
		}
	}

	public static void imprimir_matriz_char(char[][] matriz) {
		System.out.println("Matriz");
		for (int fila = 0; fila < MAX_FILA; fila++) {
			imprimir_arreglo_char(matriz[fila]);
			System.out.println();
		}
	}

	public static void cargar_arreglo_indice(int[] arreglo) {
		for (int fila = 0; fila < MAX_FILA; fila++) {
			arreglo[fila] = fila;
		}
	}

	public static void imprimir_arreglo_indices(int[] arr) {
		for (int pos = 0; pos < MAX_COLUMNA; pos++) {
			System.out.print(arr[pos] + " | ");
		}
	}

	public static void ordenar_arreglo_burbujeo(int[] arr) {
		
	}

	public static boolean hayVocal(char caracter) {
		if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u')
			return true;
		else
			return false;
	}
	
	public static int cantidadVocalesFila(char[][] matriz, int fila) {
		int cantidad = 0;
		for (int col = 0; col < MAX_COLUMNA; col++) {
			if (hayVocal(matriz[fila][col])) {
				cantidad++;
			}
		}
		
		return cantidad;
	}
	
	public static void ordenar_arreglo_indices_segun_vocales(char[][] matriz, int[] arreglo) {
		int temp;
		for (int i = 1; i < MAX_FILA; i++) {
			for (int j = 0; j < MAX_FILA - 1; j++) {
				if ( cantidadVocalesFila(matriz, arreglo[j]) < cantidadVocalesFila(matriz, arreglo[j + 1])) {
					temp = arreglo[j];
					arreglo[j] = arreglo[j + 1];
					arreglo[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		char[][] matriz = new char[MAX_FILA][MAX_COLUMNA];

		cargar_matriz_aleatorio_char(matriz);
		imprimir_matriz_char(matriz);

		int[] ARR_CANT_VOCALES_FILAS_ORD = new int[MAX_FILA];
		cargar_arreglo_indice(ARR_CANT_VOCALES_FILAS_ORD);

		System.out.println();
		System.out.println("Arreglo de indices");
		imprimir_arreglo_indices(ARR_CANT_VOCALES_FILAS_ORD);

		ordenar_arreglo_indices_segun_vocales(matriz, ARR_CANT_VOCALES_FILAS_ORD);
		
		System.out.println();
		System.out.println("Arreglo de indices ordenado");
		imprimir_arreglo_indices(ARR_CANT_VOCALES_FILAS_ORD);

	}

}

