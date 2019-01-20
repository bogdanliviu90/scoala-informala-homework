/**
 * The Product Class stores all the attributes available for all products: an unique identifier, a name, how many items
 * of the same type are available in stock, price, validity date, weight
 * Product Class is also a superclass (parent class for VegetableProduct and AnimalProduct classes
 * Instances of Product will be stored in a Product items list, in the Main class
 *
 * @author Bogdan Butuza
 */
package ro.sci.bv.main.StoreSimulator;

public class Product {
    private int id;
    private String name;
    private int stock;
    private double price;
    private String validity;
    private double weight;

    /**
     * Constructor method goes here
     */
    public Product() {

    }

    /**
     * This setter method sets an identifier for this instance
     * @param id an integer value, representing an unique identifier
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This setter method sets a name/ description for this instance
     * @param name a String value, representing product's name or description
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This setter method sets how many items of an instance are available in stock
     * @param stock an integer variable, representing the amount
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * This setter method sets how much cost an item of this type
     * @param price an integer variable, representing the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * This setter method sets the validity time for every Product instance
     * @param validity a String variable, representing the validity period
     */
    public void setValidity(String validity) {
        this.validity = validity;
    }

    /**
     * This method sets the weight for every item of this type
     * @param weight an integer variable, meaning the weight of the product
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * This getter method is used to obtain an instance id
     * @return an integer value, representing the unique identifier
     */
    public int getId() {
        return this.id;
    }

    /**
     * This method gets the amount of items of the same types
     * @return an integer value, meaning the number of same item types
     */
    public int getStock() {
        return this.stock;
    }

    /**
     * This method gets a product name/ description
     * @return a String value, meaning the object's name/ description
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method gets the price of a Product instance
     * @return a integer value, representing price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * This method outputs to the user a product's attributes
     * @return a String, containing all the details included in a Product object
     */
    public String getProduct() {
        return "| ID: " + this.id + " | Product: " + this.name + " | Stock: " + this.stock + " | Price: " + this.price +
                " | Valid until: " + this.validity + " | Weight: " + this.weight + " |";
    }
}
