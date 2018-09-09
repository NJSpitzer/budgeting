package njs.data;

import java.math.BigDecimal;

/**
 * @author Nicholas Spitzer
 *
 * Class to contain data about a transaction
 *
 * Fields:
 * - isExpense: true/false to say if the Transaction is an expense or income
 * - amount: BigDecial to contain how much the Transaction is
 *
 * Constructors: 3
 * - Transaction()
 * - Transaction(BigDecimal amount)
 * - Transaction(boolean isExpense, BigDecimal amount)
 *
 * Methods
 * - isExpense()
 * - getAmount()
 */

public class Transaction {

    private boolean isExpense;
    private BigDecimal amount;

    public Transaction() {
        isExpense = false;
        amount = new BigDecimal("0.00").setScale(2, BigDecimal.ROUND_CEILING);
    }

    public Transaction(BigDecimal amount) {
        this.amount = amount;
    }

    public Transaction(boolean isExpense, BigDecimal amount) {
        this.isExpense = isExpense;
        this.amount = amount;
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
    public void setIsExpense(boolean isExpense) {
        this.isExpense = isExpense;
    }

    /**
     * @return BigDecimal for how much the Transaction is
     */
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
