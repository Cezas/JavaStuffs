/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package employee;

import java.text.NumberFormat;

/**
 *
 * @author Robert
 */
public class SalariedEmployee extends Employee{
    private double salary;

    
    public SalariedEmployee(String firstName, String lastName, String SSN,
            double salary){
        
        super(firstName,lastName,SSN);
        
        if(salary<=0)
            throw new IllegalArgumentException("How did you not get anything.");
  
        this.salary=salary;
    }
    
    public void setSalary(double val){
        if (val<=0)
            throw new IllegalArgumentException("Salary cannot be 0 or less");
        
    
        salary=val;
    }
    
    public double getSalary(){
        return salary;
    }
    
    @Override
    public double calcEarn(){
        //setSalary(salary);  not necessary
        
        return getSalary();
    }
    
    @Override
    //precond-perc is entered as a decimal
    public void raise(double perc){
        if(perc>=1)
            throw new IllegalArgumentException("Percentage must be added "
                    + "as a decimal.");
        
        salary=salary*(1+perc);
    }
    
    @Override
    public String toString(){
        return String.format("%s: %s %s %s: %s%n  %s: %.2f%n  %s %s%n",
                "Salaried Employee", getFirstName(), getLastName(),"with ssn",
                getSSN(),"Salary",getSalary(), "Earnings:", NumberFormat.getCurrencyInstance().format(calcEarn()));      
    }
    
}
