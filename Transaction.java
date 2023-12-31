import java.time.format.DateTimeFormatter;

public class Transaction {
    private String date;
    private String type;
    private double amount;
    private String description;




    //Default Constructor
    public Transaction(String date, String type, double amount, String description){
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.description = description;
    }


    //Setters and getters methods
    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public double getAmount() {
        return amount;
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Date: " + date.formatted(formatter) +
               ", Type: " + type +
               ", Amount: $" + amount +
               ", Description: " + description;
    }

}
