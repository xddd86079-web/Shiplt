import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParcelBoxTest {

    @Test
    public void shouldAddParcelIfWeightIsNotExceeded() {
        ParcelBox<Parcel> box = new ParcelBox<>(10);

        StandardParcel parcel = new StandardParcel(
                "Описание", 5, "Адрес", 20
        );

        box.addParcel(parcel);

        assertEquals(1, box.getAllParcels().size());
        assertTrue(box.getAllParcels().contains(parcel));
    }

    @Test
    public void shouldNotAddParcelIfWeightIsExceeded() {
        ParcelBox<Parcel> box = new ParcelBox<>(10);

        StandardParcel parcel1 = new StandardParcel(
                "Первая", 7, "Адрес", 20
        );

        StandardParcel parcel2 = new StandardParcel(
                "Вторая", 5, "Адрес", 20
        );

        box.addParcel(parcel1);
        box.addParcel(parcel2);

        assertEquals(1, box.getAllParcels().size());
        assertFalse(box.getAllParcels().contains(parcel2));
    }

    @Test
    public void shouldAddParcelOnBoundaryWeight() {
        ParcelBox<Parcel> box = new ParcelBox<>(10);

        StandardParcel parcel = new StandardParcel(
                "Граничная", 10, "Адрес", 20
        );

        box.addParcel(parcel);

        assertEquals(1, box.getAllParcels().size());
        assertTrue(box.getAllParcels().contains(parcel));
    }
}
