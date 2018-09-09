package njs.data;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Nicholas Spitzer
 * <p>
 * Class to contain data about a transaction
 * <p>
 * Fields:
 * - isExpense: true/false to say if the Transaction is an expense or income
 * - amount: BigDecial to contain how much the Transaction is
 * - date: Date for when the transaction happened
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

    public boolean isExpense() {
        return isExpense;
    }

    /**
     * @return String saying if it is an expense or not
     */
    public String isExpenseString() {
        if (isExpense) {
            return "Expense";
        }
        return "Income";
    }

    /**
     * Set if Transaction is an expense or not
     *
     * @param isExpense as boolean
     */
    public void setIfExpense(boolean isExpense) {
        this.isExpense = isExpense;
    }

    /**
     * Set if Transaction is an expense or not
     *
     * @param isExpense as String
     */
    public void setIfExpense(String isExpense) {

        if (isExpense.equals("Income")) {
            this.isExpense = false;
        } else if (isExpense.equals("Expense")) {
            this.isExpense = true;
        }
    }

    /**
     * @return BigDecimal for how much the Transaction is
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Update amount of transaction
     *
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
     * @return date of transaction as String
     */
    public String getDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(date);
    }

    /**
     * Update date of transaction
     *
     * @param date Date of transaction
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return transactionID for transaction
     */
    public String getTransactionID() {
        return transactionID;
    }
}
