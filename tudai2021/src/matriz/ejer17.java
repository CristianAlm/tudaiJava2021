package matriz;

import java.util.Random;

/*
 * Para el Ejemplo 10, hacer:
	– cargar un arreglo ARR_SUMAS_COLUMNAS_PARES los índices de las columnas de MAT
	cuya suma es par (-1 para completar si no hay).
	– ordenar ARR_SUMAS_COLUMNAS_PARES de forma ascendente según las sumas de
	columnas de MAT utilizando un método de ordenamiento.
 * */
public class ejer17 {


	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 5;
	public static final int MAXVALOR = 10;
	public static final int MINVALOR = 1;
	
	public static void main(String[] args) {
		int [][] mat;                  
		int [] arr_suma_filas_ord;
		int [] arr_suma_col_pares;  
		mat = new int[MAXFILA][MAXCOLUMNA];                  
		arr_suma_filas_ord = new int[MAXFILA];
		arr_suma_col_pares = new int [MAXCOLUMNA];
		
		cargar_matriz_aleatorio_int(mat);
		imprimir_matriz_int(mat);
		cargar_indices_filas_arreglo(arr_suma_filas_ord);
		inicializar_arreglo(arr_suma_col_pares);
		cargar_indices_col_arreglo(mat, arr_suma_col_pares);
		
		System.out.println("");
		
		ordenar_arreglo_indice_seleccion(mat,arr_suma_filas_ord);
		ordenar_arreglo_indice_col(mat,arr_suma_col_pares);
		imprimir_arreglo(arr_suma_filas_ord);
		imprimir_arreglo_col(arr_suma_col_pares);
	}



	private static void inicializar_arreglo(int[] arr) {
		for (int i = 0; i < MAXCOLUMNA; i++) {
			arr[i]=-1;
		}
	}

	public static void ordenar_arreglo_indice_col(int[][] original, int arr[]) {
		int pos_menor, tmp;
		int i, j;
		
		i = 0;
		while (i < MAXCOLUMNA) { 
			pos_menor = i;
			j = i + 1;
			while (j < MAXCOLUMNA && arr[j]!= -1){ 	
				if (sumaCol(original, arr[j]) < sumaCol(original, arr[pos_menor])) { 	
					pos_menor = j;
				}
				j++;
			}
			if (pos_menor != i){
				tmp = arr[i];
				arr[i] = arr[pos_menor];
				arr[pos_menor] = tmp;
			}
			i++;
		}
	}		
	
	
	public static void cargar_indices_col_arreglo(int[][] mat, int [] arr){
		int arreglo = 0;
		for (int col = 0; col < MAXCOLUMNA; col++){
			int sumaCol = sumaCol(mat, col);
				if (sumaCol %2==0) {
					arr[arreglo] = col;
					arreglo++;
			}
		}
	}



	private static int sumaCol(int[][] mat, int col) {
		int suma = 0;
		for (int fila = 0; fila < MAXFILA; fila++) {
			suma += mat[fila][col];
		}
		
		return suma;
	}


	public static void cargar_indices_filas_arreglo(int [] arr){
		for (int fila = 0; fila < MAXFILA; fila++){
			arr[fila] = fila;
		}
	}

	public static int obtener_suma_fila(int [] arr){
		int suma = 0;
		for (int columna = 0; columna < MAXCOLUMNA; columna++){
			suma += arr[columna];
		}
		return suma;
	}
	
	public static void ordenar_arreglo_indice_seleccion(int[][] original, int arr[]) {
		int pos_menor, tmp;
		int i, j;
		i = 0;
		while (i < MAXFILA) { 
			pos_menor = i;
			j = i + 1;
			while (j < MAXFILA){ 	
				if (obtener_suma_fila(original[arr[j]]) < obtener_suma_fila(original[arr[pos_menor]])) { 	
					pos_menor = j;
				}
				j++;
			}
			if (pos_menor != i){
				tmp = arr[i];
				arr[i] = arr[pos_menor];
				arr[pos_menor] = tmp;
			}
			i++;
		}
	}		
	
	public static void imprimir_arreglo(int [] arr){
		for (int pos = 0; pos < MAXFILA; pos++){
			System.out.print("|"+arr[pos]);
		}   
		System.out.println("|");
	} 
	
	public static void imprimir_arreglo_col(int [] arr){
		for (int pos = 0; pos < MAXCOLUMNA; pos++){
			System.out.print("|"+arr[pos]);
		}   
		System.out.println("|");
	} 
	
	public static void cargar_matriz_aleatorio_int(int [][] mat){
		Random r = new Random();
		for (int fila = 0; fila < MAXFILA; fila++){
			for (int columna = 0; columna < MAXCOLUMNA; columna++){
				mat[fila][columna]=(r.nextInt(MAXVALOR+MINVALOR-1) + MINVALOR);
			}
		}
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