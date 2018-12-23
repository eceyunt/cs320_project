package Test;
import Model.Account;
import Model.RetailManagement;
import View.GUI;
import org.junit.Test;
import static org.junit.Assert.*;

public class UnitTests {

    @Test
    public void testGUI() {
        GUI gui = new GUI(new RetailManagement(new Account(0.0)));
        assertNotNull(gui);
    }

    @Test
    public void testRetailer() {
        assertNotNull(new RetailManagement(new Account(0.0)));
    }
}
