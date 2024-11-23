package page.Tests;

import org.junit.jupiter.api.Test;
import page.server.Customer.Cart_Operations.Cart_functionalities;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartUnitTest {
    @Test
    public void cartUnitTest() {
        String item = "ABC";
        Cart_functionalities CF1 = new Cart_functionalities();
        int result = CF1.Cart_return_availabilty(item);
        assertEquals(result,0);
    }
}
