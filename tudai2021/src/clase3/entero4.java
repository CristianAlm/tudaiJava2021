package clase3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Escribir un programa que ingrese un número entero por teclado e
	imprima el resultado de determinar:
_ es múltiplo de 6 y de 7,
_ es mayor a 30 y múltiplo de 2, o es menor igual a 30,
_ el cociente de la división de dicho número con 5 es mayor a 10.
 * */

public class entero4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = pedirValor();
		int cociente;
		
		cociente = num/5;
		
		realizarPrograma(num,cociente);
	}

	private static void realizarPrograma(int num, int cociente) {
		// TODO Auto-generated method stub
		if ((num%6==0)&&(num%7==0)) {
			System.out.println("Es multiplo de 6 y de 7");
		}
		if ((num > 30) &&(num%2==0)) {
			System.out.println("es mayor a 30 y múltiplo de 2");
		}else if (num <= 30) {
			System.out.println("Es un numero menor a 30");
		}
		if (cociente > 10) {
			System.out.println("El cociente de la division entre 5 da un resultado mayor a 10");
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
