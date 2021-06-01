package matriz;

import java.util.Random;

/*
 * Hacer un programa que dada la matriz de secuencias de enteros definida y
	precargada permita encontrar por cada fila la posición de inicio y fin de la
	secuencia cuya suma de valores sea mayor.
 * */

public class ejer11 {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 15;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] matint;
		matint = new int[MAXFILA][MAXCOLUMNA];
		int suma = 0, posIniMayor = 0, posFinMayor = 0, sumaMayor = 0,filaMayor = 0;
		
		cargar_matriz_aleatorio_secuencias_int(matint);
		imprimir_matriz_int_secuencias(matint);
		
		//recorrerMatriz(matint);
		recorrer_secuencias_matriz(matint,suma,posIniMayor, posFinMayor, sumaMayor, filaMayor);


	}
	private static void recorrer_secuencias_matriz(int[][] matint,int suma,int posIniMayor, int posFinMayor, int sumaMayor, int filaMayor) {
		// TODO Auto-generated method stub
	for (int fila = 0; fila<MAXFILA; fila++){
		int posIni=0;
		int posFin=0;
		
		while (posIni < MAXCOLUMNA) {
			posIni=obtenerInicio(matint[fila],posIni);
			if (posIni != -1) {
				posFin=obtenerFin(matint[fila],posIni);
				if (posFin != -1) {
					suma = sumaSecuencia(matint[fila],posIni,posFin);
					if (suma>sumaMayor) {
						sumaMayor=suma;
						posIniMayor=posIni;
						posFinMayor=posFin;
						filaMayor=fila;
					}
					
					posIni = posFin+1;					
				}else {
					posIni=MAXCOLUMNA;
				}
			}else{
				posIni = MAXCOLUMNA;				
			}
		}
		
	}
	
System.out.println("Pos Ini es " + posIniMayor + " y la fin es " + posFinMayor + " y la suma de esa secuencia es "+ sumaMayor +"la fila es: "+filaMayor);
}
	
	/*
	public static void recorrerMatriz(int[][] matint) {
		// TODO Auto-generated method stub
		int sumaMayor = 0, posIniMayor = 0, posFinMayor = 0;
		int posIni=0,posFin=0,suma=0;
		
		for (int fila = 0; fila < MAXFILA; fila++) {
			mirarSecuencia(matint[fila], sumaMayor,posIniMayor,posFinMayor,posIni,posFin,suma);
		}
		System.out.println("La mfffffffffffffffffffffffffffayor secuencia suma: "+sumaMayor+ " y la pos inicial: " + posIniMayor+" y la final es: "+ posFinMayor);
	}

		
	public static void mirarSecuencia(int[] arr, int sumaMayor,int posIniMayor, int posFinMayor, int posIni, int posFin, int suma) {
		// TODO Auto-generated method stub
		
		while (posIni<MAXCOLUMNA) {
			posIni=obtenerInicio(arr,posIni);
			if (posIni!=-1) {
				posFin=obtenerFin(arr,posIni);
				if (posFin!=-1) {
					System.out.println("La posicion inicial es: "+posIni+" y la posicion final es: "+posFin);
					
					suma=sumaSecuencia(arr,posIni,posFin);
					if (suma>sumaMayor) {
						sumaMayor=suma;
						posIniMayor=posIni;
						posFinMayor=posFin;
					}
					posIni=posFin+1;
				} else {
					posIni=MAXCOLUMNA;
				}
			} else {
				posIni=MAXCOLUMNA;
			}
		}
		System.out.println("");
		System.out.println("La mayor secuencia suma: "+sumaMayor+ " y la pos inicial: " + posIniMayor+" y la final es: "+ posFinMayor);
	}
*/
	private static int sumaSecuencia(int[] arrint, int posIni, int posFin) {
		// TODO Auto-generated method stub
		int sumaLocal =0;
		for (int i = posIni; i <= posFin; i++) {
			sumaLocal += arrint[i];
		}
		return sumaLocal;
	}
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
					}else{
						mat[fila][pos]=0;
					}
				}
			}
		}

}
