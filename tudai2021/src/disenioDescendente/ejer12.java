package disenioDescendente;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Siguiendo la Clase 4 Ejercicio 4, hacer un programa completo (usando
	métodos donde se requiera) en el cual se solicite de teclado el ingreso de
	un día, un número de mes, y un año; luego calcule la cantidad de días
	desde la última luna nueva (edad lunar), e informe por pantalla en cual de
	las 4 fases se corresponde para esa fecha.
	
	
	ejercicio:
	
		El astrónomo Metón de Atenas descubrió hacia el siglo V a.C que la luna
	repite su ciclo cada 19 años (el mismo día del mismo mes tendrá la misma
	fase lunar). Sus aportes permitieron determinar la fase de la luna para una
	fecha dada. Los pasos para obtener esa información son:
	
		a. Calcular el número áureo: permite conocer en qué año-tipo del ciclo
		nos encontramos considerando la repetición de ciclos cada 19 años.
		El número áureo se calcula de la siguiente forma:
		– Tomamos la cifra del año que nos interesa (por ejemplo 2023) y le sumamos 1
		(2023+1=2024)
		– A continuación dividimos el resultado por 19 (ciclo de repetición) y nos
		quedamos con el resto 2024/19 = 106 resto = 10 (10 es el resto entre 2024 y 19). Al
		dividir por 19 hemos eliminado los ciclos repetidos. Así el número áureo es 10.
		
		b. Calcular la epacta: es la edad de la luna en días el 1 de enero del
		año elegido, y se calcula de la siguiente forma:
		– Se resta 1 del número áureo, y se multiplica por 11 (en nuestro caso 10-1 = 9; 9*11
		= 99)
		– Después, se divide por 30 (un mes lunar) y de nuevo nos quedamos con el resto:
		99/30 = 3 resto = 9. Significa que el 1 de enero de 2023 habrán pasado 9 días
		desde la última luna nueva.
		
		c. Finalmente, para saber la edad lunar en un día cualquiera,
		(supongamos el 15 de junio de 2023) realizaremos la siguiente
		operación:
		1) A la epacta (9) le sumamos 1 por cada mes a partir de marzo (por
		ejemplo: de marzo a junio sumamos 4, y si el mes fuera enero de
		marzo a enero sumamos 11), y luego le sumamos el día del mes
		requerido (15), es decir 9+4+15=28.
		2) 28 es la edad lunar para esa fecha, y si pasara de 29 habría que
		reducirlo obteniendo el resto de dividir por 30.
		3) Es decir que el 15 de junio de 2023 habrán pasado 28 días desde la
		última luna nueva, por lo que la luna será menguante casi nueva (a
		falta de un día aproximadamente).

Se pide: hacer un programa completo en el cual se solicite de teclado el
ingreso de un día, un número de mes, y un año; luego calcule la cantidad
de días desde la última luna nueva (edad lunar), e informe por pantalla en
cual de las 4 fases se corresponde para esa fecha.
 * */

public class ejer12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int dia, mes, anio;
		dia = pedirDia();
		mes = pedirMes();
		anio = pedirAnio();
		
		int numeroAureo = calcularAureo(anio);
		int epacta = calcularEpacta(numeroAureo);
		int edad =  edadLunar(dia, mes, epacta);
		System.out.println(edad);
		
	}

	private static int edadLunar(int dia, int mes, int epacta) {
		// TODO Auto-generated method stub
		int cantMes = calcularCantMes(mes);
		epacta += cantMes;
		int resultadoEpacta = epacta + dia;
		
		if (resultadoEpacta > 29) {
			resultadoEpacta %= 30;
		}
		return resultadoEpacta;
		
		
	}

	private static int calcularCantMes(int mes) {
		// TODO Auto-generated method stub
		int variableLocal = 0;
		switch (mes) {
		case 3:
			variableLocal = 1;
			break;
		case 4:
			variableLocal = 2;
			break;
		case 5:
			variableLocal = 3;
			break;
		case 6:
			variableLocal = 4;
			break;
		case 7:
			variableLocal = 5;
			break;
		case 8:
			variableLocal = 6;
			break;
		case 9:
			variableLocal = 7;
			break;
		case 10:
			variableLocal = 8;
			break;
		case 11:
			variableLocal = 9;
			break;
		case 12:
			variableLocal = 10;
			break;
		case 1:
			variableLocal = 11;
			break;
		case 2:
			variableLocal = 12;
			break;
		default:
			break;
		}
		
		return variableLocal;
	}

	private static int calcularEpacta(int numeroAureo) {
		// TODO Auto-generated method stub
		int calculoEpacta;
		
		calculoEpacta = ((numeroAureo - 1)*11);
		
		int segundoEpacta = (calculoEpacta%30);
		
		return segundoEpacta;

	}

	private static int calcularAureo(int anio) {
		// TODO Auto-generated method stub
		int resultadoDivision;
		
		anio +=1;
		
		resultadoDivision = (anio%19);
		
		return resultadoDivision;
	}

	private static int pedirAnio() {
		// TODO Auto-generated method stub
		int variableLocal=0;
		boolean variableValida = false;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			
			try {
				System.out.println("Ingrese el anio: ");
				variableLocal=Integer.valueOf(entrada.readLine());
				if (variableLocal > 0) {
					variableValida = true;
				}
				
			} catch (Exception exc) {
				// TODO: handle exception
				System.out.println(exc);
			}
		} while (!variableValida);
		
		return variableLocal;
	}

	private static int pedirMes() {
		// TODO Auto-generated method stub
		int variableLocal=0;
		boolean variableValida = false;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			
			try {
				System.out.println("Ingrese el mes: ");
				variableLocal=Integer.valueOf(entrada.readLine());
				if (variableLocal > 0 && variableLocal <= 12) {
					variableValida = true;
				}
				
			} catch (Exception exc) {
				// TODO: handle exception
				System.out.println(exc);
			}
		} while (!variableValida);
		
		return variableLocal;
	}

	private static int pedirDia() {
		// TODO Auto-generated method stub
		int variableLocal=0;
		boolean variableValida = false;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			
			try {
				System.out.println("Ingrese el dia: ");
				variableLocal=Integer.valueOf(entrada.readLine());
				if (variableLocal > 0 && variableLocal < 32) {
					variableValida = true;
				}
				
			} catch (Exception exc) {
				// TODO: handle exception
				System.out.println(exc);
			}
		} while (!variableValida);
		
		return variableLocal;
	}

}
