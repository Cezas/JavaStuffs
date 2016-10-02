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
public class BasePlusCommissionEmployee extends CommissionEmployee{
    private double baseSalary;
    
    public BasePlusCommissionEmployee(String firstName, String lastName, String SSN,
            double grossSales, double comRate, double baseSalary){
        
        super(firstName, lastName, SSN, grossSales, comRate);
        this.baseSalary=baseSalary;
    }
    
    public double getBaseSal(){
            return baseSalary;
        }
    public void setBaseSal(double val){
        if(val<=0)
            throw new IllegalArgumentException("What a loser, no sales");
        
        this.baseSalary=val;
    }
    
    @Override
    public double calcEarn(){
      return getGrossSales()*getComRate()+getBaseSal();
    }
    
    @Override
    //precond-perc is entered as a decimal
    public void raise(double perc){
        if(perc>=1)
            throw new IllegalArgumentException("Percentage must be added "
                    + "as a decimal.");
        
        setComRate((1+perc)*getComRate());
        baseSalary=(1+perc)*baseSalary;
        
    }
    
     @Override
    public String toString(){
        return String.format("%s: %s %s %s: %s%n  %s: %.2f%n  %s: %.2f%n  %s%.2f%n  %s%s%n",
                "Base Salary + Commission Employee", getFirstName(), getLastName(),"with ssn",
                getSSN(),"Gross Sales", getGrossSales(), "Commission Rate", 
                getComRate(), "with Base Salary of: ", getBaseSal(), 
                "Earnings: ", NumberFormat.getCurrencyInstance().format(calcEarn()));      
    }
}
