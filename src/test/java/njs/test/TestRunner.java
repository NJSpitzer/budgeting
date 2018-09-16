package njs.test;

public class TestRunner {

    public static void main(String args[]) {

        TransactionClassTests transactionTests = new TransactionClassTests();
        TimeFrameTests timeFrameTests = new TimeFrameTests();

        System.out.println("TRANSACTION TESTS\n" +
                "******************************************************");
        System.out.println("Create Default Transaction test: \n" + transactionTests.createDefaultTransaction());
        System.out.println("\nCreate Transaction with Amount test: \n" + transactionTests.createTransactionWithAmount());
        System.out.println("\nCreate Transaction as Income with Amount test: \n" + transactionTests.createTransactionAmountIsExpense());
        System.out.println("\nCreate Transaction with Amount and Date test: \n" + transactionTests.createTransactionWithAmountAndDate());
        System.out.println("\nCreate Transaction as Income with Amount and Date test: \n" + transactionTests.createTransactionIsExpenseAmountDate());

        System.out.println("\n\n\nTIME FRAME TESTS\n" +
                "******************************************************");

        System.out.println("Test Month:\n" + timeFrameTests.testMonthFunctions());
        System.out.println("\nTest Quarter:\n" + timeFrameTests.testQuarterFunctions());
    }
}
