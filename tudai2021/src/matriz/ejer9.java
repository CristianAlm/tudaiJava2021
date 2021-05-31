package matriz;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Hacer un programa que dado una matriz de enteros de tamaño 4*5 que
	se encuentra precargada, solicite al usuario el ingreso de una fila y dos
	números enteros (columnas de la matriz), y ordene de forma creciente la
	matriz en la fila indicada entre las dos posiciones columnas ingresadas.
 * */

public class ejer9 {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] matint ={{0,1,2,3,4,5,6,45,97,99},
				{50,91,12,13,64,15,16,17,58,49},
				{99,81,22,23,46,25,26,27,28,49},
				{99,98,32,33,94,35,36,37,38,89},
				{99,99,42,16,44,45,46,47,48,99}
				};
		int fila, colIni, colFin;
		
		System.out.println("Matriz Original");
		imprimir_matriz_int(matint);
		System.out.println("Ingrese el valor ");
		colIni=pedirValor();
		System.out.println("Ingrese el valor ");
		colFin=pedirValor();
		System.out.println("Ingrese fila ");
		fila = pedirValor();
		
		burbujeo(matint[fila], colIni,colFin);
		
		System.out.println("Matriz Final");
		imprimir_matriz_int(matint);

	}
	
	private static void burbujeo(int[] arr, int colIni, int colFin) {
		// TODO Auto-generated method stub
		int temp;
		for(int i = colIni;i <=colFin;i++){
			for (int j = colIni ; j <= colFin - 1; j++){
				if (arr[j] > arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	private static int pedirValor() {
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
