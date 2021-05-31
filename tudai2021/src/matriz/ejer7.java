package matriz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**/

public class ejer7 {
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
		int pos = 0;
		
		System.out.println("Matriz Original");
		imprimir_matriz_int(matint);
		System.out.println("Ingrese el valor ");
		usuario=pedirValor();
		System.out.println("Ingrese fila ");
		fila = pedirValor();
		
		procesar(matint, fila,usuario,pos);
		
		System.out.println("Matriz Final");
		imprimir_matriz_int(matint);

	}
	private static void procesar(int[][] matint, int fila, int usuario, int pos) {
		// TODO Auto-generated method stub
		for (int i = 0; i < MAXCOLUMNA; i++) {
			if (i==fila) {
				pos =buscarValor(matint[i], usuario, pos);
				insertarValor(matint[i],usuario, pos);
				
			}
		}
	}
	private static void insertarValor(int[] arr, int usuario, int pos) {
		// TODO Auto-generated method stub
		corrimientoDerecha(arr,pos);
		arr[pos]=usuario;
		
		
	}
	
	private static int buscarValor(int[] matint, int usuario, int pos) {
		System.out.println("Entro");
		// TODO Auto-generated method stub
		for (int i = 0; i < MAXCOLUMNA; i++) {
			if (matint[i] <= usuario) {
				pos++;
			}
		}
		System.out.println(pos);
		return pos;
	}
	
	private static void corrimientoDerecha(int[] arr, int pos) {
		// TODO Auto-generated method stub
		int indice = MAXCOLUMNA-1;//El indice desde el final
		while (indice > pos){
			arr[indice] = arr[indice-1];
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
