package matriz;

import java.util.Random;

public class ejer12 {
	  public static final int FILAS = 5;
		public static final int COLUMNAS = 15;

		public static final int MAXVALOR = 9;
		public static final int MINVALOR = 1;
		public static final double probabilidad_letra = 0.4;

		public static void cargar_arreglo_aleatorio_secuencias_char(char[] arr) {
			Random r = new Random();
			arr[0] = ' ';
			arr[COLUMNAS - 1] = ' ';
			for (int pos = 1; pos < COLUMNAS - 1; pos++) {
				if (r.nextDouble() > probabilidad_letra) {
					arr[pos] = (char) (r.nextInt(26) + 'a');
				} else {
					arr[pos] = ' ';
				}
			}
		}

		public static void imprimir_arreglo_secuencias_char(char[] arr) {
			for (int pos = 0; pos < COLUMNAS; pos++) {
				System.out.print(arr[pos] + "|");
			}
			System.out.print("\n");
		}
		
		public static void cargar_matriz_secuencias_char(char[][] matriz) {
			for (int fila = 0; fila < FILAS; fila++) {
				cargar_arreglo_aleatorio_secuencias_char(matriz[fila]);
			}
			
		}
		
		public static void imprimir_matriz_secuencias_char(char[][] matriz) {
			for (int fila = 0; fila < FILAS; fila++) {
				imprimir_arreglo_secuencias_char(matriz[fila]);
			}
			
		}
		
		
		public static int final_secuencia(char[] arreglo, int indice) {
			int pos = indice;
			
			while (pos >= 0 && arreglo[pos] == ' ') {
				pos--;
			}
			
			if (pos >= 0)
				return pos;
			else
				return -1;
		}
		
		public static int inicio_secuencia(char[] arreglo, int indice) {
			int pos = indice;
			
			while (pos >= 0 && arreglo[pos] != ' ') {
				pos--;
			}
			
			if (pos >= 0)
				return pos+1;
			else
				return -1;
		}
		
		public static void imprimir_indices_ante_ultima_secuencia_arreglo(char[] arreglo) {
			
			int inicio = -1;
			int fin = final_secuencia(arreglo, COLUMNAS-1);
			
			int contador = 0;
			
			int inicioAnteUltima = -1;
			int finAnteUltima = -1;
			
			
			while (fin != -1) {
				inicio = inicio_secuencia(arreglo, fin);
				
				if (inicio != -1) {
					System.out.println("   Hay una secuencia entre: " + inicio + " y " + fin + " --> es la " + contador + "° secuencia");
					
					if (contador == 1) {
						inicioAnteUltima = inicio;
						finAnteUltima = fin;
					}
					
					contador++;
					fin = final_secuencia(arreglo, inicio-1);
				}
			}
			
			if (inicioAnteUltima != -1 ) {
				System.out.println("-----------------------------------");
				System.out.println("El inicio y fin de la anteultima secuencia es: " + inicioAnteUltima + " y " + finAnteUltima);
				System.out.println("-----------------------------------");
			}else {
				System.out.println("No hay anteultima secuencia");
			}
			
			
			
		}
		
		public static void imprimir_indices_ante_ultima_secuencia_matriz(char[][] matriz) {
			for (int fila = 0; fila < FILAS; fila++) {
				System.out.println("Procesando fila " + fila);
				imprimir_indices_ante_ultima_secuencia_arreglo(matriz[fila]);
			} 
			
		}

		public static void main(String[] args) {
			
			char[][] matriz = new char[FILAS][COLUMNAS];
			cargar_matriz_secuencias_char(matriz);
			
			System.out.println("Matriz de secuencias");
			imprimir_matriz_secuencias_char(matriz);
			System.out.println();
			imprimir_indices_ante_ultima_secuencia_matriz(matriz);

		}
	}

