package array;

/*	Hacer un programa que dado el arreglo definido y precargado
 * 
 *  elimine del arreglo todas las ocurrencias de una secuencia patrón dada por otro arreglo
	de iguales características (solo tiene esa secuencia). Al eliminar se pierden los
	valores haciendo los corrimientos.*/

public class ejer15 {
	public static final int MAX = 10;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={0,1,2,0,5,4,0,1,2,0};//0205401200
		int[] arrayPatron={0,0,0,0,0,1,2,0,0,0};
		int inicio=0,fin=0;
		
		imprimirArray(array);
		System.out.println("");
		int inicioPatron = obtenerInicio(arrayPatron, 0);
		int finPatron = obtenerFin(arrayPatron, inicioPatron);
		System.out.println(inicioPatron + " y " + finPatron);

		recorrer_secuencias(array,arrayPatron, inicio,fin, inicioPatron, finPatron);
		System.out.println("");
		imprimirArray(array);
	

	}
	private static void recorrer_secuencias(int[] array, int [] arrayPatron, int inicio, int fin, int inicioPatron, int finPatron) {
		// TODO Auto-generated method stub
		while (inicio < MAX) {
			inicio=obtenerInicio(array,inicio);
			if (inicio != -1) {
				fin=obtenerFin(array,inicio);
				if (fin != -1) {
					System.out.println("Pos Ini es " + inicio + " y la fin es " + fin);
					if (esValido(inicio,fin,inicioPatron,finPatron)) {
						System.out.println("Es Valido");
						reconocer_y_correr(array, arrayPatron, inicio, fin, inicioPatron, finPatron);
					}inicio = fin+1;					
				}else {
					inicio=MAX;
				}
			}else{
				inicio = MAX;				
			}
		}
		
	}
	
	private static void reconocer_y_correr(int[] array, int [] arrayPatron, int inicio, int fin, int inicioPatron, int finPatron) {
		while ((inicioPatron <= finPatron) && (array[inicio] == arrayPatron[inicioPatron])) {
			
			corrimientoIzquierda(array,inicio);
			inicioPatron++;
			
		}	
	}
	private static void corrimientoIzquierda(int[] arr, int indice) {
		// TODO Auto-generated method stub
		while (indice < arr.length-1) {
			arr[indice]=arr[indice+1];
			indice++;
		}
	}
	
	private static boolean esValido(int posIni, int posFin,int inicioPatron,int finPatron ) {
		// TODO Auto-generated method stub
		return (finPatron-(inicioPatron-1))==(posFin - (posIni-1));
	}
	

	private static void imprimirArray(int[] arr) {
		// TODO Auto-generated method stub
		System.out.print("Arreglo de secuencias int\n|");
		for (int pos = 0; pos < MAX; pos++){
			System.out.print(arr[pos]+"|");
		}
		System.out.print("\n");
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
}
