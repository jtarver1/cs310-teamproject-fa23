package edu.jsu.mcis.cs310.tas_fa23;

import edu.jsu.mcis.cs310.tas_fa23.dao.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class AbsenteeismTest {
    
    private DAOFactory daoFactory;

    @Before
    public void setup() {

        daoFactory = new DAOFactory("tas.jdbc");

    }
    
    @Test
    public void testAbsenteeismShift1Weekday() throws SQLException {
        
        AbsenteeismDAO absenteeismDAO = daoFactory.getAbsenteeismDAO();
        EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();
        PunchDAO punchDAO = daoFactory.getPunchDAO();
		
        /* Get Punch/Employee Objects */
        
        Punch p = punchDAO.find(3634);
        Employee e = employeeDAO.find(p.getBadge());
        Shift s = e.getShift();
        Badge b = e.getBadge();
        
        /* Get Pay Period Punch List */
        
        LocalDate ts = p.getOriginaltimestamp().toLocalDate();
        LocalDate begin = ts.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        LocalDate end = begin.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        
        ArrayList<Punch> punchlist = punchDAO.list(b, begin, end);
        
        /* Adjust Punch List */
        
        for (Punch punch : punchlist) {
            punch.adjust(s);
        }
        
        /* Compute Pay Period Total Absenteeism */
        
        BigDecimal percentage = DAOUtility.calculateAbsenteeism(punchlist, s);
        
        /* Insert Absenteeism Into Database */
        
        Absenteeism a1 = new Absenteeism(e, ts, percentage);
        absenteeismDAO.create(a1);
        
        /* Retrieve Absenteeism From Database */
        
        Absenteeism a2 = absenteeismDAO.find(e, ts);
        
        /* Compare to Expected Value */
        
        assertEquals("#28DC3FB8 (Pay Period Starting 09-02-2018): 2.50%", a2.toString());
        
    }
    
    @Test
    public void testAbsenteeismShift1Weekend() throws SQLException {
        
        AbsenteeismDAO absenteeismDAO = daoFactory.getAbsenteeismDAO();
        EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();
        PunchDAO punchDAO = daoFactory.getPunchDAO();

        /* Get Punch/Employee Objects */
        
        Punch p = punchDAO.find(1087);
        Employee e = employeeDAO.find(p.getBadge());
        Shift s = e.getShift();
        Badge b = e.getBadge();
        
        /* Get Pay Period Punch List */
        
        LocalDate ts = p.getOriginaltimestamp().toLocalDate();
        LocalDate begin = ts.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        LocalDate end = begin.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        
        ArrayList<Punch> punchlist = punchDAO.list(b, begin, end);
        
        /* Adjust Punch List */
        
        for (Punch punch : punchlist) {
            punch.adjust(s);
        }
        
        /* Compute Pay Period Total Absenteeism */
        
        BigDecimal percentage = DAOUtility.calculateAbsenteeism(punchlist, s);
        
        /* Insert Absenteeism Into Database */
        
        Absenteeism a1 = new Absenteeism(e, ts, percentage);
        absenteeismDAO.create(a1);
        
        /* Retrieve Absenteeism From Database */
        
        Absenteeism a2 = absenteeismDAO.find(e, ts);
        
        /* Compare to Expected Value */
        
        assertEquals("#F1EE0555 (Pay Period Starting 08-05-2018): -20.00%", a2.toString());
        
    }
    
    @Test
    public void testAbsenteeismShift2Weekend() throws SQLException {
        
        AbsenteeismDAO absenteeismDAO = daoFactory.getAbsenteeismDAO();
        EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();
        PunchDAO punchDAO = daoFactory.getPunchDAO();

        /* Get Punch/Employee Objects */
        
        Punch p = punchDAO.find(4943);
        Employee e = employeeDAO.find(p.getBadge());
        Shift s = e.getShift();
        Badge b = e.getBadge();
        
        /* Get Pay Period Punch List */
        
        LocalDate ts = p.getOriginaltimestamp().toLocalDate();
        LocalDate begin = ts.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        LocalDate end = begin.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        
        ArrayList<Punch> punchlist = punchDAO.list(b, begin, end);
        
        /* Adjust Punch List */
        
        for (Punch punch : punchlist) {
            punch.adjust(s);
        }
        
        /* Compute Pay Period Total Absenteeism */
        
        BigDecimal percentage = DAOUtility.calculateAbsenteeism(punchlist, s);
        
        /* Insert Absenteeism Into Database */
        
        Absenteeism a1 = new Absenteeism(e, ts, percentage);
        absenteeismDAO.create(a1);
        
        /* Retrieve Absenteeism From Database */
        
        Absenteeism a2 = absenteeismDAO.find(e, ts);
        
        /* Compare to Expected Value */
        
        assertEquals("#08D01475 (Pay Period Starting 09-16-2018): -27.50%", a2.toString());
        
    }
    
    @Test
    public void testAbsenteeismShift12Weekday() throws SQLException {
        
        AbsenteeismDAO absenteeismDAO = daoFactory.getAbsenteeismDAO();
        EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();
        PunchDAO punchDAO = daoFactory.getPunchDAO();

        /* Get Punch/Employee Objects */
        
        Punch p = punchDAO.find(1792);
        Employee e = employeeDAO.find(p.getBadge());
        Shift s = e.getShift();
        Badge b = e.getBadge();
        
        /* Get Pay Period Punch List */
        
        LocalDate ts = p.getOriginaltimestamp().toLocalDate();
        LocalDate begin = ts.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        LocalDate end = begin.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        
        ArrayList<Punch> punchlist = punchDAO.list(b, begin, end);
        
        /* Adjust Punch List */
        
        for (Punch punch : punchlist) {
            punch.adjust(s);
        }
        
        /* Compute Pay Period Total Absenteeism */
        
        BigDecimal percentage = DAOUtility.calculateAbsenteeism(punchlist, s);
        
        /* Insert Absenteeism Into Database */
        
        Absenteeism a1 = new Absenteeism(e, ts, percentage);
        absenteeismDAO.create(a1);
        
        /* Retrieve Absenteeism From Database */
        
        Absenteeism a2 = absenteeismDAO.find(e, ts);
        
        /* Compare to Expected Value */
        
        assertEquals("#76E920D9 (Pay Period Starting 08-12-2018): -4.38%", a2.toString());
        
    }
    
    @Test
    public void testAbsenteeismShift3Weekday() throws SQLException {
        
        AbsenteeismDAO absenteeismDAO = daoFactory.getAbsenteeismDAO();
        EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();
        PunchDAO punchDAO = daoFactory.getPunchDAO();

        /* Get Punch/Employee Objects */
        
        Punch p = punchDAO.find(1904);
        Employee e = employeeDAO.find(p.getBadge());
        Shift s = e.getShift();
        Badge b = e.getBadge();
        
        /* Get Pay Period Punch List */
        
        LocalDate ts = p.getOriginaltimestamp().toLocalDate();
        LocalDate begin = ts.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        LocalDate end = begin.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        
        ArrayList<Punch> punchlist = punchDAO.list(b, begin, end);
        
        /* Adjust Punch List */
        
        for (Punch punch : punchlist) {
            punch.adjust(s);
        }
        
        /* Compute Pay Period Total Absenteeism */
        
        BigDecimal percentage = DAOUtility.calculateAbsenteeism(punchlist, s);
        
        /* Insert Absenteeism Into Database */
        
        Absenteeism a1 = new Absenteeism(e, ts, percentage);
        absenteeismDAO.create(a1);
        
        /* Retrieve Absenteeism From Database */
        
        Absenteeism a2 = absenteeismDAO.find(e, ts);
        
        /* Compare to Expected Value */
        
        assertEquals("#398B1563 (Pay Period Starting 08-19-2018): -11.25%", a2.toString());
        
    }
}