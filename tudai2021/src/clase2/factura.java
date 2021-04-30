package clase2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 	Escribir un programa que pida que se ingresen datos necesarios para emitir una
	factura por la compra de dos artículos de librería (tipo factura, número, nombre
	cliente, producto 1, importe 1, producto 2, importe 2, importe total). Como
	salida debe imprimir por pantalla la factura en un formato similar al siguiente
	(utilizar literales):
	
		Factura                   C          201
		Nombre y Apellido        Jorge Rodríguez
		Producto                         Importe
		Lápices                             12.2
		Cuadernos                           20.0
		Importe Total                       30.2
	
 * */

public class factura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char tipoFactura;
		int numFactura, importe1, importe2, total;
		String cliente, producto1, producto2;
		
		System.out.println("Ingrese tipo Factura");
		tipoFactura = pedirFactura();
		System.out.println("Ingrese el numero de factura");
		numFactura = pedirEntero();
		System.out.println("Ingrese el cliente");
		cliente = pedirTexto();
		System.out.println("Ingrese el producto");
		producto1 = pedirTexto();
		System.out.println("Ingrese su importe");
		importe1 = pedirEntero();
		System.out.println("Ingrese el producto");
		producto2 = pedirTexto();
		System.out.println("Ingrese su importe");
		importe2 = pedirEntero();
		
		total = importe1+importe2;
		
		imprimir(tipoFactura, numFactura,cliente,producto1,importe1,producto2,importe2,total);
		

	}

	private static void imprimir(char tipoFactura, int numFactura,
			String cliente, String producto1, int importe1, String producto2,
			int importe2, int total) {
		// TODO Auto-generated method stub
		
		System.out.println("Factura: " + tipoFactura + "          " + numFactura + "\n" + 
				"Nombre y apellido: " + cliente + "\n"
				+ "Producto             Importe" + "\n" 
				+ producto1 + "          " + importe1 + "\n"
				+ producto2 + "          " + importe2 + "\n"
				+ "Importe total " + total);
		
	}

	private static String pedirTexto() {
		// TODO Auto-generated method stub
		String variableLocal = null;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			variableLocal=entrada.readLine();
		} catch (Exception exc) {
			// TODO: handle exception
			System.out.println(exc);
		}
		
		return variableLocal;
	}

	private static int pedirEntero() {
		// TODO Auto-generated method stub
		int variableLocal=0;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			variableLocal=Integer.valueOf(entrada.readLine());
		} catch (Exception exc) {
			// TODO: handle exception
			System.out.println(exc);
		}
		
		return variableLocal;
	}

	private static char pedirFactura() {
		// TODO Auto-generated method stub
		char variableLocal = 0;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			variableLocal=entrada.readLine().charAt(0);
		} catch (Exception exc) {
			// TODO: handle exception
			System.out.println(exc);
		}
		
		return variableLocal;
	}

}
