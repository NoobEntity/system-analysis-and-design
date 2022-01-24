package model;

import java.util.ArrayList;
import java.util.Random;

public class User {
	private int id;
	private String Fname,Lname;
	private String Password,Username;
	private String Gender,Email,BirthDate;
	private long NationalCode,PhoneNumber;
	private long SajamCode,IdentifierCode;
	private ArrayList<model.Orders> Orders = new ArrayList<>();
	private ArrayList<model.Honors> Honors = new ArrayList<>();
	private ArrayList<NotesAndAlerts> Notes = new ArrayList<>();

	private long IntroductionCode;
	private ArrayList<Integer> IntroducedPeople = new ArrayList();

	public void AddIntroducedPeople(int id) {
		IntroducedPeople.add(id);
	}

	public void CreateCode() {
		Random r = new Random();
		IntroductionCode=r.nextLong();
	}

	public long getIntroductionCode() {
		return IntroductionCode;
	}

	public ArrayList<Integer> getIntroducedPeople() {
		return IntroducedPeople;
	}


	public int getId() {
		return id;
	}

	public String getFname() {
		return Fname;
	}
    public void setFname(String fname) {
		Fname=fname;
	}
    public String getLname() {
		return Lname;
	}
    public void setLname(String lname) {
		Lname=lname;
	}
    public String getPassword() {
		return Password;
	}
    public void setPassword(String password) {
		Password=password;
	}
    public String getUsername() {
		return Username;
	}
    public void setUsername(String username) {
		Username=username;
	}
    public String getGender() {
		return Gender;
	}
    public void setGender(String gender) {
		Gender=gender;
	}
    public String getEmail() {
		return Email;
	}
    public void setEmail(String email) {
		Email=email;		
	}
    public String getBirthDate() {
		return BirthDate;
	}
    public void setBirthDate(String birthdate) {
		BirthDate=birthdate;
	}
    public long getPhoneNumber() {
		return PhoneNumber;
	}
    public void setPhoneNumber(long phonenumber) {
		PhoneNumber=phonenumber;
	}
    public long getNationalCode() {
		return NationalCode;
	}
    public void setNationalCode(long nationalcode) {
		NationalCode=nationalcode;
	}
    public long getSajamCode() {
		return SajamCode;
	}
    public void setSajamCode(long sajamcode) {
		SajamCode=sajamcode;
	}
    public long getIdentifierCode() {
		return IdentifierCode;
	}
    public void setIdentifierCode(long identifiercode) {
		IdentifierCode=identifiercode;
	}
	public ArrayList<model.Honors> getHonors() {
		return Honors;
	}
	public void setHonors(Honors honor) {
		Honors.add(honor);
	}
	public ArrayList<model.Orders> getOrders() {
		return Orders;
	}
	public void setOrder(Orders order) {
		Orders.add(order);
	}

	public ArrayList<NotesAndAlerts> getNotes() {
		return Notes;
	}

	public void setNote(NotesAndAlerts notes) {
		Notes.add(notes);
	}

	public void sendSMS(String number){}
	public boolean authCode(int code){
		return code==123456;
	}
	public boolean auth(String username , long password){
		return username.equals("hamed") && password==123456789;
	}
}
