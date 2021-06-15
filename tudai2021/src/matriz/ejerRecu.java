package matriz;

/*
Sea una matriz precargada (no implementar el metodo de carga) de caracteres de tamanio 14*90 de secuencias de caracteres digitos separadas por el caracter digito cero. 
Cada fila de la matriz empieza y termina con uno o mas separadores caracter digito cero. Se pide realizar un programa que:
_por cada secuencia que tiene a lo sumo 7 caracteres, inserte despues de cada caracter digito menor al caracter digito seis, dos separadores caracter digito cero. 
Suponer que cada fila de la matriz tiene espacio para agregar esos caracteres.
*/


public class ejerRecu {
	
	public static final int MAXFILA = 14;
	public static final int MAXCOLUMNA = 90;
	public static final int LARGOLIMITE = 7;
	public static final int VECES = 2;
	public static final char COMPARADOR = '6';
	public static final char SEPARADOR = '0';
	

	public static void main(String[] args) {
		
		//declaraciones e inicializaciones de matriz A
		tratarMatriz(A);
		
	}


	private static void tratarMatriz(char[][] A) {
		for (int fila = 0; fila < MAXFILA; fila++) {
			tratarArray(A[fila]);
		}
		
	}


	private static void tratarArray(char[] a) {
		
		int ini = 0, fin = 0, largo;
		
		while (ini<MAXCOLUMNA) {
			ini=obtenerInicio(a,fin);
			if (ini<MAXCOLUMNA) {
				fin=obtenerFin(a, ini);
				if (fin < MAXCOLUMNA) {
					largo = fin-ini+1;
					if (largo <= LARGOLIMITE) {
						analizoSec(a,ini,fin);
					}
					fin=obtenerFin(a, ini);
				}
			}
			
		}
	}
	private static void analizoSec(char[] a, int ini, int fin) {
		for (int i = ini; i <= fin; i++) {
			if (a[i]<COMPARADOR) {
				insertar(a,i);
			}
		}
	}


	private static void insertar(char[] a, int pos) {
		corrimientoDerecha(a, pos);
		copiar(a,pos);
		
	}


	private static void copiar(char[] a, int pos) {
		// TODO Auto-generated method stub
		for (int veces = VECES; veces > 0; veces--) {
			a[pos+veces]= SEPARADOR;
		}
	}


	public static void corrimientoDerecha(char a[], int ini){
	    for(int veces = VECES; veces > 0; veces--)
	        for(int i = MAXCOLUMNA -1; i > ini; i--){
	            a[i] = a[i - 1];
	        }
	}


	public static int obtenerInicio(char[] fila, int ini){ 
	    int iterador = ini;
	    while(iterador < MAXCOLUMNA && fila[iterador] == SEPARADOR){
	      iterador++;
	    }
	    return iterador;
	  }

	  public static int obtenerFin(char[] fila, int ini){
	    int iterador = ini; 
	    while(iterador < MAXCOLUMNA && fila[iterador] != SEPARADOR){
	      iterador++;
	    }
	    return iterador - 1;
	  }

}
