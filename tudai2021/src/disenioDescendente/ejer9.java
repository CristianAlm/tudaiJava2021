package disenioDescendente;
/*
 * Realizar un programa que dado dos números enteros y un
	carácter, todos ingresados por el usuario, muestre por
	pantalla el resultado de la operación matemática básica
	considerando el valor del carácter. Si ingreso el caracter:
	– ‘a’ la suma, ‘b’ la resta, ‘c’ la multiplicación y ‘d’ la división
	entre ambos números.
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ejer9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1, num2;
		num1 = pedirValor();
		num2 = pedirValor();
		char usuario = pedirCaracter();
		
		char suma = 'a', resta = 'b', multiplicacion = 'c', division = 'd';
		
		operaciones(num1,num2, usuario, suma, resta,multiplicacion,division);

	}

	private static void operaciones(int num1, int num2, char usuario,
			char suma, char resta, char multiplicacion, char division) {
		// TODO Auto-generated method stub
		if (usuario == 'a') {
			System.out.println("La suma es: " + (num1+num2));
			nuevamente(num1,num2, usuario, suma, resta,multiplicacion,division);
		}else if (usuario == 'b') {
			System.out.println("La resta es: " + (num1-num2));
			nuevamente(num1,num2, usuario, suma, resta,multiplicacion,division);
		}else if (usuario == 'c') {
			System.out.println("La multiplicacion es: " + (num1*num2));
			nuevamente(num1,num2, usuario, suma, resta,multiplicacion,division);
		}else if (usuario == 'd') {
			System.out.println("La division es: " + (num1/num2));
			nuevamente(num1,num2, usuario, suma, resta,multiplicacion,division);
		}else {
			System.out.println("No se eleigio una operacion");
			usuario = pedirCaracter();
			operaciones(num1,num2, usuario, suma, resta,multiplicacion,division);
		}
	}

	private static void nuevamente(int num1, int num2, char usuario, char suma,
			char resta, char multiplicacion, char division) {
		// TODO Auto-generated method stub
		num1 = pedirValor();
		num2 = pedirValor();
		usuario = pedirCaracter();
		operaciones(num1,num2, usuario, suma, resta,multiplicacion,division);
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

	private static char pedirCaracter() {
		// TODO Auto-generated method stub
		char variableLocal = 0;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Ingrese un caracter: ");
			variableLocal=entrada.readLine().charAt(0);
			
		} catch (Exception exc) {
			// TODO: handle exception
			System.out.println(exc);
		}
		return variableLocal;
	}

}
