/**
 * VegetableProduct is a subclass of the Product superclass
 * It inherits all the attributes and all the methods from the parent class
 * A specific attribute for this class is the list of vitamins
 *
 * @author Bogdan Butuza
 */
package ro.sci.bv.main.StoreSimulator;

public class VegetableProduct extends Product {

    private String vitaminList;

    /**
     * Constructor for a VegetableProduct object
     */
    public VegetableProduct() {
        super();
    }

    /**
     * This method sets the vitamins list contained by a product of this type
     * @param vitaminList a String variable, representing the content of a vitamins list
     */
    public void setVitaminList(String vitaminList) {
        this.vitaminList = vitaminList;
    }

    /**
     * This method shows the content of an object of this type
     * @return a String value, representing object's details
     */
    @Override
    public String toString() {
        return getProduct() + " Vitamins contained: " + this.vitaminList + " |";
    }
}
