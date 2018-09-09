package njs.test;

public class TestRunner {

    public static void main(String args[]) {

        TransactionClassTests transactionTests = new TransactionClassTests();

        System.out.println("Create Default Transaction test: \n" + transactionTests.createDefaultTransaction());
        System.out.println("\nCreate Transaction with Amount test: \n" + transactionTests.createTransactionWithAmount());
        System.out.println("\nCreate Transaction as Income with Amount test: \n" + transactionTests.createTransactionAmountIsExpense());
    }
}
