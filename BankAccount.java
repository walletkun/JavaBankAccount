import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private ArrayList<Transaction> transactions;
    private double DEFAULT_INTERESTRATE = 0.055;


    //Default constructor with only accountNumber and accountHolder because depending on what's the first deposit amount
    public BankAccount(String accountNumber, String accountHolder){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    
    //Withdrawl 
    public double withdrawal(double withdrawlAmount,String message){
        //If withdrawl is larger than the balance return a message
        if(withdrawlAmount > balance){
            throw new IllegalArgumentException("Insufficient funds");
        }
        else{
            balance -= withdrawlAmount;
            return balance;
        }
    }


    //Deposit
    public double deposit(double depositAmount, String message){
        //Checks the depositAmount to be greater than 20$
        if(depositAmount < 20.0){
            throw new IllegalArgumentException("Deposit must be greater than 20$");
        }
        balance += depositAmount;
        return balance;
    }
    

    public void applyInterest(){
        double interest = (balance * DEFAULT_INTERESTRATE)/100;
        deposit(interest, "Interest Added");
    }

    
    public ArrayList<Transaction> getTransactionHistory() {
        return transactions;
    }

    private String getCurrentDate() {
        // Define the desired date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Get the current date and format it
        LocalDateTime now = LocalDateTime.now();
        return formatter.format(now);
    }


    public String getFormattedTransactionHistory() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction history for ").append(accountHolder).append("'s ").append(this.getClass().getSimpleName()).append(":\n");
        for (Transaction transaction : transactions) {
            sb.append(transaction).append("\n");
        }
        sb.append("Current balance: $").append(balance);
        return sb.toString();
    }

}
