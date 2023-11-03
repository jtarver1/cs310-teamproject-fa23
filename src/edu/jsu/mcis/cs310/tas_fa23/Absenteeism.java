package edu.jsu.mcis.cs310.tas_fa23;

import java.math.BigDecimal;
import java.time.*;
/**
 *
 * @author Connor
 */
public class Absenteeism 
{
    private Employee employee; 
    private LocalDate date;
    private BigDecimal absentPercentage;
    
    public Absenteeism(Employee employee, LocalDate date, BigDecimal absentPercentage)
    {
        this.employee = employee;
        this.date = date;
        this.absentPercentage = absentPercentage;
    }
    
    public Employee getEmployee()
    {
        return employee;
    }
    
    public LocalDate getDate()
    {
        return date;
    }
    
    public BigDecimal getAbsentPercenatge()
    {
        return absentPercentage;
    }
    
    public String toString(Absenteeism absenteeism)
    {
        
        Double absentPercent = absenteeism.getAbsentPercenatge().doubleValue();
        Integer employeeID = absenteeism.getEmployee().getId();
        LocalDate day = absenteeism.getDate();
        
        return "#" + employeeID.toString() + " (Period Period Starting: " + day.toString() + "): " + absentPercent.toString() + "%";
    }
}