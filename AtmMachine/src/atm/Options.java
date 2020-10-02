package atm;

import java.util.*;
public class Options {
	Scanner sc= new Scanner(System.in);
	
	HashMap<Integer,Integer> account=new HashMap<Integer,Integer>();
	ArrayList<Account> person=new ArrayList<Account>();
   public void getchoice() {
	  
	  
	   System.out.println("ENTER 1: IF YOU HAVE ACCOUNT");
	   System.out.println("ENTER 2: IF YOU WANT TO CREATE ACCOUNT");
	   int d=sc.nextInt();
	   switch(d) {
	   case 1:  confirm();
	              break;
		   
	   case 2:   AddAccount();
	               break;
	   
	  default:   System.out.println("WRONG CHOICE ENTER");             
	   
	   }
	   
   }
   public void confirm() {
	   
	   System.out.println("PLEASE ENTER YOUR DETAILS FOR VERIFICATIONS");
	   System.out.println("PLEASE ENTER YOUR ACCOUNT NO");
	   int AccountNo=sc.nextInt();
	   System.out.println("PLEASE ENTER YOUR PASSWORD");
	   int password=sc.nextInt();
	 if(  account.containsKey(AccountNo)) {
		if( account.get(AccountNo)==password) {
			for(Account t: person) {
				if(t.getAccountNo()==AccountNo) {
					getoptions(t);
					break;
				}
			}
			
		}
		else {
			System.out.println("WRONG PASSWORD");
			getchoice();
		}
		 
	 }
	 else {
		 System.out.println("WRONG ACCOUNT NO");
		 getchoice();
	 }
	   
   }
   public void getoptions(Account t) {
	   
	   System.out.println("YOU HAVE BEEN SUCCESSFULLY LOGGED IN TO YOUR ACCOUNT");
	   System.out.println("ENTER 1: TO CHECK YOUR CURRENT BALANCE");
	   System.out.println("ENTER 2: TO WITHDRAW MONEY FROM YOUR ACCOUNT");
	   System.out.println("ENTER 3: TO GET YOUR ACCOUNT INFORMATION ");
	   System.out.println("ENTER 4: TO ADD AMOUNT TO YOUR ACCOUNT");
	   System.out.println("ENTER 5: TO CHANGE YOUR PASSWORD");
	   System.out.println("ENTER 6: TO EXIT");
	   int d=sc.nextInt();
	   switch(d) {
	   case 1: System.out.println("YOUR CURRENT BALANCE IS : " + t.getCurrentAmount());
	            getchoice();
	           break;
	   case 2:  withdraw(t);
	              getchoice();
	            break;
	   case 3: System.out.println(t);
	             getchoice();
	            break;
	   case 4: addAmount( t);
	            getchoice();
	            break;
	   case 5: changepassword( t);
		   getchoice();
	           break;
	           
	   case 6:  getchoice();
	            break;
	   default: System.out.println("WRONG CHOICE");
	   getchoice();
	   
	   }
	   
   }
   public void AddAccount() {
	   Scanner sc= new Scanner(System.in);
	   int AccountNo;
		 int age;
	      String name;
		 int CurrentAmount;
		 int password;
	   System.out.println("THANK YOU FOR CREATING ACCOUNT IN OUR BANK");
	   System.out.println("PLEASE SUBMIT THE FOLLOWING DETAILS");
	   System.out.println(" please enter your ACCOUNT NO");
	   AccountNo=sc.nextInt();
	  if( account.containsKey(AccountNo)) {
		  System.out.println("ACCOUNT IS ALREADY PRESENT");
		  getchoice();
	  }
	   System.out.println(" please enter your PASSWORD");
	   password=sc.nextInt();
	   System.out.println(" please enter your AGE");
	   age=sc.nextInt();
	   System.out.println(" please enter your name");
	   name=sc.next();
	   System.out.println(" please enter your CURRENTAMOUNT");
	   CurrentAmount=sc.nextInt();
	   account.put(AccountNo,password);
	   Account t=new Account(AccountNo,age,name,CurrentAmount,password);
	   person.add(t);
	   System.out.println("YOUR ACCOUNT HAS BEEN CREATED SUCCESSFULLY");
	   getchoice();
   }
   public void withdraw(Account t) {
	   int amount;
	   System.out.println("ENTER THE AMOUNT YOU WANT TO WIHDRAW");
	   amount = sc.nextInt();
	   int remainingAmount=t.getCurrentAmount()-amount;
	   if(remainingAmount<=0) {
		   System.out.println("SORRY YOU DONT HAVE ENOUGH AMOUNT TO WITHDRAW");
	   }
	   else {
		   t.setCurrentAmount(remainingAmount);
		   System.out.println("YOU HAVE SUCCESSFULLY WITHDRAW THE AMOUNT");
		 //  getoptions(t);
	   }
	   
   }
   
   public void addAmount(Account t) {
	   int amount;
	   System.out.println("ENTER THE AMOUNT YOU WANT TO ADD");
	   amount = sc.nextInt();
	   int total=amount+t.getCurrentAmount();
	   t.setCurrentAmount(total);
	   System.out.println("YOU HAVE  SUCCESSFULLY ADDED AMOUNT TO YOUR ACCOUNT");
	  // getoptions(t);
	   
   }
   
   
   
   public void changepassword(Account t) {
	   int password;
	   System.out.println("ENTER YOUR OLD PASSWORD");
	   if(t.getPassword()==sc.nextInt()) {
		   System.out.println("ENTER THE NEW PASSWORD");
		   password=sc.nextInt();
		   account.put(t.getAccountNo(),password);
		   System.out.println("YOUR PASSWORD HAS BEEN CHANGED");
	   }
	   else
		   System.out.println("WE CANNOT CHANGE YOUR PASSWORD");
	   
	   
	   
   }
   
   
}
