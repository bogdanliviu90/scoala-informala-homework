/**
 * AnimalProduct is a subclass for the Product superclass
 * It inherits all the attributes and all the methods from the parent class
 * A specific attribute for this class is the storage temperature
 *
 * @author Bogdan Butuza
 */
package ro.sci.bv.main.StoreSimulator;

public class AnimalProduct extends Product {

    private double storageTemp;

    /**
     * Constructor for an AnimalProduct object
     */
    public AnimalProduct() {
        super();
    }

    /**
     * This method sets the storage temperature for an AnimalProduct instance
     * @param storageTemp an integer variable, representing the temperature at which a product of this type must be
     *                    stored
     */
    public void setStorageTemp(double storageTemp) {
        this.storageTemp = storageTemp;
    }

    /**
     * This method prints to the user the details of an object of this type
     * @return a String value, meaning the content of an AnimalProduct object
     */
    @Override
    public String toString() {
        return getProduct() + " Storage temperature: " + this.storageTemp + " |";
    }
}
