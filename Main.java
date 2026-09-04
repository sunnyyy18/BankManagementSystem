import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

class Customer{
    private int id;
    private String name;
    private double balance;


    Customer(int id,String name,double balance){
        this.id=id;
        this.name=name;
        this.balance=balance;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    void deposit(double amount){
        if(amount<=0)return;
        balance+=amount;
        System.out.println("Amount deposited succesfully");
    }
    void withdraw(double amount){
        if (amount <= 0) {
            System.out.println("Invalid amount");
        }
        else if (amount > balance) {
            System.out.println("Insufficient balance");
        }
        else {
            balance -= amount;
        }
        System.out.println("Amount withdrawal successfully");
    }
    void checkBalance(){
        System.out.println("Account holder :" + name +" " + "ID :"+ id);
        System.out.println("Your current balance is :"+balance);
    }
}
public class Main{
    static void functions (Customer alpha){
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Press 1 to Deposit ");
            System.out.println("Press 2 to Withdraw ");
            System.out.println("Press 3 to Check Account info");
            System.out.println("Press 0 to exit");
            int choice = scan.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter the amount you want to add :");
                    double Addamount = scan.nextDouble();
                    alpha.deposit(Addamount);
                    break;
                case 2:
                    System.out.println("Enter amount to be withdraw :");
                    double withamount = scan.nextDouble();
                    alpha.withdraw(withamount);
                    break;
                case 3:
                    alpha.checkBalance();
                    break;
                case 0:
                    System.out.println("Thank you for Choosing Us");
                    flag=false;
                    break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer,Customer> map = new HashMap<>();
        boolean flag = true;
        while(flag) {
            System.out.println("To Register Customer press 1");
            System.out.println("To Perform Activity press 2");
            System.out.println("Enter 0 to exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter user id :");
                    int id = sc.nextInt();
                    while(true){
                        if(map.containsKey(id)){
                            System.out.println("Error!!!    User already exist please Re-Enter");
                            id = sc.nextInt();
                        }
                        else{
                            break;
                        }
                    }
                    sc.nextLine();
                    System.out.println("Enter Account Holder's Name :");
                    String name = sc.nextLine();
                    System.out.println("Please Add base amount :");
                    double balance = sc.nextDouble();
                    Customer c = new Customer(id, name, balance);
                    map.put(id, c);
                    break;
                case 2:
                    System.out.println("Please verify acc by entering ID : ");
                    int veri = sc.nextInt();
                    if(map.containsKey(veri)){
                        functions (map.get(veri));
                    }
                    else {
                        System.out.println("User do not Exist");
                    }
                    break;
                case 0:
                    flag=false;
                    break;
            }
        }
    }
}