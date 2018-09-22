package njs.test.framework;

import njs.test.TransactionClassTests;

public class NuTestRunner {

    public static void main(String args[]) {

        TransactionClassTests transactionTests = new TransactionClassTests();

        transactionTests.newTransactionCreationTest();
    }
}
