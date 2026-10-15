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

}