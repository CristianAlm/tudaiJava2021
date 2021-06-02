package matriz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*
 * Hay dos matrices MAT1 y MAT2 de secuencias de caracteres letras separados
por espacios de tamaño MAXF x MAXC que están precargadas. Ambas
matrices están precargadas y cada fila empieza y termina con caracteres
espacios. Además se tiene el siguiente método:
– un método que retorna el índice inicial de la secuencia de mayor tamaño de un
arreglo de secuencias (de caracteres letras minúsculas separados por espacios) de
tamaño MAXFIL.
Se pide realizar un programa que
– contenga la definición de los encabezados de los métodos de carga de la matriz y
del método mencionado en el enunciado (se supone que existen y no se requiere
implementarlos).
– para MAT1 y MAT2 elimine de cada secuencia el primer carácter vocal.
– para MAT1 agregue al principio de cada secuencia el primer carácter de la
secuencia de mayor tamaño de dicha fila.
– en cada fila, si se verifica que la secuencia de mayor tamaño de la fila para MAT1 es
mayor que la primer secuencia en dicha fila para MAT2, las intercambie (la que está
en MAT1 pasa a MAT2 y la que esta en MAT2 pasa a MAT1) sin usar estructuras
auxiliares (otros arreglos o matrices).
– para un valor de fila ingresado por el usuario verifique e imprima si la primera
secuencia de MAT1 en dicha fila es igual la primera secuencia de MAT2 en dicha fila.
 * */

