import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Email{

    private String email;

    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private String alternateEmail;
    private int defaultpasswordLength=12;
    private int mailboxCapacity = 500;
    private String companysuffix = "FANG.com";

    public Email(String firstName,String lastName){
       this.firstName = firstName;
       this.lastName = lastName;

       System.out.println("Email created with firstname = " + this.firstName + " and lastname = "+ this.lastName);
       this.department = setDept();
       System.out.println("Department :" + this.department);
       
       this.password = genPassword(defaultpasswordLength);
       System.out.println("Your password is : "+ this.password);

       email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+ department +"." +companysuffix; 
       System.out.println("your email is :" + email);
    }

    private String setDept(){
        System.out.println("Department Codes \n 1 for Sales \n 2 for Development \n 3 for Accounting \n 0 for none \n Enter the Department" );
        Scanner sc = new Scanner(System.in);
        int deptChoice =  sc.nextInt();

        if(deptChoice == 1) {return "Sales";}
        else if(deptChoice == 2) {return "Development";}
        else if(deptChoice ==3) {return "Accounting";}
        else{return "";}
    }
   

    // private String setDept() {
    //     String[] options = {"None", "Sales", "Development", "Accounting"};
    //     int choice = JOptionPane.showOptionDialog(
    //         null,
    //         "Select Department",
    //         "Department Selection",
    //         JOptionPane.DEFAULT_OPTION,
    //         JOptionPane.INFORMATION_MESSAGE,
    //         null,
    //         options,
    //         options[0]
    //     );
    
    //     if (choice == 1) {
    //         return "Sales";
    //     } else if (choice == 2) {
    //         return "Development";
    //     } else if (choice == 3) {
    //         return "Accounting";
    //     } else {
    //         return ""; // Default to None
    //     }
    // }
    
    
    

    private String genPassword(int length){

        String setpass = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&";
        char pass[] = new char[length];

        for(int i = 0;i<length;i++){
            int random = (int) (Math.random() * setpass.length());
            pass[i] = setpass.charAt(random);
        }

        return new String(pass);
      
    }

    public void setCapacity(int value){
        this.mailboxCapacity = value;
        System.out.println("Your mailbox capacity is now changed to "+value+" emails");
    }
    public void setpass(String pass){
        this.password = pass;
        System.out.println("Your password is changed to " +this.password);
    }
    public void setAlternateEmail(String mail){
        this.alternateEmail = mail;
        System.out.println("Your alternate mail is changed to "+this.alternateEmail);
    }

    public String getalternateEmail(){
        return this.alternateEmail;
    }
    public int getmailCapacity(){
        return this.mailboxCapacity;
    }

    public String getPassword(){
        return this.password;

    }
    public void showInfo(){
        System.out.println("Name : "+this.firstName + " "+this.lastName +"\n"+"Mail : "+this.email + "\nMailBox Capacity : "+this.mailboxCapacity);
    }
    public String getEmail() {
        return this.email;
    }
    
    public void menu(){

        while(true){
        Scanner sc = new Scanner(System.in);
        System.out.println("EXTRA OPTIONS :\n1 to change mailbox capacity \n2 to change you password\n3 to change alternate email \n4 to view your whole info\n0 to exit ");
        int choice = sc.nextInt();
        if(choice  == 1){
           System.out.println("Enter the value for mail capacity");
           int value = sc.nextInt();
           setCapacity(value);
        }
        else if(choice == 2){
          System.out.println("Enter new password");
          String newPass = sc.next();
          setpass(newPass);
        }
        else if(choice == 3){
            System.out.println("Enter you new alternate email");
            String newAlternate = sc.next();
            setAlternateEmail(newAlternate);
        }
        else if(choice == 0){
            break;
        }
        else if (choice == 4){
            showInfo();
        }
        else{
            System.out.println("Invalid Choice");
            break;
        }
    }
    }

}