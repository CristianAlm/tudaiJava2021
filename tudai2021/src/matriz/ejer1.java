package matriz;

/*
 * Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, invierta el orden del contenido por fila. Este intercambio no se debe realizar
de manera explícita, hay que hacer un método que incluya una iteración de intercambio.
 * */

public class ejer1 {
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
		System.out.println("Matriz original");
		imprimir_matriz_int(matint);
		invertirOrden(matint);
		System.out.println("Con Intercambio");
		imprimir_matriz_int(matint);

	}
	
	private static void invertirOrden(int[][] matint) {
		// TODO Auto-generated method stub
		for (int i = 0; i < MAXFILA; i++) {
			invertirFila(matint[i]);
		}
		
	}

	private static void invertirFila(int[] arr) {
		// TODO Auto-generated method stub
		
		int aux=0;
		for(int i=0;i<MAXCOLUMNA/2;i++){
			aux= arr[i];
			arr[i]=arr[MAXCOLUMNA-1-i];
			arr[MAXCOLUMNA-1-i]= aux;
		}
		
		/*
		 *int i=0;
		int j= MAXCOLUMNA-1;
		int aux=0;
		while (i<j) {
			aux=arr[i];
			arr[i]=arr[j];
			arr[j]=aux;
			i++;
			j--;
		} 
		 * */
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
