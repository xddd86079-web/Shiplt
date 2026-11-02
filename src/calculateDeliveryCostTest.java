import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class calculateDeliveryCostTest {
    @Test
    public void shouldCalculateFragileDeliveryCost() {
        FragileParcel fragileParcel = new FragileParcel("описание", 10, "адресс", 20);
        assertEquals(40, fragileParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldCalculatePerishableDeliveryCost() {
        PerishableParcel perishableParcel = new PerishableParcel("описание", 10, "адресс", 20, 2);
        assertEquals(30, perishableParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldCalculateStandardDeliveryCost() {
        StandardParcel standardParcel = new StandardParcel("описание", 10, "адресс", 20);
        assertEquals(20, standardParcel.calculateDeliveryCost());
    }
}
