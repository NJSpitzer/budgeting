package njs.data.investment;

import java.util.ArrayList;

/**
 * @author Nicholas Spitzer
 * @date March 25, 2019
 *
 * Purpose: Class to hold all the stock purchases for a certain ETF or company
 */

public class StockBundle {

    private String name;
    private ArrayList<StockPurchase> stockPurchases;

    public StockBundle(String name) {
        this.name = name;
        stockPurchases = new ArrayList<StockPurchase>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStockPurchase(StockPurchase purchase) {
        stockPurchases.add(purchase);
    }

    public void sellStocks(int numberOfStocks) {

        while (numberOfStocks > stockPurchases.get(0).getNumberOfShares()) {
            numberOfStocks = numberOfStocks - stockPurchases.get(0).getNumberOfShares();
            stockPurchases.get(0).sellAllShares();
            stockPurchases.remove(0);
        }

        if (stockPurchases.size() > 0) {
            stockPurchases.get(0).sellShares(numberOfStocks);
        }
    }
}
