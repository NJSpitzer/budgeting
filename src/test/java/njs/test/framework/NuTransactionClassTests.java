package njs.test.framework;

import njs.data.Transaction;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NuTransactionClassTests implements ITest {

    private Transaction transaction;
    private BigDecimal transactionAmount;
    private Date transactionDate;
    private boolean isExpense;

    private String report;

    public NuTransactionClassTests()  {

        transactionAmount = new BigDecimal("7.56").setScale(2, RoundingMode.CEILING);

        try {
            transactionDate = new SimpleDateFormat("MM/dd/yyyy").parse("02/07/2002");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        isExpense = false;
    }

    /* ******************** NEW TEST STRUCTURE ************************/

    @Test
    public void newTransactionCreationTest() {

        String report = "Is expense? # #\n" +
                "Has Amount? # #\n" +
                "Has Date? # #\n" +
                "Has TransactionID? # #";

        Reporter.log("Testing TestNG reporter. Report update");

        transaction = new Transaction();

        Verification.verifyTrue(transaction.isExpense(),
                String.format("Validating if transaction is expense? %s", transaction.isExpenseString()));

        Verification.verifyTrue(transaction.getAmount() != null,
                String.format("Transaction is not null? %s", transaction.getAmount()));

        Verification.verifyTrue(transaction.getDate() != null,
                String.format("Date is not null? %s", transaction.getDate()));

        Verification.verifyTrue(transaction.getTransactionID() != null,
                String.format("Transaction ID is not null? %s", transaction.getTransactionID()));
    }

    @Override
    public String getTestName() {
        return getClass().getSimpleName();
    }
}
