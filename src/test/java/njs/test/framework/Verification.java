package njs.test.framework;

import org.testng.Assert;
import org.testng.Reporter;

public class Verification {

    public static void verifyEqual(Object expected, Object actual, String message) {
        try{
            Reporter.log(message);
            Assert.assertTrue(expected.equals(actual), message);
        } catch (Throwable throwable) {
            Assert.fail(String.format("Verification failed! - %s", message));
        }
    }

    public static void verifyTrue(Boolean bool, String message) {
        verifyTrue(bool, message, false);
    }

    public static void verifyTrue(Boolean bool, String message, boolean mustPass) {
        try {
            Reporter.log(message);
            Assert.assertTrue(bool, message);
        } catch (Throwable throwable) {
            if (mustPass) {
                Assert.fail(String.format("Verification failed! - %s", message));
            } else {
                Reporter.log(String.format("FAILURE! Verification failed! - %s", message));
            }
        }
    }
}
