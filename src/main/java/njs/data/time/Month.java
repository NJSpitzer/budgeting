package njs.data.time;

import njs.data.Transaction;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;

/**
 * Class to hold all of the transactions for a month
 *
 * @author Nicholas Spitzer
 *
*/

public class Month {

    private Date startDate = new Date("01/01/2018");;
    private Date endDate = new Date("01/31/2018");
    private int numberOfWeeks = 4;
    private String name = "January 2018";
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    private BigDecimal totalIncome = new BigDecimal("0.00").setScale(2, RoundingMode.CEILING);
    private BigDecimal totalExpenses = new BigDecimal("0.00").setScale(2, RoundingMode.CEILING);
    private BigDecimal netTotal = new BigDecimal("0.00").setScale(2, RoundingMode.CEILING);

    public Month(Date startDate, Date endDate, String name) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
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
     * Add a transaction
     * @param transaction Transaction to be added
     */
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    /**
     * Remove transaction
     * @param transaction Transaction to be removed
     */
    public void removeTransaction(Transaction transaction) {
        // Remove via unique transaction ID
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getTransactionID().equals(transaction.getTransactionID())) {
                transactions.remove(i);
                break;
            }
        }
    }
}
