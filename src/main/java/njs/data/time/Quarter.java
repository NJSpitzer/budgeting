package njs.data.time;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * @author Nicholas Spitzer
 *
 * Data class to hold data about a quarter
 */

public class Quarter {

    private String quarterName;
    private ArrayList<Month> months = new ArrayList<>();

    public Quarter(String quarterName) {
        this.quarterName = quarterName;
    }

    public String getQuarterName() {
        return quarterName;
    }

    public void setQuarterName(String quarterName) {
        this.quarterName = quarterName;
    }

    public void addMonth(Month month) {
        months.add(month);
    }

    public Month getMonth(String name) {

        for (Month m: months) {
            if (m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }

    /**
     * @return total expenses for Quarter as BigDecimal
     */
    public BigDecimal getTotalExpenses() {
        BigDecimal totalExpense = new BigDecimal("0.00").setScale(2, RoundingMode.CEILING);

        for (int i = 0; i < months.size(); i++) {
            totalExpense = totalExpense.add(months.get(i).getTotalExpenses());
        }

        return totalExpense;
    }

    /**
     * @return total income of Quarter as BigDecimal
     */
    public BigDecimal getTotalIncome() {
        BigDecimal totalIncome = new BigDecimal("0.00").setScale(2, RoundingMode.CEILING);

        for (int i = 0; i < months.size(); i++) {
            totalIncome = totalIncome.add(months.get(i).getTotalIncome());
        }

        return totalIncome;
    }

    /**
     * @return net total (income minus expenses) for Quarter as BigDecimal
     */
    public BigDecimal getNetTotal() {
        BigDecimal netTotal = new BigDecimal("0.00").setScale(2, RoundingMode.CEILING);

        for (int i = 0; i < months.size(); i++) {
            netTotal = netTotal.add(months.get(i).getNetTotal());
        }

        return netTotal;
    }

    public String getMonthlyBreakdown() {

        String output = "";

        for (Month m: months) {
            output = output.concat(m.toString() + "\n\n");
        }

        return output;
    }

    public String toString() {

        String output = String.format("Name: %s\nIncome for Quarter: $%s\nExpenses for Quarter: $",
                this.quarterName, this.getTotalIncome());

        if (this.getTotalExpenses().compareTo(new BigDecimal("0.00").setScale(2)) > 0) {
            output = output.concat("-");
        }

        output = output.concat(String.format("%s\nNet Total for Quarter: $", this.getTotalExpenses()));

        output = output.concat(String.format("%s", this.getNetTotal()));

        return output;
    }
}