public class ejer16 {
	public static final int FILAS = 5;
	public static final int COLUMNAS = 15;

	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_letra = 0.4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] mat1 = new char[FILAS][COLUMNAS];
		char[][] mat2 = new char[FILAS][COLUMNAS];
		int usuario;
		cargar_matriz_secuencias_char(mat1);
		cargar_matriz_secuencias_char(mat2);
		
		System.out.println("Matriz Original");
		imprimir_matriz_secuencias_char(mat1);
		System.out.println();
		imprimir_matriz_secuencias_char(mat2);
		//obtenerInicioSecuencia(mat1);
		
		//eliminarVocal(mat1);
		//eliminarVocal(mat2);
		
		//imprimir_matriz_secuencias_char(mat1);
		//System.out.println();
		//imprimir_matriz_secuencias_char(mat2);
		
		//agregarPrincipio(mat1);
		
		//tratarDosMat(mat1,mat2);
		
	
		usuario = pedirValor();
		
		verifySecuencias(mat1,mat2,usuario);
		
		System.out.println("/n");
		
		imprimir_matriz_secuencias_char(mat1);
		System.out.println();
		imprimir_matriz_secuencias_char(mat2);
	}
	
	private static void verifySecuencias(char[][] mat1, char[][] mat2, int usuario) {
		// TODO Auto-generated method stub
		System.out.println("El usuario eligio la fila " + usuario);
		recorrerPrimerSecuencia(mat1[usuario],mat2[usuario]);
	}

	private static void recorrerPrimerSecuencia(char[] arr1, char[] arr2) {
		// TODO Auto-generated method stub
		int inicio =0;
		int fin = 0;
		
		while (inicio<COLUMNAS) {
			inicio=obtenerInicio(arr1,inicio);
			if (inicio!=-1) {
				fin=obtenerFin(arr1,inicio);
				if (fin!=-1) {
				System.out.println("La primera secuencia empieza en " + inicio + " y el fin es " + fin);
				compararOtroArrglo(arr1,arr2, inicio,fin);
				inicio=COLUMNAS;
				} else {
					inicio=COLUMNAS;
				}
			} else {
				inicio=COLUMNAS;
			}
		}
		
	}

	private static void compararOtroArrglo(char[] arr1, char[] arr2,
			int inicio, int fin) {
		// TODO Auto-generated method stub
		int largoMat1, largoMat2;
		largoMat1 = (fin - inicio+1);
        largoMat2 = obtenerPrimerSecuencia(arr2);
        
        if(largoMat1==largoMat2){
        	System.out.println("Tienen el mismo largo");
        }else{
        	System.out.println("No tienen el mismo largo");
        }
        
        //System.out.println("El largo de mat1 es " + largoMat1 + " y el largo de mat2 es " + largoMat2);
        
        
		
		
	}

	private static int obtenerPrimerSecuencia(char[] arr2) {
		// TODO Auto-generated method stub
		int inicio=0;
		int fin;
		int largo = 0;
		
		while (inicio<COLUMNAS) {
			inicio=obtenerInicio(arr2,inicio);
			if (inicio!=-1) {
				fin=obtenerFin(arr2,inicio);
				if (fin!=-1) {
					//System.out.println("La primera secuencia empieza en " + inicio + " y el fin es " + fin);
					
					largo = fin - inicio+1;
					
											
					inicio=COLUMNAS;
				} else {
					inicio=COLUMNAS;
				}
			} else {
				inicio=COLUMNAS;
			}
		}
		return largo;
	}

	private static int pedirValor() {
		// TODO Auto-generated method stub
		int variableLocal=0;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Ingrese el valor sw fila: ");
			variableLocal=Integer.valueOf(entrada.readLine());
		} catch (Exception exc) {
			// TODO: handle exception
			System.out.println(exc);
		}
		
		return variableLocal;
	}

	private static void tratarDosMat(char[][] mat1, char[][] mat2) {
		// TODO Auto-generated method stub
		int secuenciaLarga =0;
		for(int fila =0; fila < FILAS;fila++){
			secuenciaLarga = recorrerArrayLargo(mat1[fila]);
			
			recorrerArreglo(mat2[fila],secuenciaLarga, mat1[fila]);
			
		}
	}
	private static void recorrerArreglo(char[] arr, int secuenciaLarga, char[] arr1 ) {
		// TODO Auto-generated method stub
		int inicio =0;
		int fin = 0;
		
		while (inicio<COLUMNAS) {
			inicio=obtenerInicio(arr,inicio);
			if (inicio!=-1) {
				fin=obtenerFin(arr,inicio);
				if (fin!=-1) {
					if((fin-inicio+1)<secuenciaLarga){
						cambiarFilas(arr1,arr);
						
						inicio = COLUMNAS;
					}
					inicio=fin+1;
				} else {
					inicio=COLUMNAS;
				}
			} else {
				inicio=COLUMNAS;
			}
		}
	}

	private static void cambiarFilas(char[] arr1, char[] arr) {
		// TODO Auto-generated method stub
		char aux;
		for (int i = 0; i < COLUMNAS; i++) {
			aux = arr1[i];
			arr1[i]= arr[i];
			arr[i]=aux;
		}
	}

	private static void agregarPrincipio(char[][] mat1) {
		// TODO Auto-generated method stub
		
		
		for (int fila = 0; fila < FILAS; fila++) {
			int inicio =0;
			int fin =0;
			int posLocal = recorrerArray(mat1[fila],inicio, fin );
			System.out.println("Hay  " + posLocal);
			while (inicio<COLUMNAS) {
				inicio=obtenerInicio(mat1[fila],inicio);
				if (inicio!=-1) {
					fin=obtenerFin(mat1[fila],inicio);
					if (fin!=-1) {
						System.out.println("Hay secuencia entre " + inicio + " y en " + fin);
						mat1[fila][inicio]=mat1[fila][posLocal];
						inicio=fin+1;
					} else {
						inicio=COLUMNAS;
					}
				} else {
					inicio=COLUMNAS;
				}
			}
		}
	}

	private static void recorrerArrayAgregar(char[] arr, int inicioMayor, int finMayor) {
		// TODO Auto-generated method stub
		int inicio =0;
		int fin = 0;
		
		while (inicio<COLUMNAS) {
			inicio=obtenerInicio(arr,inicio);
			if (inicio!=-1) {
				fin=obtenerFin(arr,inicio);
				if (fin!=-1) {
					System.out.println("Hay secuencia entre " + inicio + " y en " + fin);
					//recorrerSecuencia(arr, inicio,fin);
					
		
					inicio=fin+1;
				} else {
					inicio=COLUMNAS;
				}
			} else {
				inicio=COLUMNAS;
			}
		}
	}

	private static void eliminarVocal(char[][] arr) {
		// TODO Auto-generated method stub
		for (int fila = 0; fila < FILAS; fila++) {
			recorrerArrayEleminar(arr[fila]);
		}
	}

	private static void obtenerInicioSecuencia(char[][] mat1) {
		// TODO Auto-generated method stub
		int inicio=0,fin=0;
		int posLocal =0;
		int largoLocal =0;
		int inicioMayor =0;
		int largoMayor = 0;
		
		for (int fila = 0; fila < FILAS; fila++) {
			posLocal =recorrerArray(mat1[fila], inicio, fin );
			//largoLocal =recorrerArrayLargo(mat1[fila], posLocal,inicio, fin );
			
			if(largoMayor < largoLocal){
				largoMayor = largoLocal;
				inicioMayor = posLocal;
				System.out.println("El inicio mayor es " + inicioMayor);
				System.out.println("El largo mayor es " + largoMayor);
			}
			
		}
		
	}
	
	private static int recorrerArrayLargo(char[] arr) {
		// TODO Auto-generated method stub
		int inicio=0;
		int fin;
		int largo = 0;
		
		while (inicio<COLUMNAS) {
			inicio=obtenerInicio(arr,inicio);
			if (inicio!=-1) {
				fin=obtenerFin(arr,inicio);
				if (fin!=-1) {
					//System.out.println("Hay secuencia entre " + inicio + " y en " + fin);
					
					if(largo<(fin - inicio+1)){
						largo = fin - inicio+1;
					}
											
					inicio=fin+1;
				} else {
					inicio=COLUMNAS;
				}
			} else {
				inicio=COLUMNAS;
			}
		}
		return largo;
	}
	
	private static int recorrerArray(char[] arr, int inicio, int fin) {
		// TODO Auto-generated method stub
		
		int largo = 0;
		int inicioMayor =0;
		
		while (inicio<COLUMNAS) {
			inicio=obtenerInicio(arr,inicio);
			if (inicio!=-1) {
				fin=obtenerFin(arr,inicio);
				if (fin!=-1) {
					//System.out.println("Hay secuencia entre " + inicio + " y en " + fin);
					
					if(largo<(fin - inicio+1)){
						largo = fin - inicio+1;
						inicioMayor=inicio;
					}					
					inicio=fin+1;
				} else {
					inicio=COLUMNAS;
				}
			} else {
				inicio=COLUMNAS;
			}
		}
		//System.out.println("El largo es " + largo + " en " + inicioMayor);
		return inicioMayor;
	}
	private static void recorrerArrayEleminar(char[] arr) {
		// TODO Auto-generated method stub
		int inicio =0;
		int fin = 0;
		
		while (inicio<COLUMNAS) {
			inicio=obtenerInicio(arr,inicio);
			if (inicio!=-1) {
				fin=obtenerFin(arr,inicio);
				if (fin!=-1) {
					//System.out.println("Hay secuencia entre " + inicio + " y en " + fin);
					recorrerSecuencia(arr, inicio,fin);
		
					inicio=fin+1;
				} else {
					inicio=COLUMNAS;
				}
			} else {
				inicio=COLUMNAS;
			}
		}
		//System.out.println("El largo es " + largo + " en " + inicioMayor);
	}
	private static void recorrerSecuencia(char[] arr, int inicio, int fin) {
		// TODO Auto-generated method stub
		while(inicio <= fin){
			if(esVocal(arr, inicio)){
				corrimientoIzquierda(arr, inicio);
				inicio = fin +1;
			}
			inicio++;
		}
	}

	private static void corrimientoIzquierda(char[] arr, int inicio) {
		// TODO Auto-generated method stub
		for(int i = inicio;i<COLUMNAS-1;i++){
			arr[i]=arr[i+1];
		}
	}
	

	private static boolean esVocal(char[] arr, int inicio) {
		// TODO Auto-generated method stub
		char letra = arr[inicio];
		if(letra == 'a'||letra == 'e'||letra == 'i'||letra == 'o'||letra == 'u'){
			return true;			
		}
		return false;
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

