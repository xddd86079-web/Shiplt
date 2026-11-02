import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IsExpiredTest {
    @Test
    public void shouldReturnFalseWhenNotExpired() {
        PerishableParcel perishableParcel = new PerishableParcel("описание", 10, "адресс", 20, 2);
        assertFalse(perishableParcel.isExpired(21));
    }

    @Test
    public void shouldReturnTrueWhenExpired() {
        PerishableParcel perishableParcel = new PerishableParcel("описание", 10, "адресс", 20, 2);
        assertTrue(perishableParcel.isExpired(23));
    }

    @Test
    public void shouldReturnFalseOnBoundaryDay() {
        PerishableParcel perishableParcel = new PerishableParcel("описание", 10, "адресс", 20, 2);
        assertFalse(perishableParcel.isExpired(22));
    }
}
