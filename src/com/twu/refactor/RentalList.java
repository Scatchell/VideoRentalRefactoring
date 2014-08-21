package com.twu.refactor;

import java.util.ArrayList;
import java.util.Iterator;

public class RentalList implements Iterable<Rental>{

    private ArrayList<Rental> rentalList;

    public RentalList() {
        this.rentalList = new ArrayList<Rental>();
    }


    public double totalCost() {
        double totalAmount = 0;

        for (Rental rental : rentalList) {
            totalAmount += rental.amount();
        }

        return totalAmount;
    }

    public int totalRenterPoints() {
        int totalFrequentRenterPoints = 0;

        for (Rental rental : rentalList) {
            totalFrequentRenterPoints += rental.frequentRenterPoints();
        }

        return totalFrequentRenterPoints;
    }

    @Override
    public Iterator<Rental> iterator() {
        return rentalList.iterator();
    }

    public void add(Rental rental) {
        rentalList.add(rental);
    }
}
