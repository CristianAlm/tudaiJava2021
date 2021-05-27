package array;

import java.util.Random;

/*
 * Hacer un programa que dado el arreglo definido y precargado
 * 
 *  permita encontrar la posición de inicio y fin de la anteúltima secuencia (considerar
comenzar a buscarla a partir de la ultima posición del arreglo)
 * */

public class ejer12 {
	
	public static final int MAX = 40;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array;
		array = new int[MAX];

		cargar_arreglo_aleatorio_secuencias_int(array);
		imprimir_arreglo_secuencias_int(array);
		
		buscarSecuencia(array);

	}
	
	private static void buscarSecuencia(int[] array) {
		// TODO Auto-generated method stub
		int posIni = MAX-1, posFin = 0;
		int cantidad =0;
	
		while (posIni<MAX && cantidad<2) {
			posIni=obtenerInicio(array,posIni);
			if (posIni!=-1) {
				posFin=obtenerFin(array,posIni);
				if (posFin!=-1) {
					if(cantidad==1){
						System.out.println("La posicion inicial es: "+posIni+" y la posicion final es: "+posFin);						
					}
					cantidad++;
					posIni=posFin-1;
					//System.out.println("La pos inicial que paso es " + posIni);
				} else {
					posIni=MAX;
				}
			} else {
				posIni=MAX;
			}
		}
		
		
	}

	private static int obtenerFin(int[] arrint, int posIni) {
		// TODO Auto-generated method stub
		int i=posIni;
		while ((i>=0)&&(arrint[i]!=0)) {
			i--;
		}if (i>=0) {
			return i+1;
		} else {
			return -1;
		}
	}
	private static int obtenerInicio(int[] arrint, int posIni) {
		// TODO Auto-generated method stub
		int i=posIni;
		while ((i>=0)&&(arrint[i]==0)) {
			i--;
		}
		if (i>=0) {
			return i;
		} else {
			return -1;
		}
	}

	private static void imprimir_arreglo_secuencias_int(int[] arr) {
		// TODO Auto-generated method stub
		System.out.print("Arreglo de secuencias int\n|");
		for (int pos = 0; pos < MAX; pos++){
			System.out.print(arr[pos]+"|");
		}
		System.out.print("\n");
	}

	private static void cargar_arreglo_aleatorio_secuencias_int(int[] arr) {
		// TODO Auto-generated method stub
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
	
}
