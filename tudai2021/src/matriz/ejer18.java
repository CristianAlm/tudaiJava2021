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
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ejer18 {

	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 15;
	public static final int MAXVALOR = 10;
	public static final int MINVALOR = 1;
	//private static final double probabilidad_letra = 0.3;
	public static void main(String[] args) {
		
		char [][] mat;                  
		int [] cantVocales;
		mat = new char[MAXFILA][MAXCOLUMNA];                  
		cantVocales = new int[MAXFILA];
		
		cargar_matriz_aleatorio_secuencias_char(mat);
		imprimir_matriz_secuencias_char(mat);
		cargar_indices_filas_arreglo(cantVocales);
		
		System.out.println("");
		
		ordenar_arreglo_indice_seleccion(mat, cantVocales);
		imprimir_arreglo(cantVocales);
		
		
		System.out.println("Ingrese num de fila");
		int numFila = pedirValorInt();
		
		System.out.println("");
		
		
		eliminar(mat, numFila, cantVocales);
		imprimir_matriz_secuencias_char(mat);
		
		System.out.println("");
		
		imprimir_arreglo(cantVocales);
	}

	private static void eliminar(char[][] mat, int numFila, int[] cantVocales) {
		eliminarFila(mat, numFila);
		correrAIzquierda(cantVocales,numFila);
	}

	 public static void correrAIzquierda(int[] arr, int numFila){ //junto con la de arriba
		  for(int i = 0; i < MAXFILA; i++){
			  if (numFila == arr[i]) {
				   int pos = i;
					while (pos < MAXFILA-1){
						arr[pos] = arr[pos+1];
						pos++;
								
					}
					arr[MAXFILA-1] = -1;
			
			}
		    
		}
	 }
	private static void eliminarFila(char[][] mat, int numFila) {
		for(int i = numFila; i < MAXFILA-1; i++){
			mat[i] = mat[1+i];
		}
	}
		
	

	private static int pedirValorInt() {
		// TODO Auto-generated method stub
		int variableLocal=0;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

		try {
			variableLocal=Integer.valueOf(entrada.readLine());
		} catch (Exception exc) {
			// TODO: handle exception
			System.out.println(exc);
		}			
		return variableLocal;
	}
	
	public static void ordenar_arreglo_indice_seleccion(char[][] original, int arr[]) {
		int pos_menor, tmp;
		int i, j;
		i = 0;
		while (i < MAXFILA) { 
			pos_menor = i;
			j = i + 1;
			while (j < MAXFILA){ 	
				if (cantidadVocales(original[arr[j]]) > cantidadVocales(original[arr[pos_menor]])) { 	
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
	
	public static int cantidadVocales(char[] a){ // CANTIDAD DE VOCALES
	    int cant = 0;
	    for(int i = 0; i < MAXCOLUMNA; i++){
	        if(esVocal(a[i]))
	            cant++;
	    }
	    return cant;
	}

	public static boolean esVocal(char a){
	    return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u';
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
	
	public static void cargar_matriz_aleatorio_secuencias_char(char [][] mat){
		for (int fila = 0; fila < MAXFILA; fila++){
		
			Random r = new Random();
			//mat[fila][0] = ' ';
			//mat[fila][MAXCOLUMNA-1] = ' ';
			for (int pos = 0; pos < MAXCOLUMNA; pos++){
				
			mat[fila][pos]=(char)(r.nextInt(26) + 'a');
			
					}			
				}
		}
		
	public static void imprimir_matriz_secuencias_char(char [][] mat){
		for (int fila = 0; fila < MAXFILA; fila++){
			System.out.print("|");
			for (int pos = 0; pos < MAXCOLUMNA; pos++){
				System.out.print(mat[fila][pos]+"|");
			}
			System.out.print("\n");
		}
			}
	public static void cargar_indices_filas_arreglo(int [] arr){
		for (int fila = 0; fila < MAXFILA; fila++){
			arr[fila] = fila;
		}
	}
	
	
}