import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {

    private int maxWeight;
    private ArrayList<T> parcels = new ArrayList<>();

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addParcel(T parcel) {
        int totalWeight = 0;

        for (T p : parcels) {
            totalWeight += p.getWeight();
        }

        if (totalWeight + parcel.getWeight() > maxWeight) {
            System.out.println("Превышен максимальный вес коробки!");
            return;
        }

        parcels.add(parcel);
    }

    public ArrayList<T> getAllParcels() {
        return new ArrayList<>(parcels);
    }
}
