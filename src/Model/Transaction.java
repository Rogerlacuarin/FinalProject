/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ghest
 */
public class Transaction {
    
    
     String name;
    private String date;
    private String type;
    private double amount;
    private String description;

    public Transaction(String name, String date,
            String type, double amount, String description) {

        this.name = name;
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }   
}
