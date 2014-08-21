package com.twu.refactor;

public class Rental {
    private static final double MIN_CHILDRENS_RENTAL_AMOUNT = 1.5;
    private static final int CHILDREN_LOAN_PERIOD = 3;
    private static final double OVERDUE_PENALTY = 1.5;
    private static final int MIN_REGULAR_RENTAL_AMOUNT = 2;
    private static final int REGULAR_LOAN_PERIOD = 2;
    private static final int NEW_RELEASE_RENTAL_AMOUNT = 3;

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    double amount() {
        double thisAmount = 0;

        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount = rentalAmount(REGULAR_LOAN_PERIOD, MIN_REGULAR_RENTAL_AMOUNT);
                break;
            case Movie.NEW_RELEASE:
                thisAmount = newReleaseRentalAmount();
                break;
            case Movie.CHILDRENS:
                thisAmount = rentalAmount(CHILDREN_LOAN_PERIOD, MIN_CHILDRENS_RENTAL_AMOUNT);
                break;
        }

        return thisAmount;
    }

    private int newReleaseRentalAmount() {
        return daysRented * NEW_RELEASE_RENTAL_AMOUNT;
    }


    public double rentalAmount(int defaultLoanPeriod, double baseAmount) {
        double thisAmount = baseAmount;

        if (daysRented > defaultLoanPeriod)
            thisAmount += (daysRented - defaultLoanPeriod) * OVERDUE_PENALTY;

        return thisAmount;
    }

    private boolean hasNewReleaseMovie() {
        return getMovie().getPriceCode() == Movie.NEW_RELEASE;
    }

    public int frequentRenterPoints() {
        int frequentRenterPoints = 1;

        if (hasNewReleaseMovie() && daysRented > 1) {
            frequentRenterPoints++;
        }

        return frequentRenterPoints;
    }

}