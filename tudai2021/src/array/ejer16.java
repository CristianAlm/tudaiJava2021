package array;

import java.util.Random;

/*
 * Hacer un programa que dado el arreglo definido y precargado elimine todas
	las secuencias que tienen orden descendente entre sus elementos.
 * */

public class ejer16 {
	public static final int MAX = 40;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = new int[MAX];
		
		cargar_arreglo_aleatorio_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr);
		
		resolver(arr);

	}
	private static void resolver(int[] arr) {
		// TODO Auto-generated method stub
		int posIni = 0,posFin;
		
		while (posIni<MAX) {
			posIni=obtenerInicio(arr,posIni);
			if (posIni!=-1) {
				posFin=obtenerFin(arr,posIni);
				if (posFin!=-1) {
					System.out.println("La pos Inicial es " + posIni + " y la pos Final es " + posFin);
					
					if(esValido(arr,posIni,posFin)){
						System.out.println("Descendente");
					}
					posIni=posFin+1;
				} else {
					posIni=MAX;
				}
			} else {
				posIni=MAX;
			}
		}
		
	}
	private static boolean esValido(int[] arr, int posIni, int posFin) {
		// TODO Auto-generated method stub
		
		
		return ((arr[posIni+1] <= arr[posIni])&&(arr[posIni+1]!=0)) ;
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
	private static int obtenerFin(int[] arrint, int posIni) {
		// TODO Auto-generated method stub
		int i=posIni;
		while ((i < MAX)&&(arrint[i]!=0)) {
			i++;
		}if (i<MAX) {
			return i-1;
		} else {
			return -1;
		}
	}
	
	
	private static int obtenerInicio(int[] arrint, int posIni) {
		// TODO Auto-generated method stub
		int i = posIni;
		while (i <MAX && arrint[i]==0) {
			i++;
		}
		if (i<MAX) {
			return i;
		} else {
			return-1;
		}
	}
}
