package atm;

public class Account {
	private int AccountNo;
	private int age;
    private  String name;
	private int CurrentAmount;
	private int password;
	
	Account(int AccountNo,int age,String name,int CurrentAmount,int password){
		this.AccountNo=AccountNo;
		this.age=age;
		this.CurrentAmount=CurrentAmount;
		this.name=name;
		this.password=password;
	}
	public String toString() {
		String s=" ";
		s=s+"YOUR ACCOUNT NO: "+ getAccountNo() +"\n";
		s+="YOUR AGE : " + getAge() +"\n";
		s+="YOUR NAME : " + getName() +"\n";
		s+="YOUR CURRENTAMOUNT : " + getCurrentAmount()+"\n";
		return s;
	}

	public int getAccountNo() {
		return AccountNo;
	}

	public void setAccountNo(int accountNo) {
		AccountNo = accountNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrentAmount() {
		return CurrentAmount;
	}

	public void setCurrentAmount(int currentAmount) {
		CurrentAmount = currentAmount;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

}
