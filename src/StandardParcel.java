public class StandardParcel extends Parcel {
    private static final int STANDARD_DELIVERY_COST = 2;

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    protected int getBaseCost() {
        return STANDARD_DELIVERY_COST;
    }
}
