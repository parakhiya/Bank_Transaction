import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import javafx.scene.transform.Scale;
import java.util.Date;

class Data{
    String date;
    int amount;

    Data(String date,int amount){
        this.date=date;
        this.amount=amount;
    }
}
 

class CheckingAccount{

    //Creating database
    private List<Data> credit=new ArrayList<>();
    private List<Data> debit=new ArrayList<>();
    private int InitialBalance=10000;

    //Creating date object for current day
    Date date=new Date();
    SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
    String dt=formatter.format(date);

    //Adds money to account
    void addMoney(int amount){

        Data data=new Data(dt,amount);
        credit.add(data);

        InitialBalance+=amount;

    }

    //Debits money from account
    void extractMoney(int amount){
        Data data=new Data(dt,amount);
        debit.add(data);

        InitialBalance-=amount;
    }

    //Displays transaction for checking account
    void displayTransaction(){

        System.out.println("credits are");
        for(Data dt:credit){
             
            System.out.println(dt.date+" Credit "+dt.amount);
        } 

        System.out.println("\ndebits are");
        for(Data dt:debit){
             
            System.out.println(dt.date+" Debit "+dt.amount);
        } 

        System.out.println("\nFinal balance is "+InitialBalance);
    }

    boolean isValid(int amount){
        return InitialBalance-amount>=0;
    }
}

class SavingAccount{


   //Creating database
   private List<Data> credit=new ArrayList<>();
   private List<Data> debit=new ArrayList<>();
   private int InitialBalance=10000;

   //Creating date object for current day
   Date date=new Date();
   SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
   String dt=formatter.format(date);

   //Adds money to account
   void addMoney(int amount){

       Data data=new Data(dt,amount);
       credit.add(data);

       InitialBalance+=amount;

   }

   //Debits money from account
   void extractMoney(int amount){
       Data data=new Data(dt,amount);
       debit.add(data);

       InitialBalance-=amount;
   }

   //Displays transaction for saving account
   void displayTransaction(){

       System.out.println("credits are");
       for(Data dt:credit){
            
           System.out.println(dt.date+" Credit "+dt.amount);
       } 

       System.out.println("\ndebits are");
       for(Data dt:debit){
            
           System.out.println(dt.date+" Debit "+dt.amount);
       } 

       System.out.println("\nFinal balance is "+InitialBalance);
   }

   boolean isValid(int amount){
       return InitialBalance-amount>=0;
   }
}




class Bank{
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        //User objects for accounts
        SavingAccount sa=new SavingAccount();
        CheckingAccount ca=new CheckingAccount();

        System.out.println("press 1 for saving account ");
        System.out.println("press 2 for checking account ");
        System.out.println("press 3 for exit\n ");        
        int choice =sc.nextInt();

        while(choice!=3){
            
            switch(choice){

                //Saving Account
                case 1:  
                        System.out.println("press 1 for debit saving account ");
                        System.out.println("press 2 for credit saving account ");
                        System.out.println("press 3 for display transaction saving account \n ");
                        
                        
                        int choice1=sc.nextInt();

                        switch(choice1){
                            case 1:
                                    
                                    System.out.println("enter amount to be debited saving account ");
                                    int amount=sc.nextInt();

                                    while(!sa.isValid(amount)){
                                        System.out.println("Please enter valid amount saving account ");
                                        amount=sc.nextInt();
                                    }
                                     
                                    while(amount%500!=0){
                                        System.out.println("Please enter amount in multiple of 500 ");
                                        amount=sc.nextInt();
                                    }
                                    sa.extractMoney(amount);
                                    break;
                            case 2:
                                    
                                    System.out.println("enter amount to be added saving account ");
                                    int amount1=sc.nextInt();
                                    while(amount1%500!=0){
                                        System.out.println("Please enter amount in multiple of 500  ");
                                        amount1=sc.nextInt();
                                    }
                                    sa.addMoney(amount1);
                                    break;
                            case 3:
                                    sa.displayTransaction();
                                    break;
                            default :
                                    System.out.println("Please enter valid choice");
                                    
                                    
                        }
                        break;
                //Checking account
                case 2:
                        System.out.println("press 1 for debit checking account ");
                        System.out.println("press 2 for credit checking account");
                        System.out.println("press 3 for display transaction checking account \n ");

                        int choice2=sc.nextInt();

                        switch(choice2){
                            case 1:
                                    
                                    System.out.println("enter amount to be debited checking account ");
                                    int amount=sc.nextInt();

                                    while(!ca.isValid(amount)){
                                        System.out.println("Please enter valid amount checking account ");
                                        amount=sc.nextInt();
                                    }

                                    while(amount%500!=0){
                                        System.out.println("Please enter amount in multiple of 500 ");
                                        amount=sc.nextInt();
                                    }
                                    ca.extractMoney(amount);
                                    break;
                            case 2:
                                     
                                    System.out.println("enter amount to be added checking account");
                                    int amount1=sc.nextInt();
                                    while(amount1%500!=0){
                                        System.out.println("Please enter amount in multiple of 500 ");
                                        amount1=sc.nextInt();
                                    }
                                    ca.addMoney(amount1);
                                    break;
                            case 3:
                                    ca.displayTransaction();
                                    break;
                            default :
                                    System.out.println("Please enter valid choice");
                        }                   
                        break;
                //for exit
                case 3:System.exit(1);
                        break;

                default :
                        System.out.println("Please enter valid choice");
            }

            System.out.println("press 1 for saving account ");
            System.out.println("press 2 for checking account ");
            System.out.println("press 3 for exit\n ");
        
            choice =sc.nextInt();
        }
        
    }
}