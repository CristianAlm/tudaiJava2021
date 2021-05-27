package matriz;

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class matriz16 {
	
	public static int MAX_FILA = 10;
	public static int MAX_COLUMNA = 10;
	
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero = 0.4;

	public static void cargar_arreglo_aleatorio_secuencias_int(int[] arr) {
		Random r = new Random();
		arr[0] = 0;
		arr[MAX_COLUMNA - 1] = 0;
		for (int pos = 1; pos < MAX_COLUMNA - 1; pos++) {
			if (r.nextDouble() > probabilidad_numero) {
				arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
			} else {
				arr[pos] = 0;
			}
		}
	}
	
	public static void cargar_matriz_secuencias(int[][] matriz) {
		
		for (int fila = 0; fila < MAX_FILA; fila ++) {
			cargar_arreglo_aleatorio_secuencias_int(matriz[fila]);
		}
		
	}
	
	public static void imprimir_arreglo_int(int[] arr) {
		for (int pos = 0; pos < MAX_COLUMNA; pos++) {
			System.out.print(arr[pos] + " | ");
		}
	}
	
	public static void imprimir_matriz_int(int[][] matriz) {
		System.out.println("Matriz");
		for (int fila = 0; fila < MAX_FILA; fila++) {
			imprimir_arreglo_int(matriz[fila]);
			System.out.println();
		}
	}
	
	public static int inicioSecuencia(int[] arreglo, int indicePrevio) {
		int pos = indicePrevio;
		
		while (pos < MAX_COLUMNA && arreglo[pos] == 0) {
			pos++;
		}
		
		if (pos < MAX_COLUMNA)
			return pos;
		else
			return -1;
	}
	
	public static int finSecuencia(int[] arreglo, int inicio) {
		int pos = inicio;
		
		while (pos < MAX_COLUMNA && arreglo[pos] != 0) {
			pos++;
		}
		
		if (pos < MAX_COLUMNA)
			return pos - 1;
		else
			return -1;
	}
	
	public static boolean secuenciaOrdenDescendente(int inicio, int fin, int[] arreglo) {
		
		boolean ordenado = true;
		
		for (int i = inicio; i <= fin-1; i ++) {
			if (arreglo[i] < arreglo[i+1]) {
				ordenado = false;
			}
		}
		
		return ordenado;
	}
	
	public static void eliminarConCorrimiento(int inicio, int fin, int[] arreglo) {
		int tamanio = fin - inicio + 1;
		
		for (int i = fin+1; i < MAX_COLUMNA; i++) {
			arreglo[i-tamanio] = arreglo[i];
		}
		
	}
	
	
	public static void borrar_secuencias_descendentes_de_arreglo(int[] arreglo) {
		int inicio = inicioSecuencia(arreglo, 0);
		int fin = 0;
		
		while (inicio != -1) {
			fin = finSecuencia(arreglo, inicio);
			
			if (fin != -1) {
				
				if (secuenciaOrdenDescendente(inicio, fin, arreglo)) {
					eliminarConCorrimiento(inicio, fin, arreglo);
					inicio = inicioSecuencia(arreglo, inicio + 1);
				}else {
					inicio = inicioSecuencia(arreglo, fin + 1);
				}
			}
			
		}
	}
	
	public static void borrar_secuencias_descendentes(int[][] matriz) {
		
		for (int fila = 0; fila < MAX_FILA; fila++) {
			borrar_secuencias_descendentes_de_arreglo(matriz[fila]);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		int[][] matriz = new int[MAX_FILA][MAX_COLUMNA];
		cargar_matriz_secuencias(matriz);
		
		imprimir_matriz_int(matriz);
		
		borrar_secuencias_descendentes(matriz);
		
		imprimir_matriz_int(matriz);
	}

	
	
	

}
