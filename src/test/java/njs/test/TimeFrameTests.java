package njs.test;

import njs.data.Transaction;
import njs.data.time.Month;
import njs.data.time.Quarter;
import njs.data.time.Year;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFrameTests {

    private Transaction transaction1;
    private Transaction transaction2;
    private Transaction transaction3;
    private Transaction transaction4;
    private Transaction transaction5;
    private BigDecimal amount1 = new BigDecimal("7.95").setScale(2, RoundingMode.CEILING);
    private BigDecimal amount2 = new BigDecimal("10.87").setScale(2, RoundingMode.CEILING);
    private BigDecimal amount3 = new BigDecimal("1.37").setScale(2, RoundingMode.CEILING);
    private BigDecimal amount4 = new BigDecimal("100.24").setScale(2, RoundingMode.CEILING);
    private BigDecimal amount5 = new BigDecimal("1.24").setScale(2, RoundingMode.CEILING);
    private Date date1;
    private Date date2;
    private Date date3;
    private Date date4;
    private Date date5;

    private Month month1;
    private Month month2;
    private Month month3;
    private Quarter quarter1;
    private Quarter quarter2;
    private Year year;

    private String report;

    public TimeFrameTests() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            date1 = dateFormat.parse("05/14/2003");
            date2 = dateFormat.parse("05/17/2003");
            date3 = dateFormat.parse("06/07/2003");
            date4 = dateFormat.parse("06/24/2003");
            date5 = dateFormat.parse("07/11/2003");
            month1 = new Month(dateFormat.parse("05/01/2003"), dateFormat.parse("05/31/2003"),
                    4, "May 2003");
            month2 = new Month(dateFormat.parse("06/01/2003"), dateFormat.parse("06/30/2003"),
                    4, "June 2003");
            month3 = new Month(dateFormat.parse("07/01/2003"), dateFormat.parse("07/31/2003"),
                    4, "July 2003");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        transaction1 = new Transaction(true, amount1, date1);
        transaction2 = new Transaction(false, amount2, date2);
        transaction3 = new Transaction(true, amount3, date3);
        transaction4 = new Transaction(true, amount4, date4);
        transaction5 = new Transaction(true, amount5, date5);
    }

    public String testMonthFunctions() {

        report = "";

        // Add a transaction
        month1.addTransaction(transaction1);
        // Report back
        report = report.concat(String.format("Initial Transaction: %s\n" +
                "Total Expenses: $%s\nTotal Income: $%s\nNet Total: $%s",
                month1.getTransaction(transaction1.getTransactionID()), month1.getTotalExpenses(),
                        month1.getTotalIncome(), month1.getNetTotal()));

        // Add 2nd transaction
        // Report back

        // Remove 2nd transaction
        // Report back

        return report;
    }
}
