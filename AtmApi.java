import java.util.Scanner;

public class AtmApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//declaration and initialization
		
		int[] pinDatabase = {2345, 5566, 8844};
		
		double[] accountBalances = {1056.55, 2566.99, 455.66};
		
		String[] userNameDataBase = {"JUAN","RUBEN","JOSE"};
		
		int userPin = 0,userIndex = -1;
		
		int menuOption = 0;
		
		String exitProgram = "N";
		
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
				System.out.println("Authentication successful.");
				isValidPin = true;
				break;
			}
			else System.err.println("Incorrect authentication.");
				
			
		}
		
		//interactive menu
		
		if (isValidPin == true && isValidUser == true) {
			
			do {
				
				System.out.println("=======WELCOME TO THE BANK======");
				System.out.println("1-Check balance.");
				System.out.println("2-Deposit funds.");
				System.out.println("3-Withdraw funds.");
				System.out.println("4-Exit.");
				menuOption = Integer.parseInt(scan.nextLine());
				
				
				switch (menuOption) {
					case 1:
						System.out.printf("Your balance is %.2f$",accountBalances[userIndex]);
						System.out.println("");
						break;
					case 2:
						System.out.println("Enter the amount to deposit.");
						double depositFunds = Double.parseDouble(scan.nextLine());
						accountBalances[userIndex] += depositFunds;
						break;
					case 3:
						System.out.println("Opcion 3");
						double withdrawFunds = Double.parseDouble(scan.nextLine());
						
						if(withdrawFunds > accountBalances[userIndex]) {
							System.out.println("The withdrawal exceeds the funds in your account.");
						}
						else {
							accountBalances[userIndex] -= withdrawFunds;
						}
						break;
					case 4:
						System.out.println("You have successfully logged out of the system.");
						exitProgram = "Y";
						break;
					default:
						System.out.println("Invalid option");
				
				
				
				
				
				}
				
				
	
				
			}while(exitProgram.equalsIgnoreCase("N"));
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		scan.close();
		
	}

}
