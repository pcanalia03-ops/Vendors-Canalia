import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Class for a Vending Machine.  Contains a hashtable mapping item names to item data, as
 * well as the current balance of money that has been deposited into the machine.
 */
class Vending {
    private static HashMap<String, Item> Stock = new HashMap<String,Item>();
    private double balance;
    ArrayList<String> purchases = new ArrayList<>();

    Vending(int numCandy, int numGum) {
        Stock.put("Candy", new Item(1.25, numCandy));
        Stock.put("Gum", new Item(.5, numGum));
        this.balance = 0;
    }

    /** resets the Balance to 0 */
    void resetBalance () {
        this.balance = 0;
    }

    void restock(String name, int amt){
        Stock.get(name).restock(amt);

    }

    void nameChange(String name, String newName) {
        if (Stock.containsKey(name)) {
            Stock.put(newName, Stock.get(name));
            Stock.remove(name);
        }
    }

    void removeItem(String name){
        Stock.remove(name);
    }

    int getStock (String name) {
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            return(item.getStock());
        }
        else {
            return 0;
        }
    }

    /** returns the current balance */
    double getBalance () {
        return this.balance;
    }

    /** adds money to the machine's balance
     * @param amt how much money to add
     * */
    void addMoney (double amt) {
        this.balance = this.balance + amt;
    }

    String listPurchases(){
        return(purchases.toString());
    }

    String getInfo(String name){
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            return (name + " costs " + item.getPrice() + " and there is " + item.getStock() + " left");
        }
        else {
            return("no info");
        }
    }

    void discount  (String name, double amt){
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            item.discount(amt);
        }
        else {
            return;
        }
    }

    /** attempt to purchase named item.  Message returned if
     * the balance isn't sufficient to cover the item cost.
     *
     * @param name The name of the item to purchase ("Candy" or "Gum")
     */
    String select (String name) {
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            if (item.getStock() > 0) {
                if (balance >= item.price) {
                    item.purchase(1);
                    this.balance = this.balance - item.price;
                    purchases.add(name);
                    return (name + " sold");
                }
                else
                    return ("Gimme more money");
            }
            else {
                item.restock(10);
                return ("Out of stock");
            }

        }
        else return ("Sorry, don't know that item");
    }

}

class Examples {
}

