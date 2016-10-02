/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;
import java.text.NumberFormat;
/**
 *
 * @author rjy5060
 */
public abstract class Employee{

    private final String firstName;
    private final String lastName;
    private final String SSN;
    //private double earn;  //Decided against using an earn variable
    
    
    public Employee(String firstName, String lastName, String SSN){
        this.firstName=firstName;
        this.lastName=lastName;
        this.SSN=SSN;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getSSN(){
        return SSN;
    }
    
    public abstract double calcEarn();
    
    public abstract void raise(double perc);
    
    
    
    public String toString(){
        return String.format("%s: %s %s %n  %s %s %n",
        "Employee: ", getFirstName(), getLastName(), "SSN: ", getSSN());
    }
    
    
}
