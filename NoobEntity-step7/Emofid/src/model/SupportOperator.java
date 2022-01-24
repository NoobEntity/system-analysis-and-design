package model;

import java.util.Random;

public class SupportOperator {
	private String Fname,Lname;
	private String Gender,Contract;
	private long NationalCode,PhoneNumber;
	private int ContractCode;
	//CV

	public SupportOperator(String fname , String lname , long phonenumber ,long Id ,String gender){
		PhoneNumber=phonenumber;
		ContractCode=new Random().nextInt();
		NationalCode=Id;
		Gender=gender;
		Lname=lname;
		Fname=fname;
	}

	public int getContractCode() {
		return ContractCode;
	}
}
