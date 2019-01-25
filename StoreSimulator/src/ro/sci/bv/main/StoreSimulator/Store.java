/**
 * Store Class represents the model of how a store works
 * A store of this type has products - List of Product instances and orders - List of Order instances
 * The store haas also a name, as an attribute
 *
 * @author Bogdan Butuza
 */
package ro.sci.bv.main.StoreSimulator;
import java.util.*;

public class Store {
    private String name;
    private List<Product> products;
    private List<Order> orders;

    /**
     * Constructor of a Store instance
     * @param name a String value, as the name/ title of this Store
     */
    public Store(String name) {
        this.name = name;
        System.out.println("The " + this.name + " was opened.");
    }

    /**
     * This method sets the products which will be available in the store
     * @param products a list of Product objects, representing the products available in stock
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * This method sets the orders made in the store
     * @param orders a list of Order objects, representing the orders made when selling a product/ various products
     */
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    /**
     * This method prints all the details for each Product object in the specified Product list
     * @param items a list of Product type objects, to iterate through its components
     */
    public void showProducts(List<Product> items) {
        for (Product p : items) {
            System.out.println(p.toString());
        }
    }

    /**
     * This method is used to determine if a certain product is available in stock, in order to sell it
     * For a searched Product object in a list, based on its unique id, this method also checks if the demanded
     * quantity is available. Otherwise, it lets the user know that the product can be found in a smaller amount than
     * needed or it's not available.
     *
     * @param id an integer variable, representing a product unique id
     * @param quantity an integer variable, meaning the desired amount
     * @param productList a Product type list, wich stores various Product objects
     * @param orderList an Order type list, in order to add a new order
     * @return false, if a Product cannot be sold
     *         true, if it can be sold
     */
    public static boolean checkNewOrder(int id, int quantity, List<Product> productList, List<Order> orderList) {
        boolean ok = false;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please insert selling date(yyyy-mm-dd): ");
        String newDate = userInput.nextLine();

        for (Product p : productList) {
            if ((id == p.getId()) && (p.getStock() >= quantity)) {
                ok = true;
                p.setStock(p.getStock() - quantity);
                Order anOrder = new Order();
                anOrder.setId(p.getId());
                anOrder.setName(p.getName());
                anOrder.setQuantity(quantity);
                anOrder.setPrice(p.getPrice());
                anOrder.setDate(newDate);
                orderList.add(anOrder);
            }
        }
        return ok;
    }

}