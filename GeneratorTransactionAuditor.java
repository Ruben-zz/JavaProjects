import java.util.Scanner;

public class GeneratorTransactionAuditor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Actualizacion con ingreso de datos
		 * desde la terminal 
		 * 
		 * */
		Scanner entrada = new Scanner(System.in);
		
	
		
		System.out.println("Ingresa tu nombre y apellido: ");
		
		String nombreBase = entrada.nextLine();
		
		System.out.println("Ingresa tu email de la compañia: ");
		
		String email = entrada.nextLine();
		
		
		//Ingreso de monto y constante IVA
		
		System.out.println("Ingresa el monto con almenos 2 decimales: ");
		double montoBase = Double.parseDouble(entrada.nextLine());
		
		final double IVA = 0.16;
		
		//Limpiar nombre y poner en mayusculas
		
		String cleanName = (nombreBase.toUpperCase()).strip();
		
		//Verificar si el dominio del email es legitimo
		
		boolean verificacion = email.contains("@devj.com");
		
		//LOGICA DE MATEMATICA
		
		double montoFinal = (montoBase*IVA) + montoBase;
		
		int numRandom = (int)(((Math.random()*9000)+1000));
		//calcula el token con numeros random, la longitud de letras del email y la primera letra del nombre
		String token = (cleanName.charAt(0) + "-" + numRandom + "-" + email.length());
		
		System.out.println("-----------------FACTURA------------");
		System.out.println("-----Nombre: " + cleanName);
		System.out.println("-----Correo Electronico: " + email);
		System.out.println("-----Monto + IVA: " + Math.round(montoFinal) + "$" );
		System.out.println("-----Verificacion: " + verificacion);
		System.out.println("-----TOKEN SEGURIDAD: " + token);
		
		entrada.close();
		
	}

}
