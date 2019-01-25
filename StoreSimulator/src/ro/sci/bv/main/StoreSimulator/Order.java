/**
 * The Order Class is used to create sale reports in the Main Class
 * An order is considered to have the following attributes: identifier, name/ description, quantity, price and the
 * date of placement
 * Excepting quantity and the selling date - which are inputted from the user, all others values are associated from
 * product's attributes
 *
 * @author Bogdan Butuza
 */
package ro.sci.bv.main.StoreSimulator;

public class Order {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String date;

    Order() {
    }

    /**
     * This method sets the right id for each order
     * @param id an integer variable, representing a product's unique identifier
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method sets the right name/ description for each order
     * @param name a String variable, representing a product's name/ description
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method sets the right quantity for each order
     * @param quantity an integer variable, representing the sold quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * This method sets the price of an item for same type elements
     * @param price an integer value, representing the price for a product
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * This method sets the date when the order was placed
     * @param date a String value(yyyy-MM-dd), representing the selling date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * This method gets the date of a certain order
     * @return a String value, meaning the date when the product was sold
     */
    public String getDate() {
        return this.date;
    }

    /**
     * This method prints to the user the details for a Order object
     */
    public void showOrder() {
        System.out.println("| ID: " + this.id +" | Product: " + this.name + " | No. of items: " + this.quantity + " | Price: " +
                this.price + " | Date: " + this.date + " |");
    }
}
