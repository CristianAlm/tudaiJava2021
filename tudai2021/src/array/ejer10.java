package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*
 * Hacer un programa que dado el arreglo definido y precargado
 * 
 *permita obtener a través de métodos la posición de inicio y la posición de fin de la
	secuencia ubicada a partir de una posición entera ingresada por el
	usuario.

 Finalmente, si existen imprima por pantalla ambas posiciones obtenidas.
 * */

public class ejer10 {
	public static final int MAX = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_letra = 0.4;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr;
		arr = new int[MAX];
		cargar_arreglo_aleatorio_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr);
		int usuario = pedirValor();
		int posIni = 0, posFin = 0;
		
		verifySecuence(arr, usuario, posIni, posFin);
		
	}

	private static void verifySecuence(int[] arr, int usuario, int posIni, int posFin) {
		// TODO Auto-generated method stub
		while (usuario < MAX) {
			posIni = obtenerInicio(arr, posIni);
				if(posIni != -1){
					posFin = obtenerFin(arr, posIni);
					if (posFin !=-1) {
						if (usuario == posIni) {
							System.out.println("Hay una secuencia en la posicion " + usuario + " elegida por el usuario");
						}else{
							System.out.println("Hay secuencia en");
							posIni = obtenerInicio(arr, posIni);
						}
					}
					
				}
			}
		}
	
	private static int obtenerFin(int[] arrint, int posIni) {
		// TODO Auto-generated method stub
		int i=posIni;
		while ((i<MAX)&&(arrint[i]!=0)) {
			i++;
		}if (i<MAX) {
			return i-1;
		} else {
			return -1;
		}
	}
	private static int obtenerInicio(int[] arrint, int posIni) {
		// TODO Auto-generated method stub
		int i=posIni;
		while ((i<MAX)&&(arrint[i]==0)) {
			i++;
		}
		if (i<MAX) {
			return i;
		} else {
			return -1;
		}
	}
	
	private static int pedirValor() {
		// TODO Auto-generated method stub
		int variableLocal=0;
		boolean variableValida=true;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		do{
			try {
				System.out.println("Introduzca un numero: ");
				variableLocal=Integer.valueOf(entrada.readLine());
			} catch (Exception exc) {
				// TODO: handle exception
				System.out.println(exc);
			}
			if ((variableLocal>=0)&&(variableLocal<MAX)) {
				variableValida=false;
			}
		} while (variableValida);
		
		return variableLocal;
	}
	public static void cargar_arreglo_aleatorio_secuencias_int(int []arr){
		Random r = new Random();
		arr[0] = 0;
		arr[MAX-1] = 0;
		for (int pos = 1; pos < MAX-1; pos++){
			if (r.nextDouble()>probabilidad_numero){
				arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
			}else{
				arr[pos]=0;
			}
		}
	}
	public static void imprimir_arreglo_secuencias_int(int [] arr){
		System.out.print("Arreglo de secuencias int\n|");
		for (int pos = 0; pos < MAX; pos++){
			System.out.print(arr[pos]+"|");
		}
		System.out.print("\n");
	}

}
