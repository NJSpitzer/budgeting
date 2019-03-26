package njs.data.investment;

/**
 * @author: Nicholas Spitzer
 * @date: March 25, 2019
 *
 * Purpose: To house information on a bundle of stocks purchased, containing
 * the number of shares bought, how much each was at purchase, and
 * how much each is wroth now. It also will calculate how much was invested,
 * how much the whole bundle is worth now, and how much has been made or lost on it
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StockPurchase {

    private int numberOfShares;
    private BigDecimal initialPerStockPrice;
    private BigDecimal currentPerStockPrice;

    public StockPurchase() {
        numberOfShares = 0;
        initialPerStockPrice = new BigDecimal("0.00");
        currentPerStockPrice = new BigDecimal("0.00");
    }

    public StockPurchase(int numberOfShares, String initialPrice, String currentPrice) {
        this.numberOfShares = numberOfShares;
        this.initialPerStockPrice = new BigDecimal(initialPrice).setScale(2, RoundingMode.CEILING);
        this.currentPerStockPrice = new BigDecimal(currentPrice).setScale(2, RoundingMode.CEILING);
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    /**
     * Set number of shares to be sold
     */
    public void sellShares(int numberToSell) {
        numberOfShares = numberOfShares - numberToSell;
    }

    public void sellAllShares() {
        numberOfShares = 0;
    }

    public BigDecimal getInitialPerStockPrice() {
        return initialPerStockPrice;
    }

    public void setInitialPerStockPrice(BigDecimal initialPrice) {
        this.initialPerStockPrice = initialPrice;
    }

    public BigDecimal getCurrentPerStockPrice() {
        return currentPerStockPrice;
    }

    public void setCurrentPerStockPrice(BigDecimal currentPrice) {
        this.currentPerStockPrice = currentPrice;
    }

    /**
     * Calculate how much has been invested in this
     * bundle of stock purchase
     * @return BigDecimal of amount invested initially
     */
    public BigDecimal getTotalAmountInvested() {
        BigDecimal bdNumShares = new BigDecimal(numberOfShares).setScale(2, RoundingMode.CEILING);

        return initialPerStockPrice.multiply(bdNumShares).setScale(2, RoundingMode.CEILING);
    }

    /**
     * Calculate how much money has been made or lost on this purchase
     * @return BigDecimal of how much has been made or lost
     */
    public BigDecimal calculateCurrentReturn() {
        BigDecimal bdNumShares = new BigDecimal(numberOfShares).setScale(2, RoundingMode.CEILING);

        return currentPerStockPrice.multiply(bdNumShares).setScale(2, RoundingMode.CEILING);
    }
}
