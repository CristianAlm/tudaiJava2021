package matriz;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Hacer un programa que dado una matriz ordenada creciente por filas de
	enteros de tamaño 4*5 que se encuentra precargada, solicite al usuario un
	numero entero y una fila, y elimine la primer ocurrencia de numero en la
	fila indicada (un número igual) si existe.
 * */

public class ejer8 {
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] matint ={
				{0,5,9,10,14},
				{16,19,22,25,29},
				{30,35,39,45,54},
				{60,65,72,85,99}
				};
		int usuario,fila;
		
		System.out.println("Matriz Original");
		imprimir_matriz_int(matint);
		System.out.println("Ingrese el valor ");
		usuario=pedirValor();
		System.out.println("Ingrese fila ");
		fila = pedirValor();
		
		eliminarOcurrencia(matint,usuario,fila);
		
		System.out.println("Matriz Final");
		imprimir_matriz_int(matint);

	}
	private static void eliminarOcurrencia(int[][] matint, int usuario, int fila) {
		// TODO Auto-generated method stub
		for(int i = 0; i < MAXCOLUMNA; i++){
			if(i==fila){
				tratarFila(matint[i],usuario);				
			}
		}
	}
	private static void tratarFila(int[] arr, int usuario) {
		// TODO Auto-generated method stub
		int i = 0;
		while(i < MAXCOLUMNA) {
			if(arr[i]==usuario){
				arr[i]=0;
				break;
			}
			i++;
		}
		if(i==MAXCOLUMNA){
			System.out.println("No existe");
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
