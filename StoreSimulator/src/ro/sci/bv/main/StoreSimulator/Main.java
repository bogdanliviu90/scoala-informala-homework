/**
 * This program simulates the operations available at a store
 * Each item refers to a product and has a unique id, a name/ description,
 * a stock number, a price, a validity date, a weight
 * In the store vegetable and animal products are sold
 * All animal products have also a storage temperature on their packaging
 * All vegetal products describe on their package a list of vitamins they
 * contain
 * The user will have 4 options: to add a product type on the stock, to sell a
 * product, to display daily sales report, or to exit
 *
 * @author Bogdan Butuza
 */
package ro.sci.bv.main.StoreSimulator;

import java.util.*;

public class Main {

    /**
     * This method is used to print the Store's menu to the console
     */
    private static void showMenu() {
        System.out.println("-------------------------------------------------------------\n" +
                "1. Create product and add it to stock\n" +
                "2. Sell product\n" +
                "3. Display daily sales report\n" +
                "4. Exit\n" +
                "\n" +
                "Choose an option:\n" +
                "-------------------------------------------------------------");
    }

    /**
     * This method prints out to the console the options available for Product type
     */
    public static void askProductType() {
        System.out.println("-------------------------------------------------------------\n" +
                "Product type (1 - Animal; 2 - Vegetable):\n" +
                "-------------------------------------------------------------");
    }

    /**
     * This method checks if a product ID is already taken by other instance
     * If it's not in use, it means that current value can be taken by a new instance
     *
     * @param id an integer variable, representing the inputted ID value
     * @param products a list of Product type objects, to iterate through its components
     * @return false, if the id is not matching another id attribute of a Product instance
     *         true, if the id is not available
     */
    private static boolean checkUnique(int  id, List<Product> products){
        boolean ok = false;
        for (Product p : products) {
            if (p.getId() == id) {
                ok = true;
            }
        }
        return ok;
    }

    /**
     * This method adds a product in a list of products, so the Store will have some Products when it's
     * created( a Product object in a list of Product objects)
     * There are two types of Product, depending on the option that was insert
     *
     * @param option an integer variable, representing user's choice for product type
     * @param myItems a List of Product objects, in order to add a new Product to it
     */
    private static void addProduct(int option, List<Product> myItems) {
        int number;
        Scanner keyboard = new Scanner(System.in);
        Scanner newKeyboard = new Scanner(System.in);
        System.out.print("How many products?");
        number = keyboard.nextInt();
        if (option == 1) {
            for (int i = 1; i <= number; i++) {
                AnimalProduct x = new AnimalProduct();
                System.out.println("Product ID: ");
                int id = keyboard.nextInt();
                if (checkUnique(id, myItems)) {
                    do {
                        System.out.println("This id is already in use. Insert unique product ID ");
                        id = keyboard.nextInt();
                    } while (checkUnique(id, myItems));
                }
                x.setId(id);
                System.out.println("Product name: ");
                String name = newKeyboard.nextLine();
                x.setName(name);
                System.out.println("Items in stock: ");
                x.setStock(keyboard.nextInt());
                System.out.println("Price: ");
                x.setPrice(keyboard.nextDouble());
                System.out.println("Validity date (yyyy-mm-dd): ");
                String date = newKeyboard.nextLine();
                x.setValidity(date);
                System.out.println("Weight: ");
                x.setWeight(keyboard.nextDouble());
                System.out.println("Storage temperature: ");
                x.setStorageTemp(keyboard.nextDouble());
                myItems.add(x);
                System.out.println("Product was successfully added to the stock!");
            }
        } else if (option == 2) {
            for (int i = 1; i <= number; i++) {
                VegetableProduct y = new VegetableProduct();
                System.out.println("Product ID: ");
                int id = keyboard.nextInt();
                if (checkUnique(id, myItems)) {
                    do {
                        System.out.println("This id is already in use. Insert unique product ID ");
                        id = keyboard.nextInt();
                    } while (checkUnique(id, myItems));
                }
                y.setId(id);
                System.out.println("Product name: ");
                String name = newKeyboard.nextLine();
                y.setName(name);
                System.out.println("Items in stock: ");
                y.setStock(keyboard.nextInt());
                System.out.println("Price: ");
                y.setPrice(keyboard.nextDouble());
                System.out.println("Validity date (yyyy-mm-dd): ");
                String date = newKeyboard.nextLine();
                y.setValidity(date);
                System.out.println("Weight: ");
                y.setWeight(keyboard.nextDouble());
                System.out.println("List of vitamins: ");
                String vitamins = newKeyboard.nextLine();
                y.setVitaminList(vitamins);
                myItems.add(y);
                System.out.println("Product was successfully added to the stock!");
            }
        } else {
            System.out.println("Your choice does not exist. Please insert a valid option.");
        }
    }

