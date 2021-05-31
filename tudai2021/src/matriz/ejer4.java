package matriz;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
	precargada, solicite al usuario un numero entero y una posición fila, columna. Con estos
	datos tendrá que realizar un corrimiento a derecha (se pierde el último valor en dicha fila)
	y colocar el numero en la matriz en la posición fila, columna indicada.
 * */

public class ejer4 {
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
		int usuario, fila = 0, columna = 0;
		
		System.out.println("Matriz original");
		imprimir_matriz_int(matint);
		System.out.println("Ingrese el valor ");
		usuario=pedirValor();
		System.out.println("Ingrese fila ");
		fila = pedirValor();
		System.out.println("Ingrese columna ");
		columna=pedirValor();
		
		System.out.println("La fila es: " + fila + " columna " + columna + " y el valor es " + usuario);
		
		organizacion(matint, fila,columna);
		insertarValor(matint, fila,columna,usuario);
		
		imprimir_matriz_int(matint);
	}

	

	private static void insertarValor(int[][] matint, int fila, int columna,
			int usuario) {
		// TODO Auto-generated method stub
		matint[fila][columna]=usuario;	
	}

	private static void organizacion(int[][] matint, int fila,
			int columna) {
		// TODO Auto-generated method stub
		corrimientoDerecha(matint, fila,columna);
		
	}
	
	private static void corrimientoDerecha(int[][] matint, int fila, int columna) {
		// TODO Auto-generated method stub
		int indice = MAXCOLUMNA-1;
		while (indice > columna) {
			matint[fila][indice] = matint[fila][indice-1];
			indice--;
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
