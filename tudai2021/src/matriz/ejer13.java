package matriz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
/*
 * Hacer un programa que dada la matriz de secuencias de enteros definida y
	precargada, y un número entero ingresado por el usuario, elimine de cada fila
	las secuencias de tamaño igual al número ingresado.
 * */

public class ejer13 {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 25;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] matint;
		matint = new int[MAXFILA][MAXCOLUMNA];
		int usuario;
		
		cargar_matriz_aleatorio_secuencias_int(matint);
		System.out.println("Matriz Original");
		imprimir_matriz_int_secuencias(matint);
		
		usuario = pedirValor();
		
		tratarMatriz(matint, usuario);			
		
		
		System.out.println("Matriz Final");
		imprimir_matriz_int_secuencias(matint);
		
		
	}
	private static void tratarMatriz(int[][] matint, int usuario) {
		// TODO Auto-generated method stub
		for (int fila = 0; fila < MAXFILA; fila++) {
			resolver(matint[fila],usuario);
		}
	}
	
	private static void resolver(int[] arr, int usuario) {
		// TODO Auto-generated method stub
		
		int posIni = 0,posFin;
		
		while (posIni<MAXCOLUMNA) {
			posIni=obtenerInicio(arr,posIni);
			if (posIni!=-1) {
				posFin=obtenerFin(arr,posIni);
				if (posFin!=-1) {
					if(esValido(usuario, posIni, posFin)){
						System.out.println("La pos Inicial es " + posIni + " y la pos Final es " + posFin);
						corrimientoIzquierda(arr, posIni, posFin, usuario);//Aca hay que hacer un corrimiento a izquierda
						//System.out.println("El numero elegido por el usuario es: " + usuario + " y tamanio es " + (posFin - (posIni-1)));
						posIni=0;
					}else{
						posIni=posFin+1;						
					}
				} else {
					posIni=MAXCOLUMNA;
				}
			} else {
				posIni=MAXCOLUMNA;
			}
		}
	}
	
	private static void corrimientoIzquierda(int[] arr, int posIni, int posFin, int usuario) {
		// TODO Auto-generated method stub
		
		int indice = posIni;
		while(indice<=posFin){
			corrimiento_izq(arr,posIni);
		indice++;
		}
		
		/*for (int i = posFin+1; i < MAXCOLUMNA; i++) {
			arr[i-usuario] = arr[i];
		}*/
		
	}
	public static void corrimiento_izq(int []arr,int indice ){
		
		for(int i=indice;i< MAXCOLUMNA-1;i++){
			arr[i]=arr[i+1];
		}
	}
	private static boolean esValido(int usuario, int posIni, int posFin) {
		// TODO Auto-generated method stub
		int sirve =(posFin - (posIni-1));
		if(sirve ==usuario){
			return true;			
		}else{
			return false;
		}
	}
	
	private static int obtenerFin(int[] arrint, int posIni) {
		// TODO Auto-generated method stub
		int i=posIni;
		while ((i < MAXCOLUMNA)&&(arrint[i]!=0)) {
			i++;
		}if (i<MAXCOLUMNA) {
			return i-1;
		} else {
			return -1;
		}
	}
	private static int obtenerInicio(int[] arrint, int posIni) {
		// TODO Auto-generated method stub
		int i = posIni;
		while (i <MAXCOLUMNA && arrint[i]==0) {
			i++;
		}
		if (i<MAXCOLUMNA) {
			return i;
		} else {
			return-1;
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
			if ((variableLocal>=0)&&(variableLocal<MAXCOLUMNA)) {
				variableValida=false;
			}
		} while (variableValida);
		
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
					}else{
						mat[fila][pos]=0;
					}
				}
			}
		}

}
