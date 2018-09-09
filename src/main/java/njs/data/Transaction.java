package njs.data;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Nicholas Spitzer
 *
 * Class to contain data about a transaction
 *
 * Fields:
 * - isExpense: true/false to say if the Transaction is an expense or income
 * - amount: BigDecial to contain how much the Transaction is
 * - date: Date for when the transaction happened
 *
 */

public class Transaction {

    private boolean isExpense;
    private BigDecimal amount;
    private Date date;
    private String transactionID;

    public Transaction() {
        isExpense = true;
        amount = new BigDecimal("0.00").setScale(2, BigDecimal.ROUND_CEILING);
        date = new Date();
        transactionID = generateTransactionID();
    }

    public Transaction(BigDecimal amount) {
        isExpense = true;
        this.amount = amount;
        date = new Date();
        transactionID = generateTransactionID();
    }

    public Transaction(boolean isExpense, BigDecimal amount) {
        this.isExpense = isExpense;
        this.amount = amount;
        date = new Date();
        transactionID = generateTransactionID();
    }

    public Transaction(BigDecimal amount, Date date) {
        isExpense = true;
        this.amount = amount;
        this.date = date;
        transactionID = generateTransactionID();
    }

    public Transaction(boolean isExpense, BigDecimal amount, Date date) {
        this.isExpense = isExpense;
        this.amount = amount;
        this.date = date;
        transactionID = generateTransactionID();
    }

    private String generateTransactionID() {
        return String.valueOf(new Date().getTime());
    }

    /**
     * @return String saying if it is an expense or not
     */
    public String isExpense() {
        if (isExpense) {
            return "Income";
        }
        return "Expense";
    }

    /**
     * Set if Transaction is an expense or not
     * @param isExpense
     */
    public void setIfExpense(boolean isExpense) {
        this.isExpense = isExpense;
    }

    /**
     * @return BigDecimal for how much the Transaction is
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Update amount of transaction
     * @param amount amount in transaction
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * @return date of transaction
     */
    public Date getDate() {
        return date;
    }

    /**
     * Update date of transaction
     * @param date Date of transaction
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return transactionID for transaction
     */
    public String getTransactionID() {
        return transactionID;
    }
}
