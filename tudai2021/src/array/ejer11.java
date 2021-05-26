package array;

import java.util.Random;

/*Hacer un programa que dado el arreglo definido y precargado
 * 
 *  permita encontrar la posición de inicio y fin de la secuencia cuya suma de valores sea mayor.*/

public class ejer11 {
	
	public static final int MAX = 40;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array;
		array = new int[MAX];
		int posIni=0,posFin=0,suma=0,sumaMayor=0,posIniMayor=0,posFinMayor=0;
		
		cargar_arreglo_aleatorio_secuencias_int(array);
		imprimir_arreglo_secuencias_int(array);
		System.out.println("");
		mirarSecuencia(array,posIni,posFin,suma,posIniMayor,posFinMayor,sumaMayor);
	}

	private static void mirarSecuencia(int[] arrint, int posIni, int posFin, int suma, int posIniMayor, int posFinMayor, int sumaMayor) {
		// TODO Auto-generated method stub
		while (posIni<MAX) {
			posIni=obtenerIniSecuencia(arrint,posIni);
			if (posIni!=-1) {
				posFin=obtenerFinSecuencia(arrint,posIni);
				if (posFin!=-1) {
					System.out.println("La posicion inicial es: "+posIni+" y la posicion final es: "+posFin);
					
					suma=sumaSecuencia(arrint,posIni,posFin);
					if (suma>sumaMayor) {
						sumaMayor=suma;
						posIniMayor=posIni;
						posFinMayor=posFin;
					}
					posIni=posFin+1;
				} else {
					posIni=MAX;
				}
			} else {
				posIni=MAX;
			}
		}
		System.out.println("");
		System.out.println("La mayor secuencia suma: "+sumaMayor+ " y la pos inicial: " + posIniMayor+" y la final es: "+ posFinMayor);
	}

	private static int sumaSecuencia(int[] arrint, int posIni, int posFin) {
		// TODO Auto-generated method stub
		int suma=0;
		for (int i = posIni; i <= posFin; i++) {
			suma+=arrint[i];
		}
		return suma;
	}

	private static int obtenerFinSecuencia(int[] arrint, int posIni) {
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

	private static int obtenerIniSecuencia(int[] arrint, int posIni) {
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
