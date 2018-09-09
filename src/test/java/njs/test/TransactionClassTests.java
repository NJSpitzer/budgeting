package njs.test;

import njs.data.Transaction;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionClassTests {

    private Transaction transaction;
    private BigDecimal transactionAmount;
    private Date transactionDate;
    private boolean isExpense;

    private String report;

    public TransactionClassTests() {

        transactionAmount = new BigDecimal("7.56").setScale(2, RoundingMode.CEILING);

        try {
            transactionDate = new SimpleDateFormat("mm/dd/yyyy").parse("02/07/2002");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        isExpense = false;
    }

    public String createDefaultTransaction() {

        String report = "Is expense? # #\n" +
                "Has Amount? # #\n" +
                "Has Date? # #\n" +
                "Has TransactionID? # #";

        transaction = new Transaction();

        if (transaction.isExpense().equals("Expense")) {
            report = report.replaceFirst("#", "Yes");
            report = report.replaceFirst("#", transaction.isExpense());
        } else {
            report = report.replaceFirst("#", "No");
            report = report.replaceFirst("#", transaction.isExpense());
        }

        if (transaction.getAmount() != null) {
            report = report.replaceFirst("#", "Yes");
            report = report.replaceFirst("#", transaction.getAmount().toString());
        } else {
            report = report.replaceFirst("#", "No");
            report = report.replaceFirst("#", "NULL");
        }

        if (transaction.getDate() != null) {
            report = report.replaceFirst("#", "Yes");
            report = report.replaceFirst("#", transaction.getDate().toString());
        } else {
            report = report.replaceFirst("#", "No");
            report = report.replaceFirst("#", "NULL");
        }

        if (transaction.getTransactionID() != null) {
            report = report.replaceFirst("#", "Yes");
            report = report.replaceFirst("#", transaction.getTransactionID());
        } else {
            report = report.replaceFirst("#", "No");
            report = report.replaceFirst("#", "NULL");
        }

        return report;
    }

    public String createTransactionWithAmount() {

        report = "Is amount correct? #\nExpected: $"+transactionAmount.toString()+"\nActual: $#";

        transaction = new Transaction(transactionAmount);

        if (transaction.getAmount().compareTo(transactionAmount) == 0) {
            report = report.replaceFirst("#", "Yes");
        } else {
            report = report.replaceFirst("#", "No");
        }
        report = report.replaceFirst("#", transaction.getAmount().toString());

        return report;
    }

    public String createTransactionAmountIsExpense() {

        report = String.format("Is amount correct? #\nExpected: %s\nActual: #\n" +
                "Is transaction marked as \"Income\"? # #", transactionAmount.toString());

        transaction = new Transaction(isExpense, transactionAmount);

        if (transactionAmount.compareTo(transaction.getAmount()) == 0) {
            report = report.replaceFirst("#", "Yes");
        } else {
            report = report.replaceFirst("#", "No");
        }
        report = report.replaceFirst("#", transaction.getAmount().toString());

        if (transaction.isExpense().equals("Income")) {
            report = report.replaceFirst("#", "Yes");
        } else {
            report = report.replaceFirst("#", "No");
        }
        report = report.replaceFirst("#", transaction.isExpense());

        return report;
    }
}
