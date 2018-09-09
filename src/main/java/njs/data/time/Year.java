package njs.data.time;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * @author Nicholas Spitzer
 *
 * Data class to hold data on a year
 */

public class Year {

    private ArrayList<Quarter> quarters = new ArrayList<>();
    private String yearName;

    public Year(String yearName) {

        this.yearName = yearName;
    }

    public String getYearName() {
        return yearName;
    }

    public void setYearName(String yearName) {
        this.yearName = yearName;
    }

    public void addQuarter(Quarter quarter) {
        quarters.add(quarter);
    }

    /**
     * @return total year expense as BigDecimal
     */
    public BigDecimal getTotalExpenses() {
        BigDecimal totalExpenses = new BigDecimal("0.00").setScale(2, RoundingMode.CEILING);

        for (int i = 0; i < quarters.size(); i++) {
            totalExpenses = totalExpenses.add(quarters.get(i).getTotalExpenses());
        }

        return totalExpenses;
    }

    /**
     * @return total year income as BigDecimal
     */
    public BigDecimal getTotalIncome() {
        BigDecimal totalIncome = new BigDecimal("0.00").setScale(2, RoundingMode.CEILING);

        for (int i = 0; i < quarters.size(); i++) {
            totalIncome = totalIncome.add(quarters.get(i).getTotalIncome());
        }

        return totalIncome;
    }

    /**
     * @return total year net total (income minus expenses) as BigDecimal
     */
    public BigDecimal getNetTotal() {
        BigDecimal netTotal = new BigDecimal("0.00").setScale(2, RoundingMode.CEILING);

        for (int i = 0; i < quarters.size(); i++) {
            netTotal = netTotal.add(quarters.get(i).getNetTotal());
        }

        return netTotal;
    }
}
