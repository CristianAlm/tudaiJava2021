package disenioDescendente;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Escribir un programa que mientras el usuario ingresa un numero de mes
	(entero) entre 1 y 12 inclusive, muestre por pantalla la cantidad de días del
	mes ingresado (suponer febrero de 28 días) (¿mostrar por pantalla la
	cantidad de días del mes debería realizarse con un método? Debería).
 * */

public class ejer7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mes = pedirMes();
		
		mostrar(mes);
		
	}

	private static int pedirMes() {
		// TODO Auto-generated method stub
		int variableLocal=0;
		boolean variableValida = false;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		while(!variableValida){
			try {
				System.out.println("Ingrese el mes: ");
				variableLocal=Integer.valueOf(entrada.readLine());
				
				if(mesValido(variableLocal)){
					System.out.println("Vale para el ejer.");
					variableValida = true;
				}
				
			} catch (Exception exc) {
				// TODO: handle exception
				System.out.println(exc);
			}
		}
		
		return variableLocal;
	}

	private static boolean mesValido(int variableLocal) {
		// TODO Auto-generated method stub
		return variableLocal > 0 && variableLocal < 13;
	}

	private static void mostrar(int mes) {
		// TODO Auto-generated method stub
		while(mesValido(mes)){
			mostrarDias(mes);
			mes = pedirMes();
			mostrar(mes);			
		}
		
	}

	private static void mostrarDias(int mes) {
		// TODO Auto-generated method stub
		if((mes == 4)||(mes == 6)||(mes == 9)||(mes == 11)) System.out.println("Mes de 30 dias");
        else if(mes == 2) System.out.println("Febrero 28 dias");
        else System.out.println("Mes de 31 dias");
	}

}
