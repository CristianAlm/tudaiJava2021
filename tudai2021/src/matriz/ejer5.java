package matriz;
/*
 * Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
	precargada, solicite al usuario un numero entero y elimine la primer ocurrencia de numero
	en la matriz (un número igual) si existe. Para ello tendrá que buscar la posición y si está,
	realizar un corrimiento a izquierda y no continuar buscando.
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ejer5 {
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
		int usuario;
		
		System.out.println("Matriz original");
		imprimir_matriz_int(matint);
		System.out.println("Ingrese el valor ");
		usuario=pedirValor();
		System.out.println("Ingrese fila ");
		
		System.out.println("El valor es " + usuario);
		
		borrarOcurrencia(matint, usuario);
		
		System.out.println("Matriz final");
		imprimir_matriz_int(matint);
	}
	
	private static void borrarOcurrencia(int[][] matint, int usuario) {
		// TODO Auto-generated method stub
		for (int fila = 0; fila < MAXFILA; fila++) {
			for (int columna = 0; columna < MAXCOLUMNA; columna++) {
				if(matint[fila][columna]==usuario){
					corrimientoIzquierda(matint, fila, columna);
				}
				
			}
		}
		
	}
	private static void corrimientoIzquierda(int[][] matint, int fila, int columna) {
		// TODO Auto-generated method stub
		while(fila < MAXFILA-1){
			while (columna<MAXCOLUMNA-1) {
				matint[fila][columna]=matint[fila][columna+1];
				columna++;
			}
			fila++;
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
