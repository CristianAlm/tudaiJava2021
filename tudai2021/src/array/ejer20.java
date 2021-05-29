package array;
/*
 * Para el Ejemplo 19, hacer:
	– cargar los índices de inicio de todas secuencias en el arreglo ORDEN2 de tamaño
	MAX, que está inicializado con -1.
	– Suponiendo que hay un método que permite ordenar de forma ascendente un
	arreglo de las características de ORDEN2 (el método ordena los índices de inicio de
	secuencia de según el tamaño de las secuencias a los que hacen referencia),
	generar un arreglo ORDEN3 de tamaño MAX de índices de las secuencias de
	ORIGINAL con el orden mencionado (deberá definir además los encabezados de
	el/los método/s prexistentes y hacer las llamadas cuando los utilice).
 * */

import java.util.Random;
public class ejer20 {
	public static final int MAX = 30;
	public static final int MAXVALOR = 10;
	public static final int MINVALOR = 0;
	public static final double probabilidad_numero = 0.2;
	public static void main(String[] args) {
		int [] original = new int [MAX];
		int [] orden = new int [MAX];
		int [] orden3 = new int [MAX];
		int posIni = 0, posFin = 0;
		cargar_arreglo_aleatorio_secuencias_int(original);
		inicializar_arreglo(orden);
		imprimir_arreglo_secuencias_int(original);
		imprimir_arreglo_secuencias_int(orden);
		recorrer_secuencias(original,orden, posIni,posFin);
		
		//ordenar_arreglo_seleccion(orden3,orden,original,posIni,posFin);
		imprimir_arreglo_secuencias_int(orden3);
	}
	/*
	public static void ordenar_arreglo_seleccion(int[]orden3,int []orden,int []original,int posIni, int posFin) {
		int pos_menor, tmp,largo=0,aux;
		for (int i = posIni; i <= posFin; i++) {
			pos_menor = i;
			aux++;
			} if (pos_menor>posFin) {
					if (aux<largo) {
						
					}largo=aux;
			}
			/*
			if (pos_menor != i){
				tmp = orden3[i];
				orden3[i] = orden3[pos_menor];
				orden3[pos_menor] = tmp;
			}
		}
	 */
	
	
	public static void recorrer_secuencias(int[] original, int [] orden, int posIni, int posFin) {
		int indice=0;
		while (posIni < MAX) {
			posIni=obtenerInicio(original,posIni);
			if (posIni != -1) {
				posFin=obtenerFin(original,posIni);
				if (posFin != -1) {
					System.out.println("Pos Ini es " + posIni + " y la fin es " + posFin);
					 
						System.out.println("Es Valido");
						cargarPosOrden(orden, posIni, indice);
						indice++;
					posIni = posFin+1;					
				}else {
					posIni=MAX;
				}
			}else{
				posIni = MAX;				
			}
		}
		
	}
	
	
	
	private static void cargarPosOrden(int[] orden, int posIni, int indice) {
		// TODO Auto-generated method stub
		orden[indice]=posIni;
		
	}

	private static boolean esValido(int arr[],int posIni, int posFin) {
		// TODO Auto-generated method stub
		int suma = 0;
		for (int pos = posIni; pos <= posFin; pos++){
			suma+=arr[pos];
		}
		if (suma%2== 0) {
			return true;
		}else{
			return false;
		}
	}

	public static int suma_secuencia(int [] arr,int posIni, int posFin){
		int suma = 0;
		for (int pos = posIni; pos <= posFin; pos++){
			suma+=arr[pos];
		}
		return (suma);
		}
	
		public static int obtenerFin(int[] arrint, int posIni) {
				
				int i=posIni;
				while ((i<MAX)&&(arrint[i]!=0)) {
					i++;
				}if (i<MAX) {
					return i-1;
				} else {
					return -1;
				}
			}
		
		
		public static int obtenerInicio(int[] arrint, int posIni) {
				
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
	public static void inicializar_arreglo(int [] arr){
		for (int pos = 0; pos < MAX; pos++){
			arr[pos] = -1;
		}
	}

	public static void imprimir_arreglo_secuencias_int(int [] arr){
		System.out.print("Arreglo de secuencias int\n|");
		for (int pos = 0; pos < MAX; pos++){
		System.out.print(arr[pos]+"|");
		}
		System.out.print("\n");
	}
	
	public static void cargar_arreglo_aleatorio_secuencias_int(int []arr){
		Random r = new Random();
		arr[0] = 0;
		arr[MAX-1] = 0;
		for (int pos = 1; pos < MAX-1; pos++){
			if (r.nextDouble()>probabilidad_numero){
				arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + (MINVALOR+1));
			}
			else{
				arr[pos]=0;
			}
		}
	}
}