    /**
     * This method prints to the user a report containing all the orders made within the same date
     *
     * @param date a String value, meaning the inputted date( in format "yyyy-MM-dd")
     * @param orders  an Order type list, containing all the registered orders
     */
    private static void createReport(String date, List<Order> orders) {
        boolean ok = false;
        System.out.println("Writing report: ");
        for (Order o : orders) {
            if (o.getDate().equals(date)) {
                o.showOrder();
                ok = true;
            }
        }
        if(!ok) {
            System.out.println("No order was placed in " + date);
        }
    }

    public static void main(String[] args) {
        List<Product> myProducts = new ArrayList<>();
        //Creating some products
        //Firs product:
        AnimalProduct itemOne = new AnimalProduct();
        itemOne.setId(1);
        itemOne.setName("Cheddar Cheese");
        itemOne.setStock(19);
        itemOne.setPrice(15);
        itemOne.setValidity("2019-03-03");
        itemOne.setWeight(250);
        itemOne.setStorageTemp(20);

        //Second product:
        VegetableProduct itemTwo = new VegetableProduct();
        itemTwo.setId(2);
        itemTwo.setName("Bananas");
        itemTwo.setStock(27);
        itemTwo.setPrice(12);
        itemTwo.setValidity("2019-01-20");
        itemTwo.setWeight(800);
        itemTwo.setVitaminList("A, B6, C, Magnesium");

        //Third product:
        VegetableProduct itemThree = new VegetableProduct();
        itemThree.setId(3);
        itemThree.setName("Mushrooms");
        itemThree.setStock(40);
        itemThree.setPrice(9);
        itemThree.setValidity("2019-01-20");
        itemThree.setWeight(180);
        itemThree.setVitaminList("B1, B3, B6, D, Pholic Acid, Copper");

        //Adding the products to the stock
        myProducts.add(itemOne);
        myProducts.add(itemTwo);
        myProducts.add(itemThree);

        Store myStore = new Store("Local Store");
        myStore.setProducts(myProducts);

        List<Order> myOrders = new ArrayList<>();

        showMenu();

        Scanner input = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);
        System.out.println("Your choice is: ");
        int opt = input.nextInt();
        while(!(opt == 4)) {
            switch (opt) {
                case 1:
                    myStore.showProducts(myProducts);
                    System.out.println(" ");
                    askProductType();
                    Scanner newInput = new Scanner(System.in);
                    System.out.println("Enter the product type: ");
                    int choice = input.nextInt();
                    addProduct(choice, myProducts);
                    myStore.setProducts(myProducts);
                    break;
                case 2:
                    myStore.showProducts(myProducts);
                    System.out.println(" ");
                    System.out.println("What would you like to sell?");
                    System.out.println("Please insert product ID: ");
                    int searchId = input.nextInt();
                    System.out.println("Please insert desired quantity: ");
                    int quantity = input.nextInt();
                    if (myStore.checkNewOrder(searchId, quantity, myProducts, myOrders)) {
                        System.out.println("A new order was successfully placed.");
                        myStore.setOrders(myOrders);
                    }else{
                        System.out.println("The product is either not available, or the store cannot provide the " +
                                "desired quantity");
                    }
                    break;
                case 3:
                    System.out.println("Please enter a date(yyyy-mm-dd): ");
                    String searchDate = stringInput.nextLine();
                    createReport(searchDate, myOrders);
                    break;
                default:
                    System.out.println("Your option is not valid. Please insert one from the options above");
            }
            System.out.println("\n");
            showMenu();
            System.out.println("Your choice is: ");
            opt = input.nextInt();
        }

    }
}
