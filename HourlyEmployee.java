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
public class HourlyEmployee extends Employee{
    private double hourlyWage;
    private double hoursWorked;
    
    public HourlyEmployee(String firstName, String lastName, String SSN,
            double hourlyWage, int hoursWorked){
        
        super(firstName,lastName,SSN);
        
        if(hourlyWage<=0.0)
            throw new IllegalArgumentException("Don't be a scrooge.");
        
        if(hoursWorked<1||hoursWorked>168)
            throw new IllegalArgumentException("Nice hours, dude.");       
        
        this.hourlyWage=hourlyWage;
        this.hoursWorked=hoursWorked;
    }
    
    public void setWage(double val){
        if(val<=0)
            throw new IllegalArgumentException("This isn't a shirt factory.");
        
        hourlyWage=val;
    }
    
    public double getWage(){
        return hourlyWage;
    }
    
    public void setHours(int val){
        if(val<=0 || val>168)
            throw new IllegalArgumentException("Permanent vacay or indentured "
                    + "servant ");
        
        hoursWorked=val;
    }
    
    public double getHours(){
        return hoursWorked;
    }
    
    @Override
    public double calcEarn(){       
        //if overtime, calculate 40 hours regular and add the extra overtime
        if(hoursWorked>40)
            return ((hoursWorked-40)*1.5*hourlyWage)+40*hourlyWage;
        
        return hoursWorked*hourlyWage;
    }
    
    @Override
    //precond-perc is entered as a decimal
    public void raise(double perc){
        if(perc>=1)
            throw new IllegalArgumentException("Percentage must be added "
                    + "as a decimal.");
        
        hourlyWage=hourlyWage*(1+perc);
    }
    
    @Override
    public String toString(){
        return String.format("%s: %s %s %s: %s%n  %s: %.2f%n  %s: %.2f%n  %s %s%n",
                "Hourly Employee", getFirstName(), getLastName(),"with ssn",
                getSSN(),"Hourly Wage", getWage(), "Hours Worked", 
                getHours(), "Earnings:", NumberFormat.getCurrencyInstance().format(calcEarn()));      
    }
    
}
