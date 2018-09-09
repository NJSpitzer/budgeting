package njs.runner;

import njs.data.Transaction;

/**
 * @author Nicholas Spitzer
 *
 * Runner class for Budget project
 */

public class Runner {

    /**
     * Main method to run Budget project
     * @param args
     */
    public static void main(String args[]) {

        Transaction transaction = new Transaction();

        System.out.println(String.format("Amount: %s\nDate: %s\nTransactionID: %s",
                transaction.getAmount(), transaction.getDate(), transaction.getTransactionID()));
    }
}
