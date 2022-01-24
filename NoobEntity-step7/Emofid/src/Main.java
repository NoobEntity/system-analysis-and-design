import model.NotesAndAlerts;
import model.Orders;
import model.SupportOperator;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static User user = new User();
    private static ArrayList<Integer> recommenders =new ArrayList();
    private static SupportOperator operator = new SupportOperator("Javad","gholami", 321678674l, 468768754l, "male");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1-create account \n2-log in \n3-exit");
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> newUserMenu();
                case 2 -> oldUserMenu();
                case 3 -> System.exit(0);
                default -> System.out.println("Wrong input");
            }
        }
    }

    private static void newUserMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your first name : ");
        user.setFname(scanner.nextLine());
        System.out.println("enter your last name : ");
        user.setLname(scanner.nextLine());
        System.out.println("enter your desired password : ");
        user.setPassword(scanner.nextLine());
        System.out.println("enter your desired username : ");
        user.setUsername(scanner.nextLine());
        boolean check = false;
        System.out.println("1-male \n2-female (this cannot be changed)");
        do{
            int input = scanner.nextInt();
            switch (input){
                case 1 -> {user.setGender("male");check=true;}
                case 2 -> {user.setGender("female");check=true;}
                default -> System.out.println("wrong input");
            }
        }while(!check);
        scanner.nextLine();
        System.out.println("enter your email : ");
        user.setEmail(scanner.nextLine());
        System.out.println("enter your birthdate  (this cannot be changed): ");
        user.setBirthDate(scanner.nextLine());
        System.out.println("enter your Id code  (this cannot be changed): ");
        user.setNationalCode(scanner.nextLong());
        System.out.println("enter your phone number (this cannot be changed): ");
        user.setPhoneNumber(scanner.nextLong());
        System.out.println("enter your sajam code (this cannot be changed): ");
        user.setSajamCode(scanner.nextLong());
        System.out.println("did anyone invite you ? \nplease enter the code (and if not , enter 0): ");
        user.setIdentifierCode(scanner.nextLong());
        System.out.println("you will get a message , please enter the code :");

        do{
            scanner.nextLine();
        } while(!user.authCode(scanner.nextInt()));
        System.out.println("you are one of our family now!");
    }

    private static void oldUserMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter you username : ");
        String username = scanner.nextLine();
        System.out.println("enter you password : ");
        long password = scanner.nextLong();
        if(user.auth(username,password)){
            user = new User();
            user.setFname("hesam");
            user.setLname("hakemi");
            user.setPassword("123456789");
            user.setUsername("hesam");
            user.setEmail(null);
            user.setBirthDate("1380/4/4");
            user.setNationalCode(3861111111l);
            user.setPhoneNumber(9181122535l);
            user.setSajamCode(321687687l);
            user.setIdentifierCode(0l);
            showMenu();
        }
        else {
            System.out.println("wrong password or username");
        }
    }

    private static void showMenu(){

        Scanner scanner = new Scanner(System.in);
        boolean doWhile = true;
        do{
            System.out.println("1-show my personal info" +
                " \n2-set an order" +
                " \n3-edit my info" +
                " \n4-get your invitation code" +
                " \n5-people you have invited" +
                " \n6-add a note" +
                " \n7-see notes" +
                " \n8-help" +
                " \n9-exit");
            int input = scanner.nextInt();
            switch(input){
                case 1->
                        System.out.println(
                                "first name : "+user.getFname()+"\n"
                                        +"first name : "+user.getLname()+"\n"
                                        +"username : "+user.getUsername()+"\n"
                                        +"password : "+user.getPassword()+"\n"
                                        +"gender : "+user.getGender()+"\n"
                                        +"email : "+user.getEmail()+"\n"
                                        +"birthdate : "+user.getBirthDate()+"\n"
                                        +"ID : "+user.getNationalCode()+"\n"
                                        +"Phone number : "+user.getPhoneNumber()+"\n"
                                        +"sajam code : "+user.getSajamCode()+"\n"
                                        +"inviter code : "+user.getIdentifierCode()+"\n"
                                        +"invitation code : "+user.getIntroductionCode()+"\n"
                        );
                case 2 -> {
                    System.out.println("enter the symbol");
                    String symbol = scanner.nextLine();
                    System.out.println("enter the amount");
                    long amount = scanner.nextLong();
                    user.setOrder(new Orders(symbol , user.getId() , "today" , amount));
                }
                case 3 -> {
                    System.out.println("enter your first name : ");
                    user.setFname(scanner.nextLine());
                    System.out.println("enter your last name : ");
                    user.setLname(scanner.nextLine());
                    System.out.println("enter your desired password : ");
                    user.setPassword(scanner.nextLine());
                    System.out.println("enter your desired username : ");
                    user.setUsername(scanner.nextLine());
                }
                case 4 -> {
                    if(user.getIntroductionCode()==0l){
                        recommenders.add(user.getId());
                        user.CreateCode();
                    }
                    System.out.println("your invitation code : "+user.getIntroductionCode());
                }
                case 5 -> System.out.println(user.getIntroducedPeople());
                case 6 -> {
                    scanner.nextLine();
                    System.out.println("enter your desired symbol : ");
                    String symbol = scanner.nextLine();
                    System.out.println("enter your note title : ");
                    String title = scanner.nextLine();
                    System.out.println("enter your note : ");
                    String note = scanner.nextLine();
                    System.out.println("enter your alarm date : ");
                    String date = scanner.nextLine();
                    user.setNote(new NotesAndAlerts(note,title,symbol , date));
                }
                case 7 -> System.out.println(user.getNotes());

                case 8 -> {
                    System.out.println("you are connected to operator number 1 with contract code : " + operator.getContractCode() + "\nhello! \nhow can I help you?");
                    scanner.nextLine();
                    System.out.println("Alright! we call you later!");
                }
                case 9 -> doWhile=false;
                default -> System.out.println("wrong input");
            }
        }while(doWhile);
    }
}
