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
public class CommissionEmployee extends Employee{
    private double grossSales;
    private double comRate;
    
    public CommissionEmployee(String firstName, String lastName, String SSN,
            double grossSales, double comRate){
        super(firstName, lastName, SSN);
        
        if(grossSales<=0.0)
            throw new IllegalArgumentException("Sales cannot be 0.");
        
        if(comRate<=0.0||comRate>=1.0)
            throw new IllegalArgumentException("CommissionRate cannot be 0 and cannot be"
                    + "greater than 1.");
        
        this.grossSales=grossSales;
        this.comRate=comRate;
    }
    
    public double getGrossSales(){
        return grossSales;
    }
    
    public void setGrossSales(double val){
        if(val<=0)
            throw new IllegalArgumentException("No sales, what a loser");
        
        this.grossSales=val;
    }
    
    public double getComRate(){
        return comRate;
    }
    
     public void setComRate(double val){
        if(val<=0)
            throw new IllegalArgumentException("Eyyyy no tip?");
        
        this.comRate=val;
    }
    
    @Override
    public double calcEarn(){
        return getGrossSales()*getComRate();
    }
    
    @Override
    //precond-perc is entered as a decimal
    public void raise(double perc){
        if(perc>=1)
            throw new IllegalArgumentException("Percentage must be added "
                    + "as a decimal.");
        
        comRate=(1+perc)*comRate;
    }
     
    @Override
    public String toString(){
        return String.format("%s: %s %s %s: %s%n  %s: %.2f%n  %s: %.2f%n  %s %s%n",
                "Commission Employee", getFirstName(), getLastName(),"with ssn",
                getSSN(),"Gross Sales", getGrossSales(), "Commission Rate", 
                getComRate(), "Earnings:", NumberFormat.getCurrencyInstance().format(calcEarn()));      
    }
    
}
