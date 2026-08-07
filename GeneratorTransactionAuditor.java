import java.util.Scanner;

public class GeneratorTransactionAuditor {
	public static final double IVA = 0.16;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Actualizacion con ingreso de datos
		 * desde la terminal 
		 * 
		 * */
		int contador = 0;
		Scanner entrada = new Scanner(System.in);
		String exitProgram;
		
		do {
		System.out.println("Ingresa tu nombre y apellido: ");
		
		String nombreBase = entrada.nextLine();
		
		System.out.println("Ingresa tu email de la compañia: ");
		
		String email = entrada.nextLine();
		
		//Evaluando con condicional switch
		
		System.out.println("Ingresa tu sector corporativo");
		
		String opciones = (entrada.nextLine().toUpperCase()).strip();
		
		String codigoArea = switch(opciones) {
			case "IT" -> "101";
			
			case "FINANZAS" -> "202";
			
			case "VENTAS" -> "303";
		
			default -> "000";
		
		
		};
		
		
		//Evalua tipo de moneda
		
		System.out.println("¿La Transaccion es en dolares?");
		System.out.println("S/N");
		String monedaVerificacion = entrada.nextLine();
		
		String simboloMoneda = monedaVerificacion.equalsIgnoreCase("S") ? "$" : "Bs";
		
		
		//Ingreso de monto y constante IVA
		System.out.println("Ingresa el monto con almenos 2 decimales: ");
		double montoBase = Double.parseDouble(entrada.nextLine());
		
		//Bucle para evitar que se ingrese un monto no valido
		while (montoBase <= 0) {
				System.err.println("ERROR: El monto ingresado es inválido. Por favor, ingrese un monto superior a 0:");
				montoBase = Double.parseDouble(entrada.nextLine());	
		
		}
		
		
		
		
		
			//Limpiar nombre y poner en mayusculas
			
			String cleanName = (nombreBase.toUpperCase()).strip();
			
			//Verificar si el dominio del email es legitimo
			
			boolean verificacion = email.contains("@devj.com");
			//Imprime el token si el dominio corporativo es real,sino imprime error
			if (verificacion) {
				//LOGICA DE MATEMATICA
				
				double montoFinal = (montoBase*IVA) + montoBase;
				
				int numRandom = (int)(((Math.random()*9000)+1000));
				//calcula el token con numeros random, la longitud de letras del email y la primera letra del nombre
				String token = (codigoArea + "-" + cleanName.charAt(0) + "-" + numRandom + "-" + email.length());
				
				System.out.println("-----------------FACTURA------------");
				System.out.println("-----Nombre: " + cleanName);
				System.out.println("-----Correo Electronico: " + email);
				System.out.println("-----Monto + IVA: " + Math.round(montoFinal) + simboloMoneda );
				System.out.println("-----Verificacion: Valida");
				System.out.println("-----TOKEN SEGURIDAD: " + token);
				contador ++;
			}
			else {
				System.out.println("ALETA INFRACCION: El correo ingresado no pertence a la red corporativa de @devj.com.");
				System.out.println("Transaccion denegada...");
			}
			
			System.out.println("Deseas hacer otra transaccion(Y/N)");
			exitProgram = entrada.nextLine();
		}while(exitProgram.equalsIgnoreCase("Y"));
			
		System.out.println("Ha finalizado el programa, se ha realizado exitosamente " + contador + " transacciones.");
		
		entrada.close();
		
	}

}
