package njs.data.time;

import njs.data.Transaction;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Class to hold all of the transactions for a month
 *
 * @author Nicholas Spitzer
 *
*/

public class Month {

    private Date startDate;
    private Date endDate;
    private int numberOfWeeks = 4;
    private String name;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    private BigDecimal totalIncome = new BigDecimal("0.00").setScale(2, RoundingMode.CEILING);
    private BigDecimal totalExpenses = new BigDecimal("0.00").setScale(2, RoundingMode.CEILING);
    private BigDecimal netTotal = new BigDecimal("0.00").setScale(2, RoundingMode.CEILING);

    public Month() {
        GregorianCalendar calendar = new GregorianCalendar();
        startDate = calendar.getTime();
        name = String.format("%i %i", calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR));
        calendar.add(Calendar.DATE, 28);
        endDate = calendar.getTime();
        numberOfWeeks = 4;
    }

    public Month(Date startDate, Date endDate, String name) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;

        numberOfWeeks = (int)( (endDate.getTime() - startDate.getTime())
                / (1000 * 60 * 60 * 24 * 7) );
    }

    public Month(Date startDate, Date endDate, int numberOfWeeks, String name) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfWeeks = numberOfWeeks;
        this.name = name;
    }

    /**
     *
     * @return The start date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Update the start date
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     *
     * @return The end date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Update the end date
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     *
     * @return the number of weeks
     */
    public int getNumberOfWeeks() {
        return numberOfWeeks;
    }

    /**
     * Update the number of weeks
     * @param numberOfWeeks
     */
    public void setNumberOfWeeks(int numberOfWeeks) {
        this.numberOfWeeks = numberOfWeeks;
    }

    /**
     *
     * @return the Month/year name of the month (Ex: January 2018)
     */
    public String getName() {
        return name;
    }

    /**
     * Update the name of the month (Ex: January 2018)
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return total expenses as BigDecimal
     */
    public BigDecimal getTotalExpenses() {
        return totalExpenses;
    }

    /**
     *
     * @return total income as BigDecimal
     */
    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    /**
     *
     * @return net total (income minus expenses) as BigDecimal
     */
    public BigDecimal getNetTotal() {
        return netTotal;
    }

    /**
     * Add a transaction
     * @param transaction Transaction to be added
     */
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);

        if (transaction.isExpense()) {
            totalExpenses = totalExpenses.add(transaction.getAmount());
            netTotal = netTotal.subtract(transaction.getAmount());
        } else {
            totalIncome = totalIncome.add(transaction.getAmount());
            netTotal = netTotal.add(transaction.getAmount());
        }
    }

    /**
     * Remove transaction
     * @param transaction Transaction to be removed
     */
    public void removeTransaction(Transaction transaction) {
        removeTransaction(transaction.getTransactionID());
    }

    /**
     * Remove transaction
     * @param transactionID ID of transaction to remove
     */
    public void removeTransaction(String transactionID) {

        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getTransactionID().equals(transactionID)) {
                Transaction transaction = transactions.get(i);

                if (transaction.isExpense()) {
                    totalExpenses = totalExpenses.subtract(transaction.getAmount());
                    netTotal = netTotal.add(transaction.getAmount());
                } else {
                    totalIncome = totalIncome.subtract(transaction.getAmount());
                    netTotal = netTotal.subtract(transaction.getAmount());
                }

                transactions.remove(transaction);

                break;
            }
        }
    }
}
