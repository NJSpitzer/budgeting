#Design Document for Budgeting Project
**Author:** Nicholas Spitzer

##Data Classes
* Transaction - class to hold data about transactions
  * Examples:
    * Payment of Bill
    * Paycheck
    * Buying gas
   * Data about transactions
     * Amount
     * Is it income or expense?
     * Name
     * Date
* Month - class to hold a whole month's transactions
  * Data
    * All of the Transactions of that month
    * Start date and end date
    * Number of weeks
* Loan - class to hold data about a loan
  * Data
    * Starting/current amount
    * Monthly minimum payment
    * Interest charged
    * Years & months left to payoff
* Debt - class to hold data about a credit card
  * Data
    * Current amount
    * Each transaction (payment or new charge)
    * Interest
    * Extra paid each month
* Quarter - class to hold data about the quarter's expenses
  * Data
    * Data from the 3 Months in it (amount made vs amount spent)
    * Start date and end date
* Year - class to show how the year is going
  * Data
    * Data for the quarters in that year about income and expenses