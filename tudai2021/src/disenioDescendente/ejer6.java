package disenioDescendente;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Escribir un programa que mientras que el usuario ingrese un número entero
	natural, llame a un método que calcule la sumatoria entre 1 y dicho
	numero y se lo retorne como resultado.
 * */

public class ejer6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int usuario =1;
		
		while (usuario > 0) {
			usuario = pedirValor();
			realizar(usuario);			
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

	private static void realizar(int usuario) {
		// TODO Auto-generated method stub
		while (esNumNatural(usuario)) {
			sumatoria(usuario);
			usuario = pedirValor();
		}
	}

	private static boolean esNumNatural(int usuario) {
		// TODO Auto-generated method stub
		return usuario > 0;
	}

	private static void sumatoria(int usuario) {
		// TODO Auto-generated method stub
		int sumatoriaLocal = 0;
		for (int i = 1; i <= usuario; i++) {
			sumatoriaLocal+=i;
		}
		System.out.println("La sumatoria es " + sumatoriaLocal);
	}

}
