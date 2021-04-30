package clase3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	 * Escribir un programa que permita el ingreso de dos números
	enteros por teclado e imprima el resultado de comparar:
	_ el primero mayor al segundo.
	_ ambos son múltiplos de 2.
 * */

public class entero3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num1, num2;
		num1 = pedirValor();
		num2 = pedirValor();
		
		if(num1 > 0 && num2 >0) {
			realizarPrograma(num1,num2);			
		}else{
			main(args);
		}
		
		
	}

	private static void realizarPrograma(int num1, int num2) {
		// TODO Auto-generated method stub
		if (num1 > num2) {
			System.out.println("El primer valor es el mayor y es " + num1);
		} else {
			System.out.println("El segundo valor es el mayor y es " + num2);
		}
		if ((num1%2==0)&&(num2%2==0)) {
			System.out.println("Ambos son multiplos de 2");
		}
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

}
