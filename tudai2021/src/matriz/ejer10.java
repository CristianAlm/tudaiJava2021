package matriz;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
/*
 * Hacer un programa que dada la matriz de secuencias de enteros definida
	y precargada, permita obtener a través de métodos la posición de inicio y
	la posición de fin de la secuencia ubicada a partir de una posición entera
	y una fila, ambas ingresadas por el usuario. Finalmente, si existen imprima
	por pantalla ambas posiciones obtenidas.
 * */

public class ejer10 {
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero = 0.4;
	public static void main(String[] args) {
		int [][] matint;
		int fila,pos1;
		matint = new int[MAXFILA][MAXCOLUMNA];
		
		cargar_matriz_aleatorio_secuencias_int(matint);
		imprimir_matriz_int_secuencias(matint);
		System.out.println("ingrese fila");
		fila=pedirValor();
		System.out.println("ingrese posicion ");
		pos1=pedirValor();
		recorrer_secuencias(matint[fila],pos1);
	}
	//OBTENER FIN DE SECUENCIA 
	private static int obtenerFin(int[] arrint, int posIni) {
				// TODO Auto-generated method stub
				int i=posIni;
				while ((i<MAXCOLUMNA)&&(arrint[i]!=0)) {
					i++;
				}if (i<MAXCOLUMNA) {
					return i-1;
				} else {
					return -1;
				}
			}
		
		//OBTENER INICIO DE SECUENCIA
	private static int obtenerInicio(int[] arrint, int posIni) {
				// TODO Auto-generated method stub
				int i=posIni;
				while ((i<MAXCOLUMNA)&&(arrint[i]==0)) {
					i++;
				}
				if (i<MAXCOLUMNA) {
					return i;
				} else {
					return -1;
				}
			}
		
		//RECORRER SECUENCIAS
	

	public static void recorrer_secuencias(int[] array, int pos1) {
			// TODO Auto-generated method stub
			int fin=0;
			while (pos1 < MAXCOLUMNA) {
				pos1=obtenerInicio(array,pos1);
				if (pos1 != -1) {
					fin=obtenerFin(array,pos1);
					if (fin != -1) {
						System.out.println("Pos Ini es " + pos1 + " y la fin es " + fin);
						pos1=MAXCOLUMNA;				
					}else {
						pos1=MAXCOLUMNA;
					}
				}else{
					pos1 = MAXCOLUMNA;				
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
	public static void imprimir_matriz_int_secuencias(int [][] mat){
		for (int fila = 0; fila < MAXFILA; fila++){
			for (int pos = 0; pos < MAXCOLUMNA; pos++){
				System.out.print(mat[fila][pos]+"|");
				}
				System.out.print("\n");
				}
		}
	public static void cargar_matriz_aleatorio_secuencias_int(int [][]
			mat){
			for (int fila = 0; fila < MAXFILA; fila++){
				Random r = new Random();
				mat[fila][0] = 0;
				mat[fila][MAXCOLUMNA-1] = 0;
				for (int pos = 1; pos < MAXCOLUMNA-1; pos++){
				if (r.nextDouble()>probabilidad_numero){
				mat[fila][pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
				}
				else{
				mat[fila][pos]=0;
				}
				}
			}
			}
}
