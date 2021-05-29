package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
/*
 * Se tiene un arreglo ORIGINAL precargado de caracteres letras minúsculas de
	tamaño MAX que está ordenado de forma ascendente. Además se tiene un
	arreglo ORDEN1 precargado de tamaño MAX. ORDEN1 tiene posiciones de
	ORIGINAL de forma tal que permita recorrer de forma ascendente y
	consecutiva los caracteres vocales de ORIGINAL. ORDEN1 tendrá valores -1 al
	final en el caso de que ORIGINAL tenga consonantes. Se pide:
	– Dada una posición ingresada por el usuario desde teclado, eliminar la letra de dicha
	posición en ORIGINAL, y actualizar el arreglo ORDEN1.
	– Imprimir los caracteres vocales siguiendo el orden establecido en ORIGINAL.
 * */

public class ejer18 {
	public static final int MAX = 40;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_letra = 0.4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [] original;
		int [] orden1;
		original = new char[MAX];
		orden1 = new int[MAX];
		cargar_arreglo_aleatorio_secuencias_char(original);
		cargar_arreglo_orden1(orden1);
		buscarVocal(original,orden1);
		ordenar(original,orden1);
		System.out.println("Arreglo original");
		imprimir_arreglo_secuencias_char(original);
		System.out.println();
		System.out.println("Arreglo de posiciones vocales de original");
		imprimir_arreglo(orden1);
		
		gestionarPosUsuario(original,orden1);
		buscarVocal(original,orden1);
		ordenar(original,orden1);
		imprimir_arreglo(orden1);
		imprimir_arreglo_secuencias_char(original);
		
		seleccionarCaracter(original,orden1);
		imprimir_arreglo(orden1);
		
		

	}
	private static void seleccionarCaracter(char[] original, int[] orden1) {
		// TODO Auto-generated method stub
		//int maxPares = obtenerMax(orden1);
		for (int i = 0; i < MAX; i++) {
			if (esVocal(original[i])) {
				System.out.println(original[i]);
				
			}
		}
	}
	private static boolean esVocal(char usuario) {
		// TODO Auto-generated method stub
		return usuario =='a' || usuario =='e' ||usuario =='i' ||usuario =='o' ||usuario =='u';
	}
	private static void gestionarPosUsuario(char[] original, int[] orden1) {
		// TODO Auto-generated method stub
		/*
		 * Dada una posición ingresada por el usuario desde teclado, eliminar la letra de dicha
			posición en ORIGINAL, y actualizar el arreglo ORDEN1.
		 * */
		
		int usuario = pedirValor();
		
		original[usuario]=' ';
		
	}
	private static int pedirValor() {
		// TODO Auto-generated method stub
		int variableLocal=0;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Ingrese el valor: ");
			variableLocal=Integer.valueOf(entrada.readLine());
		} catch (Exception exc) {
			// TODO: handle exception
			System.out.println(exc);
		}
		
		return variableLocal;
	}
	private static void buscarVocal(char[] original, int[] orden1) {
		int pos;
		int indice=0;
		for ( pos = 0; pos < original.length; pos++) {
			char x = original[pos];
			if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
				insertarPosicionVocal(orden1, pos,indice);
				//ordenar(original,orden1);
				indice++;
			}
			
		}
		
	}
	private static void insertarPosicionVocal(int[] orden1,int pos, int indice) {
		// TODO Auto-generated method stub
		if(pos<MAX) {
			orden1[indice]=pos;
		}
	}
	private static void ordenar(char[] original, int[] orden1) {
		// TODO Auto-generated method stub
		int posMenor, aux;
        int maxPares = obtenerMax(orden1);
        for (int i = 0; i <= MAX - 1; i++) {
            posMenor = i;
            for (int j = i + 1; j <= maxPares; j++) {
                if (original[orden1[j]] < original[orden1[posMenor]]) {
                    posMenor = j;
                }
            }
            if (posMenor != i) {
                aux = orden1[i];
                orden1[i] = orden1[posMenor];
                orden1[posMenor] = aux;
            }
        }
	}
	private static int obtenerMax(int[] orden1) {
		// TODO Auto-generated method stub
		 int pos = 0;
	     while (orden1[pos] != (-1)) {
	        pos++;
	     }
	     int ultimaPos = pos - 1;
	     return ultimaPos;
	}
	public static void imprimir_arreglo(int [] arr){
		for (int pos = 0; pos < MAX; pos++){
			System.out.print("|"+arr[pos]);
		}   
		System.out.println("|");
	}
	private static void cargar_arreglo_orden1(int[] orden1) {
		// TODO Auto-generated method stub
		for (int pos = 0; pos < MAX; pos++){
			orden1[pos] = -1;
		}
	}
	public static void cargar_arreglo_aleatorio_secuencias_char(char
			[] arr){
			Random r = new Random();
			for (int pos = 0; pos < MAX; pos++){
				
				arr[pos]=(char)(r.nextInt(26) + 'a');
			}
			
		}
	public static void imprimir_arreglo_secuencias_char(char [] arr){
		System.out.print("Arreglo de secuencias char\n|");
		for (int pos = 0; pos < MAX; pos++){
		System.out.print(arr[pos]+"|");
		}
		System.out.print("\n");
		}

}
