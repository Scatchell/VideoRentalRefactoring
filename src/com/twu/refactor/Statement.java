package com.twu.refactor;

public class Statement {

    private RentalList rentalList;
    private String customerName;

    public Statement(RentalList rentalList, String customerName) {
        this.rentalList = rentalList;
        this.customerName = customerName;
    }

    public String print() {
        return header() + body() + footer();
    }

    private String header() {
        return "Rental Record for " + customerName + "\n";
    }

    private String body() {
        String result = "";

        for (Rental rental : rentalList) {
            result += rentalLine(rental, rental.amount());
        }

        return result;
    }

    private String footer() {
        return "Amount owed is " + String.valueOf(rentalList.totalCost()) + "\n" + "You earned " + String.valueOf(rentalList.totalRenterPoints())
                + " frequent renter points";
    }

    private String rentalLine(Rental rental, double thisAmount) {
        return "\t" + rental.getMovie().getTitle() + "\t"
                + String.valueOf(thisAmount) + "\n";
    }
}
