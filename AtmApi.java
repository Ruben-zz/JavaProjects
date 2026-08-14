import java.util.Scanner;

public class AtmApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//declaration and initialization
		
		int[] pinDatabase = {2345, 5566, 8844};
		
		double[] accountBalances = {1056.55, 2566.99, 455.66};
		
		String[] userNameDataBase = {"JUAN","RUBEN","JOSE"};
		
		int userPin = 0,userIndex = -1;
		
		
		
		String userName = "";
		
		//add the Scanner method from java.util.
		
		Scanner scan = new Scanner(System.in);
		
		//variables de emergencia
		
		boolean isValidUser = false, isValidPin = false;
		
		
		
		//User Input
		while(!isValidUser){
		
			
		System.out.println("Welcome to the bank. Please enter the username.");
		userName = (scan.nextLine().toUpperCase()).strip();
		boolean isValid = false;
			for(int i= 0; i < userNameDataBase.length; i++) {
				
				if(userName.equals(userNameDataBase[i])) {
					isValid = true;
					userIndex = i;
					break;
				}	
			}
			
			if(isValid) {
				System.out.println("Registered user.");
				isValidUser = true;
			}
			else {
				System.err.println("Error: Unregistered user.");
			}
			
		}
		
		
		
		
		
		
		//PIN input
		while(!isValidPin) {
		
		System.out.println("Please enter your 4-digit PIN:");
		
		userPin = Integer.parseInt(scan.nextLine());
		
			//PIN verification l
			if(pinDatabase[userIndex] == userPin) {
				System.out.println("Authentication successful." + userNameDataBase[userIndex] + " Your balances is " + accountBalances[userIndex] + "$");
				isValidPin = true;
				break;
			}
			else System.err.println("Incorrect authentication.");
				
			
		}
		
	
		scan.close();
		
	}

}
