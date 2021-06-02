package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*
 * Hacer un programa que dado el arreglo definido y precargado, y un n�mero
	entero ingresado por el usuario, copie de forma continua las secuencias de
	tama�o igual al n�mero ingresado en otro arreglo de iguales caracter�sticas e
	inicializado con 0. La copia en este �ltimo arreglo deben comenzar desde el
	principio del mismo.
 * */

public class ejer14 {
	
	public static final int MAX = 40;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr;
		int[] arr2;
		arr = new int[MAX];
		arr2 = new int[MAX];
		
		cargar_arreglo_aleatorio_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr);
		
		int usuario = pedirValor();
		int indice = 0;
		
		resolver(arr, arr2, usuario, indice);
		imprimir_arreglo_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr2);
		
	}
	
	private static void resolver(int[] arr, int[] arr2, int usuario, int indice) {
		// TODO Auto-generated method stub
		
		int posIni = 0,posFin;
		
		while (posIni<MAX) {
			posIni=obtenerInicio(arr,posIni);
			if (posIni!=-1) {
				posFin=obtenerFin(arr,posIni);
				if (posFin!=-1) {
					if(esValido(usuario, posIni, posFin)){
						System.out.println("La pos Inicial es " + posIni + " y la pos Final es " + posFin);
						copiarDatos(arr,arr2, posIni,posFin,indice, usuario);
						System.out.println("El numero elegido por el usuario es: " + usuario + " y tamanio es " + (posFin - (posIni-1)));
						
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
	
	

	private static void copiarDatos(int[] arr, int[] arr2, int posIni,
			int posFin, int indice, int numero) {
		// TODO Auto-generated method stub
		int posicionCero = devolverPrimerCero(arr2);
		
		indice = posicionCero;
		for (int i = posIni; i <=posFin; i++) {
			if (arr2[indice]==0) {
				arr2[indice]=arr[i];
				indice++;
			}
		}
				
			
			indice++;
		}
	private static int devolverPrimerCero(int[] arr2) {
		int posicion = 0;
				while (arr2[posicion] != 0){
					posicion++;
				}
					
		return posicion;
	}
	

	private static boolean esValido(int usuario, int posIni, int posFin) {
		// TODO Auto-generated method stub
		return usuario==(posFin - (posIni-1));
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
}
