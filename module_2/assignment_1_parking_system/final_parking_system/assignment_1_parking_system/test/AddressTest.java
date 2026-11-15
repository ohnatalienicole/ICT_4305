import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AddressTest {

    @Test
    public void testGetAddressInfo() {
        Address address = new Address(
            "123 University Blvd",
            "",
            "Denver",
            "CO",
            "80208"
        );

        assertEquals(
            "123 University Blvd, Denver, CO 80208",
            address.getAddressInfo()
        );
    }
}
