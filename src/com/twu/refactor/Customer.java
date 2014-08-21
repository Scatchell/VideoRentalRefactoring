package com.twu.refactor;

public class Customer {

    private String name;
    public RentalList rentalList = new RentalList();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
		rentalList.add(rental);
	}

    public String statement() {
        Statement statement = new Statement(rentalList, name);
        return statement.print();
    }

    public String htmlStatement() {
        return "";
    }
}
