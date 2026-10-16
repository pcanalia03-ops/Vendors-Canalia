import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorTest {

    static Vending vendor;

    @Test
    void addMoney() {
        vendor = new Vending(0,0);
        assertEquals(vendor.getBalance(),0);
        vendor.addMoney(10);
        assertEquals(vendor.getBalance(),10);
    }

    @Test
    void buyItem() {
        vendor = new Vending(10,10);
        vendor.addMoney(10);
        assertEquals(vendor.getStock("Candy"),10);
        vendor.select("Candy");
        assertEquals(vendor.getStock("Candy"),9);
        assertEquals(vendor.getBalance(),8.75);
    }

    @Test
    void emptyStock() {
        int amt = 5;
        vendor = new Vending(amt,amt);
        vendor.addMoney(10);
        assertEquals(vendor.getStock("Candy"),amt);
        for (int i = 0; i < amt; i++) {
            vendor.select("Candy");
        }
        assertEquals(vendor.getStock("Candy"),0);
        assertEquals("Out of stock",vendor.select("Candy"));
        assertEquals(vendor.getStock("Gum"),amt);
        for (int i = 0; i < amt; i++) {
            vendor.select("Gum");
        }
        assertEquals(vendor.getStock("Gum"),0);
        assertEquals("Out of stock",vendor.select("Gum"));
    }

}