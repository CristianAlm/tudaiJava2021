package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*
 * Hacer un programa que dado el arreglo definido y precargado, y un número
	entero ingresado por el usuario, elimine las secuencias de tamaño igual al
	número ingresado.
 * */

public class ejer13 {
	
	public static final int MAX = 40;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr;
		arr = new int[MAX];
		
		cargar_arreglo_aleatorio_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr);
		
		int usuario = pedirValor();
		
		resolver(arr,usuario);
		imprimir_arreglo_secuencias_int(arr);
	}
	
	private static void resolver(int[] arr, int usuario) {
		// TODO Auto-generated method stub
		
		int posIni = 0,posFin;
		
		while (posIni<MAX) {
			posIni=obtenerInicio(arr,posIni);
			if (posIni!=-1) {
				posFin=obtenerFin(arr,posIni);
				if (posFin!=-1) {
					if(esValido(usuario, posIni, posFin)){
						System.out.println("La pos Inicial es " + posIni + " y la pos Final es " + posFin);
						ponerCeros(arr, posIni,posFin);
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
	
	private static void ponerCeros(int[] arr, int posIni, int posFin) {
		// TODO Auto-generated method stub
		for (int i = posIni; i <= posFin; i++) {
			arr[i]=0;
		}
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
