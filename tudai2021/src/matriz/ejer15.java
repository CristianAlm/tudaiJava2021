package matriz;

import java.util.Random;
/*
 * Hacer un programa que dada la matriz de secuencias de caracteres definida y
precargada elimine todas las secuencias que tienen orden descendente entre
sus elementos.
 * */

public class ejer15 {
	public static final int FILAS = 5;
	public static final int COLUMNAS = 15;

	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_letra = 0.4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matriz = new char[FILAS][COLUMNAS];
		char[] patron = {' ', 'a', 'b', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
		int inicio=0,fin=0;
		int inicioPatron=obtenerInicio(patron,0);
		int finPatron=obtenerFin(patron,inicioPatron);
		cargar_matriz_secuencias_char(matriz);
		
		System.out.println("Matriz de secuencias");
		imprimir_matriz_secuencias_char(matriz);
		
		tratarMatriz(matriz, patron,inicio,fin,inicioPatron,finPatron);
		
		imprimir_matriz_secuencias_char(matriz);
	}
	private static void tratarMatriz(char[][] matriz, char[] patron, int inicio, int fin, int inicioPatron, int finPatron) {
		// TODO Auto-generated method stub
		for (int fila = 0; fila < FILAS; fila++) {
			recorrerArray(matriz[fila],patron,inicio,fin,inicioPatron,finPatron);
		}
	}
	
	private static void corrimientoIzquierda(char[] arr, int posIni, int posFin) {
		// TODO Auto-generated method stub
		
		int indice = posIni;
		while(indice<=posFin){
			corrimiento_izq(arr,posIni);
		indice++;
		}
		
	}
	public static void corrimiento_izq(char []arr,int indice ){
		
		for(int i=indice;i< COLUMNAS-1;i++){
			arr[i]=arr[i+1];
		}
	}
	private static void recorrerArray(char[] arr, char[] patron, int inicio, int fin, int inicioPatron, int finPatron) {
		// TODO Auto-generated method stub
		int posIni = inicio,posFin=fin;
		
		while (posIni<COLUMNAS) {
			posIni=obtenerInicio(arr,posIni);
			if (posIni!=-1) {
				posFin=obtenerFin(arr,posIni);
				if (posFin!=-1) {
					if(esValido(arr,posIni, posFin)){
						System.out.println("pos inicia original  "+posIni+"  pos final original  "+posFin);
						System.out.println("Son iguales");
						corrimientoIzquierda(arr,posIni,posFin);
						posIni=0;
						
					}else{
						posIni=posFin+1;
					}
											
				} else {
					posIni=COLUMNAS;
				}
			} else {
				posIni=COLUMNAS;
			}
		}
	}
	
	private static boolean esValido(char[] arr, int posIni, int posFin) {
		// TODO Auto-generated method stub
		
		int i=posIni;
		int f=posFin;
		if(((posFin-posIni+1)>1)){
		while ((i<f)&&(arr[i]>=arr[i+1])) {
			i++;
		}
		if(i==f){//Quiere decir que recorri toda la secuencia
			return true;
		}else{
			return false;			
		}
		}else{
			return false;			
		}
	}
	private static int obtenerFin(char[] arr, int posIni) {
		// TODO Auto-generated method stub
		int i=posIni;
		while ((i < COLUMNAS)&&(arr[i]!=' ')) {
			i++;
		}if (i<COLUMNAS) {
			return i-1;
		} else {
			return -1;
		}
	}
	private static int obtenerInicio(char[] arr, int posIni) {
		// TODO Auto-generated method stub
		int i = posIni;
		while (i <COLUMNAS && arr[i]==' ') {
			i++;
		}
		if (i<COLUMNAS) {
			return i;
		} else {
			return-1;
		}
	}
	
	public static void imprimir_arreglo_secuencias_char(char[] arr) {
		for (int pos = 0; pos < COLUMNAS; pos++) {
			
			System.out.print(arr[pos] + "|");
		}
		System.out.print("\n");
	}
	
	public static void cargar_matriz_secuencias_char(char[][] matriz) {
		for (int fila = 0; fila < FILAS; fila++) {
			cargar_arreglo_aleatorio_secuencias_char(matriz[fila]);
		}
		
	}
	public static void cargar_arreglo_aleatorio_secuencias_char(char[] arr) {
		Random r = new Random();
		arr[0] = ' ';
		arr[COLUMNAS - 1] = ' ';
		for (int pos = 1; pos < COLUMNAS - 1; pos++) {
			if (r.nextDouble() > probabilidad_letra) {
				arr[pos] = (char) (r.nextInt(26) + 'a');
			} else {
				arr[pos] = ' ';
			}
		}
	}
	
	public static void imprimir_matriz_secuencias_char(char[][] matriz) {
		for (int fila = 0; fila < FILAS; fila++) {
			System.out.print("|");
			imprimir_arreglo_secuencias_char(matriz[fila]);
		}
		
	}

}

